package aca.likelion.anonymousboard.board.repository;

import aca.likelion.anonymousboard.board.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
