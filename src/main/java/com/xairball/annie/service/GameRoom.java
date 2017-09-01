package com.xairball.annie.service;

import java.io.Serializable;
import java.util.List;

import com.xairball.annie.model.sys.User;

public class GameRoom implements Serializable{
	private static final long serialVersionUID = -2359747718001759778L;
	private List<User> player;
	private Integer status;
}
