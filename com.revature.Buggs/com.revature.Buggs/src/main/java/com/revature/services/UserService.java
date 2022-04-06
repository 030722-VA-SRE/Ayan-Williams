package com.revature.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dtos.UserDTO;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.repositories.BuggRepository;
import com.revature.repositories.UserRepository;

@Service
public class UserService {

	private UserDTO udto;
	private UserRepository ur;
	private BuggRepository br;
	private static Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	public UserService(UserRepository ur) {
		super();
		this.ur = ur;
	}
	
	public List<UserDTO> getUsers(){
		
		List<User> users = ur.findAll();
		
		/*-
		 *  converts the list into a stream in which a map function is applied
		 *  The map function applies some logic to each object within the List and returns that object
		 *  the newly UserDto objects are then returned
		 */
		List<UserDTO> usersDTO = users.stream()
//				.filter(user -> user.getRole().toString().equals("ADMIN"))
				.map((user) -> new UserDTO(user))
				.collect(Collectors.toList());
		
		return usersDTO;
		
	}
	
	public UserDTO getUserById(int id) throws UserNotFoundException {
		User user = ur.findById(id).orElseThrow(UserNotFoundException::new);
		// log.info("user x retrieved ...");
		log.info(MDC.get("userToken"));
		return new UserDTO(user);
	}
	
	public User getUserById2(int id) throws UserNotFoundException{
		User user = ur.findById(id).orElseThrow(UserNotFoundException::new);
		return user;
		
	}
	
	@Transactional
	public User createUser(User newUser) {	
		/*-
		 * logic for user already exists exception
		 */
		return ur.save(newUser);
	}
	
	
	
	@Transactional
	public User updateUser(int id, User user) {
		/*-
		 *  Logic for update user, ie:
		 *  	- check that user exists
		 *  	- partial updates
		 *  	- etc...
		 */
		return ur.save(user);
	}
	
	@Transactional
	public boolean deleteUserById(int id) throws UserNotFoundException {
		ur.deleteById(id);
		return true;
	}


}

























