package com.accenture.userservice.service.implementation;

import com.accenture.userservice.dao.UserDAO;
import com.accenture.userservice.model.dto.UserDTO;
import com.accenture.userservice.model.entities.User;
import com.accenture.userservice.service.UserService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private Mapper mapper;

    @Override
    public UserDTO saveUser(UserDTO newUser) {
        if(newUser != null){
            User user = mapper.map(newUser, User.class);
            user = userDAO.save(user);
            return mapper.map(user, UserDTO.class);
        }
        return null;
    }

    @Override
    public void delete(Long id){
        if(id != null){
            userDAO.deleteById(id);
        }
    }

    @Override
    public UserDTO findById(Long id) {
        UserDTO ret = null;
        Optional<User> result = userDAO.findById(id);
        if(!result.isEmpty()){
            ret = mapper.map(result.get(), UserDTO.class);
        }
        return ret;
    }

    @Override
    public Boolean existsById(Long id){
        if(id != null) {
            return userDAO.existsById(id);
        }
        return Boolean.FALSE;
    }

    @Override
    public List<UserDTO> list() {
        List<User> list = (List<User>) userDAO.findAll();
        return list.stream()
                   .map(e -> mapper.map(e, UserDTO.class))
                   .collect(Collectors.toList());
    }

    private String createSequenceOfNumbers(Integer quantity){
        String cbu = "";
        for(int i = 0 ; i < quantity ; i++) {
            cbu += (int) (Math.random() * 9) + 1;
        }
        return cbu;
    }
}
