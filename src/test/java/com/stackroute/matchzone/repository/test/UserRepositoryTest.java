package com.stackroute.matchzone.repository.test;

import com.stackroute.matchzone.model.User;
import com.stackroute.matchzone.repository.UserRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.NoSuchElementException;

@RunWith(SpringRunner.class)
@DataMongoTest

public class UserRepositoryTest {


    @Autowired
    private UserRepository userRepository;
    private User user;


    @Before
    public void setUp() throws Exception {
        user = new User();
        user.setUserEmail("jhonsimon@gmail.com");
        user.setUserName("Jhon Simon");
        user.setUserPassword("123456");
    }

    @After
    public void tearDown() throws Exception {

        userRepository.deleteAll();

    }

    @Test
    public void registerUserTest() {

        userRepository.insert(user);
        User fetcheduser = userRepository.findById("jhonsimon@gmail.com").get();
        //System.out.println(fetcheduser.getUserMailId());
        Assert.assertEquals(user.getUserEmail(), fetcheduser.getUserEmail());

    }

    @Test(expected = NoSuchElementException.class)
    public void deleteUserTest() {
        userRepository.insert(user);
        User fetcheduser = userRepository.findById("jhonsimon@gmail.com").get();
        Assert.assertEquals("jhonsimon@gmail.com", fetcheduser.getUserEmail());
        userRepository.delete(fetcheduser);
        fetcheduser = userRepository.findById("jhonsimon@gmail.com").get();

    }

    @Test
    public void updateUserTest() {
        userRepository.insert(user);
        User fetcheduser = userRepository.findById("jhonsimon@gmail.com").get();
        fetcheduser.setUserName("Jhon Simon Miguel");
        userRepository.save(fetcheduser);
        fetcheduser = userRepository.findById("jhonsimon@gmail.com").get();
        Assert.assertEquals("Jhon Simon Miguel", fetcheduser.getUserName());
    }

    @Test
    public void getUserByIdTest() {
        userRepository.insert(user);
        User fetcheduser = userRepository.findById("jhonsimon@gmail.com").get();
        Assert.assertEquals(user.getUserEmail(),fetcheduser.getUserEmail());

    }

}
