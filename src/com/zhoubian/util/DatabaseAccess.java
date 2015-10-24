package com.zhoubian.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author e
 */
public class DatabaseAccess {

	private Connection conn = null;
	private PreparedStatement pstm = null;
	private CallableStatement cstm = null;
	private ResultSet rs = null;
	private boolean isshowsql = false;
	/**
	 * 预处理参数列�?
	 */
	@SuppressWarnings("rawtypes")
	// 预处理参数列表...第一类筛选时候加了一个
	private List parameterList = null;

	public DatabaseAccess(boolean isshowsql) {
		// 设定数据库参数的获得方式，直接设定字符和读配置文�?
		// this.useConfig();
		// this.createConn();//创建普�?连接
		this.isshowsql = isshowsql;
		this.createPoolConn();// 创建连接�?
	}

	public DatabaseAccess() {
		// 设定数据库参数的获得方式，直接设定字符和读配置文�?
		this.createPoolConn();// 创建连接�?
	}

	// 创建连接池连�?
	@SuppressWarnings("rawtypes")
	private void createPoolConn() {
		try {
			conn = DatabasePool.getConnection();
			parameterList = new ArrayList();
		} catch (Exception e) {
			// System.out.println(e.getMessage());
		}
	}

	public void reGetConn() {
		conn = DatabasePool.getConnection();
	}

	/**
	 * 放置�?��参数到sql预处理列表，执行�?��sql后清空，必须在执行sql前执行�?
	 * 
	 * @param parameter
	 *            参数
	 */
	@SuppressWarnings("unchecked")
	public void setPreparedParameter(Object parameter) {
		parameterList.add(parameter);
	}

	/**
	 * 为sql加入参数
	 * 
	 * @param sql
	 *            预处理语�?
	 * @throws SQLException
	 */
	private void prepare(String sql) throws SQLException {
		pstm = getConn().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		int index = 1;
		for (Object parameter : parameterList) {
			pstm.setObject(index++, parameter);
		}
		printSql(sql);
	}

	// 准备存储过程参数
	private void prepareCall(String call) throws SQLException {
		cstm = getConn().prepareCall(call);
		int index = 1;
		for (Object parameter : parameterList) {
			cstm.setObject(index++, parameter);
		}
		printSql(call);
	}

	// 不清除预处理参数列表，来获取结果总条�?
	// 如果sql参数是select count语句 则直接执行返回一个�?条数�?
	// 如果sql参数是一个普通查询语句，则返货此查询语句去掉limit子句后结果的总条�?
	public int executeCount(String sql) {
		int count = 0;
		sql = sql.toLowerCase();
		// 说明是查数量的
		if (sql.contains("count")) {
			try {
				this.prepare(sql);
				rs = pstm.executeQuery();
				if (rs != null && rs.next()) {
					count = rs.getInt(1);
				}
			} catch (SQLException e) {
				// System.out.println(e.getMessage());
			}
		} else {
			// 说明是查列表的
			if (sql.contains("limit")) {
				sql = sql.substring(0, sql.indexOf("limit"));
			}
			StringBuilder countSql = new StringBuilder();
			countSql.append("select count(1) from (").append(sql)
					.append(") as yy");
			try {
				this.prepare(countSql.toString());
				rs = pstm.executeQuery();
				if (rs != null && rs.next()) {
					count = rs.getInt(1);
				}

			} catch (SQLException e) {
				// System.out.println(e.getMessage());
			}
		}
		return count;
	}

	// 查询密码
	public String executepass(String sql) {
		String password = "";
		try {
			rs = executeQuery(sql);
			if (rs != null && rs.next()) {
				password = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return password;
	}

	// 执行查询的SQL并返回结果集
	public ResultSet executeQuery(String sql) {
		try {
			this.prepare(sql);
			parameterList.clear();
			rs = pstm.executeQuery();
		} catch (SQLException e) {
			// System.out.println(e.getMessage());
		}
		return rs;
	}

	// 可执行插入�?更新、删除的SQL

	public boolean executeUpdate(String sql) {
		boolean b = false;
		try {
			this.prepare(sql);
			parameterList.clear();
			pstm.executeUpdate();
			b = true;
		} catch (Exception e) {
			// System.out.println(e.getMessage());
		}
		return b;
	}

	// 专用于执行select语句，并放回数据库自动生成的主键。返�?1说明插入失败

	public Integer executeInsert(String sql) {
		Integer primarykey = -1;
		try {
			this.prepare(sql);
			pstm.execute();
			parameterList.clear();
			rs = pstm.getGeneratedKeys();
			while (rs.next()) {
				primarykey = rs.getInt(1);
			}
		} catch (Exception e) {
			// System.out.println(e.getMessage());
		}
		return primarykey;
	}

	// 执行存储过程

	public boolean executeProc(String call) {
		boolean b = false;
		try {
			this.prepareCall(call);
			parameterList.clear();
			cstm.execute();
			b = true;
		} catch (Exception e) {
			// System.out.println(e.getMessage());
		}
		return b;

	}

	public void close() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// System.out.println(e.getMessage());
			}
		}
		if (pstm != null) {
			try {
				pstm.close();
			} catch (SQLException e) {
				// System.out.println(e.getMessage());
			}
		}
		if (cstm != null) {
			try {
				cstm.close();
			} catch (SQLException e) {
				// System.out.println(e.getMessage());
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// System.out.println(e.getMessage());
			}
		}
		// if (getConn() != null) {
		// try {
		// getConn().close();
		// } catch (SQLException e) {
		// //System.out.println(e.getMessage());
		// }
		// }
		// //System.out.println("--yy.db数据库连接（关闭�?-");
	}

	/**
	 * 输出SQL语句
	 * 
	 * @param sql
	 */
	private void printSql(String sql) {
		if (isshowsql) {
			StringBuffer s = new StringBuffer(sql);
			for (Object o : parameterList) {
				if (o != null
						&& o.getClass().getName().equals("java.lang.String")) {
					s = s.replace(s.indexOf("?"), s.indexOf("?") + 1,
							"'" + o.toString() + "'");
				} else {
					if (o == null) {
						s = s.replace(s.indexOf("?"), s.indexOf("?") + 1, "");
					} else {
						s = s.replace(s.indexOf("?"), s.indexOf("?") + 1,
								o.toString());
					}
				}
			}
			System.out.println("sql:" + s.toString());
		}
	}

	/**
	 * 这里的处理�?辑是 如果已经关闭了链�? 则需要重新从池子中拿到连�?
	 * 
	 * @return the conn
	 * @throws SQLException
	 */
	public Connection getConn() {
		try {
			if (conn == null || conn.isClosed()) {
				reGetConn();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 提供公共的方法开启事�?
	 */
	public void transaction() {
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 公共方法关闭事务
	 * 
	 * @param success
	 */
	public void transactionEnd(boolean success) {
		try {
			if (success) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 清除预处理中保留参数�?
	 */
	public void CleanParam() {
		parameterList.clear();
	}
}
