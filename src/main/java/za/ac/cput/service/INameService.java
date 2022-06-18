/*
TITILAYO AKINJOLE
220283982
 */
package za.ac.cput.service;

import za.ac.cput.domain.Name;

import java.util.List;
import java.util.Optional;

public interface INameService extends IService<Name, String> {
    Name save(Name name);

    Optional<Name> read(String s);

    void delete(Name name);

    List<Name> findAll();

    void delete(String s);
}
