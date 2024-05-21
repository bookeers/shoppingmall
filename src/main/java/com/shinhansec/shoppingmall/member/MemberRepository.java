package com.shinhansec.shoppingmall.member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

@Repository
public class MemberRepository {
    private Map<String, Member> memberTable = new HashMap<>();

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public String save(Member member) {
        entityManager.persist(member);

        Member savedMember = entityManager.find(Member.class, member.getId());
        return savedMember.getUserId();
    }

    public Member findById(String userId) {
        return memberTable.get(userId);
    }
}
