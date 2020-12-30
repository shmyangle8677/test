package xyl.service;

import xyl.toolkit.OracleKit;

import java.sql.*;

/**
 * @author: Administrator
 * @date: 2020/11/28 13:11
 * @description:
 */
public class Dkjs {

    public static void main(String[] args) {

        System.out.println(new Dkjs().yhke4grwtdkzh("45001067720100000001300371"));
        //System.out.println(new Dkjs().getDebx_m(0.032500000,200892.22,79));
        //2828.1035026992113

    }
    /*借款人每月按相等的金额偿还贷款本息，其中每月贷款利息按月初剩余贷款本金计算并逐月付清*/
    public double getDebx_m(double nll,double je,int qs){
        double res = 0D;
        double yll = nll/12;
        res = je*yll*Math.pow((1+yll),qs)/(Math.pow((1+yll),qs)-1);
        return res;
    }

    public double yhke4grwtdkzh(String grwtdkzh){
        double res=0D;

        String sql = "select * from yh_dkzz where grwtdkzh=?";

        try {
            Connection con = OracleKit.getInstance().getConnet();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1,grwtdkzh);
            ResultSet rs = null;
            rs = pstm.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            while (rs.next()){
                res = getDebx_m(rs.getDouble("DKNLL")/100,rs.getDouble("DKYE"),rs.getInt("SYQS"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return res;
    }
}
