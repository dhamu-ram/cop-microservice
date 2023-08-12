package io.com.user.api.usermanagement.model;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long userId;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "password")
	private char[] password;

	@Column(name = "created_dt")
	private Instant createdDt;

	@Column(name = "address_line1")
	private String addressLine1;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "country")
	private String country;

	@Column(name = "is_business")
	private boolean isBusiness;

	@Column(name = "businessName")
	private String bizName;

}
