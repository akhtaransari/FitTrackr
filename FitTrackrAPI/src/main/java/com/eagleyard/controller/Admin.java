package com.eagleyard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eagleyard.dto.AuthData;
import com.eagleyard.dto.RenewMember;
import com.eagleyard.entity.Member;
import com.eagleyard.service.GymService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin(origins = "*")
@Valid
public class Admin{
	
	@Autowired
	GymService gym;

   @PostMapping("/add")
   ResponseEntity<Member> addMemmber(@RequestBody Member member){
	   log.info("Member with name"+member.getNameValue() +"added" , member);
	   return new ResponseEntity<>(gym.addMemmber(member) ,HttpStatus.OK);
   }

   
   @GetMapping("/member")
   ResponseEntity<List<Member>> getMemmbers(){
	   log.info("Memeber List Requested");
	   return new ResponseEntity<>(gym.getMemmbers() ,HttpStatus.OK);
   }
   
   @DeleteMapping("/delete/{memberId}")
   ResponseEntity<Member> deletMemmber(@PathVariable Integer memberId){
	   log.info("Member with id {}"+memberId+"deleyed");
	   return new ResponseEntity<>(gym.deletMemmber(memberId) ,HttpStatus.OK);
   }
   
   @PatchMapping("/update/{memberId}")
   ResponseEntity<Member> updateMemmber(@RequestBody RenewMember renewMember , @PathVariable Integer memberId){
	   log.info("Member with id {}"+memberId+"Renewed");
	   return new ResponseEntity<>(gym.updateMemmber(renewMember,memberId) ,HttpStatus.OK);
	   
   }
   @PostMapping("/signin")
   ResponseEntity<Object> sigin(Authentication auth){
	   
	   return new ResponseEntity<>(auth,HttpStatus.OK);
   }
   
   
   
   
}
