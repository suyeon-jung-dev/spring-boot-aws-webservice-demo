package com.suyeon.demo.service.posts;

import com.suyeon.demo.domain.posts.Posts;
import com.suyeon.demo.domain.posts.PostsRepository;
import com.suyeon.demo.web.dto.PostsResponseDto;
import com.suyeon.demo.web.dto.PostsSaveRequestDto;
import com.suyeon.demo.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.junit.Test;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id = " + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;

    }

    @Transactional()
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        return new PostsResponseDto(entity);
    }
}
