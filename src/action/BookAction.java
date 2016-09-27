package action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import model.Book;

public class BookAction extends ActionSupport {

	private ArrayList<Book> books = new ArrayList<Book>();
	private Book book = new Book();

	private Connection connect = null;

	public BookAction() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 加载MYSQL JDBC驱动程序
			System.out.println("Success loading Mysql Driver!");

			connect = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bookdb", "root", "123456");
			// 连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码

			System.out.println("Success connect Mysql server!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String showAll() {
		Book book = null;
		try {
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("select * from book");
			while(rs.next()){
				book = new Book();
				book.setISBN(rs.getLong("ISBN"));
				book.setTitle(rs.getString("Title"));
				book.setPublisher(rs.getString("Publisher"));
				book.setPublishDate(rs.getDate("PublishDate"));
				book.setPrice(rs.getFloat("Price"));
				book.setAuthorID(rs.getLong("AuthorID"));
				books.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String addBook() {
		return SUCCESS;
	}

	public String deleteBook() {
		return SUCCESS;
	}
	
	public void setBooks(ArrayList<Book> books){
		this.books = books;
	}
	
	public ArrayList<Book> getBooks(){
		return this.books;
	}

}
