package br.com.promeTecnology.api.resources;

import br.com.promeTecnology.api.domain.User;
import br.com.promeTecnology.api.domain.dto.UserDTO;
import br.com.promeTecnology.api.services.UserServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/user") //..
public class UserResources {

    @Autowired
    private ModelMapper mapper;
    @Autowired
    private UserServices services;
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id ) {
        var user = services.findById( id );

        return ResponseEntity.ok().body( mapper.map( user,  UserDTO.class ));
    }

    @GetMapping
    public ResponseEntity< Page< UserDTO > > findAll(@PageableDefault( size = 10, sort = {"name"}) Pageable paginacao ) {
        Page<User> pageUser = services.findAll(paginacao);
        Page<UserDTO> pageUserDTO = pageUser.map(x -> mapper.map( x,  UserDTO.class ) );

        return ResponseEntity.ok().body(pageUserDTO);
    }

 }
