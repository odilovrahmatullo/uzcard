package uzcard.profile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import uzcard.exceptionhandler.AuthBadException;
import uzcard.profile.entity.ProfileEntity;
import uzcard.profile.repository.ProfileRepository;
import uzcard.profile.dto.AuthDTO;
import uzcard.profile.dto.AuthResponseDTO;
import uzcard.util.jwt.JwtUtil;

@Service
public class AuthService {
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthResponseDTO login(AuthDTO dto) {
        ProfileEntity profile = profileRepository.findByUsername(dto.getUsername());
        if(profile==null){
            throw new AuthBadException("username or password wrong");
        }
        if(!bCryptPasswordEncoder.matches(dto.getPassword(),profile.getPassword())){
            throw new AuthBadException("username or password wrong");
        }

        AuthResponseDTO responseDTO = new AuthResponseDTO();
        responseDTO.setName(profile.getName());
        responseDTO.setSurname(profile.getSurname());
        responseDTO.setRole(profile.getRole());
        responseDTO.setUsername(profile.getUsername());
        responseDTO.setJwt(JwtUtil.encode(profile.getUsername(),profile.getRole().name()));
        return responseDTO;
    }

}
