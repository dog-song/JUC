package com.domi.dameng.util;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.Arrays;

//@Configuration
@Component
@ConfigurationProperties(prefix = "spring.datasource")
public class DmUtil {
    @Value("${spring.datasource.url}")
    private  String url ;

    @Value("${spring.datasource.username}")
    private  String username ;

    @Value("${spring.datasource.password}")
    private String password ;


    @Value("${spring.datasource.drivername}")
    private  String drivername ;

    static {
        try {
            Class<?> DmDriver = Class.forName("dm.jdbc.driver.DmDriver");
            System.out.println("DmDriver = " + DmDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void runCRUD() throws Exception {
        Connection connection = DriverManager.getConnection(url, username, password);
        preparedStatement(connection);
        statement(connection);
        connection.close();
    }


    public void createDb() throws Exception {
        Connection connection = DriverManager.getConnection(url, username, password);

        String str = "create table tb_data(data1 varchar(128),data2 varchar(128));";
        PreparedStatement pstat = connection.prepareStatement(str);
        pstat.executeUpdate();
        pstat.close();
        connection.close();

    }

    private static void statement(Connection connection) throws Exception {

        Statement preparedStatement5 = connection.createStatement();

        preparedStatement5.addBatch("update  tb_data set data1='xxxxxx456' where data1='673697'");
        preparedStatement5.addBatch("update  tb_data set data1='xxxxxx789' where data1='77777'");
        //xxjsmile com.oscar.jdbc.OscarStatementV2.executeBatch()@@@@@-->com.oscar.jdbc.OscarStatement.executeUpdate()
        int[] executeBatch = preparedStatement5.executeBatch();
        System.out.println(preparedStatement5.getClass());
        System.out.println("executeBatch--->" + Arrays.toString(executeBatch));


        Statement preparedStatement6 = connection.createStatement();
        //xxjsmile com.oscar.jdbc.OscarStatement.executeQuery(String o_sql)
        preparedStatement6.executeQuery("select * from tb_data where data1='111'");
        System.out.println("111");


        Statement preparedStatement7 = connection.createStatement();
        //xxjsmile com.oscar.jdbc.OscarStatement.executeUpdate(String o_sql) -->com.oscar.jdbc.OscarStatement.executeUpdate 无参
        preparedStatement7.executeUpdate("delete from tb_data where data1='222'");
        System.out.println("2222");
        //xxjsmile com.oscar.jdbc.OscarStatement.execute(String o_sql)
        preparedStatement7.execute("select * from tb_data where data1='3333'");
        System.out.println("3333");
        preparedStatement5.close();
        preparedStatement6.close();
        preparedStatement7.close();


    }

    private static void preparedStatement(Connection connection) throws Exception {

        //com.oscar.jdbc.OscarPreparedStatementV2
        //com.oscar.jdbc.OscarStatementV2


        //t1(c1,c2,c3)
//        //query executeQuery
        String sql1 = "select count(data1) from tb_data";
        PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
        System.out.println("preparedStatement = " + preparedStatement1);
        //preparedStatement1.setString(1, "dahuang1");
        //preparedStatement1.setString(2, "123456");
        //xxjsmile  com.oscar.jdbc.OscarStatement.executeQuery()
        ResultSet resultSet = preparedStatement1.executeQuery();
        System.out.println("executeQuery： " + resultSet.next());


        //insert executeUpdate
        String sql2 = "insert into tb_data(data1,data2) values(?,?)";
        PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
        preparedStatement2.setString(1, (System.currentTimeMillis() + "").substring(6, 12));
        preparedStatement2.setString(2, (System.currentTimeMillis() + "").substring(6, 12));
        //xxjsmile com.oscar.jdbc.OscarStatement.executeUpdate()
        int result1 = preparedStatement2.executeUpdate();
        System.out.println("executeUpdate-->" + result1);

//        //delete  execute
        String sql3 = "delete from tb_data where data1=?";
        PreparedStatement preparedStatement3 = connection.prepareStatement(sql3);
        preparedStatement3.setString(1, "hehda1");

        //xxjsmile com.oscar.jdbc.OscarStatement.execute()
        boolean result2 = preparedStatement3.execute();
        System.out.println("execute--->" + result2);

//        //update executeBatch
        String sql4 = "update  tb_data set data1=? where data1=?";
        PreparedStatement preparedStatement4 = connection.prepareStatement(sql4);
        for (int i = 0; i < 5; i++) {
            preparedStatement4.setString(1, "xxxxxx-" + i);
            preparedStatement4.setString(2, "xxxxxx-" + i);
            preparedStatement4.addBatch();
        }
        //xxjsmile com.oscar.jdbc.OscarStatementV2.executeBatch()
        preparedStatement4.executeBatch();
        System.out.println(preparedStatement4.getClass());

        preparedStatement1.close();
        preparedStatement2.close();
        preparedStatement3.close();
        preparedStatement4.close();
    }

    public static void main(String[] args) throws Exception {

        new DmUtil().createDb();
        new DmUtil().runCRUD();
        //jdbc:mysql://10.0.1.25:3306/school
    }


}
