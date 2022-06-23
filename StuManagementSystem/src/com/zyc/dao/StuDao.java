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
	*@作者:ZY澄
	*功能:添加一个学生
	*参数:学生
	*/
	public void addStu(Student stu) {
		// 1、构建sql语言
		String sql = "INSERT INTO stu2 VALUES(NULL,?,?,?,?)";
		// 2、声明数据库连接对象
		Connection conn = null;
		// 3、声明查询分析器对象
		PreparedStatement pstm = null;
		try {
			// 4、获取数据库连接对象
			conn = getConn();
			// 5、获取到查询分析器
			pstm = conn.prepareStatement(sql);
			// 6、完善sql语句
			pstm.setString(1, stu.getName());
			pstm.setString(2, stu.getSex());
			pstm.setInt(3, stu.getAge());
			pstm.setString(4, stu.getPhone());
			// 7、执行sql语句
			pstm.executeUpdate();
			System.out.println("学生添加成功!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("添加学生失败！");
		} finally {
			closeAll(null, pstm, conn);
		}

	}

	/**
	*@作者:ZY澄
	*功能:删除一个学生
	*参数:学生id
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
			System.out.println("删除学生成功！");
		} catch (Exception e) {
			e.getMessage();
			System.out.println("删除学生失败！");
		} finally {
			closeAll(null, pstm, conn);
		}
	}
	/**
	*@作者:ZY澄
	*功能:删除一个学生
	*参数:学生姓名
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
			System.out.println("删除学生成功！");
		} catch (Exception e) {
			e.getMessage();
			System.out.println("删除学生失败！");
		} finally {
			closeAll(null, pstm, conn);
		}
	}


	/**
	*@作者:ZY澄
	*功能:修改学生信息
	*参数:学生id
	*/
	public void updateStu(int id) {
		String sql = "update stu2 set name=?,sex=?,age=?,phone=?where id=?";
		Student stu = new Student();
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		System.out.println("请输入要修改的姓名:");
		stu.setName(sc.nextLine());
		System.out.println("请输入要修改的性别:");
		stu.setSex(sc.nextLine());
		System.out.println("请输入要修改的年龄:");
		stu.setAge(sc2.nextInt());
		System.out.println("请输入要修改的电话:");
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
			System.out.println("修改学生成功！");
		} catch (Exception e) {
			e.getMessage();
			System.out.println("修改学生失败！");
		} finally {
			closeAll(null, pstm, conn);
//			sc.close();
//			sc2.close();
		}

	}

	/**
	*@作者:ZY澄
	*功能:修改学生信息
	*参数:学生姓名
	*/
	public void updateStu(String name) {
		String sql = "update stu2 set age=?,phone=?where name=?";
		Student stu = new Student();
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);

		System.out.println("请输入要修改的年龄:");
		stu.setAge(sc.nextInt());
		System.out.println("请输入要修改的电话:");
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
			System.out.println("修改学生成功！");
		} catch (Exception e) {
			e.getMessage();
			System.out.println("修改学生失败！");
		} finally {
			closeAll(null, pstm, conn);
//			sc.close();
//			sc2.close();
		}
	}

	/**
	*@作者:ZY澄
	*功能:查询所有学生信息
	*参数: 无
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
			System.out.println("查询成功！");
		} catch (Exception e) {
			e.getMessage();
			System.out.println("查询失败！");
		} finally {
			closeAll(rs, pstm, conn);
		}
		return list;
	}

	/**
	*@作者:ZY澄
	*功能:查询所有学生信息
	*参数:无
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
			// 获取表的列数

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
			System.out.println("查询成功！");
		} catch (Exception e) {
			e.getMessage();
			System.out.println("查询失败！");
		} finally {
			closeAll(rs, pstm, conn);
		}
		
	}
	/**
	*@作者:ZY澄
	*功能:查询一个学生信息
	*参数:一个学生id
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
			
			System.out.println("\n"+"查询成功！");
		} catch (Exception e) {
			e.getMessage();
			System.out.println("查询失败！");
			
		}finally {
			closeAll(rs, pstm, conn);
		}
	}
	/**
	*@作者:ZY澄
	*功能:查询一个学生信息
	*参数:一个学生姓名
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
			
			System.out.println("\n"+"查询成功！");

		} catch (Exception e) {
			e.getMessage();
			System.out.println("查询失败！");
		}finally {
			closeAll(rs, pstm, conn);
		}
	}
	

}
