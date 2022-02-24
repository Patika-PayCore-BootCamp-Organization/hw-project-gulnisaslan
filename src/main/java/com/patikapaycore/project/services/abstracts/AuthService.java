package com.patikapaycore.project.services.abstracts;


import com.patikapaycore.project.models.entities.User;

import javax.servlet.http.HttpServletRequest;

public interface AuthService {
    String signIn(String username,String password);
    String signUp(User user);
    void deleteUser(String username);
    User searchUser(String username);
    User whoAmI(HttpServletRequest httpServletRequest);
    String refresh(String username);

}
