package bstorm.akim.correctionExo3.presentation.rest_api;

import bstorm.akim.correctionExo3.business.dto.SectionDTO;
import bstorm.akim.correctionExo3.business.service.CrudService;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/section")
@Profile("api")
public class SectionController extends AbstractCrudController<SectionDTO, Integer> {

    public SectionController(CrudService<SectionDTO, Integer> service) {
        super(service);
    }

}
