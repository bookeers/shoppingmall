package com.shinhansec.shoppingmall.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface MemberJPARepository
     extends JpaRepository<Member, Integer> {


 }
