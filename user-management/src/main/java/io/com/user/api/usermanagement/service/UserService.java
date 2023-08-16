package io.com.user.api.usermanagement.service;

import io.com.user.api.usermanagement.dao.UserRepository;
import io.com.user.api.usermanagement.dto.UserInDto;
import io.com.user.api.usermanagement.dto.UserOutDto;
import io.com.user.api.usermanagement.exception.UserNotFoundException;
import io.com.user.api.usermanagement.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Base64;
import java.util.Optional;

/**
 * The UserService class provides methods for managing user-related operations.
 * It interacts with the UserRepository to perform CRUD operations on the User entity.
 * @author abhis
 */
@Service
public class UserService {

	@Autowired
	private final UserRepository userRepository;
	
	/**
     * The logger object for creating system logs.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	/**
	 * Adds a new user based on the provided user input DTO.
	 * @param userInDto The input DTO containing user information.
	 * @return The output DTO representing the added user.
	 */
	public UserOutDto userAdd(UserInDto userInDto) {
		User user = new User();
		user.setUserName(userInDto.getUserName());
		user.setEmail(userInDto.getEmail());
		char[] originalInput = userInDto.getPassword();
		Base64.Encoder encoder = Base64.getEncoder();
		//String encodedString = encoder.encodeToString(null)
		user.setPassword(userInDto.getPassword());
		user.setCreatedDt(Instant.now());
		user.setAddressLine1(userInDto.getAddressLine1());
		user.setCity(userInDto.getCity());
		user.setState(userInDto.getState());
		user.setCountry(userInDto.getCountry());
		user.setBusiness(true);
		user.setBizName(userInDto.getBizName());
		userRepository.save(user);
		return prepareOutDto(user);
	}

	/**
	 * Prepares the output DTO based on the provided User entity.
	 * @param user The User entity.
	 * @return The output DTO representing the user.
	 */
	private UserOutDto prepareOutDto(User user) {
		LOGGER.info(">>> prepareOutDto");
		UserOutDto userOutDto = new UserOutDto();
		userOutDto.setUserId(user.getUserId());
		userOutDto.setUserName(user.getUserName());
		userOutDto.setEmail(user.getEmail());
		userOutDto.setCreatedDt(Instant.now());
		userOutDto.setAddressLine1(user.getAddressLine1());
		userOutDto.setCity(user.getCity());
		userOutDto.setState(user.getState());
		userOutDto.setCountry(user.getCountry());
		userOutDto.setBusiness(true);
		userOutDto.setBizName(user.getBizName());
		return userOutDto;
	}

	/**
	 * Updates the user with the given ID using the provided user input DTO.
	 * @param id         The ID of the user to update.
	 * @param userInDto  The input DTO containing updated user information.
	 * @return The output DTO representing the updated user.
	 * @throws UserNotFoundException If the user with the given ID is not found.
	 */
	    public UserOutDto updateUser(final long id, final UserInDto userInDto) throws UserNotFoundException {
	        User user;
	        Optional<User> findById = userRepository.findById(id);
	        if(findById.isEmpty()){
	        	throw new UserNotFoundException("User Not found");
	        }
	        user = findById.get();
	        user.setUserName(userInDto.getUserName());
			user.setEmail(user.getEmail());
			user.setCreatedDt(Instant.now());
			user.setAddressLine1(userInDto.getAddressLine1());
			user.setCity(userInDto.getCity());
			user.setState(userInDto.getState());
			user.setCountry(userInDto.getCountry());
			user.setBusiness(true);
			user.setBizName(userInDto.getBizName());
			userRepository.save(user);
			return prepareUpdateOutDto(user);
	    }

	    /**
		 * Prepares the output DTO based on the provided User entity after an update.
		 * @param user The updated User entity.
		 * @return The output DTO representing the updated user.
		 */
	    private UserOutDto prepareUpdateOutDto(User user) {
			UserOutDto userOutDto = new UserOutDto();
			userOutDto.setUserId(user.getUserId());
			userOutDto.setUserName(user.getUserName());
			userOutDto.setEmail(user.getEmail());
			userOutDto.setCreatedDt(Instant.now());
			userOutDto.setAddressLine1(user.getAddressLine1());
			userOutDto.setCity(user.getCity());
			userOutDto.setState(user.getState());
			userOutDto.setCountry(user.getCountry());
			userOutDto.setBusiness(true);
			userOutDto.setBizName(user.getBizName());
			return userOutDto;
		}
	    
	    /**
		 * Retrieves the user with the given ID.
		 * @param id The ID of the user to retrieve.
		 * @return The User entity representing the user.
		 * @throws UserNotFoundException If the user with the given ID is not found.
		 */
	    public User getUserById(Long id) throws UserNotFoundException {
	        Optional<User> findById = userRepository.findById(id);
	        if(findById.isEmpty()){
	        	throw new UserNotFoundException("User Not found");
	        }
	        return userRepository.findById(id).orElse(null);
	    }

	    /**
		 * Deletes the user with the given ID.
		 * @param id The ID of the user to delete.
		 * @throws UserNotFoundException If the user with the given ID is not found.
		 */
	    public void deleteUser(Long id) throws UserNotFoundException {

	        Optional<User> findById = userRepository.findById(id);
	        if(findById.isEmpty()){
	        	throw new UserNotFoundException("User Not found");
	        }
	        userRepository.deleteById(id);
	    }
	
}
