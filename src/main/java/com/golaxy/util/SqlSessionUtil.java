package com.golaxy.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

public class SqlSessionUtil {
	private static final Logger logger = Logger.getLogger(SqlSession.class);
	public static SqlSession getSqlSession(){
 		SqlSession sqlSession = null;
		try {
			java.io.Reader reader=Resources.getResourceAsReader("Configuration.xml");
			SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
			sqlSession= factory.openSession();
		} catch (Exception e) {
			logger.error(e.getMessage());
//			System.out.println(e.getMessage());
		}
		return sqlSession;
 	}
}
