package com.olbnar.olddatabaseprocessor.service;

import com.olbnar.olddatabaseprocessor.mappers.UserMapper;
import com.olbnar.olddatabaseprocessor.models.OldUser;
import com.olbnar.olddatabaseprocessor.models.User;
import com.olbnar.olddatabaseprocessor.repositories.OldUserRepository;
import com.olbnar.olddatabaseprocessor.repositories.UserRepository;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
@EnableBatchProcessing
public class OldUserService {

    @Autowired
    private OldUserRepository oldUserRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public static final String BANK = "jab";

    public void processOldUsers() {
        List<OldUser> oldUsers = getAllUsers();
        List<OldUser> filteredByBank = getFilteredOldUsers(oldUsers);
        List<User> users = userMapper.mappedUsers(filteredByBank);
        userRepository.saveAll(users);
    }

    private List<OldUser> getFilteredOldUsers(List<OldUser> oldUsers) {
        return oldUsers.stream().filter(u -> u.getBanco().equals(BANK)).collect(Collectors.toList());
    }

    private List<OldUser> getAllUsers() {
        return oldUserRepository.findAll();
    }

}