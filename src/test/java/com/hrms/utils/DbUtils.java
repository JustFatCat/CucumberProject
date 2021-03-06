package com.hrms.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DbUtils {
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    public static Connection getConnection(){
        try {
            connection = DriverManager.getConnection(
                    ConfigsReader.getPropertyValue("dbUrl"),
                    ConfigsReader.getPropertyValue("dbUsername"),
                    ConfigsReader.getPropertyValue("dbPassword"));
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return connection;
    }

    public static ResultSet getResultSet(String query){
        try {
            statement = getConnection().createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return resultSet;
    }

    public static List<Map<String,String>> getDbDataIntoListOfMaps(String query){
        List<Map<String,String>> dbList = new ArrayList<>();
        Map<String,String> map;
        try {
            ResultSetMetaData resultSetMetaData = getResultSet(query).getMetaData();
            while (resultSet.next()){// loops through all rows
                map = new LinkedHashMap<>();

                for (int c = 1; c <= resultSetMetaData.getColumnCount(); c++) {// loops through each column of the row
                    map.put(resultSetMetaData.getColumnName(c), resultSet.getString(c));
                }
                dbList.add(map);
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally{
            closeConnection();
        }
        return dbList;
    }

    public static List<String> getDbDataIntoListOfStrings(String query){
        List<String> dbStringList = new ArrayList<>();
        try {
            ResultSetMetaData resultSetMetaData = getResultSet(query).getMetaData();
            while (resultSet.next()){
                for (int c = 1; c <= resultSetMetaData.getColumnCount(); c++) {
                    dbStringList.add(resultSet.getString(c));
                }
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally{
            closeConnection();
        }
        return dbStringList;
    }

    public static void closeConnection(){
        try{
            if(resultSet!=null){
                resultSet.close();
            }
            if(statement!=null){
                statement.close();
            }
            if (connection!=null){
                connection.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }


}
