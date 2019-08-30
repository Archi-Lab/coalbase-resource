package io.archilab.coalbase.resource.learningspace;


import io.archilab.coalbase.resource.core.DomainEvent;
import io.archilab.coalbase.resource.core.UniqueId;

public class LearningSpaceDomainEvent extends DomainEvent {

  private final UniqueId learningSpaceIdentifier;
  private final LearningSpaceEventType eventType;

  protected LearningSpaceDomainEvent() {
    this.learningSpaceIdentifier = null;
    this.eventType = null;
  }

  public LearningSpaceDomainEvent(UniqueId learningSpaceIdentifier,
      LearningSpaceEventType eventType) {
    this.learningSpaceIdentifier = learningSpaceIdentifier;
    this.eventType = eventType;
  }

  @Override
  public String getEventType() {
    return this.eventType.name();
  }

  public UniqueId getLearningSpaceIdentifier() {
    return this.learningSpaceIdentifier;
  }
}
