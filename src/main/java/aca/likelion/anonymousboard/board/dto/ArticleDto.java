package aca.likelion.anonymousboard.board.dto;

import aca.likelion.anonymousboard.board.domain.Article;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ArticleDto {

    private Long id;
    private String title;
    private String content;
    private Long boardId;
    private String boardType;

    public ArticleDto(
            final Long id,
            final String title,
            final String content,
            final Long boardId,
            final String boardType
    ) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.boardId = boardId;
        this.boardType = boardType;
    }

    public static ArticleDto from(final Article entity) {
        return new ArticleDto(
                entity.getId(),
                entity.getTitle(),
                entity.getContent(),
                entity.getBoard().getId(),
                entity.getBoard().getType()
        );
    }
}
