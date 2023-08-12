package io.com.user.api.usermanagement.controller;

import io.com.user.api.usermanagement.dto.UserInDto;
import io.com.user.api.usermanagement.dto.UserOutDto;
import io.com.user.api.usermanagement.exception.UserNotFoundException;
import io.com.user.api.usermanagement.model.User;
import io.com.user.api.usermanagement.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The UserController class handles HTTP requests related to user operations.
 * It provides endpoints for adding, updating, retrieving, and deleting users.
 * @author abhis
 */
@RestController
@RequestMapping("/user/")
public class UserController {

	@Autowired(required = false)	
	private UserService userService;
	
	private static final Logger logger = LogManager.getLogger(UserController.class);
	
	/**
	 * Adds a new user based on the provided UserInDto.
	 * @param userInDto The input DTO containing the details of the user to be added.
	 * @return A ResponseEntity object containing the output DTO (UserOutDto) representing the added user,
	 *         with an HTTP status of 201 (Created) if successful.
	 *         If an exception occurs, it returns a ResponseEntity object with an HTTP status of 400 (Bad Request).
	 */
	@PostMapping("/useradd")
	public ResponseEntity<Object> userAdd(@RequestBody UserInDto userInDto) {
		try {
			 UserOutDto userOutDto =  userService.userAdd(userInDto);
			logger.info("added the user successfully");
			return new ResponseEntity<>(userOutDto,HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("User is not created");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	/**
	 * Updates a user with the provided details.
	 * @param id The ID of the user to update.
	 * @param userInDto The input DTO containing the updated details of the user.
	 * @return A ResponseEntity object containing the output DTO (UserOutDto) representing the updated user,
	 *         with an HTTP status of 200 (OK) if successful.
	 * @throws UserNotFoundException If the user with the given ID is not found.
	 */
	@PutMapping("/{id}")
    public ResponseEntity<UserOutDto> updateUser(@PathVariable Long id, @RequestBody final UserInDto userInDto) throws UserNotFoundException {
        UserOutDto updatedUser = userService.updateUser(id, userInDto);
        return ResponseEntity.ok(updatedUser);
    }

	/**
	 * Retrieves a user by their ID.
	 * @param id The ID of the user to retrieve.
	 * @return A ResponseEntity object containing the retrieved User object,
	 *         with an HTTP status of 200 (OK) if the user is found.
	 *         If the user is not found, it returns a ResponseEntity object with an HTTP status of 404 (Not Found).
	 * @throws UserNotFoundException If the user with the given ID is not found.
	 */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) throws UserNotFoundException {
        User user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
	 * Deletes a user by their ID.
	 * @param id The ID of the user to delete.
	 * @return A ResponseEntity object with an HTTP status of 204 (No Content) if the user is deleted successfully.
	 * @throws UserNotFoundException If the user with the given ID is not found.
	 */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) throws UserNotFoundException {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
