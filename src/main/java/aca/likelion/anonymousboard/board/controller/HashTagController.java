package aca.likelion.anonymousboard.board.controller;

import aca.likelion.anonymousboard.board.dto.ArticleDto;
import aca.likelion.anonymousboard.board.service.HashTagService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/hashtags")
public class HashTagController {

    private final HashTagService hashTagService;

    @GetMapping("/search")
    public String hashtagSearchPage(
            @RequestParam("hashtag") String hashtagContent,
            Model model
    ) {
        List<ArticleDto> articles = hashTagService.findArticlesByContent(hashtagContent);
        model.addAttribute("articles", articles);
        model.addAttribute("hashtag", hashtagContent);

        return "hashtagsearch";
    }
}
