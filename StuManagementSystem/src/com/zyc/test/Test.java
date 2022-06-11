package com.zyc.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.zyc.dao.Basic;
import com.zyc.dao.StuDao;
import com.zyc.entity.Student;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StuDao s1=new StuDao();			
//		s1.addStu(new Student("胡歌","男",28,"1230120"));
//		s1.delStu(9);
//		s1.delStu("李四");
//		s1.updateStu(1);
//		s1.updateStu("胡歌");
		List<Student> list=new ArrayList<>();
		list = s1.selectAll();
		System.out.println(list);
//		s1.findAllStu();
//		s1.findStu(3);
//		s1.findStu("李易峰");
	}

}
