package io.thkoeln.archilab.coalbaseresources.resources;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;


@Setter
@Getter
@ToString(callSuper = true)
public class WebLinkResource {

  @Id
  public String id;
  private UUID referenceId;
  private String description;
  private String webLink;

  public WebLinkResource(String id, UUID referenceId, String description, String webLink) {
    this.id = id;
    this.referenceId = referenceId;
    this.description = description;
    this.webLink = webLink;
  }
}
