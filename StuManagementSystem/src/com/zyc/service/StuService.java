package com.zyc.service;

import java.util.List;

import com.zyc.dao.StuDao;
import com.zyc.entity.Student;

public class StuService {
	private StuDao stuDao=new StuDao();
	/**
	 * @���ܣ����һ��ѧ��
	 * @������һ��ѧ������
	 */
	public void addStu(Student stu) {
		stuDao.addStu(stu);
	}
	/**
	 * @���ܣ�ɾ��һ��ѧ��
	 * @������һ��ѧ��id
	 */
	public void delStu(int id) {
		stuDao.delStu(id);
	}
	/**
	 * @���ܣ�ɾ��һ��ѧ��
	 * @������һ��ѧ������
	 */
	public void delStu(String name) {
		stuDao.delStu(name);
	}
	
	
	/**
	 * @���ܣ��޸�ѧ����Ϣ
	 * @������һ��ѧ��id
	 */
	public void updateStu(int id) {
		stuDao.updateStu(id);
	}
	
	
	/**
	 * @���ܣ��޸�ѧ����Ϣ
	 * @������һ��ѧ������
	 */
	public void updateStu(String name) {
		stuDao.updateStu(name);
	}
	
	/**
	 * @���ܣ���ѯ����ѧ����Ϣ 
	 * @��������
	 */
	public List<Student> selectAll(){
		return stuDao.selectAll();			
	}
	
	/**
	 * @���ܣ���ѯ����ѧ����Ϣ 
	 * @��������
	 */
	public void findAllStu() {
		stuDao.findAllStu();
	}
	
	/**
	 * @���ܣ�����ѧ��id��ѯ
	 * @������id
	 */
	public void findStu(int id) {
		stuDao.findStu(id);
	}
	/**
	 * @���ܣ�����ѧ��������ѯ
	 * @����������
	 */
	public void findStu(String name) {
		stuDao.findStu(name);
	}
	
	

}
