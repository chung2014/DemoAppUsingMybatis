package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.model.Student;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class MybatisRead_SP {
    public static void main(String[] args) throws IOException {
        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        Student st = session.selectOne("MyStudent.myCallById_1", 9);

        if (st != null) {
            System.out.print("|" + st.getId());
            System.out.print("|" + st.getName());
            System.out.print("|" + st.getBranch());
            System.out.print("|" + st.getPercentage());
            System.out.print("|" + st.getEmail());
            System.out.print("|" + st.getPhone());
            System.out.println("|");
        } else {
            System.out.println("oooooohhhhh, sp result is null");
        }

        System.out.println("A record is read successfully");
        session.commit();
        session.close();
    }
}
