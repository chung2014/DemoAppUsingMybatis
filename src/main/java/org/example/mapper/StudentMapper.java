package org.example.mapper;

import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.example.model.Student;

import java.util.List;

public interface StudentMapper {
    final String getAll = "SELECT * FROM STUDENT";
    final String getById = "SELECT * FROM STUDENT WHERE ID = #{myIdVal}";
    final String deleteById = "DELETE from STUDENT WHERE ID = #{id}";
    final String insert = "INSERT INTO STUDENT (NAME, BRANCH, PERCENTAGE, PHONE, EMAIL ) VALUES (#{name}, #{branch}, #{percentage}, #{phone}, #{email})";
    final String update = "UPDATE STUDENT SET EMAIL = #{email}, NAME = #{name}, BRANCH = #{branch}, PERCENTAGE = #{percentage}, PHONE = #{phone} WHERE ID = #{id}";

    @Select(getAll)
    @Results(value = {

    })
    List<Student> myGetAllV2();

    @Select(getById)
    Student myGetByIdV2(int id);
}
