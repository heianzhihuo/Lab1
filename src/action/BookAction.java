package action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import sun.security.util.Length;

import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport {

	private ArrayList<Book> books = new ArrayList<Book>();
	private Book book = new Book();
	private String ISBN;
	private Author author = new Author();
	private String Name, Title;

	private Connection connect = null;
	Statement stmt = null;

	public BookAction() {
		/*
		 * 该方法为构造方法，每次调用时都会先加载相应的数据库， 由于在本次实验中所有Action都含有数据库操作内容
		 */
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 加载MYSQL JDBC驱动程序
			connect = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bookdb", "root", "123456");
			// 连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码
			stmt = connect.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * 以下所有方法包含了所有的Action对应的方法
	 */

	public String addBook() {
		String sql1 = "select AuthorID from author where Name='"
				+ author.getName() + "';";
		String sql2, sql3;
		int result;
		try {
			ResultSet rs1 = stmt.executeQuery(sql1);
			if (rs1.next()) {// 先判断该作者是否存在
				// 作者存在，更新作者信息
				author.setAuthorID(rs1.getLong("AuthorID"));
				sql2 = "update author set Age=" + author.getAge()
						+ ",Country='" + author.getCountry()
						+ "' where AuthorID=" + author.getAuthorID() + ";";
				stmt.executeUpdate(sql2);
			} else {
				// 作者不存在，新建作者
				sql2 = "insert into author (Name,Age,Country) values (";
				sql2 = sql2 + "'" + author.getName() + "'," + author.getAge()
						+ ",'" + author.getCountry() + "');";
				stmt.executeUpdate(sql2);
				rs1 = stmt.executeQuery(sql1);
				rs1.next();
				author.setAuthorID(rs1.getLong("AuthorID"));
			}
			book.setAuthorID(author.getAuthorID());
			sql3 = "insert into book (ISBN,Title,AuthorID,Publisher,PublishDate,Price) values (";
			sql3 = sql3 + book.ISBN + ",'" + book.getTitle() + "',"
					+ book.getAuthorID() + ",'" + book.getPublisher() + "','"
					+ book.getPublishDate() + "'," + book.getPrice() + ");";
			result = stmt.executeUpdate(sql3);
			if (result == 1) {
				return SUCCESS;
			} else {
				return ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String deleteBook() {
		String deleteString = "delete from book " + "where ISBN=" + ISBN + ";";
		try {
			int result = stmt.executeUpdate(deleteString);
			if (result == 1) {
				return SUCCESS;
			} else
				return ERROR;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String showAll() {
		Book book = null;
		try {
			ResultSet rs = stmt.executeQuery("select * from book");
			while (rs.next()) {
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

	public String reviseBook() {
		String sql1, sql2;
		try {
			if (ISBN != null) {
				sql1 = "select * from book where ISBN=" + ISBN + ";";
				ResultSet rs1 = stmt.executeQuery(sql1);
				if (rs1.next()) {
					book.setISBN(rs1.getLong("ISBN"));
					book.setAuthorID(rs1.getLong("AuthorID"));
					book.setTitle(rs1.getString("Title"));
					book.setPublisher(rs1.getString("Publisher"));
					book.setPublishDate(rs1.getDate("PublishDate"));
					book.setPrice(rs1.getFloat("Price"));
					sql2 = "select * from author where AuthorID="
							+ book.getAuthorID() + ";";
					ResultSet rs2 = stmt.executeQuery(sql2);
					if (rs2.next()) {
						author.setAuthorID(book.getAuthorID());
						author.setName(rs2.getString("Name"));
						author.setAge(rs2.getInt("Age"));
						author.setCountry(rs2.getString("Country"));
					}
				}
				return "revise";
			} else {
				sql2 = "update author set Age=" + author.getAge()
						+ ",Country='" + author.getCountry()
						+ "' where AuthorID=" + author.getAuthorID() + ";";
				sql1 = "update book set Publisher=" + "'" + book.getPublisher()
						+ "',PublishDate='" + book.getPublishDate()
						+ "',Price=" + book.getPrice()+" where ISBN="+book.getISBN();
				stmt.executeUpdate(sql1);
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String searchBook() {
		String sql1 = "select * from book where Title='" + Title + "';";
		try {
			ResultSet rs1 = stmt.executeQuery(sql1);
			if (rs1.next()) {
				book.setISBN(rs1.getLong("ISBN"));
				book.setTitle(rs1.getString("Title"));
				book.setAuthorID(rs1.getLong("AuthorID"));
				book.setPublisher(rs1.getString("Publisher"));
				book.setPublishDate(rs1.getDate("PublishDate"));
				book.setPrice(rs1.getFloat("Price"));
				String sql2 = "select * from author where AuthorID="
						+ book.getAuthorID() + ";";
				ResultSet rs2 = stmt.executeQuery(sql2);
				if (rs2.next()) {
					author.setAuthorID(book.getAuthorID());
					author.setName(rs2.getString("Name"));
					author.setAge(rs2.getInt("Age"));
					author.setCountry(rs2.getString("Country"));
				}
				return SUCCESS;
			} else {
				return ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String addAuthor() {
		if (author.getName() == null)
			return ERROR;
		try {
			String sql2 = "insert into author (Name,Age,Country) values (";
			sql2 = sql2 + "'" + author.getName() + "'," + author.getAge()
					+ ",'" + author.getCountry() + "');";
			int result = stmt.executeUpdate(sql2);
			if (result == 1)
				return SUCCESS;
			else {
				return ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String searchAuthor() {
		Book book = null;
		String sql1 = "select * from author " + "where Name='" + Name + "';";
		try {
			ResultSet rs1 = stmt.executeQuery(sql1);
			if (rs1.next()) {
				author.setAuthorID(rs1.getLong("AuthorID"));
				author.setName(Name);
				author.setAge(rs1.getInt("Age"));
				author.setCountry(rs1.getString("Country"));
				String sql2 = "select * from book " + "where AuthorID="
						+ author.getAuthorID() + ";";
				ResultSet rs2 = stmt.executeQuery(sql2);
				while (rs2.next()) {
					book = new Book();
					book.setISBN(rs2.getLong("ISBN"));
					book.setTitle(rs2.getString("Title"));
					book.setPublisher(rs2.getString("Publisher"));
					book.setPublishDate(rs2.getDate("PublishDate"));
					book.setPrice(rs2.getFloat("Price"));
					book.setAuthorID(rs2.getLong("AuthorID"));
					books.add(book);
				}
				return SUCCESS;
			} else {
				return ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	/*
	 * 以下均为struts2 所有Action所需要的set和get方法，每一个所用参数均对应一个set和一个get方法
	 */

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Author getAuthor() {
		return author;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String Name() {
		return Name;
	}

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}

	public ArrayList<Book> getBooks() {
		return this.books;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Book getBook() {
		return book;
	}

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setTitle(String Title) {
		this.Title = Title;
	}

	public String getTitle() {
		return Title;
	}
}
