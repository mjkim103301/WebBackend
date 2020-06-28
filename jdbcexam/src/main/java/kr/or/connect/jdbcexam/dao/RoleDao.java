package kr.or.connect.jdbcexam.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.connect.jdbcexam.dto.Role;

public class RoleDao {
	private static String dburl="jdbc:mysql://localhost:3306/connectdb?serverTimezone=UTC";
	private static String dbUser="connectuser";
	private static String dbpasswd="connect123!@#";
	
	public Role getRole(Integer roleId) throws SQLException {
		Role role=null;
		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(dburl, dbUser, dbpasswd);
			String sql="select role_id, description from role where role_id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, roleId);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				int id=rs.getInt(1);
				String description=rs.getString(2);
				role=new Role(id, description);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			if(rs!=null) {
				try{
					rs.close();
				}catch(SQLException e2) {
					e2.printStackTrace();
				}
			}
			
			if(ps!=null) {
				try{
					ps.close();
				}catch(SQLException e2) {
					e2.printStackTrace();
				}
			}
			if(conn!=null) {
				try{
					conn.close();
				}catch(SQLException e2) {
					e2.printStackTrace();
				}
			}
			
			
		}
				
		return role;
	}
	
	public int addRole(Role role) {
		int insertCount=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
					
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql="insert into role(role_id, description) values (?,?)";
		try(Connection conn=DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps=conn.prepareStatement(sql)){
			ps.setInt(1, role.getRoleId());
			ps.setNString(2, role.getDescription());
			insertCount=ps.executeUpdate();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return insertCount;
	}
	
	public List <Role>getRoles(){
		List<Role> list=new ArrayList<>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
					
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql="select description, role_id from role order by role_id desc";
		try(Connection conn=DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps=conn.prepareStatement(sql)){
			try(ResultSet rs=ps.executeQuery()){
				while(rs.next()) {
					String description=rs.getNString(1);
					int id=rs.getInt("role_id");
					Role role=new Role(id, description);
					list.add(role);
				}
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
	
	}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
	
	public int deleteDao(Role role) {
		int deleteCount=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
					
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql="delete from role where role_id=?";
		try(Connection conn=DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps=conn.prepareStatement(sql)){
			ps.setInt(1, role.getRoleId());
			
			deleteCount=ps.executeUpdate();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return deleteCount;
		
	}
	
	public int updateDao(Role role) {
		int updateCount=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
					
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql="update role set description=? where role_id=?";
		try(Connection conn=DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps=conn.prepareStatement(sql)){
			ps.setString(1, role.getDescription());
			ps.setInt(2,role.getRoleId() );
			updateCount=ps.executeUpdate();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return updateCount;
		
	}

}
