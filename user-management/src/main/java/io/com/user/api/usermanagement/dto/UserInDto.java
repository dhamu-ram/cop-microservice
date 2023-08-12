package io.com.user.api.usermanagement.dto;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
/**
 * The UserInDto class represents the input DTO for creating or updating a user.
 * It contains various attributes that describe the user's details.
 * @author abhis
 */
public class UserInDto {

	/**
	 * The username of the user.
	 */
	private String userName;

	/**
	 * The email address of the user.
	 */
	private String email;

	/**
	 * The password of the user (stored as a character array for security reasons).
	 */
	private char[] password;

	/**
	 * The address line 1 of the user's address.
	 */
	private String addressLine1;

	/**
	 * The city of the user's address.
	 */
	private String city;

	/**
	 * The state of the user's address.
	 */
	private String state;

	/**
	 * The country of the user's address.
	 */
	private String country;

	/**
	 * Indicates whether the user is a business user or not.
	 */
	private boolean isBusiness;

	/**
	 * The name of the business (applicable only if the user is a business user).
	 */
	private String bizName;
}
