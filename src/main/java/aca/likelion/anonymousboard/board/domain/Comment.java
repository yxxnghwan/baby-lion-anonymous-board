package aca.likelion.anonymousboard.board.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comment")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private String password;

    private Long articleId;

    public Comment(final String content, final String password, final Long articleId) {
        this.content = content;
        this.password = password;
        this.articleId = articleId;
    }

    public boolean match(final String password) {
        return this.password.equals(password);
    }
}
