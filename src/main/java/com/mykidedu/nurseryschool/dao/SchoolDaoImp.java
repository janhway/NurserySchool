package com.mykidedu.nurseryschool.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mykidedu.nurseryschool.entity.School;

@Repository
public class SchoolDaoImp extends BaseDaoImp<School> implements SchoolDao {

	// static Logger log = Logger.getLogger(SchoolDaoImp.class);

	public School getSchool(String name) {

		List<School> list = (List<School>) getCurrentSession()
				.createQuery("select p from Schools p where p.name = :pName")
				.setParameter("pName", name).list();

		return (list.size() > 0) ? list.get(0) : null;
	}

}