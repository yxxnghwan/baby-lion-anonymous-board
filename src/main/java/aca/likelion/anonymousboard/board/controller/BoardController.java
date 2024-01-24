package aca.likelion.anonymousboard.board.controller;

import aca.likelion.anonymousboard.board.dto.BoardDto;
import aca.likelion.anonymousboard.board.service.BoardService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;


    @GetMapping
    public String boards(Model model) {
        final List<BoardDto> boards = boardService.getBoards();
        model.addAttribute("boards", boards);
        return "boards";
    }
}
