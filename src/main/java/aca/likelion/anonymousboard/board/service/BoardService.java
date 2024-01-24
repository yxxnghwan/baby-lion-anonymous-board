package aca.likelion.anonymousboard.board.service;

import aca.likelion.anonymousboard.board.domain.Board;
import aca.likelion.anonymousboard.board.dto.BoardDto;
import aca.likelion.anonymousboard.board.repository.BoardRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public List<BoardDto> getBoards() {
        final List<Board> boards = boardRepository.findAll();

        return boards.stream()
                .map(BoardDto::from)
                .toList();
    }
}
