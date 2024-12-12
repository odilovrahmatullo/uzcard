package uzcard.profile;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody ProfileCreationDTO dto){
        return ResponseEntity.ok(profileService.create(dto));
    }

    @PutMapping("/update-info/{profileId}")
    public ResponseEntity<?> update(@Valid @RequestBody UpdateInfoDTO dto,
                                    @PathVariable String profileId){
        return ResponseEntity.ok(profileService.updateInfo(dto,profileId));
    }

    @PutMapping("/update-keys/{profileId}")
    public ResponseEntity<?> update(@Valid @RequestBody UpdateKeysInfo dto,
                                    @PathVariable String profileId){
        return ResponseEntity.ok(profileService.updateKeys(dto,profileId));
    }

    @GetMapping("/filter")
    public ResponseEntity<?> getByFilter(@RequestBody ProfileDTO filter,
                                         @RequestParam Integer page,
                                         @RequestParam Integer size){
        page = Math.max(page-1,0);
        return ResponseEntity.ok(profileService.getByFilter(filter,page,size));
    }

    @PutMapping("/change-status")
    public ResponseEntity<?> changeStatus(@Valid @RequestBody ChangeStatusDTO statusDTO){
        return ResponseEntity.ok(profileService.changeStatus(statusDTO));
    }





}
