package br.com.promeTecnology.api.resources;

import br.com.promeTecnology.api.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user") //..
public class UserResources {

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById( @PathVariable Long id ) {

        return ResponseEntity.ok().body( new User( id, "gui", "gui@gmail.com", "123") );

    }

 }
