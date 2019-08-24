/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author marco.junior
 */
public class spacenet {
 
    public Connection dbConn;
    public Statement stm;
    public ResultSet rs;
    
    public Connection getConexaoini() throws Exception
    {
        
    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url = "jdbc:sqlserver://;databaseName=master";
    String login ="sa";
    String senha = "spnsw2002";
    dbConn = null;
    try{
        
    Class.forName(driver);
    dbConn = DriverManager.getConnection(url, login, senha);
        System.out.println("conexao ok");
    
}catch(Exception ex ){
    throw ex;
}
        return dbConn;
    
}
    
    
    
    public Connection getConexao(String banco)throws Exception 
    {
    
    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url = "jdbc:sqlserver://;databaseName="+banco+"";
    String login ="sa";
    String senha = "spnsw2002";
    dbConn = null;
    try{
        
    Class.forName(driver);
    dbConn = DriverManager.getConnection(url, login, senha);
        System.out.println("conexao ok");
    
}catch(Exception ex ){
    throw ex;
}
        return dbConn;
    
}
    public Connection closeConexao() throws SQLException
    {
        try{
        dbConn.close();
        }catch(SQLException ex)
        {
            System.out.println("erro"+ ex.getMessage());
        }
        return dbConn;
    }
    
}
