package mx.utng.CFGA.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.CFGA.model.entity.Student;

@Repository
public class StudentDaoImpl implements IStudentDao{

    //Entity Manager y contexto de persistencia
    //Guarda internamente todas las entidads y
    //utiliza como una cache datos de BD
    //@PersistenceContext
    @Autowired
    private EntityManager em;


    @SuppressWarnings("unchecked")
    @Override
    public List<Student> list() {
        return em.createQuery("from Student").getResultList();
    }

    @Override
    public void save(Student student) {
        System.out.println("Student id="+student.getId());
        if(student.getId() != null && student.getId() >0){
            //Actualizo estudiante
            em.merge(student);
        }else{
            //Creamos nuevo estudiante en la base
            em.persist(student);
        }
    }

    @Override
    public Student getById(Long id) {
        return em.find(Student.class, id);
    }

    @Override
    public void delete(Long id) {
        Student student = getById(id);
        em.remove(student);
    }

    
}