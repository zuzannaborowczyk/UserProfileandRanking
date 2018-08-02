package com.example.exercise3.model;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {

	public UserTO mapToTransportObject(UserEntity uE) {
		UserTO result = new UserTO();
		result.setUserId(uE.getUserId());
		result.setFirstName(uE.getFirstName());
		result.setLastName(uE.getLastName());
		result.setEmail(uE.getEmail());
		result.setLifeMotto(uE.getLifeMotto());
		result.setPassword(uE.getPassword());
		result.setUserLevel(uE.getUserLevel());
		return result;

	}

	public UserEntity mapToEntity(UserTO uT) {
		UserEntity result = new UserEntity();
		result.setUserId(uT.getUserId());
		result.setFirstName(uT.getFirstName());
		result.setLastName(uT.getLastName());
		result.setEmail(uT.getEmail());
		result.setLifeMotto(uT.getLifeMotto());
		result.setPassword(uT.getPassword());
		result.setUserLevel(uT.getUserLevel());
		return result;

	}
}
