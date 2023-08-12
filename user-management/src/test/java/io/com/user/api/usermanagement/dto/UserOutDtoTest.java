package io.com.user.api.usermanagement.dto;

import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

public class UserOutDtoTest {


    @Test
    public void testSetAndGetUserId() {
        UserOutDto user = new UserOutDto();
        user.setUserId(1L);
        assertEquals(1L, user.getUserId());
    }

    @Test
    public void testSetAndGetUserName() {
        UserOutDto user = new UserOutDto();
        user.setUserName("abhishek");
        assertEquals("abhishek", user.getUserName());
    }

    @Test
    public void testSetAndGetEmail() {
        UserOutDto user = new UserOutDto();
        user.setEmail("abhishek@gmail.com");
        assertEquals("abhishek@gmail.com", user.getEmail());
    }

    @Test
    public void testSetAndGetCreatedDt() {
        UserOutDto user = new UserOutDto();
        Instant createdDt = Instant.now();
        user.setCreatedDt(createdDt);
        assertEquals(createdDt, user.getCreatedDt());
    }

    @Test
    public void testSetAndGetAddressLine1() {
        UserOutDto user = new UserOutDto();
        user.setAddressLine1("Samta St");
        assertEquals("Samta St", user.getAddressLine1());
    }

    @Test
    public void testSetAndGetCity() {
        UserOutDto user = new UserOutDto();
        user.setCity("New York");
        assertEquals("New York", user.getCity());
    }

    @Test
    public void testSetAndGetState() {
        UserOutDto user = new UserOutDto();
        user.setState("Chattisgarh");
        assertEquals("Chattisgarh", user.getState());
    }

    @Test
    public void testSetAndGetCountry() {
        UserOutDto user = new UserOutDto();
        user.setCountry("India");
        assertEquals("India", user.getCountry());
    }

    @Test
    public void testSetAndIsBusiness() {
        UserOutDto user = new UserOutDto();
        user.setBusiness(true);
        assertTrue(user.isBusiness());
    }

    @Test
    public void testSetAndGetBizName() {
        UserOutDto user = new UserOutDto();
        user.setBizName("Home decore Inc.");
        assertEquals("Home decore Inc.", user.getBizName());
    }
    
    @Test
    public void testToString() {
        UserOutDto user = new UserOutDto();
        user.setUserId(1L);
        user.setUserName("abhishek");
        user.setEmail("abhishek@gmail.com");
        user.setCreatedDt(Instant.now());
        user.setAddressLine1("Samta St");
        user.setCity("New York");
        user.setState("Chattisgarh");
        user.setCountry("India");
        user.setBusiness(true);
        user.setBizName("Home decore Inc.");

        String expectedToString = "UserOutDto(userId=1, userName=abhishek, email=abhishek@gmail.com, " +
                "createdDt=" + user.getCreatedDt() + ", addressLine1=Samta St, city=New York, state=Chattisgarh, " +
                "country=India, isBusiness=true, bizName=Home decore Inc.)";

        assertEquals(expectedToString, user.toString());
    }
    
    @Test
    public void testHashCode() {
        UserOutDto user1 = new UserOutDto();
        user1.setUserId(1L);
        user1.setUserName("abhishek");
        user1.setEmail("abhishek@gmail.com");

        UserOutDto user2 = new UserOutDto();
        user2.setUserId(1L);
        user2.setUserName("abhishek");
        user2.setEmail("abhishek@gmail.com");

        assertEquals(user1.hashCode(), user2.hashCode());
    }
    
    @Test
    public void testNoArgsConstructor() {
        UserOutDto user = new UserOutDto();
        assertNull(user.getUserId());
        assertNull(user.getUserName());
        assertNull(user.getEmail());
        assertNull(user.getCreatedDt());
        assertNull(user.getAddressLine1());
        assertNull(user.getCity());
        assertNull(user.getState());
        assertNull(user.getCountry());
        assertFalse(user.isBusiness());
        assertNull(user.getBizName());
    }
    
    @Test
    public void testAllArgsConstructor() {
        Long userId = 1L;
        String userName = "abhishek";
        String email = "abhishek@gmail.com";
        Instant createdDt = Instant.now();
        String addressLine1 = "Samta St";
        String city = "New York";
        String state = "Chattisgarh";
        String country = "India";
        boolean isBusiness = true;
        String bizName = "Home decore Inc.";

        UserOutDto user = new UserOutDto(userId, userName, email, createdDt, addressLine1, city, state, country, isBusiness, bizName);

        assertEquals(userId, user.getUserId());
        assertEquals(userName, user.getUserName());
        assertEquals(email, user.getEmail());
        assertEquals(createdDt, user.getCreatedDt());
        assertEquals(addressLine1, user.getAddressLine1());
        assertEquals(city, user.getCity());
        assertEquals(state, user.getState());
        assertEquals(country, user.getCountry());
        assertEquals(isBusiness, user.isBusiness());
        assertEquals(bizName, user.getBizName());
    }
}








