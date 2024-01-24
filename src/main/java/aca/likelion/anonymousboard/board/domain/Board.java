package aca.likelion.anonymousboard.board.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "board")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // Enum 공부하기

    public Board(final String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
