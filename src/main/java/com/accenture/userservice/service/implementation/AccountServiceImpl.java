package com.accenture.userservice.service.implementation;

import com.accenture.userservice.exception.UserServiceException;
import com.accenture.userservice.model.ErrorResponse;
import com.accenture.userservice.model.dto.AccountDTO;
import com.accenture.userservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${account.service.server.port}")
    private String accountServicePort;

    private static String DOMAIN = "http://localhost:";

    private static String REMOVE_ACCOUNTS_BY_USER_ID_SERVICE = "/account/removeAccountsByUserId/";

    @Override
    public List<AccountDTO> removeAccountsByUserId(Long userId) throws UserServiceException{
        try{
            String url = DOMAIN + accountServicePort + REMOVE_ACCOUNTS_BY_USER_ID_SERVICE + userId;
            restTemplate.setMessageConverters(getJsonMessageConverters());
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
            ResponseEntity<ErrorResponse> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, ErrorResponse.class);
            ErrorResponse errorResponse = responseEntity.getBody();
            if(responseEntity.getStatusCode().equals(HttpStatus.OK)){
                if(errorResponse.getCode() == 0){
                    return (List<AccountDTO>) errorResponse.getData();
                } else {
                    throw new UserServiceException(errorResponse.getDesc(), errorResponse.getCode());
                }
            } else {
                throw new UserServiceException(errorResponse.getDesc(), errorResponse.getCode());
            }
        } catch (Throwable t) {
            throw t;
        }
    }

    private List<HttpMessageConverter<?>> getJsonMessageConverters() {
        List<HttpMessageConverter<?>> converters = new ArrayList<>();
        converters.add(new MappingJackson2HttpMessageConverter());
        return converters;
    }

}
