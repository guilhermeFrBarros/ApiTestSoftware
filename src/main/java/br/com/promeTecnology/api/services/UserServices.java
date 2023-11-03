package br.com.promeTecnology.api.services;

import br.com.promeTecnology.api.domain.User;

public interface UserServices {
    public User findById( Long id );
}
