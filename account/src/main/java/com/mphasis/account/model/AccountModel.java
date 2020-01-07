package com.mphasis.account.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="account")
@Table(name="account")
public class AccountModel {
	public AccountModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	private String acc;
	private String name;
	private String branch;
	@Override
	public String toString() {
		return "accountModel [acc=" + acc + ", name=" + name + ", branch=" + branch + "]";
	}
	public AccountModel(String acc, String name, String branch) {
		super();
		this.acc = acc;
		this.name = name;
		this.branch = branch;
	}
	public String getAcc() {
		return acc;
	}
	public void setAcc(String acc) {
		this.acc = acc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	

}
