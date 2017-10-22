package classes;
import java.sql.*;

public class FirstExample{

        public static void main(String[] args) throws Exception {

            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //创建连接
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/lesson", "root", "lus6464lus");
            //得到执行sql语句的statement对象
            Statement stmt=conn.createStatement();
            //执行sql语句，并返回结果
            ResultSet rs=stmt.executeQuery("select * from employess1");
            //处理结果
            while(rs.next()){
                System.out.println(rs.getString("id")+"\t"+rs.getString("age")+"\t"+rs.getString("first")+"\t"+rs.getString("last"));

            }
            //关闭资源
            stmt.close();
            conn.close();
            rs.close();
        }
}