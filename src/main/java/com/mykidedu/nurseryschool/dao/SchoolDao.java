package com.mykidedu.nurseryschool.dao;

import com.mykidedu.nurseryschool.entity.Schools;

public interface SchoolDao extends BaseDao<Schools> {
	
	public Schools getSchool(String name);

}