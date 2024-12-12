package uzcard.profile;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private ProfileCustomRepository profileCustomRepository;
   /* @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;*/

    public ProfileCreationDTO create(ProfileCreationDTO dto) {
        ProfileEntity entity = new ProfileEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        // entity.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        entity.setPassword(dto.getPassword());
        entity.setUsername(dto.getUsername());
        entity.setRole(ProfileRole.ROLE_MODERATOR);
        entity.setStatus(ProfileStatus.ACTIVE);
        entity.setCreatedDate(LocalDateTime.now());
        profileRepository.save(entity);
        return dto;
    }

    public String updateInfo(UpdateInfoDTO dto, String profileId) {
        return "UPDATED "+profileRepository.updateInfo(profileId,dto.getName(),dto.getSurname());
    }

    public String updateKeys(@Valid UpdateKeysInfo dto, String profileId) {
        return "UPDATED "+profileRepository.updateKeys(profileId,dto.getUsername(),dto.getPassword());
    }


    public FilterResultDTO<ProfileDTO> getByFilter(ProfileDTO filter,Integer page, Integer size) {
        return profileCustomRepository.filter(filter, page, size);
    }
}


