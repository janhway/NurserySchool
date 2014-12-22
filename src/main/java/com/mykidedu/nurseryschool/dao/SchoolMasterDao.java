package com.mykidedu.nurseryschool.dao;

import com.mykidedu.nurseryschool.entity.School;
import com.mykidedu.nurseryschool.entity.SchoolMaster;
import com.mykidedu.nurseryschool.entity.User;

public interface SchoolMasterDao extends BaseDao<SchoolMaster> {
	public SchoolMaster createSchoolMaster(School school, User user);

	public SchoolMaster getSchoolMaster(int schoolId, int userId);
}
