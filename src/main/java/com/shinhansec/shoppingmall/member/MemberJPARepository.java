package com.shinhansec.shoppingmall.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.Optional;

public interface MemberJPARepository
     extends JpaRepository<Member, Integer> {

 //extends 기본 메소드 -> hibernate로 그대로 사용
 //커스텀 메소드( querybyexampleexecutor)

 Optional <Member> findByUserId(String userId);
 }
