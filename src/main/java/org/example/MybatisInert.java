package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.model.Student;

import java.io.IOException;
import java.io.Reader;

public class MybatisInert {
    public static void main(String[] args) throws IOException {
        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        // create a new student object
//        var student = new Student("User1", "LAW", 100, 99998888, "user2@gmail.com");
        Student student = new Student("User2", "CE", 100, 90001111, "user2@gmail.com");

        // Insert student data
        var resultInt = session.insert("MyStudent.insertAStudent", student);
        System.out.println("resultInt:" + resultInt);
        System.out.println("record inserted successfully");
        session.commit();
        session.close();
    }
}
