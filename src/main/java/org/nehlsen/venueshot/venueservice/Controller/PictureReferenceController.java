package org.nehlsen.venueshot.venueservice.Controller;

import org.nehlsen.venueshot.venueservice.Entity.PictureReference;
import org.nehlsen.venueshot.venueservice.Repository.PictureReferenceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/{venueUuid}")
public class PictureReferenceController {
    private final PictureReferenceRepository pictureReferenceRepository;

    public PictureReferenceController(PictureReferenceRepository pictureReferenceRepository) {
        this.pictureReferenceRepository = pictureReferenceRepository;
    }

    // TODO for incremental updates: list all pictures added after-datetime
    // TODO allow to moderate picture aka ban eg nudity

    @GetMapping("/picture/")
    public List<PictureReference> list(@PathVariable String venueUuid) {
        return Collections.unmodifiableList(pictureReferenceRepository.findByVenue(UUID.fromString(venueUuid)));
    }

    @PostMapping("/picture/")
    @ResponseStatus(HttpStatus.CREATED)
    public PictureReference createPictureReference(@PathVariable String venueUuid, @RequestBody PictureReferenceCreateDto dto) {
        try {
            // TODO validate PictureReference?
            final PictureReference pictureReference = new PictureReference();
            pictureReference.setVenue(UUID.fromString(venueUuid));
            pictureReference.setPublicUrl(new URL(dto.url));

            return pictureReferenceRepository.save(pictureReference);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
