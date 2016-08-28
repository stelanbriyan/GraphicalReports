/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biz.report.dao.impl;

import com.biz.report.dao.BaseDao;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

/**
 *
 * @author Aux-058
 */
public abstract class BaseDaoImpl<T> implements BaseDao<T> {

    /**
     * The type.
     */
    Class<T> type;

    /**
     * The hibernate template.
     */
    @Autowired
    private HibernateTemplate hibernateTemplate;

    /**
     * Gets the hibernate template.
     *
     * @return the hibernate template
     */
    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    /**
     * Instantiates a new base dao impl.
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public BaseDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        // T's actual type. This is only used when type obj
        // cannot be sent in the method parameter
        type = (Class) pt.getActualTypeArguments()[0];
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see sl.com.base.dao.BaseDao#creat(java.lang.Object)
     */
    public Long create(T type) {
        return (Long) hibernateTemplate.save(type);
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see sl.com.base.dao.BaseDao#read(java.lang.Long)
     */
    public T read(Long id) {
        return hibernateTemplate.get(type, id);
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see sl.com.base.dao.BaseDao#update(java.lang.Object)
     */
    public void update(T type) {
        hibernateTemplate.update(type);
    }

    public void merge(T type) {
        hibernateTemplate.merge(type);
    }

    public void delete(T type) {
        hibernateTemplate.delete(type);
    }

    public List<T> readAll() {
        return hibernateTemplate.loadAll(type);
    }
}
