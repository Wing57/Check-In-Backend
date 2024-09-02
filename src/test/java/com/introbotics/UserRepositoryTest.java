package com.introbotics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.introbotics.tables.User;

public class UserRepositoryTest {
    
    private UserRepository userRepository;

    @Before
    public void setUp() {
        userRepository = new UserRepository();
    }

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setName("Hi");
        user.setRole("user");

        userRepository.insertUser(user);

        int userid = user.getUserID();
        System.out.println("Inserted User ID: " + userid);

        User retrievedUser = userRepository.getUser(userid);
       assertNotNull("User should be inserted and retrievable", retrievedUser);
        assertEquals("Hi", retrievedUser.getName());
    }

    /*@Test
    public void testDeleteUser() {
        int idToDelete = 5;

        User retrievedUser = userRepository.getUser(idToDelete);
        assertNotNull("User should exist", retrievedUser);

        User userToDelete = new User();
        userToDelete.setUserID(idToDelete);
        userRepository.deleteUser(userToDelete);

        retrievedUser = userRepository.getUser(idToDelete);
        assertNull("User should not exist", retrievedUser);

    } */

    @Test
    public void testUpdateUser() {
        int idToUpdate = 10;

        User retrivedUser = userRepository.getUser(idToUpdate);
        assertNotNull("User should exist", retrivedUser);

        retrivedUser.setName("lesussyclat");
        retrivedUser.setRole("admin");
        userRepository.updateUser(retrivedUser);

        User updatedUser = userRepository.getUser(idToUpdate);

        assertNotNull("User should be retrievable", updatedUser);
        assertEquals("lesussyclat", updatedUser.getName());
    }
}
