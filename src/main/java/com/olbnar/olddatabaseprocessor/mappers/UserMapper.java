package com.olbnar.olddatabaseprocessor.mappers;

import com.olbnar.olddatabaseprocessor.models.OldUser;
import com.olbnar.olddatabaseprocessor.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserMapper {

    public List<User> mappedUsers(List<OldUser> oldUsers) {
        List<User> users = new ArrayList<>();
        oldUsers.forEach(oldUser -> {
            User user = new User();
            user.setName(oldUser.getNome().toUpperCase());
            user.setPassword(oldUser.getSenha());
            user.setEmail(oldUser.getEmail().toLowerCase());
            user.setActive(oldUser.getAtivo());
            user.setJoinDate(new Date());
            user.setLastLoginDate(new Date());
            user.setLastLoginDateDisplay(new Date());
            user.setNotLocked(true);
            user.setRoles("USER");
            users.add(user);
        });
        return users;
    }
}
