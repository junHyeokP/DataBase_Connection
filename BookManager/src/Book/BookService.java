package Book;

import java.util.List;

public class BookService {
	
	private BookDAO bookDAO;
	
	public BookService(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}
	
	public boolean add(Book book) {
		int result = bookDAO.insertBook(book);
		
		return (result == 1) ? true : false;
	}
	
	public Book read(int bookID) {
		Book book = bookDAO.selectBook(bookID);
		return book;
	}
	
	public List<Book> listAll() {
		List<Book> bookList = bookDAO.selectBookAll();
		return bookList;
	}
	
	public boolean edit(Book book) {
		if (book == null) {
			System.out.println("책이 없거나 내용이 비어있습니다.");
			return false;
		}
		
		Book bookInfo = bookDAO.selectBook(book.getBookID()); // 변경 전 book
		
		int result = 0;
		
		if(book != bookInfo) {
			result = bookDAO.updateBook(book);
		}
		
		return result == 1 ? true : false;
	}
	
	public boolean remove(int bookID) {
		if (bookDAO.selectBook(bookID) == null) {
			return false;
		}
		
		int result = bookDAO.deleteBook(bookID);
		
		return result == 1? true : false;
	}
}
