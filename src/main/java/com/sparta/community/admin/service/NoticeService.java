package com.sparta.community.admin.service;

import com.sparta.community.admin.entity.Notice;
import com.sparta.community.admin.repository.NoticeRepository;
import com.sparta.community.post.dto.NoticeResponseDto;
import com.sparta.community.post.dto.PostRequestDto;
import com.sparta.community.post.entity.Post;
import com.sparta.community.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeRepository noticeRepository;

    public NoticeResponseDto createNotice(PostRequestDto requestDto, User user) {
        Notice notice = new Notice(requestDto);
        notice.setUser(user);

        noticeRepository.save(notice);

        return new NoticeResponseDto(notice);
    }

    public Notice findNotice(Long id) {
        return noticeRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 게시글은 존재하지 않습니다.")
        );
    }
}
