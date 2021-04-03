package com.jj.service;

import com.jj.bean.User;

public interface UserService {

    //public boolean saveUser(User user);
    public User login(User user);
    public void registUser(User user);
    public boolean existsUsername(String username);
}
