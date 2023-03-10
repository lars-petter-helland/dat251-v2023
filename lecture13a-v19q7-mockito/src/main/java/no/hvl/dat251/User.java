package no.hvl.dat251;

public record User (String username, String password) {
    
    public boolean passwordMatches(String password) {
        return this.password.equals(password);
    }
}
