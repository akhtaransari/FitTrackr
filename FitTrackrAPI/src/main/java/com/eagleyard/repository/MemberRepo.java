package com.eagleyard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eagleyard.entity.Member;

public interface MemberRepo extends JpaRepository<Member, Integer>{

}
