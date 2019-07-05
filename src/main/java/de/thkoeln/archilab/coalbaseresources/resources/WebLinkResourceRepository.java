package de.thkoeln.archilab.coalbaseresources.resources;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource()
public interface WebLinkResourceRepository extends MongoRepository<WebLinkResource, String> {

  public List<WebLinkResource> findByReferenceId(UUID referenceId);

}
