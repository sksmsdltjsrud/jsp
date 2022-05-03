package study.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private String sql = "";
	
	LoginVO vo = null;
	
	private String url = "jdbc:mysql://localhost:3306/javagreen";
	private String user = "root";
	private String password = "1234";
	
	// DAO를 호출하는 곳에서 생성시와 동시에 DB연동처리한다.
	// 예외처리
	public LoginDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색실패~~");
		} catch (SQLException e) {
			System.out.println("Datebase 연동 실패~~~");
		}
	}
	
	public void pstmtClose() {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {}
		}
	}
	
	public void rsClose() {
		if(rs != null) {
			try {
				rs.close();
				pstmtClose();
			} catch (SQLException e) {}
		}
	}

	// 로그인 체크(id, pwd체크)
	public LoginVO loginCheck(String mid, String pwd) {
		vo = new LoginVO();
		
		try {
			sql = "select * from login where mid=? and pwd=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setName(rs.getString("name"));
				vo.setPoint(rs.getInt("point"));
				vo.setvCount(rs.getInt("vCount"));
			}
		} catch (SQLException e) {
			System.out.println("SQL 에러 : " + e.getMessage());
			// e.printStackTrace(); - 에러 쫙 뜸(e.getMessage) 쓰는 이유
		} finally {
			rsClose();
		}
		
		return vo;
	}

	// 접속포인트와 방문횟수를 각각 1씩 누적처리한다.
	public void setUpdate(String mid) {
		try {
			sql = "update login set point = point + 1, vCount = vCount + 1, lastDate = now() where mid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.executeUpdate();
			//pstmt.close();
			
			//sql = "update login set vCount = vCount + 1 where mid = ?";
			//pstmt = conn.prepareStatement(sql);
			//pstmt.setString(1, mid);
			//pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 에러 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		
	}

	// 개별자료 조회
	public LoginVO getSearch(String mid) {
		vo = new LoginVO();
		try {
			sql = "select * from login where mid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			
			rs.next();
			
			vo.setIdx(rs.getInt("idx"));
			vo.setMid(mid);										// vo.setMid(rs.getString("mid"));
			vo.setPwd(rs.getString("pwd"));
			vo.setName(rs.getString("name"));
			vo.setPoint(rs.getInt("point"));
			vo.setLastDate(rs.getString("lastDate"));
			vo.setvCount(rs.getInt("vCount"));
		} catch (SQLException e) {
			System.out.println("SQL 에러 : " + e.getMessage());
			//e.printStackTrace();
		} finally {
			rsClose();
		}	
		
		return vo;
	}

	// 회원가입처리하기
	public int setLoginJoin(LoginVO vo) {
		int res = 0;
		// try : 예외처리
		try {
			sql = "insert into login values (default,?,?,?,default,default,default)"; // 인서트
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.executeUpdate();
			res = 1;
		} catch (SQLException e) {
			System.out.println("SQL 에러 : " + e.getMessage());
		} finally {
			pstmtClose();
		}	
		
		return res;
	}

	// 아이디 중복체크...
	public int getIdCheck(String mid) {
		int res = 0;
		try {
			sql = "select mid from login where mid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			
			/*
			 * if(rs.next()) res = 0; // 아이디 중복됨.. 사용불가 
			 * else res = 1; // 아이디가 중복되지 않음.. 사용가능
			 */			
			if(!rs.next()) res = 1;	// 아이디 중복되지 않음.. 사용가능(1)
			// else res = 0;		// 아이디가 중복됨..  사용불가
		} catch (SQLException e) {
			System.out.println("SQL 에러 : " + e.getMessage());
		} finally {
			rsClose();
		}	
		
		return res;
	}

	// 전체 회원보기
	public ArrayList<LoginVO> getLoginList() {
		ArrayList<LoginVO> vos = new ArrayList<LoginVO>();
		try {
			sql = "select * from login order by idx desc"; // 나중에 가입한 사람 먼저 보겠다
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				LoginVO vo = new LoginVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setMid(rs.getString("mid"));
				vo.setPwd(rs.getString("pwd"));
				vo.setName(rs.getString("name"));
				vo.setPoint(rs.getInt("point"));
				vo.setLastDate(rs.getString("lastDate"));
				vo.setvCount(rs.getInt("vCount"));
				vos.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 에러 : " + e.getMessage());
		} finally {
			rsClose();
		}	
		
		return vos;
	}

	// 회원 탈퇴
	public int setLoginDelete(String mid) {
		int res = 0;
		try {
			sql = "delete from login where mid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.executeUpdate();
			res = 1;
		} catch (SQLException e) {
			System.out.println("SQL 에러 : " + e.getMessage());
		} finally {
			pstmtClose();
		}	
		return res;
	}

	// 회원 정보 수정하기
	public int setUpdate(LoginVO vo) {
		int res = 0;
		try {
			sql = "update login set pwd = ?, name = ? where mid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPwd());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getMid());
			pstmt.executeUpdate();
			res = 1;
		} catch (SQLException e) {
			System.out.println("SQL 에러 : " + e.getMessage());
		} finally {
			pstmtClose();
		}	
		return res;
	}

	// 관리자 인증확인
	public int getAdminCheck(String mid, String pwd) {
		int res = 0;
		try {
			sql = "select mid from login where mid=? and pwd=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery(); // 결과를 돌려받으세용~
			
			if(rs.next()) res = 1; // 참일때
		} catch (SQLException e) {
			System.out.println("SQL 에러 : " + e.getMessage());
		} finally {
			rsClose();
		}	
		
		return res;
	}
}
