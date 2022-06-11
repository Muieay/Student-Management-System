package com.zyc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.zyc.entity.Student;

public class StuDao extends Basic {
	/**
	 * @���ܣ����һ��ѧ��
	 * @������һ��ѧ������
	 */
	public void addStu(Student stu) {
		// 1������sql����
		String sql = "INSERT INTO stu2 VALUES(NULL,?,?,?,?)";
		// 2���������ݿ����Ӷ���
		Connection conn = null;
		// 3��������ѯ����������
		PreparedStatement pstm = null;
		try {
			// 4����ȡ���ݿ����Ӷ���
			conn = getConn();
			// 5����ȡ����ѯ������
			pstm = conn.prepareStatement(sql);
			// 6������sql���
			pstm.setString(1, stu.getName());
			pstm.setString(2, stu.getSex());
			pstm.setInt(3, stu.getAge());
			pstm.setString(4, stu.getPhone());
			// 7��ִ��sql���
			pstm.executeUpdate();
			System.out.println("ѧ����ӳɹ�!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("���ѧ��ʧ�ܣ�");
		} finally {
			closeAll(null, pstm, conn);
		}

	}

	/**
	 * @���ܣ�ɾ��һ��ѧ��
	 * @������һ��ѧ��id
	 */
	public void delStu(int id) {
		String sql = "delete from stu2 where id=?";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = getConn();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.executeUpdate();
			System.out.println("ɾ��ѧ���ɹ���");
		} catch (Exception e) {
			e.getMessage();
			System.out.println("ɾ��ѧ��ʧ�ܣ�");
		} finally {
			closeAll(null, pstm, conn);
		}
	}
	/**
	 * @���ܣ�ɾ��һ��ѧ��
	 * @������һ��ѧ������
	 */
	public void delStu(String name) {
		String sql = "delete from stu2 where name=?";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = getConn();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, name);
			pstm.executeUpdate();
			System.out.println("ɾ��ѧ���ɹ���");
		} catch (Exception e) {
			e.getMessage();
			System.out.println("ɾ��ѧ��ʧ�ܣ�");
		} finally {
			closeAll(null, pstm, conn);
		}
	}


	/**
	 * @���ܣ��޸�ѧ����Ϣ
	 * @������һ��ѧ��id
	 */
	public void updateStu(int id) {
		String sql = "update stu2 set name=?,sex=?,age=?,phone=?where id=?";
		Student stu = new Student();
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		System.out.println("������Ҫ�޸ĵ�����:");
		stu.setName(sc.nextLine());
		System.out.println("������Ҫ�޸ĵ��Ա�:");
		stu.setSex(sc.nextLine());
		System.out.println("������Ҫ�޸ĵ�����:");
		stu.setAge(sc2.nextInt());
		System.out.println("������Ҫ�޸ĵĵ绰:");
		stu.setPhone(sc.nextLine());

		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = getConn();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, stu.getName());
			pstm.setString(2, stu.getSex());
			pstm.setInt(3, stu.getAge());
			pstm.setString(4, stu.getPhone());
			pstm.setInt(5, id);
			pstm.executeUpdate();
			System.out.println("�޸�ѧ���ɹ���");
		} catch (Exception e) {
			e.getMessage();
			System.out.println("�޸�ѧ��ʧ�ܣ�");
		} finally {
			closeAll(null, pstm, conn);
//			sc.close();
//			sc2.close();
		}

	}

	/**
	 * @���ܣ��޸�ѧ����Ϣ
	 * @������һ��ѧ������
	 */
	public void updateStu(String name) {
		String sql = "update stu2 set age=?,phone=?where name=?";
		Student stu = new Student();
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);

		System.out.println("������Ҫ�޸ĵ�����:");
		stu.setAge(sc.nextInt());
		System.out.println("������Ҫ�޸ĵĵ绰:");
		stu.setPhone(sc2.nextLine());

		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = getConn();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, stu.getAge());
			pstm.setString(2, stu.getPhone());
			pstm.setString(3, name);
			pstm.executeUpdate();
			System.out.println("�޸�ѧ���ɹ���");
		} catch (Exception e) {
			e.getMessage();
			System.out.println("�޸�ѧ��ʧ�ܣ�");
		} finally {
			closeAll(null, pstm, conn);
//			sc.close();
//			sc2.close();
		}
	}

	/**
	 * @���ܣ���ѯ����ѧ����Ϣ 
	 * @��������
	 */
	public List<Student> selectAll() {
		List<Student> list = new ArrayList<>();
		String sql = "select * from stu2";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			conn = getConn();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Student stu = new Student();
				stu.setId(rs.getInt("id"));
				stu.setName(rs.getString("name"));
				stu.setSex(rs.getString("sex"));
				stu.setAge(rs.getInt("age"));
				stu.setPhone(rs.getString("phone"));
				list.add(stu);
			}
			System.out.println("��ѯ�ɹ���");
		} catch (Exception e) {
			e.getMessage();
			System.out.println("��ѯʧ�ܣ�");
		} finally {
			closeAll(rs, pstm, conn);
		}
		return list;
	}

	/**
	 * @���ܣ���ѯ����ѧ����Ϣ
	 * @��������
	 */
	public void findAllStu() {
		String sql = "select * from stu2";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			conn = getConn();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			// ��ȡ�������

			ResultSetMetaData mateData = (ResultSetMetaData) rs.getMetaData();
			int columnCount = mateData.getColumnCount();

			while (rs.next()) {
				for (int i = 1; i <= columnCount; i++) {
					Object oj = rs.getObject(i);
					System.out.print(oj + "\t");
				}
				System.out.println();
			}
//			System.out.println(columnCount);
			System.out.println("��ѯ�ɹ���");
		} catch (Exception e) {
			e.getMessage();
			System.out.println("��ѯʧ�ܣ�");
		} finally {
			closeAll(rs, pstm, conn);
		}
		
	}
	/**
	 * @���ܣ�����ѧ��id��ѯ
	 * @������id
	 */
	public void findStu(int id) {
		String sql="select * from stu2 where id=?";
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			conn=getConn();
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs=pstm.executeQuery();
			
			ResultSetMetaData metaData=(ResultSetMetaData) rs.getMetaData();
			int columnCount = metaData.getColumnCount();	
			
			if(rs.next()) {
				for(int i=1;i<=columnCount;i++) {
					System.out.print(rs.getObject(i)+"\t");
				}
			}
			
			System.out.println("\n"+"��ѯ�ɹ���");
		} catch (Exception e) {
			e.getMessage();
			System.out.println("��ѯʧ�ܣ�");
			
		}finally {
			closeAll(rs, pstm, conn);
		}
	}
	/**
	 * @���ܣ�����ѧ��������ѯ
	 * @����������
	 */
	public void findStu(String name) {
		String sql="select * from stu2 where name=?";
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			conn=getConn();
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, name);
			rs=pstm.executeQuery();
			
			ResultSetMetaData metaData=(ResultSetMetaData) rs.getMetaData();
			int columnCount = metaData.getColumnCount();	
			
			if(rs.next()) {
				for(int i=1;i<=columnCount;i++) {
					System.out.print(rs.getObject(i)+"\t");
				}
			}
			
			System.out.println("\n"+"��ѯ�ɹ���");

		} catch (Exception e) {
			e.getMessage();
			System.out.println("��ѯʧ�ܣ�");
		}finally {
			closeAll(rs, pstm, conn);
		}
	}
	

}
