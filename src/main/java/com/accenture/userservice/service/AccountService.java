package com.accenture.userservice.service;

import com.accenture.userservice.exception.UserServiceException;
import com.accenture.userservice.model.dto.AccountDTO;

import java.util.List;

public interface AccountService {

    List<AccountDTO> removeAccountsByUserId(Long userId) throws UserServiceException;

}
