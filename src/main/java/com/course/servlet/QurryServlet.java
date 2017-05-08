package com.course.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QurryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-mybatis.xml");
	DataSource dataSource = ctx.getBean("dataSource", DataSource.class);

	public QurryServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String get = request.getParameter("get");
		if (get.equals("login")) {
			login(request, response);
		} else if (get.equals("info")) {
			qurryStuInfo(request, response);
		} else if (get.equals("course")) {
			qurrycourse(request, response);
		} else if (get.equals("choosed")) {
			qurryChoosed(request, response);
		} else if (get.equals("sql")) {
			delete(request, response);
		} else if (get.equals("start")) {
			startqurry(request, response);
		} else if (get.equals("insert")) {
			insert(request, response);
		}else if(get.equals("getstu")){
			getstu(request, response);
		}
	}

	private void getstu(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String course_no = request.getParameter("course_no");
		String tech_no = request.getParameter("tech_no");
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "select * from choosemess c,studentmess s where c.stu_no =s.stu_no and c.course_no=? and c.tech_no=?";
		try {
			connection = dataSource.getConnection();
				statement = connection.prepareStatement(sql);
			statement.setString(1, course_no);
			statement.setString(2, tech_no);
			ResultSet rs = statement.executeQuery();
			JSONArray jsonMembers = new JSONArray();
			JSONObject member1;
			while (rs.next()) {
				member1 = new JSONObject();
				member1.put("stuNo", rs.getString("Stu_no"));
				member1.put("stuMajor", rs.getString("Stu_major"));
				member1.put("stuName", rs.getString("Stu_name"));
				member1.put("stuSex", rs.getString("Stu_sex"));
				member1.put("stuCardno", rs.getString("Stu_cardno"));
				member1.put("stuGrade", rs.getString("Stu_grade"));
				jsonMembers.put(member1);
			}
			response.setCharacterEncoding("utf-8");
			response.getWriter().append(jsonMembers.toString());
			System.out.println(jsonMembers.toString());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String isStudent = request.getParameter("isStudent");
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "select * from studentmess where stu_no=?";
		String sql2 = "select * from teachermess where tech_no=?";
		try {
			connection = dataSource.getConnection();
			if (isStudent.equals("1")) {
				statement = connection.prepareStatement(sql);
			} else {
				statement = connection.prepareStatement(sql2);
			}
			statement.setString(1, username);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				String s;
				if (isStudent.equals("1")) {
					s = rs.getString("stu_password");
				} else {
					s = rs.getString("tech_password");
				}
				response.setCharacterEncoding("utf-8");
				if (password.equals(s)) {
					response.getWriter().append("OK");
				} else {
					response.getWriter().append("ERROR");
				}
			}
		} catch (Exception e) {
			response.getWriter().append("ERROR");
			e.printStackTrace();
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String sql = request.getParameter("sql");
		String sql2 = request.getParameter("sql2");
		System.out.println(sql);
		System.out.println(sql2);
		Connection connection = null;
		Statement statement = null;
		try {
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			connection.setAutoCommit(false);
			response.setCharacterEncoding("utf-8");
			statement.executeUpdate(sql2);
			statement.executeUpdate(sql);
			connection.commit();
			response.getWriter().append("1");
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
				response.getWriter().append("0");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	}

	private void startqurry(HttpServletRequest request, HttpServletResponse response) {
		String sql = request.getParameter("sql");
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();
			JSONArray jsonMembers = new JSONArray();
			JSONObject member1;
			while (rs.next()) {
				member1 = new JSONObject();
				member1.put("Course_no", rs.getString("Course_no"));
				member1.put("Tech_name", rs.getString("Tech_name"));
				member1.put("Tech_no", rs.getString("Tech_no"));
				member1.put("Course_name", rs.getString("Course_name"));
				member1.put("Course_time", rs.getString("Course_time"));
				member1.put("Course_score", rs.getString("Course_score"));
				member1.put("Course_describe", rs.getString("Course_describe"));
				member1.put("Course_number", rs.getInt("Course_number"));
				member1.put("Course_sumno", rs.getInt("Course_sumno"));
				jsonMembers.put(member1);
			}
			response.setCharacterEncoding("utf-8");
			response.getWriter().append(jsonMembers.toString());
			System.out.println(jsonMembers.toString());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String sql = request.getParameter("sql");
		String sql2 = request.getParameter("sql2");
		String s = "update coursemess a set a.course_number=a.course_number+1 where a.course_no=";
		sql2 = s + sql2;
		System.out.println(sql);
		Connection connection = null;
		Statement statement = null;
		try {
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			connection.setAutoCommit(false);
			response.setCharacterEncoding("utf-8");
			statement.executeUpdate(sql);
			statement.executeUpdate(sql2);
			connection.commit();
			response.getWriter().append("1");
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
				response.getWriter().append("0");
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	}

	private void qurryChoosed(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String isStudent = request.getParameter("isStudent");
		Connection connection = null;
		String sql = "select * from choosemess c1, coursemess c2 where c1.course_no=c2.course_no and c1.stu_no=? and c1.tech_no=c2.tech_no";
		String sql2 = "select * from coursemess c ,teachermess t where c.tech_no=t.tech_no and c.tech_no =?";
		PreparedStatement statement = null;
		try {
			connection = dataSource.getConnection();
			if (isStudent.equals("1")) {
				statement = connection.prepareStatement(sql);
			} else {
				statement = connection.prepareStatement(sql2);
			}
			statement.setString(1, username);
			ResultSet rs = statement.executeQuery();
			JSONArray jsonMembers = new JSONArray();
			JSONObject member1;
			while (rs.next()) {
				member1 = new JSONObject();
				member1.put("Course_no", rs.getString("Course_no"));
				member1.put("Tech_name", rs.getString("Tech_name"));
				member1.put("Tech_no", rs.getString("Tech_no"));
				member1.put("Course_name", rs.getString("Course_name"));
				member1.put("Course_time", rs.getString("Course_time"));
				member1.put("Course_score", rs.getString("Course_score"));
				member1.put("Course_describe", rs.getString("Course_describe"));
				member1.put("Course_number", rs.getInt("Course_number"));
				member1.put("Course_sumno", rs.getInt("Course_sumno"));
				jsonMembers.put(member1);
			}

			response.setCharacterEncoding("utf-8");
			response.getWriter().append(jsonMembers.toString());
			System.out.println(username + ":" + jsonMembers.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	}

	private void qurrycourse(HttpServletRequest request, HttpServletResponse response) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "select * from coursemess ,teachermess where coursemess.Tech_no=teachermess.Tech_no";
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			JSONArray jsonMembers = new JSONArray();
			JSONObject member1;
			while (rs.next()) {
				member1 = new JSONObject();
				member1.put("Course_no", rs.getString("Course_no"));
				member1.put("Tech_name", rs.getString("Tech_name"));
				member1.put("Tech_no", rs.getString("Tech_no"));
				member1.put("Course_name", rs.getString("Course_name"));
				member1.put("Course_time", rs.getString("Course_time"));
				member1.put("Course_score", rs.getString("Course_score"));
				member1.put("Course_describe", rs.getString("Course_describe"));
				member1.put("Course_number", rs.getInt("Course_number"));
				member1.put("Course_sumno", rs.getInt("Course_sumno"));
				jsonMembers.put(member1);
			}
			response.setCharacterEncoding("utf-8");
			response.getWriter().append(jsonMembers.toString());
			System.out.println(jsonMembers.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	}

	private void qurryStuInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		String isStudent = request.getParameter("isStudent");
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "select * from studentmess where stu_no=?";
		String sql2 = "select * from teachermess where tech_no=?";
		try {
			connection = dataSource.getConnection();
			if (isStudent.equals("1")) {
				statement = connection.prepareStatement(sql);
			} else {
				statement = connection.prepareStatement(sql2);
			}
			statement.setString(1, username);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				if (isStudent.equals("1")) {
					JSONArray jsonMembers = new JSONArray();
					JSONObject member1 = new JSONObject();
					member1.put("stuNo", rs.getString("Stu_no"));
					member1.put("stuMajor", rs.getString("Stu_major"));
					member1.put("stuName", rs.getString("Stu_name"));
					member1.put("stuSex", rs.getString("Stu_sex"));
					member1.put("stuCardno", rs.getString("Stu_cardno"));
					member1.put("stuGrade", rs.getString("Stu_grade"));
					jsonMembers.put(member1);
					response.setCharacterEncoding("utf-8");
					response.getWriter().append(jsonMembers.toString());
					System.out.println(username + ":" + jsonMembers.toString());
				} else {
					JSONArray jsonMembers = new JSONArray();
					JSONObject member1 = new JSONObject();
					member1.put("Tech_no", rs.getString("Tech_no"));
					member1.put("Tech_major", rs.getString("Tech_major"));
					member1.put("Tech_name", rs.getString("Tech_name"));
					member1.put("Tech_sex", rs.getString("Tech_sex"));
					member1.put("Tech_title", rs.getString("Tech_title"));
					jsonMembers.put(member1);
					response.setCharacterEncoding("utf-8");
					response.getWriter().append(jsonMembers.toString());
					System.out.println(username + ":" + jsonMembers.toString());
				}
			}

		} catch (Exception e) {
			response.getWriter().append("ERROR");
			e.printStackTrace();
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	}

}
