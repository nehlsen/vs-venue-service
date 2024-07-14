package org.nehlsen.venueshot.venueservice.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;
import java.util.UUID;

@Getter
@Setter
@Entity
public class PictureReference {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(nullable = false)
    private UUID venue;

    @Column(nullable = false)
    private URL publicUrl; // FIXME rename to url
}
