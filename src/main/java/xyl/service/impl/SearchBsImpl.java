package xyl.service.impl;

import xyl.service.SearchBs;
import xyl.toolkit.OracleKit;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Administrator
 * @date: 2020/12/30 10:45
 * @description:
 */
public class SearchBsImpl implements SearchBs {
    @Override
    public List<Object> test(String par) {
        List<Object> list = new ArrayList<>();
        String sql = "SELECT * FROM gg_yh where yhdm=?";
        Connection con = OracleKit.getInstance().getConnet();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,par);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsd = rs.getMetaData();
            int i=0;
            while (rs.next()){
                List<String> list1 = new ArrayList<>();
                for (int j=1;j<rsd.getColumnCount();j++){
                    if(rs.getObject(j)==null) continue;
                    list1.add(rs.getObject(j).toString());
                }
                list.add(list1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
