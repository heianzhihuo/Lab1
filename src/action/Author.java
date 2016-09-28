package action;

public class Author {
	
	private long AuthorID;
	private String name;
	private int age;
	private String Country;
	
	public void setID(long AuthorID){
		this.AuthorID = AuthorID;
	}
	
	public long getID(){
		return AuthorID;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	
	public int getAge(){
		return age;
	}
	
	public void setCountry(String Country){
		this.Country = Country;
	}
	
	public String getCountry(){
		return Country;
	}
}
