/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biz.report.dao;

import java.util.List;

/**
 *
 * @author Aux-058
 */
public interface BaseDao<T> {

    /**
     * Creates the.
     *
     * @param type the type
     * @return the long
     */
    Long create(T type);

    /**
     * Merge.
     *
     * @param type the type
     * @return the long
     */
    void merge(T type);

    /**
     * Read.
     *
     * @param id the id
     * @return the t
     */
    T read(Long id);

    /**
     * Update.
     *
     * @param type the type
     */
    void update(T type);

    /**
     * Delete.
     *
     * @param type the type
     */
    void delete(T type);

    /**
     * Read all.
     *
     * @return the list
     */
    List<T> readAll();
}
