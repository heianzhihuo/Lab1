package action;
/*it is a test*/

public class Author {

	private long AuthorID;
	private String Name = "";
	private int Age = 0;
	private String Country = "";

	public void setAuthorID(long AuthorID) {
		this.AuthorID = AuthorID;
	}

	public long getAuthorID() {
		return AuthorID;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getName() {
		return Name;
	}
	
	public void setAge(int Age) {
		this.Age = Age;
	}

	public int getAge() {
		return Age;
	}

	public void setCountry(String Country) {
		this.Country = Country;
	}

	public String getCountry() {
		return Country;
	}
}
