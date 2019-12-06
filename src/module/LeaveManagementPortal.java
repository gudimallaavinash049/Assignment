package module;

//creating class LeaveManagementPortal
public class LeaveManagementPortal   {
//creating variables	
	private int id;
	private String name;
	//private String address;
	private String ra;
	private String desig;
	private int leaves;
	private String password;

//creating constructor
	public LeaveManagementPortal(int id, String name, String ra, String desig,int leaves,String password) {
		
		this.id = id;
		this.name = name;
		this.ra = ra;
		this.desig = desig;
		this.leaves=leaves;
		this.password= password;
	}
	//creating setters and getters
	public int getLeaves() {
		return leaves;
	}

	public void setLeaves(int leaves) {
		this.leaves = leaves;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRa() {
		return ra;
	}
	public void setRa(String ra) {
		this.ra = ra;
	}
	public String getDesig() {
		return desig;
	}
	public void setDesig(String desig) {
		this.desig = desig;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	//overriding toString method
	@Override
	public String toString() {
		return "************** LeaveManagementPortal ******************* \n id=" + id + ",\n name=" + name + ", \n ra=" + ra + ",\n  desig="
				+ desig + ", \n leaves=" + leaves ;
	}



	
}




