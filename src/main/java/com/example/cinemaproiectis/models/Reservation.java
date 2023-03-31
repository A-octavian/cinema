package com.example.cinemaproiectis.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "reservations")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "userIdFkk"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "broadcast_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "broadcastIdFk"))
    private Broadcast broadcast;
}
