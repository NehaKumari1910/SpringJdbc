package com.jda.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jda.model.UserModel;


@Repository
public class UserDao implements IUserDao{

    @Autowired
    DataSource dataSource;
    
	public int registerUser(UserModel user)  {
		try{
			Connection connection=dataSource.getConnection();
			String QUERY="insert into users(name,gender,age,user_name,email,password,phone) values(?,?,?,?,?,?,?)";
			//System.out.println("usrrrrrrrrrrr"+user.getName()+user.getGender()+user.getAge()+user.getUsername()+user.getEmail()+user.getPassword()+user.getPhone());
			Object objectArray[]=new Object[]{user.getName(),user.getGender(),user.getAge(),user.getUsername(),user.getEmail(),user.getPassword(),user.getPhone()};
			JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		//	System.out.println("hey there");
			int id=jdbcTemplate.update(QUERY, objectArray);
		//	System.out.println("id"+id);
			return id;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return 0;
	}

	public UserModel loginUser(String email) {
		String selectQuery="select * from users where email=?";
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		return (UserModel) jdbcTemplate.queryForObject(selectQuery, new Object[] { (email) }, 
				new RowMapper() {
					public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
						UserModel user=new UserModel();
						user.setName(resultSet.getString("name"));
						user.setGender(resultSet.getString("gender"));
						user.setAge(Integer.parseInt(resultSet.getString("age")));
						user.setUsername(resultSet.getString("user_name"));
						user.setEmail(resultSet.getString("email"));
						user.setPassword(resultSet.getString("password"));
						user.setPhone(resultSet.getString("phone"));
						return user;
					}
		});
	}
	public int saveUUID(String email,String uuid)
	{
		//System.out.println(email+uuid);
		try{
		String query="UPDATE users SET uuid = ? WHERE email = ?";
		Object objectArray[]=new Object[]{uuid,email};
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
	//	System.out.println("hey there");
		int id=jdbcTemplate.update(query, objectArray);
	//	System.out.println("id"+id);
		return id;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return 0;
	}
	public int update(String password,String uuid)
	{
		try{
			String query="UPDATE users SET password = ? WHERE uuid= ?";
			Object objectArray[]=new Object[]{password,uuid};
			JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		//	System.out.println("hey there");
			int id=jdbcTemplate.update(query, objectArray);
		//	System.out.println("id"+id);
			return id;
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			return 0;
		
	}
}
