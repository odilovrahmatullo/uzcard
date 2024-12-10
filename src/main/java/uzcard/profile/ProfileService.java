package uzcard.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public ProfileCreationDTO create(ProfileCreationDTO dto) {
        ProfileEntity entity = new ProfileEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        entity.setUsername(dto.getUsername());
        profileRepository.save(entity);
        return dto;
    }

}
