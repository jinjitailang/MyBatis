package cn.smbms.dao.user;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import cn.smbms.pojo.User;
import cn.smbms.utils.MyBatisUtil;

public class UserMapperTest {
	private Logger logger= Logger.getLogger(UserMapperTest.class);
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		int count =0;
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			count = sqlSession.selectOne("cn.smbms.dao.user.UserMapper.count");
			logger.debug("UserMapperTest count---->"+count);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSqlSession(sqlSession);
		}
	}
	
	@Test
	public void testGetUserList() {
		List<User> userList = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			userList = sqlSession.selectList("mapper.UserMapper.getUserList");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		for(User user:userList) {
			logger.debug("testGetUserList userCode: "
					+user.getUserCode()+" and userName "
					+user.getUserName());
		}
	}
	
	@Test
	public void testGetUserList1() {
		List<User> userList = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			userList = sqlSession.getMapper(UserMapper.class).getUserList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		for(User user:userList) {
			logger.debug("testGetUserList userCode: "
					+user.getUserCode()+" and userName "
					+user.getUserName());
		}
	}

}
