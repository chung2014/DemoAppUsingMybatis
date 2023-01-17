package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.model.Student;

import java.io.IOException;
import java.io.Reader;

public class Mybatis_Update {

    public static void main(String[] args) throws IOException {
        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        Student st = session.selectOne("MyStudent.myGetById", 1);
        System.out.println("Current details of the student:" + st);

        st.setEmail(st.getEmail() + "1");

        var resultInt = session.update("MyStudent.myUpdate", st);
        System.out.println("resultInt:" + resultInt);
        session.commit();
        session.close();

        System.out.println("VERIFYING.....");
        session = sqlSessionFactory.openSession();
        st = session.selectOne("MyStudent.myGetById", 1);
        System.out.println("Current details of the student:" + st);
        session.commit();
        session.close();
    }
}
