package org.selenium.qalegent.utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility {
    static Faker faker;
    public static String getFirstName(){
        faker=new Faker();
        String firstName=faker.name().firstName();
        return firstName;
    }
    public static String getLastName(){
        faker=new Faker();
        String lastName=faker.name().lastName();
        return lastName;
    }
    public static String getUserName(){
        faker = new Faker();
        String UserName = faker.name().username();
        return UserName;
    }
    public static String getEmailId(){
        faker = new Faker();
        String emailId =faker.name().firstName() + "gmail.com";
        return emailId;
    }
    public static String getPassword(){
        faker = new Faker();
        String password =faker.name().firstName();
        return password;
    }
    public static String getConfirmPassword(){
        faker = new Faker();
        String confirmPassword =faker.name().firstName();
        return confirmPassword;
    }
}
