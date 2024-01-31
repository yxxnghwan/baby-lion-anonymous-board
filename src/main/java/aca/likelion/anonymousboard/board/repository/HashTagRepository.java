package aca.likelion.anonymousboard.board.repository;

import aca.likelion.anonymousboard.board.domain.HashTag;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HashTagRepository extends JpaRepository<HashTag, Long> {

    List<HashTag> findByArticleId(Long articleId);

    List<HashTag> findByContent(String hashtagContent);
}
