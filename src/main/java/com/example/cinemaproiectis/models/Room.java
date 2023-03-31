package com.example.cinemaproiectis.models;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "rooms")
@ToString
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private int seats;
    private String location;

    @OneToMany(mappedBy = "room")
    private Set<Broadcast> broadcasts = new HashSet<>();
}
