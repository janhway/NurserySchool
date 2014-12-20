package com.mykidedu.nurseryschool.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.mykidedu.nurseryschool.dao.UserDao;
import com.mykidedu.nurseryschool.entity.User;

@Repository
//@Transactional
public class UserDaoImp extends BaseDaoImp<User> implements UserDao {

	static Logger log = Logger.getLogger(UserDaoImp.class);

	public List<User> getUsers(String userName) {

		log.info("can you see me?-->" + userName);

		List<User> userList = (List<User>) getCurrentSession()
				.createQuery(
						"select p from User p where p.userName like :pUserName")
				.setParameter("pUserName", "%" + userName + "%").list();

		return userList;
	}

	public User getUser(String userName) {
		//log.info("can you see me?-->" + userName);

		List<User> userList = (List<User>) getCurrentSession()
				.createQuery(
						"select p from User p where p.userName = :pUserName")
				.setParameter("pUserName", userName ).list();

		return userList.size()>0?userList.get(0):null;
	}

}
