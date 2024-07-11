package org.nehlsen.venueshot.venueservice.Repository;

import org.nehlsen.venueshot.venueservice.Entity.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VenueRepository extends JpaRepository<Venue, UUID> {
}