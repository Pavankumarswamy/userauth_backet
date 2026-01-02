package com.cetnext.certo.service;
import java.util.List;
import com.cetnext.certo.models.login;

public interface loginservice {
	public String add(login l);//adding single user
	public List<login> getall();//get multi users
	public String deleteid(String email);//delete user
	public login getbyemail(String email);//get single user by mail
	public String update(login l,String email);//update user by email
	public List<login> adddatas(List<login>l);//add data in database
}
