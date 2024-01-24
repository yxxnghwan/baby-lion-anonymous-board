package aca.likelion.anonymousboard.config;

import aca.likelion.anonymousboard.board.domain.Board;
import aca.likelion.anonymousboard.board.repository.BoardRepository;
import jakarta.annotation.PostConstruct;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile(value = "local | test")
@RequiredArgsConstructor
public class LocalInitConfig {

    private final BoardRepository boardRepository;

    // 반드시 기억 해주세요!
    // 빈 등록 방법 3가지...
    // 1. xml같은 설정파일 등록 (원시적이라 잘 사용 X)
    // 2. @Bean 이라는 어노테이션 붙은 함수의 결과값을 빈으로 등록 -> 특정 라이브러리에서 만들어준 클래스
    // 3. @Component 어노테이션 붙은 클래스 컴포넌트 스캔 -> 우리가 만드는 클래스

    @PostConstruct
    public void initBoard() {
        final List<Board> boards = List.of(
                new Board("자유 게시판"),
                new Board("개발 게시판"),
                new Board("일상 게시판"),
                new Board("사건사고 게시판")
        );
        boardRepository.saveAll(boards);

        final List<Board> savedBoards = boardRepository.findAll();
        System.out.println(savedBoards);
    }
}
