package org.paingan.member.rest.controller;

import java.util.Optional;

import org.paingan.member.domain.Member;
import org.paingan.member.repository.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MemberController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Environment environment;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Member> getMember(@PathVariable Long id) {
		Member member = new Member();
		Optional<Member> members = memberRepository.findById(id);
		
		if(members.isPresent()) {
			members.get().setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		} 
		
		log.info("{}", member);
		
		return ResponseEntity.ok(members.get());
	}
}
