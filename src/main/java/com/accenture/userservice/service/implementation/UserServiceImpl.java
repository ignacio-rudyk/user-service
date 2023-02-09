package com.accenture.userservice.service.implementation;

import com.accenture.userservice.dao.UserDAO;
import com.accenture.userservice.exception.FieldNullException;
import com.accenture.userservice.exception.UserDAOException;
import com.accenture.userservice.exception.UserInexistentException;
import com.accenture.userservice.exception.UserServiceException;
import com.accenture.userservice.model.dto.UserDTO;
import com.accenture.userservice.model.entities.User;
import com.accenture.userservice.service.AccountService;
import com.accenture.userservice.service.UserService;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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

    @Autowired
    private AccountService accountService;

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Override
    public UserDTO saveUser(UserDTO newUser) throws UserServiceException, UserDAOException {
        if(newUser != null) {
            try{
                User user = mapper.map(newUser, User.class);
                user.setIsEnabled(userIsEnabled(newUser));
                user = userDAO.save(user);
                return mapper.map(user, UserDTO.class);
            } catch (DataAccessException e) {
                logger.error("[Error " + e.getClass() + "] " + e.getMessage());
                throw new UserDAOException();
            } catch (UserServiceException e) {
                logger.error("[Error " + e.getClass() + "] " + e.getMessage());
                throw e;
            } catch (Throwable t) {
                logger.error("[Error " + t.getClass() + "] " + t.getMessage());
                throw t;
            }
        } else {
            throw new FieldNullException();
        }
    }

    @Override
    public UserDTO delete(Long id) throws UserServiceException {
        if(id == null) {
            throw new FieldNullException();
        }
        if(!existsById(id)){
            throw new UserInexistentException();
        }
        try{
            accountService.removeAccountsByUserId(id);
            UserDTO user = findById(id);
            User userDisabled = mapper.map(user, User.class);
            userDisabled.setIsEnabled(Boolean.FALSE);
            userDisabled = userDAO.save(userDisabled);
            return mapper.map(userDisabled, UserDTO.class);
        } catch (UserServiceException e) {
            logger.error("[Error " + e.getClass() + "] " + e.getMessage());
            throw e;
        } catch (Throwable t) {
            logger.error("[Error " + t.getClass() + "] " + t.getMessage());
            throw t;
        }
    }

    @Override
    public UserDTO findById(Long id) throws UserServiceException {
        if(id == null) {
            throw new FieldNullException();
        }
        Optional<User> result = userDAO.findById(id);
        if(!result.isEmpty()) {
            return mapper.map(result.get(), UserDTO.class);
        }else {
            throw new UserInexistentException();
        }
    }

    @Override
    public Boolean existsById(Long id) throws UserServiceException{
        if(id == null) {
            throw new FieldNullException();
        }
        if(userDAO.existsById(id)) {
            UserDTO userFound = findById(id);
            return userFound.getIsEnabled();
        } else {
            return Boolean.FALSE;
        }
    }

    @Override
    public List<UserDTO> list() {
        List<User> list = (List<User>) userDAO.findAll();
        return list.stream()
                   .filter(e -> e.getIsEnabled())
                   .map(e -> mapper.map(e, UserDTO.class))
                   .collect(Collectors.toList());
    }

    private Boolean userIsEnabled(UserDTO user) throws UserServiceException {
        try {
            if(existsById(user.getId())){
                UserDTO userFound = findById(user.getId());
                return userFound.getIsEnabled();
            } else {
                return Boolean.TRUE;
            }
        } catch (FieldNullException e) {
            return Boolean.TRUE;
        }
    }
}
