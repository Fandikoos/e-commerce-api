package com.personal.localEcommerce.Repository;


import com.personal.localEcommerce.LocalEcommerceApplication;
import com.personal.localEcommerce.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


// El repositorio es el encargado de interaccionar con la bbdd
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //Extender de JPA repository proporciona metodos para realizar operaciones CRUD para no ahcerlo manualmente
}
