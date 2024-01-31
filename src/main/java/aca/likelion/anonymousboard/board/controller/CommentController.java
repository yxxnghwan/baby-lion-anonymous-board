package aca.likelion.anonymousboard.board.controller;

import aca.likelion.anonymousboard.board.dto.CommentDto;
import aca.likelion.anonymousboard.board.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;


    @PostMapping
    public String writeComment(
            @RequestParam("content") String content,
            @RequestParam("password") String password,
            @RequestParam("articleId") Long articleId
    ) {
        final CommentDto comment = commentService.writeComment(content, password, articleId);
        return "redirect:/articles/" + comment.getArticleId();
    }

    @PostMapping("/delete/{commentId}")
    public String deleteComment(
            @PathVariable(name = "commentId") Long commentId,
            @RequestParam("password") String password
    ) {
        final CommentDto deletedComment = commentService.deleteComment(commentId, password);
        return "redirect:/articles/" + deletedComment.getArticleId();
    }
}
