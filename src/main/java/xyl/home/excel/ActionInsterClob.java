package xyl.home.excel;

import xyl.toolkit.OracleKit;

import java.io.File;
import java.sql.*;
import java.util.List;

/**
 * @author: Administrator
 * @date: 2020/12/15 22:35
 * @description:clob数据写入表
 */
public class ActionInsterClob {
    public static void main(String[] args) {
        new ActionInsterClob().action();
    }

    public void action(){
        File file = new File("C:\\Users\\Administrator\\Desktop\\知识库-业务知识问答\\imp-维权.xls");
        ReadExcel obj = new ReadExcel();
        List excelList = obj.readExcel(file);
        Connection con = OracleKit.getInstance().getConnet();
        String sql="insert into RB_ZXKBT (ID, BIAOTI, DAAN, QYZT, CZY, JBJGBH, TKLX, CZSJ, GXDJ) "+
                "values (?, ?, ?, 'qy', 'sa', '01000001', '99', ?, ?)";
        try {
            int base_nm = getId()+1;
            for (int i=0;i<excelList.size();i++){
                PreparedStatement pstm = con.prepareStatement(sql);
                List list = (List)excelList.get(i);
                pstm.setString(1,""+ (base_nm+i));
                pstm.setString(2,(String) list.get(0));
                pstm.setString(3,(String) list.get(1));
                pstm.setDate(4,new Date(new java.util.Date().getTime()));
                pstm.setDate(5,new Date(new java.util.Date().getTime()));
                pstm.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public int getId(){
        int nm=0;
        Connection con = OracleKit.getInstance().getConnet();
        String sql = "SELECT max(to_number(id)) ROWNM FROM rb_zxkbt";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                nm=rs.getInt("ROWNM");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return nm;
    }
}
