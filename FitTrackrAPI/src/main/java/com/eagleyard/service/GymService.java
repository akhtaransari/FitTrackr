package com.eagleyard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eagleyard.dto.RenewMember;
import com.eagleyard.entity.AllTImeRecord;
import com.eagleyard.entity.Member;
import com.eagleyard.repository.AllMemberRepo;
import com.eagleyard.repository.MemberRepo;
@Service
public class GymService implements IGymService{

	@Autowired
	MemberRepo memberRepo;
	@Autowired
	AllMemberRepo allMemberRepo;
	
	@Override
	public Member addMemmber(Member member) {
		AllTImeRecord allTImeRecord = new AllTImeRecord(member.getId(),member.getNameValue(),member.getMobileValue(),member.getStartDateValue(),member.getEndDateValue(),member.getGenderValue());
		allMemberRepo.save(allTImeRecord);
		return 	memberRepo.save(member);
	}

	@Override
	public List<Member> getMemmbers() {		
		return memberRepo.findAll();
	}

	@Override
	public Member deletMemmber(Integer memberId) {
		Optional<Member> findById = memberRepo.findById(memberId);
		memberRepo.deleteById(memberId);
		return findById.get();
	}

	@Override
	public Member updateMemmber(RenewMember renewMember, Integer memberId) {
		Member member = memberRepo.findById(memberId).get();
		member.setStartDateValue(renewMember.getStartDateValue());
		member.setEndDateValue(renewMember.getEndDateValue());
		return memberRepo.save(member);
	}

}
