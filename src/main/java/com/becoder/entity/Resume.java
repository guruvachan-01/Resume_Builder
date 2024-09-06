package com.becoder.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="STUDENT_Resume")
public class Resume {
      
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int r_id;
	private String name;
	private String mobile;
	private String email;
	private String linkden;

	private String address;
	private String pin;
	private String mother;
	private String father;
	private String city;
	private String state;
	private String date;
	private String skills;
	private String expe;
	private String C_name;
	private String joblocation;
	private String tenthmarks;
	private String shlname1;
	private String tewltmarks;
	private String shlname2;
	private String degreename;
	private String U_name;
	private String degree_marks;
	private String objtive;
	private String achivement;
	private String project;
	private String hobbis;
	
	@ManyToOne
	@JsonIgnore
	private User user;
	
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLinkden() {
		return linkden;
	}
	public void setLinkden(String linkden) {
		this.linkden = linkden;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getMother() {
		return mother;
	}
	public void setMother(String mother) {
		this.mother = mother;
	}
	public String getFather() {
		return father;
	}
	public void setFather(String father) {
		this.father = father;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getExpe() {
		return expe;
	}
	public void setExpe(String expe) {
		this.expe = expe;
	}
	public String getC_name() {
		return C_name;
	}
	public void setC_name(String c_name) {
		C_name = c_name;
	}
	public String getJoblocation() {
		return joblocation;
	}
	public void setJoblocation(String joblocation) {
		this.joblocation = joblocation;
	}
	public String getTenthmarks() {
		return tenthmarks;
	}
	public void setTenthmarks(String tenthmarks) {
		this.tenthmarks = tenthmarks;
	}
	public String getShlname1() {
		return shlname1;
	}
	public void setShlname1(String shlname1) {
		this.shlname1 = shlname1;
	}
	public String getTewltmarks() {
		return tewltmarks;
	}
	public void setTewltmarks(String tewltmarks) {
		this.tewltmarks = tewltmarks;
	}
	public String getShlname2() {
		return shlname2;
	}
	public void setShlname2(String shlname2) {
		this.shlname2 = shlname2;
	}
	public String getDegreename() {
		return degreename;
	}
	public void setDegreename(String degreename) {
		this.degreename = degreename;
	}
	public String getU_name() {
		return U_name;
	}
	public void setU_name(String u_name) {
		U_name = u_name;
	}
	public String getDegree_marks() {
		return degree_marks;
	}
	public void setDegree_marks(String degree_marks) {
		this.degree_marks = degree_marks;
	}
	public String getObjtive() {
		return objtive;
	}
	public void setObjtive(String objtive) {
		this.objtive = objtive;
	}
	public String getAchivement() {
		return achivement;
	}
	public void setAchivement(String achivement) {
		this.achivement = achivement;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getHobbis() {
		return hobbis;
	}
	public void setHobbis(String hobbis) {
		this.hobbis = hobbis;
	}
	@Override
	public String toString() {
		return "Resume [r_id=" + r_id + ", name=" + name + ", mobile=" + mobile + ", email=" + email + ", linkden="
				+ linkden + ", phone=" + ", address=" + address + ", pin=" + pin + ", mother=" + mother
				+ ", father=" + father + ", city=" + city + ", state=" + state + ", date=" + date + ", skills=" + skills
				+ ", expe=" + expe + ", C_name=" + C_name + ", joblocation=" + joblocation + ", tenthmarks="
				+ tenthmarks + ", shlname1=" + shlname1 + ", tewltmarks=" + tewltmarks + ", shlname2=" + shlname2
				+ ", degreename=" + degreename + ", U_name=" + U_name + ", degree_marks=" + degree_marks + ", objtive="
				+ objtive + ", achivement=" + achivement + ", project=" + project + ", hobbis=" + hobbis + "]";
	}
	
	
}
