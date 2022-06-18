/* IStudentRepository.java
Author: Chante Lewis:216118395
15/06/2022
 */
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Country;
import za.ac.cput.domain.Student;

import java.util.List;

@Repository
public interface IStudentRepository extends JpaRepository<Student,String> {
 List<Student> findStudentsByName_Surname(String surname);
}

