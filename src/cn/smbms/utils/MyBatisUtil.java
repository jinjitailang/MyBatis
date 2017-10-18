package cn.smbms.utils;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory factory;
	
	static {
		try {
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static SqlSession createSqlSession() {
		return factory.openSession(false);
	}
	
	public static void closeSqlSession(SqlSession sqlSession) {
		if (null!=sqlSession) {
			sqlSession.close();
		}
	}
}
