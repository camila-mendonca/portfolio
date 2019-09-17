package com.camilamendonca.portfolio.entity;

public class SelectedSkills {
	private String name;
	private boolean selected;
	public SelectedSkills() {
	}
	public SelectedSkills(String name, boolean selected) {
		this.name = name;
		this.selected = selected;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
