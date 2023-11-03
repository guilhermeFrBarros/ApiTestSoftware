package br.com.promeTecnology.api.services.impl;

import br.com.promeTecnology.api.domain.User;
import br.com.promeTecnology.api.repositories.UserRepository;
import br.com.promeTecnology.api.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserServices {

    @Autowired
    private UserRepository repository;
    @Override
    public User findById(Long id) {
        var user = repository.findById( id );

        return user.orElse(null);
    }
}
