package aca.likelion.anonymousboard.board.service;

import aca.likelion.anonymousboard.board.domain.HashTag;
import aca.likelion.anonymousboard.board.dto.HashTagDto;
import aca.likelion.anonymousboard.board.repository.HashTagRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HashTagService {

    private final HashTagRepository hashTagRepository;

    public List<HashTagDto> getHashTagsByArticleId(Long articleId) {
        List<HashTag> hashTags = hashTagRepository.findByArticleId(articleId);

        return hashTags.stream()
                .map(HashTagDto::from)
                .collect(Collectors.toList());
    }
}
