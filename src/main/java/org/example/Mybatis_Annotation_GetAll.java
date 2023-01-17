package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mapper.StudentMapper;
import org.example.model.Student;

import java.io.IOException;
import java.io.Reader;

public class Mybatis_Annotation_GetAll {
    public static void main(String[] args) throws IOException {
        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();
        session.getConfiguration().addMapper(StudentMapper.class);
        StudentMapper mapper = session.getMapper(StudentMapper.class);

        var list = mapper.myGetAllV2();
        System.out.println(list);
        session.commit();
        session.close();
    }
}
