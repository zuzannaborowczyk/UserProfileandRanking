package com.example.exercise3.repository;

import com.example.exercise3.model.GameException;

public class NoSuchGameTypeException extends GameException {

	public NoSuchGameTypeException(String message) {
		super(message);
	}

}
