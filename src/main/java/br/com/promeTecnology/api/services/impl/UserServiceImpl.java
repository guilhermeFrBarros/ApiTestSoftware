package br.com.promeTecnology.api.services.impl;

import br.com.promeTecnology.api.domain.User;
import br.com.promeTecnology.api.domain.dto.UserDTO;
import br.com.promeTecnology.api.repositories.UserRepository;
import br.com.promeTecnology.api.services.UserServices;
import br.com.promeTecnology.api.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserServices {

    @Autowired
    private UserRepository repository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public User findById(Long id) {
        var user = repository.findById( id );

        return user.orElseThrow( () -> new ObjectNotFoundException("Objeto não encotrado") ) ;
    }

    @Override
    public Page<User> findAll(Pageable paginacao) {
        var pageUser = repository.findAll(paginacao);

        return pageUser;
    }

    @Override
    public User create(UserDTO userDTO) {
        var user = repository.save( mapper.map( userDTO, User.class) );
        return user;
    }
}
