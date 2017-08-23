package mybatis0817;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.cy.pojo.User;

public class UserTest {

	@Test
	public void testFindUserById() throws Exception {
		String resource = "SqlMapConfig.xml";
		// 通过流将核心配置文件读取进来
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 通过核心配置文件输入流来创建会话工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		// 通过工厂创建会话
		SqlSession openSession = factory.openSession();
		// 第一个参数：所调用的sql语句=namespace+.+sql的ID
		// 第二个参数传入的参数
		User user = openSession.selectOne("test.findUserById", 1);
		System.out.println(user);
		openSession.close();
	}

	@Test
	public void testFindUserByUserName() throws Exception {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = factory.openSession();
		List<User> selectList = openSession.selectList("test.findUserName", "王");
	}

	@Test
	public void testInsertUser() throws Exception {
		String resource = "SqlMapConfig.xml";
		InputStream inputstream = Resources.getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputstream);
		SqlSession openSession = factory.openSession();
		User user = new User();
		user.setUsername("赵四11");
		user.setBirthday(new Date());
		user.setSex("2");
		user.setAddress("上海11");
		System.out.println("====" + user.getId());
		openSession.insert("test.insertUser", user);
		// 提交事务(mybatis会自动开启事务，但是mybatis不知道你何时会提交，所以需手动提交)
		openSession.commit();
		System.out.println("====" + user.getId());
	}

	@Test
	public void testDelUserById() throws Exception {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = factory.openSession();
		openSession.delete("test.delUserById", 27);
		openSession.commit();
		openSession.close();
	}

	@Test
	public void testUpdateUserById() throws Exception {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = factory.openSession();
		User user = new User();
		user.setId(28);
		user.setUsername("王麻子");
		openSession.update("test.updateUserById", user);
		openSession.commit();
	}
}
