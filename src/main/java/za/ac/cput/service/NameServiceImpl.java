/*
TITILAYO AKINJOLE
220283982
 */
package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Name;
import za.ac.cput.repository.NameRepository;

import java.util.List;
import java.util.Optional;

@Service

public class NameServiceImpl implements INameService{

    private final NameRepository repository;

    @Autowired
    public NameServiceImpl(NameRepository repository){
        this.repository = repository;
    }


    @Override
    public Name save(Name name) {
        return this.repository.save(name);
    }

    @Override
    public Optional<Name> read(String s) {
      //  return this.repository.findById(s);
        return this.repository.read(s);
    }

    @Override
    public void delete(Name name) {
        this.repository.delete(name);
    }

    @Override
    public List<Name> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void delete(String s) {

    }

}
