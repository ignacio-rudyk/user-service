package com.accenture.userservice.dao;

import com.accenture.userservice.model.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<User, Long> {

}
