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



}
