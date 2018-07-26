package com.example.exercise3.repository;

import java.util.List;

import com.example.exercise3.model.UserEntity;

public interface UserRepository {

	List<UserEntity> findAll();
	UserEntity findById(long id);
	void updateUserFirstName(UserEntity newEntitFirstName);
	void updateUserLastName(UserEntity newEntityLastName);
	void updateUserEmail(UserEntity newEntityEmail);
	void updateUserPassword(UserEntity newEntityPassword);
	void updateUserLifeMotto(UserEntity newEntityLifeMotto);
	
	
}
