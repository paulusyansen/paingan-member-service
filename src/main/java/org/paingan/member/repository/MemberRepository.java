package org.paingan.member.repository;

import java.util.Optional;

import org.paingan.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member, Long> {
	public Optional<Member> findById(Long id);
}
