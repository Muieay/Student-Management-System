package com.zyc.service;

import java.util.List;

import com.zyc.dao.StuDao;
import com.zyc.entity.Student;

public class StuService {
	private StuDao stuDao=new StuDao();
	/**
	*@作者:ZY澄
	*功能:添加一个学生
	*参数:学生
	*/
	public void addStu(Student stu) {
		stuDao.addStu(stu);
	}
	/**
	*@作者:ZY澄
	*功能:删除一个学生
	*参数:学生id
	*/
	public void delStu(int id) {
		stuDao.delStu(id);
	}
	/**
	*@作者:ZY澄
	*功能:删除一个学生
	*参数:学生姓名
	*/
	public void delStu(String name) {
		stuDao.delStu(name);
	}
	
	
	/**
	*@作者:ZY澄
	*功能:修改学生信息
	*参数:学生id
	*/
	public void updateStu(int id) {
		stuDao.updateStu(id);
	}
	
	
	
	/**
	*@作者:ZY澄
	*功能:修改学生信息
	*参数:学生姓名
	*/
	public void updateStu(String name) {
		stuDao.updateStu(name);
	}
	/**
	*@作者:ZY澄
	*功能:查询所有学生信息
	*参数:无
	*/
	public List<Student> selectAll(){
		return stuDao.selectAll();			
	}
	
	/**
	*@作者:ZY澄
	*功能:查询所有学生信息
	*参数:无
	*/
	public void findAllStu() {
		stuDao.findAllStu();
	}
	
	/**
	*@作者:ZY澄
	*功能:查询一个学生信息
	*参数:一个学生id
	*/
	public void findStu(int id) {
		stuDao.findStu(id);
	}
	/**
	*@作者:ZY澄
	*功能:查询一个学生信息
	*参数:一个学生姓名
	*/
	public void findStu(String name) {
		stuDao.findStu(name);
	}
	
	

}
