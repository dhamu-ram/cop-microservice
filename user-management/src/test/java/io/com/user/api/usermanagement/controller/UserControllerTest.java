package io.com.user.api.usermanagement.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.com.user.api.usermanagement.dto.UserInDto;
import io.com.user.api.usermanagement.dto.UserOutDto;
import io.com.user.api.usermanagement.exception.UserNotFoundException;
import io.com.user.api.usermanagement.model.User;
import io.com.user.api.usermanagement.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void testUserAdd() throws Exception {
        UserInDto userInDto = new UserInDto();
        userInDto.setUserName("Abhishek");
        userInDto.setEmail("abhi@gmail.com");

        UserOutDto userOutDto = new UserOutDto();
        userOutDto.setUserId(1L);
        userOutDto.setUserName("Abhishek");
        userOutDto.setEmail("abhi@gmail.com");

        ObjectMapper objectMapper = new ObjectMapper();

        when(userService.userAdd(userInDto)).thenReturn(userOutDto);

        String uri = "/user/useradd";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8").accept(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(userInDto));

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        assertEquals(HttpStatus.CREATED.value(), mvcResult.getResponse().getStatus());
        assertEquals(objectMapper.writeValueAsString(userOutDto), mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void testUpdateUser() throws Exception {
        Long id = 1L;
        UserInDto userInDto = new UserInDto();
        userInDto.setUserName("Abhishek");
        userInDto.setEmail("abhi@gmail.com");

        UserOutDto updatedUser = new UserOutDto();
        updatedUser.setUserId(id);
        updatedUser.setUserName("Abhishek");
        updatedUser.setEmail("abhi@gmail.com");

        ObjectMapper objectMapper = new ObjectMapper();

        when(userService.updateUser(id, userInDto)).thenReturn(updatedUser);

        String uri = "/user/{id}";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.put(uri, id).contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8").accept(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(userInDto));

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        assertEquals(objectMapper.writeValueAsString(updatedUser), mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void testGetUserById() throws Exception {
        Long id = 1L;
        User user = new User();
        user.setUserId(id);
        user.setUserName("Abhishek");
        user.setEmail("abhi@gmail.com");

        when(userService.getUserById(id)).thenReturn(user);

        String uri = "/user/{id}";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(uri, id).contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8").accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        assertEquals(new ObjectMapper().writeValueAsString(user), mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void testGetUserById_UserNotFoundException() throws Exception {
        Long id = 1L;

        when(userService.getUserById(id)).thenReturn(null);

        String uri = "/user/{id}";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(uri, id).contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8").accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        assertEquals(HttpStatus.NOT_FOUND.value(), mvcResult.getResponse().getStatus());
    }


    @Test
    public void testDeleteUser() throws Exception {
        Long id = 1L;

        String uri = "/user/{id}";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(uri, id).contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8").accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        assertEquals(HttpStatus.NO_CONTENT.value(), mvcResult.getResponse().getStatus());
    }
    @Test
    public void testDeleteUser_Success() throws Exception {
        Long id = 1L;
        doNothing().when(userService).deleteUser(id);
        ResponseEntity<Void> response = userController.deleteUser(id);
        verify(userService, times(1)).deleteUser(id);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    public void testDeleteUser_UserNotFoundException() throws Exception {
        Long id = 1L;
        doThrow(new UserNotFoundException("User Not found")).when(userService).deleteUser(id);
        try {
            userController.deleteUser(id);
            fail("User Not found");
        } catch (UserNotFoundException e) {
            verify(userService, times(1)).deleteUser(id);
        }
    }


}

