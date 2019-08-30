package io.thkoeln.archilab.coalbaseresources.learningspace;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.thkoeln.archilab.coalbaseresources.resources.WebLinkResourceRepository;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

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
      this.webLinkResourceRepository.deleteAllByReferenceId(
          learningSpaceDomainEvent.getLearningSpaceIdentifier().getUuid());
    }
  }
}
