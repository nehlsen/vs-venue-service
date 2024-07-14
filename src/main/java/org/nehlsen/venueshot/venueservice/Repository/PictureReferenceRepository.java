package org.nehlsen.venueshot.venueservice.Repository;

import org.nehlsen.venueshot.venueservice.Entity.PictureReference;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PictureReferenceRepository extends JpaRepository<PictureReference, UUID> {
    List<PictureReference> findByVenue(UUID venueId);
}