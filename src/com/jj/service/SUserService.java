package com.jj.service;

import com.jj.bean.SUser;

public interface SUserService {
    public SUser login(SUser suser);
    public void registUser(SUser suser);
    public boolean existsUsername(String username);
}
