package br.com.promeTecnology.api.services.impl;

import br.com.promeTecnology.api.domain.User;
import br.com.promeTecnology.api.domain.dto.UserDTO;
import br.com.promeTecnology.api.repositories.UserRepository;
import br.com.promeTecnology.api.services.UserServices;
import br.com.promeTecnology.api.services.exceptions.DataIntegratvViolationException;
import br.com.promeTecnology.api.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        findByEmail( userDTO );
        return repository.save( mapper.map( userDTO, User.class) );
    }

    @Override
    public User update(UserDTO userDTO) {
        findByEmail( userDTO );
        var user = repository.getReferenceById( userDTO.getId() );
        user.atulaizarInformacoes( userDTO );

        return user;
    }

    @Override
    public void delete( Long id ) {
        repository.deleteById( id );
    }

    public void findByEmail( UserDTO userDTO) {
        Optional<User> user = repository.findByEmail( userDTO.getEmail() );

        if ( user.isPresent() && !user.get().getId().equals(userDTO.getId()) ) {
            throw new DataIntegratvViolationException(" email ja cadastrado");
        }
    }
}
