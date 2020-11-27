package bstorm.akim.correctionExo3.presentation.rest_api;

import bstorm.akim.correctionExo3.business.dto.SectionDTO;
import bstorm.akim.correctionExo3.business.dto.container.SectionsContainer;
import bstorm.akim.correctionExo3.business.dto.reports.AlreadyExistsReport;
import bstorm.akim.correctionExo3.business.dto.reports.NotFoundReport;
import bstorm.akim.correctionExo3.business.service.CrudService;
import bstorm.akim.correctionExo3.exception.ElementAlreadyExistsException;
import bstorm.akim.correctionExo3.exception.ElementNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/section")
public class SectionController extends CrudController<SectionDTO, Integer>{

    public SectionController(CrudService<SectionDTO, Integer> service) {
        super(service);
    }

}
