package controllers;
import models.*;
 
public class Security extends Secure.Security {
    
    static boolean authenticate(String username, String password) {
        User user = Database.getUserByName(username);
        boolean correctLogin = (user != null && user.password.equals(password));
        if (correctLogin) {Database.setCurrentUser(Database.getUserByName(username));}
        return correctLogin;
    }
}
