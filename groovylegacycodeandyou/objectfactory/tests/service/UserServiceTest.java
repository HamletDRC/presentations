package service;

import domain.UserDTO;
import domain.User;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import factory.ObjectFactory;

public class UserServiceTest {

    @Test
    public void testNoMocking() {
        ObjectFactory factory = new ObjectFactory();
        UserService service = new UserService(factory);
        service.create(new UserDTO("fname", "lname")); 
    }

    @Test
    public void testMocking() {

        // arrange
        User user = mock(User.class);
        ObjectFactory factory = mock(ObjectFactory.class);
        when(factory.make(User.class)).thenReturn(user);

        // act
        UserService service = new UserService(factory);
        service.create(new UserDTO("fname", "lname"));

        // assert
        verify(user).setFirstName("fname");
        verify(user).setLastName("lname");
        verify(user).save();
    }
}
