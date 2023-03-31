package com.example.cinemaproiectis.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "wishlists")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "userIdFkkkk"))
    private User user;
}
