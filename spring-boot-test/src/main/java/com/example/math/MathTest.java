package com.example.math;

import com.example.springboottest.Student;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;
import java.math.BigDecimal;

/**
 * @author yingru.ljw
 * @date 2019-08-27 10:30
 */
public class MathTest {

    public static void main(String[] args) throws IllegalAccessException {

        m();
    }


    private static  void testThrow(){
        throw new RuntimeException("test");
    }


    public static void m() throws IllegalAccessException {
        Student student = new Student();
        student.setB("c");

        Field[]fields = FieldUtils.getAllFields(Student.class);
        for(Field field : fields){
            String obj = (String) field.get(student);
            System.out.println(obj);

        }

    }
}
