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
		book = new Book("팽성권 교수님이 쏘아올린 작은 DB", "팽성권", "운수대통", 1000);
		
		if (service.add(book)) {
			System.out.println("책이 성공적으로 등록되었습니다.");
		}
		else System.out.println("책 등록에 실패했습니다.");*/
		
		//책 목록 보기
		
		List<Book> bookList = service.listAll();
		for (Book book1 : bookList) {
			System.out.println(book1.toString());
		}
		
		//책 조회
		/*book = service.read(2);
		if (book != null) {
			System.out.println(book.toString());
		} 
		else System.out.println("없는 번호 입니다.");*/
		
		// 책 내용 수정
		/*book = new Book(2, "맛좋을날", "곰세마리", "사골곰탕", 12000);
		if (service.edit(book)) {
			System.out.println("행 변경을 완료했습니다.");
		} else {
			System.out.println("행 변경에 실패했습니다.");
		}*/
	
		// 책 삭제
		/*if (service.remove(1)) {
			System.out.println(book.getBookID() + "번 행을 성공적으로 삭제했습니다.");
		} else {
			System.out.println("삭제에 실패했습니다.");
		}*/
		
		
	}

}
