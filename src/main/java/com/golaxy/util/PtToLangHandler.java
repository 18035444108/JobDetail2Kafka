package com.golaxy.util;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

/**
 * 将数据时间类型转化为long型
 * @author lx
 *
 */
public class PtToLangHandler implements TypeHandler<Long> {

	@Override
	public void setParameter(PreparedStatement ps, int i, Long parameter, JdbcType jdbcType) throws SQLException {
		if (parameter == null)
			ps.setNull(i, Types.LONGNVARCHAR);
		else {
			ps.setLong(i, parameter);
		}

	}

	@Override
	public Long getResult(ResultSet rs, String columnName) throws SQLException {
		long pt = TimeUtil.getTime(rs.getString(columnName));
		return pt;
	}

	@Override
	public Long getResult(ResultSet rs, int columnIndex) throws SQLException {
		long pt = TimeUtil.getTime(rs.getString(columnIndex));
		return pt;
	}

	@Override
	public Long getResult(CallableStatement cs, int columnIndex) throws SQLException {
		long pt = TimeUtil.getTime(cs.getString(columnIndex));
		return pt;
	}

}
