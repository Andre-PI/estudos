package com.dbconnection;
import java.sql.*;
 

public class ConnectDB {
    private String url = "jdbc:postgresql://localhost:5432/usersdb";
    private String user = "postgres";
    private String password = "cagliosturo";

    static{
        try {
        Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        System.out.println("error");
        }
    }
    public void createUser(String username, String password, String email){
        if(checkUser(username)){
            return;
        }
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement pStatement = con.prepareStatement("insert into users(username,password, email) values(?,?,?);");
            pStatement.setString(1, username);
            pStatement.setString(2, password);
            pStatement.setString(3, email);
            pStatement.executeUpdate();
            pStatement.close();
            con.close();
            System.out.println("created");
        } catch (Exception e) {
            System.out.println("err" + e);
        }
    }

    private boolean checkUser(String username){
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement statement = con.prepareStatement("SELECT * FROM users where username=?");
            statement.setString(1, username );
            ResultSet rs = statement.executeQuery();
            return rs.next();

        } catch (Exception e) {
            
        }
        return false;
    }
    
    public boolean confirmPassword(String username, String password){
        if(checkUser(username)){
            try {
                Connection connection = DriverManager.getConnection(url,user,password);
                PreparedStatement pstm = connection.prepareStatement("SELECT * FROM users where username=? and password=?;");
                pstm.setString(1, username);
                pstm.setString(2, password);
                ResultSet rs = pstm.executeQuery();
                if (rs.next()) {
                    return true;
                }
                
                connection.close();
                pstm.close();
            } catch (Exception e) {
                
            }
        }
        return false;
    }

    public String returnData(String username){
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            PreparedStatement pstm = connection.prepareStatement("SELECT * FROM users where username=?;");
            pstm.setString(1, username);
           
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                return rs.getString(2) + ";" + rs.getString(4);
            }
            pstm.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        
    }
 
    
}
