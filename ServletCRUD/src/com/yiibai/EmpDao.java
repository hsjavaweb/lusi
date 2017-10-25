package com.yiibai;

/**
 * Created by DELL on 2017/10/25.
 */
import java.util.*;
import java.sql.*;

public class EmpDao {
    // 表名称
    private static String tbName = "employees";

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/lesson?useSSL=false&characterEncoding=utf8", "root", "lus6464lus");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    public static int save(Emp e) {
        int status = 0;
        try {
            Connection con = EmpDao.getConnection();
            String sql = "INSERT INTO " + tbName + "(name,age,education,address,salary) values (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, e.getName());
            ps.setInt(2, e.getAge());
            ps.setString(3, e.getEducation());
            ps.setString(4, e.getAddress());
            ps.setFloat(5, e.getSalary());

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static int update(Emp e) {
        int status = 0;
        try {
            String sql = "UPDATE " + tbName + " SET name=?,age=?,education=?,address=?,salary=? where id=?";
            Connection con = EmpDao.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, e.getName());
            ps.setInt(2, e.getAge());
            ps.setString(3, e.getEducation());
            ps.setString(4, e.getAddress());
            ps.setFloat(5, e.getSalary());
            ps.setInt(6, e.getId());

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static int delete(int id) {
        int status = 0;
        try {
            String sql = "DELETE FROM " + tbName + " WHERE id=?";
            Connection con = EmpDao.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            status = ps.executeUpdate();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public static Emp getEmployeeById(int id) {
        Emp e = new Emp();

        try {
            String sql = "SELECT * FROM " + tbName + " WHERE id=?";
            Connection con = EmpDao.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e.setId(rs.getInt("id"));
                e.setName(rs.getString("name"));
                e.setAge(rs.getInt("age"));
                e.setAddress(rs.getString("address"));
                e.setEducation(rs.getString("education"));
                e.setSalary(rs.getFloat("salary"));
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return e;
    }

    public static List<Emp> getAllEmployees() {
        List<Emp> list = new ArrayList<Emp>();

        try {
            String sql = "SELECT * FROM " + tbName+" ORDER BY id DESC";
            Connection con = EmpDao.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Emp e = new Emp();
                e.setId(rs.getInt("id"));
                e.setName(rs.getString("name"));
                e.setAddress(rs.getString("address"));
                e.setAge(rs.getInt("age"));
                e.setEducation(rs.getString("education"));
                e.setSalary(rs.getFloat("salary"));
                list.add(e);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}