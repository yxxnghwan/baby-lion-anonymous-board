package aca.likelion.anonymousboard.board.service;

import aca.likelion.anonymousboard.board.domain.Article;
import aca.likelion.anonymousboard.board.domain.Board;
import aca.likelion.anonymousboard.board.domain.HashTag;
import aca.likelion.anonymousboard.board.dto.ArticleDto;
import aca.likelion.anonymousboard.board.repository.ArticleRepository;
import aca.likelion.anonymousboard.board.repository.BoardRepository;
import aca.likelion.anonymousboard.board.repository.HashTagRepository;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final BoardRepository boardRepository;
    private final HashTagRepository hashTagRepository;

    public ArticleDto postArticle(
            String title,
            String content,
            String password,
            Long boardId
    ) {
        final Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new NoSuchElementException("존재하지 않는 게시판입니다. boardId = " + boardId));

        final Article article = new Article(title, content, password, board);
        final Article savedArticle = articleRepository.save(article);

        final List<String> hashTagContents = Arrays.stream(content.split("\\s+"))
                .filter(word -> word.startsWith("#") && word.length() > 1)
                .collect(Collectors.toList());

        final List<HashTag> hashTags = hashTagContents.stream()
                .map(it -> new HashTag(it, savedArticle.getId()))
                .collect(Collectors.toList());

        hashTagRepository.saveAll(hashTags);

        return ArticleDto.from(savedArticle);
    }

    public ArticleDto getArticle(final Long articleId) {
        final Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new NoSuchElementException("게시글이 존재하지 않습니다 articleId = " + articleId));

        return ArticleDto.from(article);
    }

    public List<ArticleDto> getAllArticles() {
        final List<Article> articles = articleRepository.findAll();

        return articles.stream()
                .map(ArticleDto::from)
                .toList();
    }

    public ArticleDto deleteArticle(final Long articleId, final String password) {
        final Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new NoSuchElementException("삭제할 게시글이 존재하지 않습니다."));

        if (!article.match(password)) {
            throw new IllegalStateException("패스워드가 일치하지 않습니다.");
        }

        articleRepository.deleteById(articleId);

        return ArticleDto.from(article);
    }

    public List<ArticleDto> getArticlesByBoardId(final Long boardId) {
        List<Article> articles = articleRepository.findByBoardId(boardId);

        return articles.stream()
                .map(ArticleDto::from)
                .collect(Collectors.toList());
    }
}
