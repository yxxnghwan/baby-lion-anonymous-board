package aca.likelion.anonymousboard.board.service;

import aca.likelion.anonymousboard.board.domain.Article;
import aca.likelion.anonymousboard.board.domain.Board;
import aca.likelion.anonymousboard.board.dto.ArticleDto;
import aca.likelion.anonymousboard.board.repository.ArticleRepository;
import aca.likelion.anonymousboard.board.repository.BoardRepository;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final BoardRepository boardRepository;

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
}
