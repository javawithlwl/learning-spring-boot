package com.careerit.sc.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
  @Autowired
  private SeedDataProvider seedDataProvider;

  private List<AppUser> users;
  @Override
  public AppUser login(String username, String password) {
    this.users = seedDataProvider.getUsers();
    for (AppUser user : users) {
      if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
        return user;
      }
    }
    return null;
  }

  public SeedDataProvider getSeedDataProvider() {
    return seedDataProvider;
  }

  public void setSeedDataProvider(SeedDataProvider seedDataProvider) {
    this.seedDataProvider = seedDataProvider;
  }
}
