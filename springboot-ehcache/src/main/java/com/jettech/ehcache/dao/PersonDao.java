package com.jettech.ehcache.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jettech.ehcache.bean.Person;

public interface PersonDao extends JpaRepository<Person, Long> {

}
