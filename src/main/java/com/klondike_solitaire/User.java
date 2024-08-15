package com.klondike_solitaire;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class User {

    protected static String email;
    protected static String password;
    protected static int user_id;
    static User current_user;

    // DS
    // -----------------------------------------------------------------------------
    protected static HashMap<String, String> users;
    // -----------------------------------------------------------------------------

    // call this constructor if a new user sign up to ask store_name
    public User(String email, String password, int user_id) {
        User.email = email;
        User.password = password;
        User.user_id = user_id;
    }

    // return current active user's email
    protected static String getEmail(){
        return email;
    }

    // return current active user's password
    protected static String getPassword(){
        return password;
    }

    // return current active user_id
    protected static int getUserId(){
        return user_id;
    }

    protected static int fetchUserId(){

        String query = "SELECT user_id FROM users WHERE user_email = ?";

        try{
            // retrieving user_id of current active_user
            Database.prepareStatement(query);
            // returns email from TextField directly
            Database.pst.setString(1, Login.getEmail());

            ResultSet rs = Database.pst.executeQuery();

            while (rs.next()){
                user_id = rs.getInt("user_id");
            }

            return user_id;

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return -1;
    }

    // prepare list of total registered users
    static protected void getUsers(){

        String query = "SELECT user_email, user_password FROM users";

        try{
            // Storing the user's data into HashMap
            Database.prepareStatement(query);

            users = new HashMap<>();

            ResultSet rs = Database.pst.executeQuery();

            while(rs.next()){

                String email = rs.getString("user_email");
                String password = rs.getString("user_password");

                users.put(email, password);
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}