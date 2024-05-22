package com.shinhansec.shoppingmall.member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Member member) {
        entityManager.persist(member);
    }

    public Member findByUserId(String userId) {
        List<Member> members =
                entityManager.createQuery("select m from Member m where m.userId = :userId", Member.class)
                .setParameter("userId", userId).getResultList();
        if (members.isEmpty()) {

            return null;
        }
        else {

            return members.get(0);
        }
    }

    public Member findById(int id) {
        return entityManager.find(Member.class, id);
    }
}