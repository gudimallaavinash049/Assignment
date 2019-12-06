package module;
//creating  LeaveStatus class
public class LeaveStatus {
//declaring private variables of LeaveStatus	
	private int id ;
	private String name;
	private int totalLeavesAvilable;
	private String status ;
	private String desig;
	//creating constructor 
	public LeaveStatus(int id, String status) {
		
		this.id = id;
		this.status = status;
	}
	
	public LeaveStatus(int id, String name, int totalLeavesAvilable, String status, String desig) {
		super();
		this.id = id;
		this.name = name;
		this.totalLeavesAvilable = totalLeavesAvilable;
		this.status = status;
		this.desig=desig;
	}

	public String getDesig() {
		return desig;
	}

	public void setDesig(String desig) {
		this.desig = desig;
	}

	//creating setters and getters
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
	public int getTotalLeavesAvilable() {
		return totalLeavesAvilable;
	}
	public void setTotalLeavesAvilable(int totalLeavesAvilable) {
		this.totalLeavesAvilable = totalLeavesAvilable;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	//overriding toString()
	@Override
	public String toString() {
		return "LeaveStatus  Id = " + id +", Name = "+name+", Total Avilable Leaves = "+totalLeavesAvilable+"  status=" + status ;
	}
	

}
