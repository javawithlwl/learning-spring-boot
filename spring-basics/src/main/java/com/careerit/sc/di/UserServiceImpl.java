package com.careerit.sc.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class UserServiceImpl implements UserService{

  @Autowired
  private UserDao userDao;

  @Override
  public AppUser login(String username, String password) {
    Assert.notNull(username,"Username should not be null");
    Assert.notNull(password,"Password should not be null");
    AppUser user = userDao.login(username,password);
    return user;
  }

  public UserDao getUserDao() {
    return userDao;
  }

  public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
  }
}
