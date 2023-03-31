package com.example.cinemaproiectis.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table( name = "broadcasts")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Broadcast {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private Date date;

    @OneToMany(mappedBy = "broadcast")
    private Set<Reservation> reservations = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "movieIdFk"))
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "roomIdFk"))
    private Room room;
}
