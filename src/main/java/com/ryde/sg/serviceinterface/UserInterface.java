package com.ryde.sg.serviceinterface;


import java.util.List;

import com.ryde.sg.entity.UserEntity;
import com.ryde.sg.exception.CreateUserException;
import com.ryde.sg.model.ResponseModel;
import com.ryde.sg.model.User;


public interface UserInterface {
	
	public ResponseModel addUser(User requestModel) throws CreateUserException;
	
	public List<UserEntity> findAllUser() throws Exception;

	public ResponseModel deleteUser(User req) throws Exception;

	public ResponseModel editUser(User req) throws Exception;

}
