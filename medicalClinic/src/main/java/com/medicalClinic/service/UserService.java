package com.medicalClinic.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.medicalClinic.DTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService implements IGenericService<UserDTO, Long> {

    @Autowired
    private ObjectMapper mapper;

    @Override
    public UserDTO find(Long aLong) {
        return null;
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        return null;
    }

    @Override
    public Boolean delete(UserDTO userDTO) {
        return null;
    }

    @Override
    public List<UserDTO> findAll() {
        return null;
    }

    @Override
    public UserDTO update(UserDTO userDTO, Long aLong) {
        return null;
    }
}
