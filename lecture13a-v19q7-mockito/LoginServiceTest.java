package no.hvl.dat251;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LoginServiceTest {
    
    //SUT
    LoginService loginService = new LoginService();
    
    //Test data
    User per = new User("Per", "1234");
    
    //Mocked collaborators
    @Mock UserDAO mockUserDAO;
    @Mock User mockUser;
    
    //-------------------------------------------------------
    
    @BeforeEach void setup() {
        loginService.setUserDAO(mockUserDAO);
    }
    
    @Test void anExistingUserWithMatchingPasswordShouldBeAuthenticated() {
        when(mockUserDAO.findByUserName(anyString())).thenReturn(per);
        assertTrue(loginService.isAuthenticated("notRelevantInTest", per.password()));
    }
    
    @Test void anExistingUserWithNonMatchingPasswordShouldNotBeAuthenticated() {
        when(mockUserDAO.findByUserName(anyString())).thenReturn(per);
        assertFalse(loginService.isAuthenticated("notRelevantInTest", "abcd"));
    }
    
    @Test void loginServiceShouldTellUserDAOToFindUserByUserName() {
        loginService.isAuthenticated("knut", "notRelevantInTest");
        verify(mockUserDAO).findByUserName("knut");
    }
    
    @Test void loginServiceShouldAskFoundUserIfPasswordMatches() {
        when(mockUserDAO.findByUserName(anyString())).thenReturn(mockUser);
        loginService.isAuthenticated("notRelevantInTest", "notRelevantInTest");
        verify(mockUser).passwordMatches("notRelevantInTest");
    }

}
