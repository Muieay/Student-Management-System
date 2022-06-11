package com.zyc.test;

import java.util.Scanner;
import com.zyc.entity.Student;
import com.zyc.service.StuService;

public class StuSystem {
	public static void main(String[] args) {
		System.out.println("**********欢迎进入学生管理系统*********");
		System.out.println("\t1、查询所有学生");
		System.out.println("\t2、查询单个学生");
		System.out.println("\t3、添加学生");
		System.out.println("\t4、修改学生");
		System.out.println("\t5、删除学生");
		System.out.println("\t6、退出");
		System.out.println("**********************************");
		Scanner sc = new Scanner(System.in);
		int flag = -1;
		try {
			while (flag != 0 && flag != 6) {
				System.out.println("请输入要执行的序号：");
				flag = sc.nextInt();
				caozuo(flag);
			}
		} catch (Exception e) {
			e.getMessage();
			System.out.println("您的输入有误！");
		}
		sc.close();
	}

	
//	NoSuchElementException：没有这样的元素异常。
//	解决方法	
//	保留最后一个close，其他的删掉

	
	
	public static StuService ser = new StuService();

//	增
	static void addstu() {
		Student stu = new Student();
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		try {
			System.out.println("请输入要添加的姓名:");
			stu.setName(sc.nextLine());
			System.out.println("请输入要添加的性别:");
			stu.setSex(sc.nextLine());
			System.out.println("请输入要添加的年龄:");
			stu.setAge(sc2.nextInt());
			System.out.println("请输入要添加的电话:");
			stu.setPhone(sc.nextLine());
			ser.addStu(stu);

		} catch (Exception e) {
			e.getMessage();
			System.out.println("您的输入有误！");
		} finally {
//			sc.close();
//			sc2.close();
		}
	}

//	删
	static void delstu() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("请输入要删除学生的id或姓名：");
			if (sc.hasNextInt()) {

				Object oj = sc.next();
				int id = Integer.parseInt((String) oj);
				ser.delStu(id);
			} else if (sc.hasNextLine()) {
				Object name = sc.next();
				ser.delStu((String) name);
			}

		} catch (Exception e) {
			e.getMessage();
			System.out.println("您的输入有误！");
		} finally {
//			sc.close();
		}
	}

//	改
	static void updatestu() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("请输入要修改学生的id或姓名：");
			if (sc.hasNextInt()) {

				Object oj = sc.next();
				int id = Integer.parseInt((String) oj);
				ser.updateStu(id);
			} else if (sc.hasNextLine()) {
				Object name = sc.next();
				ser.updateStu((String) name);
			}
		} catch (Exception e) {
			e.getMessage();
			System.out.println("您的输入有误！");
		} finally {
//			sc.close();
		}

	}

//	查
	static void kuangjia() {
		System.out.println("ID" + "\t" + "姓名" + "\t" + "性别" + "\t" + "年龄" + "\t" + "电话号码");
	}

	static void findAllstu() {
		kuangjia();
		ser.findAllStu();
	}

	static void findstu() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("请输入要查询学生的id或姓名：");

			if (sc.hasNextInt()) {

				Object oj = sc.next();

				kuangjia();
				int id = Integer.parseInt((String) oj);
				ser.findStu(id);
			} else if (sc.hasNextLine()) {
				Object name = sc.next();
				kuangjia();
				ser.findStu((String) name);
			}
		} catch (Exception e) {
			e.getMessage();
			System.out.println("您的输入有误！");
		} finally {
//			sc.close();
		}
	}

	static void caozuo(int flag) {
		if (flag == 1) {
			findAllstu();
		} else if (flag == 2) {
			findstu();
		} else if (flag == 3) {
			addstu();
		} else if (flag == 4) {
			updatestu();
		} else if (flag == 5) {
			delstu();
		} else if (flag == 6 || flag == 0) {
			System.out.println("感谢使用！");
			return;
		} else {
			System.out.println("您输入的序号不存在，请重新输入！");
		}
	}

}
