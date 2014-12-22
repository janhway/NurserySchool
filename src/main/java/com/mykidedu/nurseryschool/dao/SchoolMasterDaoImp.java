package com.mykidedu.nurseryschool.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mykidedu.nurseryschool.entity.School;
import com.mykidedu.nurseryschool.entity.SchoolMaster;
import com.mykidedu.nurseryschool.entity.SchoolMasterId;
import com.mykidedu.nurseryschool.entity.User;

@Repository
public class SchoolMasterDaoImp extends BaseDaoImp<SchoolMaster> implements
		SchoolMasterDao {

	@Autowired
	private UserDao userDao;

	public SchoolMaster createSchoolMaster(School school, User user) {

		// 创建用户，并检查用户的id
		userDao.create(user);
		User tmpUser = userDao.getUser(user.getUserName());
		if (tmpUser == null) {
			return null; // 可以不抛异常
		}

		SchoolMaster master = new SchoolMaster();
		SchoolMasterId masterId = new SchoolMasterId();
		masterId.setSchool(school);
		masterId.setUser(tmpUser);
		master.setSchoolMasterId(masterId);

		getCurrentSession().save(master); // 失败应该会抛异常，那么会回滚增加的用户

		return master;
	}

	public SchoolMaster getSchoolMaster(int schoolId, int userId) {

		List<SchoolMaster> list = (List<SchoolMaster>) getCurrentSession()
				.createQuery(
						"select p from SchoolMaster p where p.schoolMasterId.school.id = :pSchoolId and  p.schoolMasterId.user.id = :pUserId")
				.setParameter("pSchoolId", schoolId)
				.setParameter("pUserId", userId).list();

		return (list.size() > 0) ? list.get(0) : null;
	}

}
