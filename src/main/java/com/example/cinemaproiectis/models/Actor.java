package com.example.cinemaproiectis.models;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "actors")
@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "actor")
    private Set<ActorMovie> actorMovies = new HashSet<>();
}
