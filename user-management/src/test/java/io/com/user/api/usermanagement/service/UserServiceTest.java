package io.com.user.api.usermanagement.service;

import io.com.user.api.usermanagement.dao.UserRepository;
import io.com.user.api.usermanagement.dto.UserInDto;
import io.com.user.api.usermanagement.dto.UserOutDto;
import io.com.user.api.usermanagement.exception.UserNotFoundException;
import io.com.user.api.usermanagement.model.User;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.Instant;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    public UserServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testUserAdd() {
    	long userId = 1;
        UserInDto userInDto = new UserInDto();
        userInDto.setUserName("abhishek");
        userInDto.setEmail("abhishek@gmail.com");
        userInDto.setPassword("password".toCharArray());
        userInDto.setAddressLine1("Samta St");
        userInDto.setCity("Raipur");
        userInDto.setState("NY");
        userInDto.setCountry("India");
        userInDto.setBusiness(true);
        userInDto.setBizName("Home decore Inc.");

        String dateString = "2023-06-11T15:38:16.189356200Z";
        Instant instant = Instant.parse(dateString);
        User user = new User();
        user.setUserId(userId);
        user.setUserName(userInDto.getUserName());
        user.setEmail(userInDto.getEmail());
        user.setPassword(userInDto.getPassword());
        user.setCreatedDt(instant);
        user.setAddressLine1(userInDto.getAddressLine1());
        user.setCity(userInDto.getCity());
        user.setState(userInDto.getState());
        user.setCountry(userInDto.getCountry());
        user.setBusiness(userInDto.isBusiness());
        user.setBizName(userInDto.getBizName());

        when(userRepository.save(user)).thenReturn(user);
        
        UserOutDto expectedOutDto = new UserOutDto();
        expectedOutDto.setUserId(userId);
        expectedOutDto.setUserName(user.getUserName());
        expectedOutDto.setEmail(user.getEmail());
        expectedOutDto.setCreatedDt(instant);
        expectedOutDto.setAddressLine1(user.getAddressLine1());
        expectedOutDto.setCity(user.getCity());
        expectedOutDto.setState(user.getState());
        expectedOutDto.setCountry(user.getCountry());
        expectedOutDto.setBusiness(user.isBusiness());
        expectedOutDto.setBizName(user.getBizName());

        UserOutDto resultOutDto = userService.userAdd(userInDto);
        resultOutDto.setUserId(userId);
        resultOutDto.setCreatedDt(instant);
        assertEquals(expectedOutDto, resultOutDto);
    }

    @Test
    public void testUpdateUser() throws UserNotFoundException {
        long userId = 1L;
        UserInDto userInDto = new UserInDto();
        userInDto.setUserName("abhishek");
        userInDto.setEmail("abhishek@gmail.com");
        userInDto.setPassword("password".toCharArray());
        userInDto.setAddressLine1("Samta St");
        userInDto.setCity("Raipur");
        userInDto.setState("NY");
        userInDto.setCountry("India");
        userInDto.setBusiness(true);
        userInDto.setBizName("Home decore Inc.");

        User existingUser = new User();
        existingUser.setUserId(userId);
        existingUser.setUserName("abhishek");
        existingUser.setEmail("abhishek@gmail.com");

        when(userRepository.findById(userId)).thenReturn(Optional.of(existingUser));
        when(userRepository.save(any(User.class))).thenReturn(existingUser);

        String dateString = "2023-06-11T15:38:16.189356200Z";
        Instant instant = Instant.parse(dateString);
        UserOutDto expectedOutDto = new UserOutDto();
        expectedOutDto.setUserId(userId);
        expectedOutDto.setUserName(userInDto.getUserName());
        expectedOutDto.setEmail(userInDto.getEmail());
        expectedOutDto.setCreatedDt(instant);
        expectedOutDto.setAddressLine1(userInDto.getAddressLine1());
        expectedOutDto.setCity(userInDto.getCity());
        expectedOutDto.setState(userInDto.getState());
        expectedOutDto.setCountry(userInDto.getCountry());
        expectedOutDto.setBusiness(userInDto.isBusiness());
        expectedOutDto.setBizName(userInDto.getBizName());

        UserOutDto resultOutDto = userService.updateUser(userId, userInDto);
        resultOutDto.setCreatedDt(instant);
        assertEquals(expectedOutDto, resultOutDto);
        verify(userRepository, times(1)).findById(userId);
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    public void testGetUserById() throws UserNotFoundException {
        long userId = 1;
        User user = new User();
        user.setUserId(userId);
        user.setUserName("abhishek");
        user.setEmail("abhishek@gmail.com");

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        User resultUser = userService.getUserById(userId);

        assertEquals(user, resultUser);
      //  verify(userRepository, times(1)).findById(userId);
    }
    @Test
    public void testDeleteUser() throws UserNotFoundException {
        long userId = 1L;
        User user = new User();
        user.setUserId(userId);
        user.setUserName("abhishek");
        user.setEmail("abhishek@gmail.com");

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        userService.deleteUser(userId);

        verify(userRepository, times(1)).findById(userId);
        verify(userRepository, times(1)).deleteById(userId);
    }
}
