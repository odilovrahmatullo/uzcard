package uzcard.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(name = "company")
@RestController
public class CompanyController {
    @Autowired
    private CompanyService companyService;

}
