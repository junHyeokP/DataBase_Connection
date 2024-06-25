<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="Book.*"
    import="book_oracle.*"
    import="java.util.List"
    pageEncoding="UTF-8"%>
<%!
	BookService service = new BookService(new OracleBookDAO());
	List<Book> bookList = service.listAll();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 관리 메인 페이지</title>
</head>
<body>
		<h1>도서 관리 메인 페이지</h1>
		<a href = "registPage.jsp"><input type = "button" value = "새로운 책 등록하기"></a>	
		<br>
		<% if (bookList.size() == 0) { %>
			<p>등록된 책이 존재하지 않습니다.</p>
		<% } else { %>
		<table>
			<tr><th>책 번호</th><th>책 이름</th><th>저자</th><th>출판사</th><th>가격</th>
			<% for (Book book : bookList) { %>
			<tr>
				<td> <%= book.getBookID() %></td>
				<td> <a href = "detailPage.jsp"><%= book.getBookname() %></a> </td>
				<td> <%= book.getAuthor() %> </td>
				<td> <%= book.getPublisher() %></td>
				<td> <%= book.getPrice() %> </td>
			</tr>	
			<% } %>
		</table>
	<% } %>
</body>
</html>