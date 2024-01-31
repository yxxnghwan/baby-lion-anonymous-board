package aca.likelion.anonymousboard.board.repository;

import aca.likelion.anonymousboard.board.domain.Article;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    List<Article> findByBoardId(Long boardId);

    @Query("select a from Article a where a.content like :searchText or a.title like :searchText")
    List<Article> search(@Param("searchText") String searchText);
}
