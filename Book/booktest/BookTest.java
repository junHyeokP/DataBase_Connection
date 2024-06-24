package booktest;

import java.util.List;

import Book.Book;
import Book.BookService;
import book_oracle.OracleBookDAO;

public class BookTest {

	public static void main(String[] args) {
		BookService service = new BookService(new OracleBookDAO());
		Book book;
		
		/*// 책 추가
		book = new Book(1001, "check", "chek", "che", 1000);
		if (service.add(book)) {
			System.out.println("책이 성공적으로 등록되었습니다.");
		}
		else System.out.println("책 등록에 실패했습니다.");*/
		
		//책 목록 보기
		
		/*List<Book> bookList = service.listAll();
		for (Book book1 : bookList) {
			System.out.println(book1.toString());
		}*/
		
		//책 조회
		book = service.read(1);
		if (book != null) {
			System.out.println(book.toString());
		}
		
		/*// 책 내용 수정
		book = new Book(1001, "check", "chek", "che", 1000);
		service.edit(book, 1000);
		
		// 회원 삭제
		service.remove(1001);*/
		
		
	}

}
