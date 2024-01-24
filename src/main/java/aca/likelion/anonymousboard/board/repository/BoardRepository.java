package aca.likelion.anonymousboard.board.repository;

import aca.likelion.anonymousboard.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
