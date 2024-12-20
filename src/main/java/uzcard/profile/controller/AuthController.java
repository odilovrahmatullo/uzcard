package uzcard.profile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uzcard.profile.dto.AuthDTO;
import uzcard.profile.dto.AuthResponseDTO;
import uzcard.profile.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody AuthDTO dto){
        return ResponseEntity.ok(authService.login(dto));
    }
}
