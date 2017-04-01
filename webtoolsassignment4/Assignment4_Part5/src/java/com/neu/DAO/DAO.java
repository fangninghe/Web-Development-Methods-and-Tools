/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.commons.dbutils.DbUtils;

/**
 *
 * @author Alex
 */
public class DAO {
    private String driver;
    private String dburl;
    private String dbuser;
    private String dbpassword;
    
    public DAO(){
        driver = "com.mysql.jdbc.Driver";
        dburl = "jdbc:mysql://localhost:3306/saleorder";
        dbuser = "root";
        dbpassword="asdfg";
        
        DbUtils.loadDriver(driver);
    }
    
    public Connection getConnection(){
        Connection connection =null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/saleorder", "root", "asdfg");
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
        }
        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        }
        return connection;
    }
    public void close(Connection connection){
        if(connection != null){
            try{
                DbUtils.close(connection);
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    } 
}
