package io.ascending.training.jdbc;

import io.ascending.training.model.Department;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class DepartmentDaoTest {
    private DepartmentDao departmentDao;

    @Test
    public void getDepartmentsTest()
    {
        List<Department> departments = departmentDao.getDepartments();
        int expectedNumOfDept = 4;
        Assert.assertEquals(expectedNumOfDept,departments.size());


    }


    @Before
    public void setUp()
    {
        departmentDao = new DepartmentDao();
        Department testRecord = new Department();
        testRecord.setName("asscending");
        testRecord.setDescription("offline bootcamp");
        //departmentDao.save(testRecord);


    }

    @After
    public void tearDown()
    {
        //departmentDao.delete
    }
}
