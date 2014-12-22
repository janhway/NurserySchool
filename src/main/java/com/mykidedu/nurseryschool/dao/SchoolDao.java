package com.mykidedu.nurseryschool.dao;

import com.mykidedu.nurseryschool.entity.School;

public interface SchoolDao extends BaseDao<School> {
	
	public School getSchool(String name);

}