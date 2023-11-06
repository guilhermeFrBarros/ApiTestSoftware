package br.com.promeTecnology.api.services.impl;

import br.com.promeTecnology.api.domain.User;
import br.com.promeTecnology.api.repositories.UserRepository;
import br.com.promeTecnology.api.services.UserServices;
import br.com.promeTecnology.api.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserServices {

    @Autowired
    private UserRepository repository;
    @Override
    public User findById(Long id) {
        var user = repository.findById( id );

        return user.orElseThrow( () -> new ObjectNotFoundException("Objeto não encotrado") ) ;
    }
}
