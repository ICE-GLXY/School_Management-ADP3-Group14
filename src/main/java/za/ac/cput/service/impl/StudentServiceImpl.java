/* StudentServiceImpl.java
Author: Chante Lewis:216118395
16/06/2022
 */

package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Country;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Student;
import za.ac.cput.repository.IStudentRepository;
import za.ac.cput.service.IStudentService;
import za.ac.cput.util.Helper;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {
    private final IStudentRepository repository;

    @Autowired
    public StudentServiceImpl(IStudentRepository repository){
        this.repository = repository;
    }

    //Save operation
    @Override
    public Student save(Student student){return this.repository.save(student);}

    //Read one operation
    @Override
    public Optional<Student> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    //Delete operation
    public void delete(Student student) {this.repository.delete(student);}

    //Delete by studentId
    @Override
    public void deleteByID(String id) {
        Optional<Student> student = read(id);
        if(student.isPresent()) delete (student.get());
    }

    //Read all operation
    public List<Student> findAll() {return this.repository.findAll();}

    public List<Student> findStudentsByName_Surname(String surname) {
        return repository.findStudentsByName_Surname(surname);
    }

}

