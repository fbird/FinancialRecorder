package com.financial.tools.recorderserver.store;

import java.util.List;

import com.financial.tools.recorderserver.entity.User;

public interface UserStore {

	public User getUser(long userId);

	public User getUserByName(String userName);

	public void updateBalance(long userId, float balance);

	public long saveUser(User user);

	public List<User> findUserByType(int userType);

	public List<User> findAll();

}
