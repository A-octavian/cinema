package com.example.cinemaproiectis.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@ToString
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)

    private Long id;

    @OneToMany(mappedBy = "user")
    private Set<Movie> movies = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Reservation> reservations = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Review> reviews = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<WishList> wishList = new HashSet<>();

    private boolean isAdmin;

    private boolean isEmployee;

    @Column( nullable = false)
    private String firstName;

    @Column( nullable = false)
    private String lastName;

    @Column( nullable = false)
    private String email;

    @Column( nullable = false)
    private String password;

    @Column( nullable = false)
    private String phoneNumber;

    public User(boolean isAdmin, boolean isEmployee, String firstName, String lastName, String email, String password, String phoneNumber) {
        this.isAdmin = isAdmin;
        this.isEmployee = isEmployee;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public User() {
    }
}
