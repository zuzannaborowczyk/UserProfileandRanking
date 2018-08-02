package com.example.exercise3.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.exercise3.model.UserEntity;
import com.example.exercise3.model.UserLevel;
import com.example.exercise3.model.UserDoesNotExistException;

@Repository
public class UserRepositoryInMemory implements UserRepository {

	private List<UserEntity> users=new ArrayList<>();
	
	public void reset(){
		
		//users.clear();
	}
	
	public void initialize() {
		users.add(new UserEntity(2L, "Marek", "Lewandowski", "Carpe Diem", "Lubieplacki", "marek.lewandowski@op.pl", UserLevel.BEGINNER));
		users.add(new UserEntity(123, "Maja", "Lewanska", "Mysle wiec jestem", "polska345", "maja.lewanska@op.pl", UserLevel.BEGINNER));
		users.add(new UserEntity(847453675, "Iza", "Lewandowski", " ", "kuzynkaiza", "iza.lewandowski@onet.pl", UserLevel.INTERMEDIATE));
		users.add(new UserEntity(45L, "Slawomir", "Lopez", "Tralala", "Zycie345", "slawomir.lopez@gmail.pl", UserLevel.ADVANCED));
		users.add(new UserEntity(555L, "Jurek", "Broniecki", "Lubie zycie", "qwertz", "jurek.bronieckii@op.pl", UserLevel.BEGINNER));
		users.add(new UserEntity(55L, "Jurek", "Mankowski", "Lubie zycie", "blafsj", "jurek.mankowski@op.pl", UserLevel.BEGINNER));
		
	}

	public UserRepositoryInMemory() {
		this.users = new ArrayList<>();
		initialize();
		
		
		
	}

	@Override
	public List<UserEntity> findAll() {
		/*List<UserEntity> usersCopy = new ArrayList<>(users.size());
		Collections.copy(usersCopy, users);
		return usersCopy;*/
		return new ArrayList<>(users);
	}


	
	@Override
	public UserEntity findById(long id) {

		return users.stream()
				.filter(user -> user.getUserId()==id)
				.findFirst()
				.orElseGet(() -> {
					throw new UserDoesNotExistException("Could not find a user with id: " + id);
				});
	}
	

	@Override
	public void updateUserFirstName(UserEntity newEntityFirstName) {
		findById(newEntityFirstName.getUserId()).setFirstName(newEntityFirstName.getFirstName());
		
	}
	@Override
	public void updateUserLastName(UserEntity newEntityLastName) {
		findById(newEntityLastName.getUserId()).setLastName(newEntityLastName.getLastName());
		
	}

	@Override
	public void updateUserEmail(UserEntity newEntityEmail) {
		findById(newEntityEmail.getUserId())
		.setEmail(newEntityEmail.getEmail());
		
	}

	@Override
	public void updateUserPassword(UserEntity newEntityPassword) {
		findById(newEntityPassword.getUserId()).setPassword(newEntityPassword.getPassword());
		
	}

	@Override
	public void updateUserLifeMotto(UserEntity newEntityLifeMotto) {
		findById(newEntityLifeMotto.getUserId()).setLifeMotto(newEntityLifeMotto.getLifeMotto());
		
	}
	
	
	

	

}
