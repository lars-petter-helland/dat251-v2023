package no.hvl.dat251;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LoginServiceTest {
    
    @Mock UserDAO mockUserDAO;
    
    User arne = new User("arne", "pass");
    
    @Test
    void shouldCallGetUserOnUserDAO() {
        LoginService loginService = new LoginService();
        loginService.setUserDAO(mockUserDAO);
        
        loginService.isAuthenticated("knut", "123");
        verify(mockUserDAO).findByUserName("knut");
    }
    
    
    @Test
    void existingUserOK() {
        LoginService loginService = new LoginService();
        loginService.setUserDAO(mockUserDAO);
        
        when(mockUserDAO.findByUserName("arne")).thenReturn(arne);
        assertTrue(loginService.isAuthenticated("arne", "pass"));
    }
    
}
