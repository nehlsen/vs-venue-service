package org.nehlsen.venueshot.venueservice.Controller;

import org.nehlsen.venueshot.venueservice.Entity.Venue;
import org.nehlsen.venueshot.venueservice.Repository.VenueRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class VenueController {
    private final VenueRepository venueRepository;

    public VenueController(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    @GetMapping("/")
    public List<Venue> index() {
        return Collections.unmodifiableList(venueRepository.findAll());
    }
}
