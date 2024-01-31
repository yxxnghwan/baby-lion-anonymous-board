package aca.likelion.anonymousboard.board.service;

import aca.likelion.anonymousboard.board.domain.Comment;
import aca.likelion.anonymousboard.board.dto.CommentDto;
import aca.likelion.anonymousboard.board.repository.CommentRepository;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentDto writeComment(
            final String content,
            final String password,
            final Long articleId
    ) {
        final Comment comment = new Comment(content, password, articleId);
        final Comment savedComment = commentRepository.save(comment);

        return CommentDto.from(savedComment);
    }

    public List<CommentDto> getByArticleId(final Long articleId) {
        final List<Comment> comments = commentRepository.findByArticleId(articleId);

        return comments.stream()
                .map(CommentDto::from)
                .toList();
    }

    public CommentDto deleteComment(final Long commentId, final String password) {
        final Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new NoSuchElementException("삭제할 댓글이 존재하지 않습니다."));

        if (!comment.match(password)) {
            throw new IllegalStateException("패스워드가 일치하지 않습니다.");
        }

        commentRepository.deleteById(comment.getId());

        return CommentDto.from(comment);
    }
}
