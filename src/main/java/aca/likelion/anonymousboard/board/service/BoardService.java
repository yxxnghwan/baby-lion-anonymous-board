package aca.likelion.anonymousboard.board.service;

import aca.likelion.anonymousboard.board.domain.Board;
import aca.likelion.anonymousboard.board.dto.BoardDto;
import aca.likelion.anonymousboard.board.repository.BoardRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
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

    public BoardDto getBoard(final Long boardId) {
        final Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new NoSuchElementException("게시판이 존재하지 않습니다. boardId = " + boardId));

        return BoardDto.from(board);
    }
}
