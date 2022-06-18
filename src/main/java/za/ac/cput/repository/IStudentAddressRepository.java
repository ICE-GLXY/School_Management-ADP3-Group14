/* IStudentAddressRepository.java
Author: Chante Lewis:216118395
15/06/2022
 */
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.StudentAddress;

import java.util.List;

@Repository
public interface IStudentAddressRepository extends JpaRepository<StudentAddress,String> {
    List <StudentAddress> findByAddressCityCountryName (String name);
}


