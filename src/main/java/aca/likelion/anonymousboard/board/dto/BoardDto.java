package aca.likelion.anonymousboard.board.dto;

import aca.likelion.anonymousboard.board.domain.Board;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BoardDto {

    private Long id;
    private String type;

    public BoardDto(final Long id, final String type) {
        this.id = id;
        this.type = type;
    }

    public static BoardDto from(final Board entity) {
        return new BoardDto(entity.getId(), entity.getType());
    }
}
