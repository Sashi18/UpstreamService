package com.stackroute.matchzone.service;

import com.stackroute.matchzone.exceptions.UserAlreadyExistsException;
import com.stackroute.matchzone.exceptions.UserNotFoundException;
import com.stackroute.matchzone.model.User;

public interface UserService {

	boolean createUser(User user) throws UserAlreadyExistsException;
	
	boolean deleteUser(String userId) throws UserNotFoundException;
	
	User updateUser(String userId, User user) throws UserNotFoundException;
	
	User getUser(String userId) throws UserNotFoundException;
	
}
