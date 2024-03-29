package com.shubham.actions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shubham.dao.CommonDAO;
import com.shubham.dao.classmarkerDAO;

public class Group {

	private String groupname;
	private String groupdesc;
	private String showstudent;
	private String selectedstudent;
	private List<String> studentlist = new ArrayList<String>();
	private ArrayList<Group> grouplist;
	
	

	
	public String fetchgroup() throws ClassNotFoundException, SQLException {
		fetchstudent();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		grouplist = new ArrayList<Group>();
		Group group = new Group();
		
		
		con = CommonDAO.getConnection();
		pstmt = con.prepareStatement("select group_mst.groupname,group_mst.groupdesc,user_mst.userid from group_mst,user_mst,group_student_mapping where group_mst.groupid=group_student_mapping.groupid and user_mst.uid=group_student_mapping.studentid;");
		rs = pstmt.executeQuery();
		while(rs.next()) {
			group = new Group();
			group.setGroupname(rs.getString(1));
			group.setGroupdesc(rs.getString(2));	
			group.setShowstudent(rs.getString(3));
//			role.setRightlist(rs.getString(3));
			grouplist.add(group);
//			
		}
		System.out.println(grouplist);
		return "success";
	}

	public String addgroup() throws ClassNotFoundException, SQLException {
		fetchstudent();
		if(classmarkerDAO.addgroup(groupname,groupdesc,selectedstudent)==true) {
			return "success";
		}
		return "fail";
	}
	
	public String fetchstudent() throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement pstmt,pstmt1 = null;
		ResultSet rs,rs1 = null;

//		rightlist = new ArrayList<String>();
	
		
		con = CommonDAO.getConnection();
		pstmt = con.prepareStatement("select user_mst.userid from user_mst,role_mst,user_role_mapping where user_mst.uid=user_role_mapping.userid and role_mst.roleid=user_role_mapping.roleid and role_mst.rolename=\"student\";");
		rs = pstmt.executeQuery();
		while(rs.next()) {
			studentlist.add(rs.getString(1));
		}
		
		return "success";
	}
	
	public String execute() {
		return "success";
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public String getGroupdesc() {
		return groupdesc;
	}

	public void setGroupdesc(String groupdesc) {
		this.groupdesc = groupdesc;
	}

	public String getShowstudent() {
		return showstudent;
	}

	public void setShowstudent(String showstudent) {
		this.showstudent = showstudent;
	}

	public String getSelectedstudent() {
		return selectedstudent;
	}

	public void setSelectedstudent(String selectedstudent) {
		this.selectedstudent = selectedstudent;
	}

	public List<String> getStudentlist() {
		return studentlist;
	}

	public void setStudentlist(List<String> studentlist) {
		this.studentlist = studentlist;
	}

	@Override
	public String toString() {
		return "Group [groupname=" + groupname + ", groupdesc=" + groupdesc + ", showstudent=" + showstudent
				+ ", selectedstudent=" + selectedstudent + ", studentlist=" + studentlist + ", grouplist=" + grouplist
				+ "]";
	}

	public ArrayList<Group> getGrouplist() {
		return grouplist;
	}

	public void setGrouplist(ArrayList<Group> grouplist) {
		this.grouplist = grouplist;
	}


	
	
	
}
