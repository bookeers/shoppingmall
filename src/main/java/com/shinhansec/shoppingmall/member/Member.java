package com.shinhansec.shoppingmall.member;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Member {
    @Id
    private int id;

    private String userId;
    private String pw;
    private String name;
    private String email;
    private String contact;

    public Member(String userId, String pw, String name, String email, String contact) {
        this.userId = userId;
        this.pw = pw;
        this.name = name;
        this.email = email;
        this.contact = contact;
    }

    public static Member fromDtoToEntity(MemberDto memberDto) {
        return new Member(
                memberDto.getUserId(),
                memberDto.getPw(),
                memberDto.getName(),
                memberDto.getEmail(),
                memberDto.getContact()
        );
    }
    @Override
    public String toString() {
        return String.format("userId='%s', pw='%s', name='%s', email='%s', contact='%s'",
                userId, pw, name, email, contact);

    }
}
