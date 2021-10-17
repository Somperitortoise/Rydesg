package com.ryde.sg.service.user;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryde.sg.entity.UserEntity;
import com.ryde.sg.exception.CreateUserException;
import com.ryde.sg.model.ResponseModel;
import com.ryde.sg.model.User;
import com.ryde.sg.repository.UserRepository;
import com.ryde.sg.serviceinterface.UserInterface;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class UserService implements UserInterface{
	
	Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public ResponseModel addUser(User requestModel) throws CreateUserException {
		logger.info("Add User {}", requestModel);
		UserEntity entity = new UserEntity();
		entity.setAddress(requestModel.getAddress());
		entity.setDescription(requestModel.getDescription());
		entity.setDob(requestModel.getDob());
		entity.setName(requestModel.getName());
		UserEntity ent = userRepository.save(entity);
		return new ResponseModel(null, "user added : "+ent.getId(), true);
	}
	
	
	@Override
	public List<UserEntity> findAllUser() throws Exception  {
		logger.info("findAllUser");
		try {
			return userRepository.findAll();
		}catch (Exception e) {
			logger.error("findAllUser {}", e);
			throw new Exception();
		}
		
		
		
	}


	@Override
	@Transactional
	public ResponseModel deleteUser(User req) throws Exception {
		logger.info("deleteUser");
		try {
			if(null == req.getId()) {
				return new ResponseModel(null,"User Id can't be null : ", false);
			}
			Optional<UserEntity> ent = userRepository.findById(req.getId());
			if(null != ent && !ent.isEmpty()) {
				userRepository.delete(ent.get());
				return new ResponseModel(null,"User successfully deleted id: "+req.getId(), true);
			}else {
				return new ResponseModel(null,"fail to user delete, id not Found for : "+req.getId(), false);
			}
			
		}catch (Exception e) {
			logger.error("deleteUser {}", e);
			throw new Exception();
		}
	}
	
	
	@Override
	@Transactional
	public ResponseModel editUser(User req) throws Exception {
		logger.info("deleteUser");
		try {
			if(null == req.getId()) {
				return new ResponseModel(null,"User Id can't be null : ", false);
			}
			Optional<UserEntity> ent = userRepository.findById(req.getId());
			if(null != ent && !ent.isEmpty()) {
				if(null != req.getName()) {
					ent.get().setName(req.getName());
				}
				if(null != req.getDob()) {
					ent.get().setDob(req.getDob());
				}
				if(null != req.getAddress()) {
					ent.get().setAddress(req.getAddress());
				}
				if(null != req.getDescription()) {
					ent.get().setDescription(req.getDescription());
				}
				userRepository.save(ent.get());
				return new ResponseModel(null,"User successfully edited id: "+req.getId(), true);
			}else {
				return new ResponseModel(null,"fail to user edit, id not Found for : "+req.getId(), false);
			}
			
		}catch (Exception e) {
			logger.error("deleteUser {}", e);
			throw new Exception();
		}
	}

}
