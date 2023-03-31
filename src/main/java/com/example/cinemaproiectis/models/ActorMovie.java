package com.example.cinemaproiectis.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "movie_actor")
@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
public class ActorMovie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "actor_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "actorIdFk"))
    private Actor actor;

    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "movieIdFkk"))
    private Movie movie;
}
