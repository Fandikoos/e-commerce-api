package com.personal.localEcommerce.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "stores")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @JsonBackReference
    // Many to one con User (un usario puede tener muchas tiendas)
    // optional indica que cada tienda debe tener un propietario 100%
    @ManyToOne()
    // Foreign key permite dar un nombre personalizado a la clave foranea en bbdd para tener un esquema más claro
    // La columna user_id de la tabla stores será una clave foranea que ahcer referencia a la id de la tabla users
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "FK_USER_STORE"))
    private User owner;
}
