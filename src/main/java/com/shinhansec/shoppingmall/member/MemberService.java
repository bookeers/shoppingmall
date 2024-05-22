package com.shinhansec.shoppingmall.member;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public String join(Member member) {
        if (checkDuplicateId(member.getUserId())) {
            return "중복된 아이디입니다.";
        } else {
            memberRepository.save(member);
            return "성공";
        }
    }
    public boolean checkDuplicateId(String userId) {
        Member existMember = memberRepository.findByUserId(userId);
        if (existMember != null) {
            return true;
        }
        else {

            return false;
        }
    }
}