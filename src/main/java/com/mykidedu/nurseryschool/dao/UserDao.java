package com.mykidedu.nurseryschool.dao;

import java.util.List;
import com.mykidedu.nurseryschool.entity.Users;

public interface UserDao extends BaseDao<Users> {

	public List<Users> getUsers(String userName);
	
	public Users getUser(String userName);
}