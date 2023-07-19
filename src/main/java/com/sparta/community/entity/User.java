package com.sparta.community.entity;

import com.sparta.community.dto.SignupRequestDto;
import com.sparta.community.dto.UserRequestDto;
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
    // 게시글 작성 시 보일 닉네임 (부리)
    @Column(nullable = false, unique = true)
    private String nickname;
    // 한줄 소개
    @Column
    private String one_liner;
    @Column
    @Enumerated(value = EnumType.STRING)
    private UserRoleEnum role;

    public User(SignupRequestDto signupRequestDto, String password, UserRoleEnum role) {
        this.username = signupRequestDto.getUsername();
        this.password = password;

        this.email = signupRequestDto.getEmail();
        this.nickname = signupRequestDto.getNickname();

        this.one_liner = "자기소개를 입력해주세요.";
        this.role = role;
    }

    // User 받기?
    public User(UserRequestDto userRequestDto) {
        this.username = userRequestDto.getUsername();

        this.email = userRequestDto.getEmail();
        this.nickname = userRequestDto.getNickname();

        this.one_liner = "자기소개를 입력해주세요.";
    }

    // 수정
    public void update(UserRequestDto requestDto) {
        // id를 어떻게 해야하나
        this.username = requestDto.getUsername();
        this.email = requestDto.getEmail(); // 이메일 수정...??
        this.one_liner = requestDto.getOne_liner();
    }

}

