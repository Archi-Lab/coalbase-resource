package de.thkoeln.archilab.coalbaseresources.learningspace;


import de.thkoeln.archilab.coalbaseresources.core.DomainEvent;
import de.thkoeln.archilab.coalbaseresources.core.UniqueId;

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
    return learningSpaceIdentifier;
  }
}
