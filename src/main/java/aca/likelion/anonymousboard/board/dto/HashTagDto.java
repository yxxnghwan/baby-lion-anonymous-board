package aca.likelion.anonymousboard.board.dto;

import aca.likelion.anonymousboard.board.domain.HashTag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HashTagDto {

    private Long id;
    private String content;
    private Long articleId;

    public HashTagDto(final Long id, final String content, final Long articleId) {
        this.id = id;
        this.content = content;
        this.articleId = articleId;
    }

    public static HashTagDto from(HashTag entity) {
        return new HashTagDto(
                entity.getId(),
                entity.getContent(),
                entity.getArticleId()
        );
    }
}
