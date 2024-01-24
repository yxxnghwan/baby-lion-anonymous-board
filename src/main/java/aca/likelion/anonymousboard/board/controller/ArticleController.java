package aca.likelion.anonymousboard.board.controller;

import aca.likelion.anonymousboard.board.dto.ArticleDto;
import aca.likelion.anonymousboard.board.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/post")
    public String postArticle(
            @RequestParam(name = "boardId") Long boardId,
            Model model
    ) {
        model.addAttribute("boardId", boardId);
        return "postarticle";
    }

    @PostMapping
    public String articleCreated(
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam("password") String password,
            @RequestParam("boardId") Long boardId,
            Model model
    ) {
        final ArticleDto article = articleService.postArticle(title, content, password, boardId);
        model.addAttribute("article", article);
        return "article";
    }
}
