package com.sparta.community.user.entity;

import com.sparta.community.user.dto.SignupRequestDto;
import com.sparta.community.user.dto.UserRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 사용자 정보를 담은 엔티티

@Entity
@Getter
@Setter
@Table(name = "user")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // 로그인 시 사용 (ayboori)
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, unique = true)
    private String email;
    // 한줄 소개
    @Column
    private String oneLine;
    @Column
    @Enumerated(value = EnumType.STRING)
    private UserRoleEnum role;

    public User(SignupRequestDto signupRequestDto, String password, UserRoleEnum role) {
        this.username = signupRequestDto.getUsername();
        this.password = password;

        this.email = signupRequestDto.getEmail();

        this.oneLine = signupRequestDto.getOneLine();
        this.role = role;
    }

    // User 받기?
    public User(UserRequestDto userRequestDto) {
        this.username = userRequestDto.getUsername();

        this.email = userRequestDto.getEmail();

        this.oneLine = userRequestDto.getOneLine();
    }

    // 수정
    public void update(UserRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.email = requestDto.getEmail(); // 이메일 수정...??
        this.oneLine = requestDto.getOneLine();
    }
}

