package mx.utng.CFGA.model.dao;

import java.util.List;

import mx.utng.CFGA.model.entity.Student;

public interface IStudentDao {
    List<Student> list();
    void save(Student student);
    Student getById(Long id);
    void delete(Long id);
}
