package com.larkin.spider;/**
 * @program: encyclopaedia_java
 * @description: 解析html提取外链（非洲新闻网）
 * @author: Larkin
 * @create: 2022-06-07 14:32
 **/

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.logging.log4j.util.Strings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

/**
 * @description: 解析html提取外链（非洲新闻网）
 * @version 1.0
 * @author Larkin
 * @date 2022/6/7 14:32 
 */
@Slf4j
public class ExplainHtml {
    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        String mysql_url = "jdbc:mysql://10.10.63.214:3306/spiderflow?useSSL=false&useUnicode=true&characterEncoding=UTF8&autoReconnect=true";
        String username = "root";
        String password = "Larkin123-";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //连接数据库
            connection = DriverManager.getConnection(mysql_url, username, password);
            //向数据库发送SQL的Statement
            statement = connection.createStatement();
            //编写sql
            String sql = "select * from sabc_shortv2";
            //执行sql，返回结果集
            resultSet = statement.executeQuery(sql);
            List<String> urls = new ArrayList<>();
            while (resultSet.next()) {
                String title = resultSet.getString("title").trim();
                String source = resultSet.getString("source");
                if (!Strings.isBlank(source)){
                    source = source.replaceAll("&quot","");
                    String mp4Link = getMP4Link(source);
                    if (!mp4Link.equals("ERROR"))
                    {urls.add(mp4Link);}
                }
                System.out.println(title);
            }
            //urls.forEach(System.out::println);
            System.out.println("for test:"+urls.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String getMP4Link(String source){
        int i = source.indexOf(".mp4");
        int leftCurve = i;
        while(leftCurve > 4){
            String substring = source.substring(leftCurve - 4, leftCurve);
            if (substring.equals("http")){
                String http = StringEscapeUtils.unescapeJava(source.substring(leftCurve - 4, i+4));
                System.out.println(http);
                return http;
            }
            leftCurve=leftCurve-1;
        }
        return "ERROR";
    }

}
