package org.lanqiao.converter;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public class BooleanAndIntConverter extends BaseTypeHandler<Boolean>{
    /**
	 * Java类型（String）→ JDBC类型（Integer）
	 * 
	 * @param ps:
	 *            当前的PreparedStatement对象
	 * @param i:
	 *            当前参数的位置
	 * @param parameter:
	 *            当前参数值
	 */
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Boolean parameter, JdbcType jdbcType)
			throws SQLException {
		/*
		 * 如果Java类型的parameter==true，则在数据库中存储JDBC类型的数字1
		 * 如果Java类型的parameter==false，则在数据库中存储JDBC类型的数字0
		 */
		if (parameter){
			ps.setInt(i, 1);
		}
		else{
			ps.setInt(i, 0);
		}
	}

	/**
	 *  JDBC类型（Integer）-->Java类型（Boolean）
	 */
	@Override
	public Boolean getNullableResult(ResultSet rs, String columnName) throws SQLException{
		/*
		 *  通过字段名获取值
		 */
		int sexNum = rs.getInt(columnName);
		/*
		 * 如果数据库中的JDBC变量sexNum == 1，则返回Java类型的true
		 * 如果数据库中的JDBC变量sexNum ==0，则返回Java类型的false
		 */
		if (sexNum == 1)	{
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 *  JDBC类型（Integer）-->Java类型（Boolean）
	 */
	@Override
	public Boolean getNullableResult(ResultSet rs, int columnIndex) throws SQLException{
		/*
		 *  通过字段的索引获取值
		 */
		int sexNum = rs.getInt(columnIndex);
		if (sexNum == 1)	{
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 *  JDBC类型（Integer）-->Java类型（Boolean）
	 */
	@Override
	public Boolean getNullableResult(CallableStatement cs, int columnIndex) throws SQLException{
		/*
		 *  通过调用存储过程获取值
		 */
		int sexNum = cs.getInt(columnIndex);
		if (sexNum == 1)	{
			return true;
		}
		else{
			return false;
		}
	}
}