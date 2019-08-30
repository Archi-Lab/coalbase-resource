package io.archilab.coalbase.resource.resources;

import java.util.List;
import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource()
public interface WebLinkResourceRepository extends MongoRepository<WebLinkResource, String> {

  public List<WebLinkResource> findByReferenceId(UUID referenceId);

  void deleteAllByReferenceId(UUID referenceId);

}
