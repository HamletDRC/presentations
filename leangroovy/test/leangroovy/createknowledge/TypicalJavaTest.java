package leangroovy.createknowledge;

import leangroovy.eliminatewaste.User;
import leangroovy.eliminatewaste.UserService;
import org.junit.Assert;
import org.junit.Test;


public class TypicalJavaTest {

    @Test
    public void test_users_can_be_retrieved_without_exception() {
        // arrange
        UserService userService = new UserService();

        // act
        User user = (User)userService.get("user1");

        // assert
        Assert.assertEquals("John", user.getFirstName());
        Assert.assertEquals("Doe", user.getLastName());
        Assert.assertEquals(123456, user.getId()); 
    }

}
