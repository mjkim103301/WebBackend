package kr.or.connect.jdbcexam.dto;

public class Role {
	//카멜 표기법
	private Integer roleId;
	private String description;
	public Integer getRoleId() {
		return roleId;
	}
	
	public Role() {
		
	}
	public Role(Integer roleId, String description) {
		super();
		this.roleId=roleId;
		this.description=description;
	}
	
	public Role(Integer roleId) {
		super();
		this.roleId=roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", description=" + description + "]";
	}
	
	
}
