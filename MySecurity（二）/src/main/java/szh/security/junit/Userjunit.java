package szh.security.junit;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import szh.security.entity.MyUser;
import szh.security.service.MyUserService;
import szh.security.serviceimpl.MyUserServiceImpl;

public class Userjunit {
@Test
public void getUser()
{
	ClassPathXmlApplicationContext xml =new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
	MyUserService myUserService =(MyUserServiceImpl)xml.getBean("myUserServiceImpl");
	MyUser myUser =myUserService.getUserByName("szh");
	System.out.println(myUser.getUser_password());
}
}
