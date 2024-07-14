package org.nehlsen.venueshot.venueservice.Controller;

import org.nehlsen.venueshot.venueservice.Entity.Venue;
import org.nehlsen.venueshot.venueservice.Repository.VenueRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
public class VenueController {
    private final VenueRepository venueRepository;

    public VenueController(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    @GetMapping("/")
    public List<Venue> list() {
        return Collections.unmodifiableList(venueRepository.findAll());
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Venue createVenue(@RequestBody Venue venue) {
        // TODO validate venue
        return venueRepository.save(venue);
    }

    @GetMapping("/{venueUuid}")
    public Venue getVenue(@PathVariable String venueUuid) {
        return venueRepository.findById(UUID.fromString(venueUuid)).orElseThrow(VenueNotFoundException::new);
    }
}
