package mysqlconfig;

import dataobjects.AdressTable;
import mysqlconfig.enums.ADRESSFIELDS;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StatemenT {
    private Statement statement;
    public StatemenT() {
        try {
            makeStatemenT();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Statement makeStatemenT() throws SQLException {
        Connectt c = null;
        c = new Connectt();
        Connection conn = c.makeConnection();
        statement = conn.createStatement();
        return statement;
    }
    public AdressTable selectByFieldName(ADRESSFIELDS adressfields, String data) throws SQLException {
        String select = "SELECT * FROM sys.adress where "+adressfields+"='"+data+"'";
        ResultSet resultSet = null;
        resultSet = statement.executeQuery(select);
        resultSet.next();
        System.out.println(resultSet.getString("name"));
        return new AdressTable(resultSet);
    }

    public List <AdressTable> selectListTableDuplicateEmail() throws SQLException {
        String select =
                "SELECT * FROM sys.adress WHERE email IN (SELECT email FROM sys.adress GROUP BY email HAVING COUNT(*) > 1) ORDER BY email";
        ResultSet resultSet = null;
        resultSet = statement.executeQuery(select);
        List<AdressTable> adressTableList=new ArrayList<>();
        while (resultSet.next()){
            adressTableList.add(new AdressTable(resultSet));
        }
        return adressTableList;
    }

    public  List<AdressTable> selectUniqueName() throws SQLException {
        String select = "SELECT  DISTINCT name FROM sys.adress LIMIT 0,100;";
        ResultSet resultSet = null;
        resultSet = statement.executeQuery(select);
        List<AdressTable> adressTableList=new ArrayList<>();
        while (resultSet.next()){
            adressTableList.add(new AdressTable(resultSet));
        }
        return adressTableList;
    }

}
