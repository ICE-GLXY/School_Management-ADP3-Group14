/* StudentAddressServiceImpl.java
Author: Chante Lewis:216118395
16/06/2022
 */

package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Student;
import za.ac.cput.domain.StudentAddress;
import za.ac.cput.repository.IStudentAddressRepository;
import za.ac.cput.service.IStudentAddressService;
import java.util.List;
import java.util.Optional;

@Service
public class StudentAddressServiceImpl implements IStudentAddressService {
    private final IStudentAddressRepository repository;

    @Autowired
    public StudentAddressServiceImpl(IStudentAddressRepository repository){
        this.repository = repository;
    }

    //Save operation
    @Override
    public StudentAddress save(StudentAddress studentAddress){return this.repository.save(studentAddress);}

    //Read one operation
    @Override
    public Optional<StudentAddress> read(String id) {
        return this.repository.findById(id);
    }

    //Delete operation
    @Override
    public void delete(StudentAddress studentAddress) {this.repository.delete(studentAddress);}

    //Delete by studentAddress id
    @Override
    public void deleteByID(String id) {
        Optional<StudentAddress> studentAddress = read(id);
        if(studentAddress.isPresent()) delete (studentAddress.get());
    }

    //Read all operation
    public List<StudentAddress> findAll() {return this.repository.findAll();}

    public List<StudentAddress> findByAddressCityCountryName(String name) {
        return repository.findByAddressCityCountryName(name);
    }
}
