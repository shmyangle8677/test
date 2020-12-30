package xyl.toolkit;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class OracleKit {
    private static OracleKit oracleKit = null;

    private static  String driver =null;
    private static  String url =null;
    private static  String username =null;
    private static  String password =null;

    static {
        //下面的路径寻找方法在打成jar执行的时候，会找不到路径。因为线程的问题？未解！！！
        //String path = Thread.currentThread().getContextClassLoader().getResource("").getPath()+"/applications.properties";
        Properties props = new Properties();
        try {
            //props.load(new FileInputStream(new File(path)));
            props.load(OracleKit.class.getResourceAsStream("/applications.properties"));
            driver=props.getProperty("connection.driver");
            url = props.getProperty("connection.url");
            username = props.getProperty("connection.username");
            password = props.getProperty("connection.password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

/*    static {
        driver="oracle.jdbc.OracleDriver";
        url = "jdbc:oracle:thin:@172.20.200.8:1521/orcl";
        username = "bsgjj_test";
        password = "bsgjj_test";
    }
    public OracleKit() {
    }*/

    public static OracleKit getInstance(){
        if(oracleKit == null){
            oracleKit = new OracleKit();
        }
        return oracleKit;
    }

    public Connection getConnet(){
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public void colseConnet(Connection con){
        try {
            if(con != null)
                con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
