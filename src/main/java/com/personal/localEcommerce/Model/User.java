package com.personal.localEcommerce.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.personal.localEcommerce.Utils.RoleUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class User {

    // Clave primaria
    @Id
    // Generación autmática del id del user
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    // Cmapo de tipo enum y el string indica que debe ser almacenado como un string en la bbdd mysql
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleUser roleUser;

    @Column
    private Date registerDate;

    @JsonIgnoreProperties("owner")
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Store> stores = new ArrayList<>();

}
