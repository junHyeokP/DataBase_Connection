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
	
	public boolean edit(Book book, int newPrice) {
		Book bookInfo = bookDAO.selectBook(book.getBookID());
		
		if (book == null) return false;
		if (newPrice == bookInfo.getPrice()) return false;
		
		int result = 0;
		
		if(newPrice != bookInfo.getPrice()) {
			bookInfo.setPrice(newPrice);
			result = bookDAO.updateBook(bookInfo);
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
