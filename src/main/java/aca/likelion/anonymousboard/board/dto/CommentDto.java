package aca.likelion.anonymousboard.board.dto;

import aca.likelion.anonymousboard.board.domain.Comment;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommentDto {

    private Long id;
    private String content;
    private Long articleId;

    public CommentDto(final Long id, final String content, final Long articleId) {
        this.id = id;
        this.content = content;
        this.articleId = articleId;
    }

    public static CommentDto from(final Comment entity) {
        return new CommentDto(entity.getId(), entity.getContent(), entity.getArticleId());
    }
}
