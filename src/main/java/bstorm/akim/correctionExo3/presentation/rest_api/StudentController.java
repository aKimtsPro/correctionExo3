package bstorm.akim.correctionExo3.presentation.rest_api;

import bstorm.akim.correctionExo3.business.dto.StudentDTO;
import bstorm.akim.correctionExo3.business.service.CrudService;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
@Profile("api")
public class StudentController extends AbstractCrudController<StudentDTO, Integer> {

    public StudentController(CrudService<StudentDTO, Integer> service) {
        super(service);
    }

}
