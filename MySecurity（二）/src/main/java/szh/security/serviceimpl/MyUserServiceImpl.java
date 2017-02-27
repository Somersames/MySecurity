package szh.security.serviceimpl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import szh.security.dao.UserDao;
import szh.security.entity.MyUser;
import szh.security.service.MyUserService;
@Service
public class MyUserServiceImpl implements MyUserService{
	@Autowired
	UserDao userdao;
	
	@Override
	public MyUser getUserByName(String name) {
		return userdao.getUserByName(name);
	}
}
