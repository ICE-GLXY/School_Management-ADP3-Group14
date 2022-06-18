/*
TITILAYO AKINJOLE
220283982
 */
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Name;

import java.util.List;

public interface INameRepository extends JpaRepository<Name,String> {
    List<Name> findAll();
}