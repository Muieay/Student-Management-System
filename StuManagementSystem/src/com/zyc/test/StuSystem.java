package com.zyc.test;

import java.util.Scanner;
import com.zyc.entity.Student;
import com.zyc.service.StuService;

public class StuSystem {
	public static void main(String[] args) {
		System.out.println("**********��ӭ����ѧ������ϵͳ*********");
		System.out.println("\t1����ѯ����ѧ��");
		System.out.println("\t2����ѯ����ѧ��");
		System.out.println("\t3�����ѧ��");
		System.out.println("\t4���޸�ѧ��");
		System.out.println("\t5��ɾ��ѧ��");
		System.out.println("\t6���˳�");
		System.out.println("**********************************");
		Scanner sc = new Scanner(System.in);
		int flag = -1;
		try {
			while (flag != 0 && flag != 6) {
				System.out.println("������Ҫִ�е���ţ�");
				flag = sc.nextInt();
				caozuo(flag);
			}
		} catch (Exception e) {
			e.getMessage();
			System.out.println("������������");
		}
		sc.close();
	}

//	NoSuchElementException��û��������Ԫ���쳣��
//	����쳣Ӧ����˵��λ����������Ԫ�أ�Ҳ�����Ҳ���������Ԫ�ء�
//	����1
//	���ҵĶ��new Scanner��close�ϣ���һ��������Scanner ��close�ˣ���һ�������е�newӦ����û��ִ�У�������ִ���˵�����ر��ˣ�
//	���ǵ��½�������in.nextInt();�Ҳ���in�����ڱ�������Ϊ��ȷʵnew��һ��Scanner�������ڱ���ʱû�б���������ʱ�������⡣
//
//	�������1
//	�������һ��close��������ɾ��

	
	
	public static StuService ser = new StuService();

//	��
	static void addstu() {
		Student stu = new Student();
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		try {
			System.out.println("������Ҫ��ӵ�����:");
			stu.setName(sc.nextLine());
			System.out.println("������Ҫ��ӵ��Ա�:");
			stu.setSex(sc.nextLine());
			System.out.println("������Ҫ��ӵ�����:");
			stu.setAge(sc2.nextInt());
			System.out.println("������Ҫ��ӵĵ绰:");
			stu.setPhone(sc.nextLine());
			ser.addStu(stu);

		} catch (Exception e) {
			e.getMessage();
			System.out.println("������������");
		} finally {
//			sc.close();
//			sc2.close();
		}
	}

//	ɾ
	static void delstu() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("������Ҫɾ��ѧ����id��������");
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
			System.out.println("������������");
		} finally {
//			sc.close();
		}
	}

//	��
	static void updatestu() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("������Ҫ�޸�ѧ����id��������");
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
			System.out.println("������������");
		} finally {
//			sc.close();
		}

	}

//	��
	static void kuangjia() {
		System.out.println("ID" + "\t" + "����" + "\t" + "�Ա�" + "\t" + "����" + "\t" + "�绰����");
	}

	static void findAllstu() {
		kuangjia();
		ser.findAllStu();
	}

	static void findstu() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("������Ҫ��ѯѧ����id��������");

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
			System.out.println("������������");
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
			System.out.println("��лʹ�ã�");
			return;
		} else {
			System.out.println("���������Ų����ڣ����������룡");
		}
	}

}
