package com.abhinav.service;

import com.abhinav.exception.ProjectException;
import com.abhinav.exception.UserException;
import com.abhinav.model.User;

public interface UserService {

	public User findUserProfileByJwt(String jwt) throws UserException, ProjectException;
	
	public User findUserByEmail(String email) throws UserException;
	
	public User findUserById(Long userId) throws UserException;

	public User updateUsersProjectSize(User user,int number);

//	public List<User> findAllUsers();

//	public List<User> getPenddingRestaurantOwner();

	void updatePassword(User user, String newPassword);

	void sendPasswordResetEmail(User user);

//	void sendPasswordResetEmail(User user);
}
