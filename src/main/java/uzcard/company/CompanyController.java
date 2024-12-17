package uzcard.company;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @PostMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CompanyCreationDTO>create(@RequestBody CompanyCreationDTO dto){
        return ResponseEntity.ok(companyService.create(dto));
    }

    @PutMapping("/info")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> updateInfo(@RequestBody UpdateInfoDTO dto,
                                                    @RequestParam String id ){
        return ResponseEntity.ok(companyService.updateInfos(dto,id));
    }

    @PutMapping("/keys")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> updateKeys(@RequestBody UpdateKeysDTO dto,
                                             @RequestParam String id ){
        return ResponseEntity.ok(companyService.updateKeys(dto,id));
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getByPagination(@RequestParam Integer page,
                                             @RequestParam Integer size){
        page = Math.max(page-1,0);
        return ResponseEntity.ok(companyService.getByPagination(page,size));
    }

    @PutMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable String id){
        return ResponseEntity.ok(companyService.delete(id));
    }

}


