package com.mykidedu.nurseryschool.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.mykidedu.nurseryschool.dao.UserDao;
import com.mykidedu.nurseryschool.entity.Schools;
import com.mykidedu.nurseryschool.entity.SchoolMaster;
import com.mykidedu.nurseryschool.entity.SchoolMasterId;
import com.mykidedu.nurseryschool.entity.Users;

@Repository
public class UserDaoImp extends BaseDaoImp<Users> implements UserDao {

	static Logger log = Logger.getLogger(UserDaoImp.class);

	public List<Users> getUsers(String userName) {

		log.info("can you see me?-->" + userName);

		List<Users> userList = (List<Users>) getCurrentSession()
				.createQuery(
						"select p from Users p where p.userName like :pUserName")
				.setParameter("pUserName", "%" + userName + "%").list();

		return userList;
	}

	public Users getUser(String userName) {
		// log.info("can you see me?-->" + userName);

		List<Users> userList = (List<Users>) getCurrentSession()
				.createQuery(
						"select p from Users p where p.userName = :pUserName")
				.setParameter("pUserName", userName).list();

		return (userList.size() > 0) ? userList.get(0) : null;
	}
}
