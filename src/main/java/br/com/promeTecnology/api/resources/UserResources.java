package br.com.promeTecnology.api.resources;

import br.com.promeTecnology.api.domain.User;
import br.com.promeTecnology.api.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user") //..
public class UserResources {

    @Autowired
    private UserServices services;
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById( @PathVariable Long id ) {
        var user = services.findById( id );

        return ResponseEntity.ok().body( user );
    }

 }
