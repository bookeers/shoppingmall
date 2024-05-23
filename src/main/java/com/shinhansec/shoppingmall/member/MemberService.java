package com.shinhansec.shoppingmall.member;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public String Signup(Member member) {
        if (checkDuplicateId(member.getUserId())) {
            throw new IllegalArgumentException("중복된 아이디입니다.");
        } else {
            memberRepository.save(member);
            return "회원가입 성공";
        }
    }

    public boolean checkDuplicateId(String userId) {
        return memberRepository.findByUserId(userId).isPresent();
    }

    public Member login(String userId, String pw) {
        Member member = memberRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("아이디 혹은 비밀번호가 잘못되었습니다."));

        if (!member.getPw().equals(pw)) {

            throw new IllegalArgumentException("아이디 혹은 비밀번호가 잘못되었습니다.");
        }

        return member;
    }
}