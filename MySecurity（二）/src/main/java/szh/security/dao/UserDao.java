package szh.security.dao;



import szh.security.entity.MyUser;
public interface UserDao {
	 MyUser getUserByName(String name);
}
