package de.thkoeln.archilab.coalbaseresources.learningspace;

import de.thkoeln.archilab.coalbaseresources.resources.WebLinkResourceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class LearningSpaceEventConsumer {

  private final ObjectMapper objectMapper;

  @Autowired
  private WebLinkResourceRepository webLinkResourceRepository;

  @Autowired
  public LearningSpaceEventConsumer(
      final ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  @KafkaListener(topics = "${learning-space.topic}", groupId = "${spring.kafka.group-id}")
  public void listen(String message) throws IOException {
    LearningSpaceDomainEvent learningSpaceDomainEvent = this.objectMapper
        .readValue(message, LearningSpaceDomainEvent.class);

    if (learningSpaceDomainEvent.getEventType().equals(LearningSpaceEventType.DELETED.name())) {
      webLinkResourceRepository.deleteAllByReferenceId(
          learningSpaceDomainEvent.getLearningSpaceIdentifier().getUuid());
    }
  }
}
