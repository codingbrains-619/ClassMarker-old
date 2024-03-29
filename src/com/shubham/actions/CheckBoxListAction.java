package com.shubham.actions;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class CheckBoxListAction extends ActionSupport{

	private List<String> colors;

	private String yourColor;
	
	public String getYourColor() {
		return yourColor;
	}

	public void setYourColor(String yourColor) {
		this.yourColor = yourColor;
	}

	public CheckBoxListAction(){
		colors = new ArrayList<String>();
		colors.add("red");
		colors.add("yellow");
		colors.add("blue");
		colors.add("green");
	}
	
	public String[] getDefaultColor(){
		return new String [] {"red", "green"};
	}
	
	public List<String> getColors() {
		return colors;
	}

	public void setColors(List<String> colors) {
		this.colors = colors;
	}

	public String execute() {
		return SUCCESS;
	}
	
	public String display() {
		return NONE;
	}
}