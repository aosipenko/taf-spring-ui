package se.telenor.taf.service;

import se.telenor.taf.util.UserType;

public class UserService {

    public static String setUpUser(UserType user){
        System.out.println("Setup User");
        return "User_ssn";
    }

    public static void clearUser(UserType userType){
        System.out.println("Clear user " + userType.name());
    }
}
