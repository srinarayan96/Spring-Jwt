package com.jwt.example.Jwt_demo.repositories;

import com.jwt.example.Jwt_demo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
}
