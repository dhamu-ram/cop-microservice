package io.com.user.api.usermanagement.model;

import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testGetUserId() {
        User user = new User();
        user.setUserId(1L);
        assertEquals(1L, user.getUserId());
    }

    @Test
    public void testGetUserName() {
        User user = new User();
        user.setUserName("abhishek");
        assertEquals("abhishek", user.getUserName());
    }

    @Test
    public void testGetEmail() {
        User user = new User();
        user.setEmail("abhishek@gmail.com");
        assertEquals("abhishek@gmail.com", user.getEmail());
    }

    @Test
    public void testGetPassword() {
        User user = new User();
        char[] password = "password".toCharArray();
        user.setPassword(password);
        assertArrayEquals(password, user.getPassword());
    }

    @Test
    public void testGetCreatedDt() {
        User user = new User();
        Instant createdDt = Instant.now();
        user.setCreatedDt(createdDt);
        assertEquals(createdDt, user.getCreatedDt());
    }

    @Test
    public void testGetAddressLine1() {
        User user = new User();
        user.setAddressLine1("samta Street");
        assertEquals("samta Street", user.getAddressLine1());
    }

    @Test
    public void testGetCity() {
        User user = new User();
        user.setCity("raipur");
        assertEquals("raipur", user.getCity());
    }

    @Test
    public void testGetState() {
        User user = new User();
        user.setState("Chattisgarh");
        assertEquals("Chattisgarh", user.getState());
    }

    @Test
    public void testGetCountry() {
        User user = new User();
        user.setCountry("India");
        assertEquals("India", user.getCountry());
    }

    @Test
    public void testIsBusiness() {
        User user = new User();
        user.setBusiness(true);
        assertTrue(user.isBusiness());
    }

    @Test
    public void testGetBizName() {
        User user = new User();
        user.setBizName("home decore Business");
        assertEquals("home decore Business", user.getBizName());
    }

    @Test
    public void testSetUserId() {
        User user = new User();
        user.setUserId(1L);
        assertEquals(1L, user.getUserId());
    }

    @Test
    public void testSetUserName() {
        User user = new User();
        user.setUserName("abhishek");
        assertEquals("abhishek", user.getUserName());
    }

    @Test
    public void testSetEmail() {
        User user = new User();
        user.setEmail("abhishek@gmail.com");
        assertEquals("abhishek@gmail.com", user.getEmail());
    }

    @Test
    public void testSetPassword() {
        User user = new User();
        char[] password = "password".toCharArray();
        user.setPassword(password);
        assertArrayEquals(password, user.getPassword());
    }

    @Test
    public void testSetCreatedDt() {
        User user = new User();
        Instant createdDt = Instant.now();
        user.setCreatedDt(createdDt);
        assertEquals(createdDt, user.getCreatedDt());
    }

    @Test
    public void testSetAddressLine1() {
        User user = new User();
        user.setAddressLine1("Samta Street");
        assertEquals("Samta Street", user.getAddressLine1());
    }

    @Test
    public void testSetCity() {
        User user = new User();
        user.setCity("Raipur");
        assertEquals("Raipur", user.getCity());
    }

    @Test
    public void testHashCode() {
        User user1 = new User();
        user1.setUserId(1L);
        user1.setUserName("abhishek");
        user1.setEmail("abhishek@gmail.com");

        User user2 = new User();
        user2.setUserId(1L);
        user2.setUserName("abhishek");
        user2.setEmail("abhishek@gmail.com");
        assertEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    public void testToString() {
        User user = new User();
        user.setUserId(1L);
        user.setUserName("abhishek");
        user.setEmail("abhishek@gmail.com");
        user.setPassword("password".toCharArray());
        user.setCreatedDt(Instant.parse("2023-05-17T12:00:00Z"));
        user.setAddressLine1("samta Street");
        user.setCity("raipur");
        user.setState("chattisgarh");
        user.setCountry("india");
        user.setBusiness(true);
        user.setBizName("home decore Business");

        String expected = "User(userId=1, userName=abhishek, email=abhishek@gmail.com, " +
                "password=[p, a, s, s, w, o, r, d], createdDt=2023-05-17T12:00:00Z, " +
                "addressLine1=samta Street, city=raipur, state=chattisgarh, " +
                "country=india, isBusiness=true, bizName=home decore Business)";
        assertEquals(expected, user.toString());
    }
}








