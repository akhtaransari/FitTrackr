package com.eagleyard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eagleyard.entity.AllTImeRecord;

public interface AllMemberRepo extends JpaRepository<AllTImeRecord, Integer>{

}
