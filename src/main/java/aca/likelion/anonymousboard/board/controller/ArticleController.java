package aca.likelion.anonymousboard.board.controller;

import aca.likelion.anonymousboard.board.dto.ArticleDto;
import aca.likelion.anonymousboard.board.dto.CommentDto;
import aca.likelion.anonymousboard.board.dto.HashTagDto;
import aca.likelion.anonymousboard.board.service.ArticleService;
import aca.likelion.anonymousboard.board.service.CommentService;
import aca.likelion.anonymousboard.board.service.HashTagService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;
    private final CommentService commentService;
    private final HashTagService hashTagService;

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
        return "redirect:/articles/" + article.getId();
    }

    @GetMapping("/{articleId}")
    public String articlePage(
            @PathVariable(name = "articleId") Long articleId,
            Model model
    ) {
        final ArticleDto article =  articleService.getArticle(articleId);
        final List<CommentDto> comments = commentService.getByArticleId(articleId);
        final List<HashTagDto> hashTags = hashTagService.getHashTagsByArticleId(articleId);
        model.addAttribute("article", article);
        model.addAttribute("comments", comments);
        model.addAttribute("hashtags", hashTags);
        return "article";
    }

    @PostMapping("/delete/{articleId}")
    public String deleteArticle(
            @PathVariable(name = "articleId") Long articleId,
            @RequestParam("password") String password
    ) {
        final ArticleDto deletedArticle = articleService.deleteArticle(articleId, password);

        return "redirect:/boards/" + deletedArticle.getBoardId();
    }
}
