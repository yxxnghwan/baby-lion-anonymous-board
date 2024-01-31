package aca.likelion.anonymousboard.board.service;

import aca.likelion.anonymousboard.board.domain.Article;
import aca.likelion.anonymousboard.board.domain.HashTag;
import aca.likelion.anonymousboard.board.dto.ArticleDto;
import aca.likelion.anonymousboard.board.dto.HashTagDto;
import aca.likelion.anonymousboard.board.repository.ArticleRepository;
import aca.likelion.anonymousboard.board.repository.HashTagRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HashTagService {

    private final HashTagRepository hashTagRepository;
    private final ArticleRepository articleRepository;

    public List<HashTagDto> getHashTagsByArticleId(Long articleId) {
        List<HashTag> hashTags = hashTagRepository.findByArticleId(articleId);

        return hashTags.stream()
                .map(HashTagDto::from)
                .collect(Collectors.toList());
    }

    public List<ArticleDto> findArticlesByContent(final String hashtagContent) {
        List<HashTag> hashTags = hashTagRepository.findByContent(hashtagContent);

        final List<Long> articleIds = hashTags.stream()
                .map(HashTag::getArticleId)
                .collect(Collectors.toList());

        List<Article> articles = articleRepository.findAllById(articleIds);

        return articles.stream()
                .map(ArticleDto::from)
                .collect(Collectors.toList());
    }
}
