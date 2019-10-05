package io.ascending.training.jdbc;

import io.ascending.training.model.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDao {

    static final String DB_URL = "jdbc:postgresql://localhost:5431/dealer";
    static final String USER = "admin";
    static final String PASS = "password";
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public List<Department> getDepartments(){

        Statement stmt = null;
        ResultSet rs = null;
        List<Department> departments = new ArrayList<>();
        logger.debug("debug11111111111");
        logger.info("info");
        logger.debug("debug22222222222");

        try {
            Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql="SELECT * FROM department";
            rs = stmt.executeQuery(sql);

            while(rs.next())
            {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                //String location = rs.getString("location");

                Department department = new Department();
                department.setId(id);
                department.setName(name);
                department.setDescription(description);
                departments.add(department);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return departments;

    }

//    public Department save(Department d)
//    {
//        Connection conn = null;
//        Statement stmt = null;
//        try{
//            System.out.println("");
//            conn = DriverManager.getConnection(DB_URL,USER,PASS);
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
//    }


}
