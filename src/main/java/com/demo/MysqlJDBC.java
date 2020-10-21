package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2019-09-17
 * @time 10:56
 */
public class MysqlJDBC {

    public static void main(String[] args) throws Exception {

        Connection con = null;
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?useSSL=false", "root", "root");
        Statement stmt;
        stmt = con.createStatement();
        ResultSet res = stmt.executeQuery("select * from t_user as a   left join t_operation_log as b  on a.id=  b.user_id limit 0");

        int metaData = res.getMetaData().getColumnCount();
        List<String> columnNameList = new ArrayList<>();


        for (int i = 1; i <= metaData; i++) {
            String columnName = res.getMetaData().getColumnName(i);
            columnNameList.add(columnName);
        }

        System.out.println(columnNameList);

        List<Map<String,Object>>  listmap= new ArrayList<>();
        while (res.next()) {

            Map<String,Object> map=new HashMap<>();
            for (String columnName  : columnNameList) {

                map.put(columnName,res.getObject(columnName));
            }
            listmap.add(map);
            
        }
        System.out.println(listmap);


    }
}
