package com.mykidedu.nurseryschool.dao;

import java.util.List;
import com.mykidedu.nurseryschool.entity.User;

public interface UserDao extends BaseDao<User> {

	public List<User> getUsers(String userName);
	
	public User getUser(String userName);
}