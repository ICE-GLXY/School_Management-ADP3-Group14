/* IStudentService.java
Author: Chante Lewis:216118395
16/06/2022
 */

package za.ac.cput.service;

import za.ac.cput.domain.Student;

import java.util.List;

public interface IStudentService extends IService<Student,String> {

    List<Student> findAll();
    void deleteByID(String id);

    List<Student> findStudentsByName_Surname(String surname);
}
