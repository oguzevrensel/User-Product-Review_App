package com.example.application.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(max = 50)
    @NotBlank
    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @Size(max = 50)
    @Column(name = "last_name")
    private String lastName;

    @Size(max = 50)
    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private long phoneNumber;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<ProductReview> productReviews;
}
