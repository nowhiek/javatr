package by.epam.jwd.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.epam.jwd.bean.Role;
import by.epam.jwd.bean.Status;
import by.epam.jwd.bean.User;
import by.epam.jwd.dao.UserDAO;
import by.epam.jwd.dao.connectionpool.ConnectionPool;
import by.epam.jwd.dao.connectionpool.ConnectionPoolException;
import by.epam.jwd.exception.dao.DAOException;

public class UserDAOImpl implements UserDAO {
	
	private final static String GET_ALL_USERS = "SELECT * FROM User";
	private final static String ADD_USER = "INSERT INTO User (id, userName, userPassword, userEmail, userRole, userStatus, isBanned) VALUES (default, ?, ?, ?, ?, ?, ?)";
	private final static String GET_USER = "SELECT * from User WHERE id = ?";
	
	@Override
	public List<User> getAll() throws DAOException {
		ConnectionPool pool = null;
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		List<User> result = new ArrayList<>();
		
		try {
			pool = ConnectionPool.getInstance();
			pool.initPoolData();
			
			connection = pool.takeConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(GET_ALL_USERS);
			
			while (rs.next()) {
				User user = new User();
				
				//getString(2) change to getString("columnName")
				user.setUserName(rs.getString(2));
				user.setUserPassword(rs.getString(3));
				user.setUserEmail(rs.getString(4));
				user.setUserRole(Role.valueOf(rs.getString(5).toUpperCase()));
				user.setUserStatus(Status.valueOf(rs.getString(6).toUpperCase()));
				user.setUserBan(Boolean.parseBoolean(rs.getString(7)));
				
				result.add(user);
			}
		} catch (ConnectionPoolException e) {
			throw new DAOException("Pool can't get connection.", e);
		} catch (SQLException e) {
			throw new DAOException("SQL can't get information.", e);
		} finally {
			pool.closeConnection(connection, statement, rs);
		}
		
		return result;
	}

	@Override
	public User getUserById(int id) throws DAOException {
		ConnectionPool pool = null;
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User result = new User();
		
		try {
			pool = ConnectionPool.getInstance();
			pool.initPoolData();
			
			connection = pool.takeConnection();
			ps = connection.prepareStatement(GET_USER);
			
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				result.setUserName(rs.getString(2));
				result.setUserPassword(rs.getString(3));
				result.setUserEmail(rs.getString(4));
				result.setUserRole(Role.valueOf(rs.getString(5).toUpperCase()));
				result.setUserStatus(Status.valueOf(rs.getString(6).toUpperCase()));
				result.setUserBan(Boolean.parseBoolean(rs.getString(7)));
			}
		} catch (ConnectionPoolException e) {
			throw new DAOException("Pool can't get connection.", e);
		} catch (SQLException e) {
			throw new DAOException("SQL can't get information.", e);
		} finally {
			pool.closeConnection(connection, ps, rs);
		}
		
		return result;
	}

	@Override
	public boolean update(User user) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean create(User user) throws DAOException {
		ConnectionPool pool = null;
		Connection connection = null;
		PreparedStatement ps = null;
		boolean flag = false;
		
		try {
			pool = ConnectionPool.getInstance();
			pool.initPoolData();
			
			connection = pool.takeConnection();
			ps = connection.prepareStatement(ADD_USER);
			
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getUserPassword());
			ps.setString(3, user.getUserEmail());
			ps.setString(4, user.getUserRole().getTitle());
			ps.setString(5, user.getUserStatus().getTitle());
			ps.setBoolean(6, user.getUserIsBanned());
			
			ps.executeUpdate();
			flag = true;
		} catch (ConnectionPoolException e) {
			throw new DAOException("Pool can't get connection.", e);
		} catch (SQLException e) {
			throw new DAOException("SQL can't get information.", e);
		} finally {
			pool.closeConnection(connection, ps);
		}
		
		return flag;
	}

	@Override
	public boolean remove(User user) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean isUserExist(User user) throws DAOException {
		List<User> all = getAll();
		
		for	(int i = 0; i < all.size(); i++) {
			if (user.getUserName().equalsIgnoreCase(all.get(i).getUserName())) {
				return true;
			}
		}
		
		return false;
	}
}
