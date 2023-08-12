package io.com.user.api.usermanagement.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserInDtoTest {

    @Test
    public void testSetAndGetUserName() {
        UserInDto user = new UserInDto();
        user.setUserName("abhishek");
        assertEquals("abhishek", user.getUserName());
    }

    @Test
    public void testSetAndGetEmail() {
        UserInDto user = new UserInDto();
        user.setEmail("abhishek@gmail.com");
        assertEquals("abhishek@gmail.com", user.getEmail());
    }

    @Test
    public void testSetAndGetPassword() {
        UserInDto user = new UserInDto();
        char[] password = "password".toCharArray();
        user.setPassword(password);
        assertArrayEquals(password, user.getPassword());
    }

    @Test
    public void testSetAndGetAddressLine1() {
        UserInDto user = new UserInDto();
        user.setAddressLine1("samta St");
        assertEquals("samta St", user.getAddressLine1());
    }

    @Test
    public void testSetAndGetCity() {
        UserInDto user = new UserInDto();
        user.setCity("raipur");
        assertEquals("raipur", user.getCity());
    }

    @Test
    public void testSetAndGetState() {
        UserInDto user = new UserInDto();
        user.setState("Chattisgarh");
        assertEquals("Chattisgarh", user.getState());
    }

    @Test
    public void testSetAndGetCountry() {
        UserInDto user = new UserInDto();
        user.setCountry("India");
        assertEquals("India", user.getCountry());
    }

    @Test
    public void testSetAndIsBusiness() {
        UserInDto user = new UserInDto();
        user.setBusiness(true);
        assertTrue(user.isBusiness());
    }

    @Test
    public void testSetAndGetBizName() {
        UserInDto user = new UserInDto();
        user.setBizName("Home decode Inc.");
        assertEquals("Home decode Inc.", user.getBizName());
    }
    
    @Test
    public void testNoArgsConstructorAndAllArgsConstructor() {
        UserInDto user = new UserInDto();
        assertNull(user.getUserName());
        assertNull(user.getEmail());
        assertNull(user.getPassword());
        assertNull(user.getAddressLine1());
        assertNull(user.getCity());
        assertNull(user.getState());
        assertNull(user.getCountry());
        assertFalse(user.isBusiness());
        assertNull(user.getBizName());

        UserInDto user2 = new UserInDto("abhishek", "abhishek@gmail.com", "password".toCharArray(),
                "samta St", "raipur", "Chattisgarh", "India", true, "Home decode Inc.");
        assertNotNull(user2.getUserName());
        assertNotNull(user2.getEmail());
        assertNotNull(user2.getPassword());
        assertNotNull(user2.getAddressLine1());
        assertNotNull(user2.getCity());
        assertNotNull(user2.getState());
        assertNotNull(user2.getCountry());
        assertNotNull(user2.isBusiness());
        assertNotNull(user2.getBizName());
    }

    @Test
    public void testToString() {
        UserInDto user = new UserInDto("abhishek", "abhishek@gmail.com", "password".toCharArray(),
                "samta St", "raipur", "Chattisgarh", "India", true, "Home decode Inc.");

        String expectedToString = "UserInDto(userName=abhishek, email=abhishek@gmail.com, " +
                "password=[p, a, s, s, w, o, r, d], addressLine1=samta St, city=raipur, state=Chattisgarh, " +
                "country=India, isBusiness=true, bizName=Home decode Inc.)";

        assertEquals(expectedToString, user.toString());
    }

    @Test
    public void testEqualsAndHashCode() {
        UserInDto user1 = new UserInDto("abhishek", "abhishek@gmail.com", "password".toCharArray(),
                "samta St", "raipur", "Chattisgarh", "India", true, "Home decode Inc.");
        UserInDto user2 = new UserInDto("abhishek", "abhishek@gmail.com", "password".toCharArray(),
                "samta St", "raipur", "Chattisgarh", "India", true, "Home decode Inc.");

        assertEquals(user1, user2);
        assertEquals(user1.hashCode(), user2.hashCode());
    }

}
