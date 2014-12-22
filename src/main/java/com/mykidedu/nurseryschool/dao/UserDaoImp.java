package com.mykidedu.nurseryschool.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.mykidedu.nurseryschool.dao.UserDao;
import com.mykidedu.nurseryschool.entity.School;
import com.mykidedu.nurseryschool.entity.SchoolMaster;
import com.mykidedu.nurseryschool.entity.SchoolMasterId;
import com.mykidedu.nurseryschool.entity.User;

@Repository
public class UserDaoImp extends BaseDaoImp<User> implements UserDao {

	static Logger log = Logger.getLogger(UserDaoImp.class);

	public List<User> getUsers(String userName) {

		log.info("can you see me?-->" + userName);

		List<User> userList = (List<User>) getCurrentSession()
				.createQuery(
						"select p from Users p where p.userName like :pUserName")
				.setParameter("pUserName", "%" + userName + "%").list();

		return userList;
	}

	public User getUser(String userName) {
		// log.info("can you see me?-->" + userName);

		List<User> userList = (List<User>) getCurrentSession()
				.createQuery(
						"select p from Users p where p.userName = :pUserName")
				.setParameter("pUserName", userName).list();

		return (userList.size() > 0) ? userList.get(0) : null;
	}
}
