package uzcard.profile.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uzcard.profile.dto.*;
import uzcard.profile.service.ProfileService;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> create(@Valid @RequestBody ProfileCreationDTO dto) {
        return ResponseEntity.ok(profileService.create(dto));
    }

    @PutMapping("/update-info/{profileId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> update(@Valid @RequestBody UpdateInfoDTO dto,
                                    @PathVariable String profileId) {
        return ResponseEntity.ok(profileService.updateInfo(dto, profileId));
    }

    @PutMapping("/update-keys/{profileId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> update(@Valid @RequestBody UpdateKeysInfo dto,
                                    @PathVariable String profileId) {
        return ResponseEntity.ok(profileService.updateKeys(dto, profileId));
    }

    @GetMapping("/filter")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getByFilter(@RequestBody ProfileDTO filter,
                                         @RequestParam Integer page,
                                         @RequestParam Integer size) {
        page = Math.max(page - 1, 0);
        return ResponseEntity.ok(profileService.getByFilter(filter, page, size));
    }

    @PutMapping("/change-status")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> changeStatus(@Valid @RequestBody ChangeStatusDTO statusDTO) {
        return ResponseEntity.ok(profileService.changeStatus(statusDTO));
    }


}
