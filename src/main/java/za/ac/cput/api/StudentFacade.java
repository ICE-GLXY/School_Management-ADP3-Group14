package za.ac.cput.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.cput.service.IStudentAddressService;
import za.ac.cput.service.IStudentService;



@Component
public class StudentFacade {
    private IStudentAddressService iStudentAddressService;
    private IStudentService iStudentService;

    @Autowired
    public StudentFacade(IStudentAddressService iStudentAddressService, IStudentService iStudentService) {
        this.iStudentAddressService = iStudentAddressService;
        this.iStudentService = iStudentService;
    }
}
