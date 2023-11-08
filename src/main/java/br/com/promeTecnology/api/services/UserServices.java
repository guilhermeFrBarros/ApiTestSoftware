package br.com.promeTecnology.api.services;

import br.com.promeTecnology.api.domain.User;
import br.com.promeTecnology.api.domain.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;

public interface UserServices {
    public User findById( Long id );

    Page<User> findAll (Pageable paginacao);

    User create(UserDTO userDTO);

}
