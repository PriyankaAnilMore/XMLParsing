package xmlparsing;

public class Employee {
//	String id;
	String firstname;
	String lastname;
	String location;

	public Employee() {

	}

	public Employee( String firstname, String lastname, String location) {
	//	this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.location = location;
	}

	/*public String getid() {
		return id;
	}

	public void setid(String id) {
		this.id = id;

	}*/

	public String getfirstname() {
		return firstname;
	}

	public void setfirstname(String firstname) {
		this.firstname = firstname;

	}

	public String getlastname() {
		return lastname;
	}

	public void setlastname(String lastname) {
		this.lastname = lastname;

	}

	public String getlocation() {
		return location;
	}

	public void setlocation(String location) {
		this.location = location;

	}
	public String toString(){
		StringBuffer sb=new StringBuffer();
		sb.append("Employee Details : ");
		sb.append("firstname: "+getfirstname());
		sb.append(" , ");
		sb.append("lastname: "+getlastname());
		sb.append(" , ");
	//	sb.append("id "+getid());
		//sb.append(" , ");
		sb.append("location: "+getlocation());
		sb.append(" , ");
		return sb.toString();
	}
}