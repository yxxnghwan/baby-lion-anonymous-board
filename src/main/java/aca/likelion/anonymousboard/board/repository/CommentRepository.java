package aca.likelion.anonymousboard.board.repository;

import aca.likelion.anonymousboard.board.domain.Comment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByArticleId(Long articleId);
    // select c from Comment c where c.articleId = :articleId
}
