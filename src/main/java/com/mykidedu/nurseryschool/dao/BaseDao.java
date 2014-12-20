package com.mykidedu.nurseryschool.dao;

import java.util.List;

public interface BaseDao<T> {
	
	public void create(T entity);

	public void update(T entity);

	public void delete(T entity);

	public void delete(long id);

	public T load(int id);

	public T load(long id);

	public T get(int id);

	public T get(long id);

	public List<T> list();

	public List<T> list(int start, int count);

}
