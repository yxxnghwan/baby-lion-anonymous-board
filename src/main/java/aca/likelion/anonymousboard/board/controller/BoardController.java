package aca.likelion.anonymousboard.board.controller;

import aca.likelion.anonymousboard.board.dto.ArticleDto;
import aca.likelion.anonymousboard.board.dto.BoardDto;
import aca.likelion.anonymousboard.board.service.ArticleService;
import aca.likelion.anonymousboard.board.service.BoardService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;
    private final ArticleService articleService;


    @GetMapping
    public String boards(Model model) {
        final List<BoardDto> boards = boardService.getBoards();
        final List<ArticleDto> articles = articleService.getAllArticles();
        model.addAttribute("boards", boards);
        model.addAttribute("articles", articles);
        return "boards";
    }

    @GetMapping("/{id}")
    public String board(
            @PathVariable(name = "id") Long id,
            Model model
    ) {
        final BoardDto board = boardService.getBoard(id);
        final List<ArticleDto> articles = articleService.getArticlesByBoardId(id);
        model.addAttribute("board", board);
        model.addAttribute("articles", articles);
        return "boarddetail";
    }
}
