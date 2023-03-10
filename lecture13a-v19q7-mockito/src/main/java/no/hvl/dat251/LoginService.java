package no.hvl.dat251;

public class LoginService {
    
    UserDAO userDAO = new UserDAO();
    
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean isAuthenticated(String username, String password) {
        User user = userDAO.findByUserName(username);
        if (user != null) {
            return user.passwordMatches(password);
        }
        return false;
    }
    
}