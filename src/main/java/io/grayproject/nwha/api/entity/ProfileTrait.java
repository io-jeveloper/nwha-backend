package io.grayproject.nwha.api.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

/**
 * @author Ilya Avkhimenya
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "profiles_traits")
public class ProfileTrait {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "trait_id", nullable = false)
    private Trait trait;

    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    @Column(nullable = false)
    private Integer value; // percentage

    @CreationTimestamp
    @Column(nullable = false)
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;
}
