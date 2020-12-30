package xyl.home;

import xyl.toolkit.OracleKit;

import java.sql.*;

/**
 * 查数据库案例
 */
public class RedueTable {

    public static void main(String[] args) {
        searchTable();
    }

    public static void searchTable(){
        String sql = "SELECT * FROM gg_yh";
        Connection con = OracleKit.getInstance().getConnet();
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            while (rs.next()){
                String yhxm= rs.getString("YHXM");
                StringBuffer stringBuffer = new StringBuffer();
                if(yhxm.equals("王瑜")){
                    for (int i=1;i<=columnCount;i++){
                        //System.out.println(rs.getString("YHDM"));
                        if(i>1) stringBuffer.append("::");
                        stringBuffer.append(rs.getString(i));
                    }
                    System.out.println(stringBuffer.toString());
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
