package br.com.promeTecnology.api.services;

import br.com.promeTecnology.api.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserServices {
    public User findById( Long id );

    Page<User> findAll (Pageable paginacao);
}
