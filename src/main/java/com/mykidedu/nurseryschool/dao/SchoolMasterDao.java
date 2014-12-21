package com.mykidedu.nurseryschool.dao;

import com.mykidedu.nurseryschool.entity.Schools;
import com.mykidedu.nurseryschool.entity.SchoolMaster;
import com.mykidedu.nurseryschool.entity.Users;

public interface SchoolMasterDao extends BaseDao<SchoolMaster> {
	public SchoolMaster createSchoolMaster(Schools school, Users user);

	public SchoolMaster getSchoolMaster(int schoolId, int userId);
}
