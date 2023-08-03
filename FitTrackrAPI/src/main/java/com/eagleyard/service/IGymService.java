package com.eagleyard.service;

import java.util.List;

import com.eagleyard.dto.RenewMember;
import com.eagleyard.entity.Member;

public interface IGymService {
	
	Member addMemmber( Member member);	   
	List<Member> getMemmbers();
	Member deletMemmber(Integer memberId);
	Member updateMemmber(RenewMember renewMember , Integer memberId);
}
