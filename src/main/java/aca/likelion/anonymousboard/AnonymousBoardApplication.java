package aca.likelion.anonymousboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AnonymousBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnonymousBoardApplication.class, args);
	}
	/*
	게시판
	- id
	- type(자유 게시판, 개발 게시판, 일상 게시판, 사건사고 게시판)

	게시글
	- id
	- 제목
	- 내용
	- 비밀번호

	댓글
	- id
	- 내용
	- 비밀번호
	 */
}
