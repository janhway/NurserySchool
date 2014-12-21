package com.mykidedu.nurseryschool.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mykidedu.nurseryschool.entity.Schools;

@Repository
public class SchoolDaoImp extends BaseDaoImp<Schools> implements SchoolDao {

	// static Logger log = Logger.getLogger(SchoolDaoImp.class);

	public Schools getSchool(String name) {

		List<Schools> list = (List<Schools>) getCurrentSession()
				.createQuery("select p from Schools p where p.name = :pName")
				.setParameter("pName", name).list();

		return (list.size() > 0) ? list.get(0) : null;
	}

}