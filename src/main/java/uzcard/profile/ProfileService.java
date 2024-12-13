package uzcard.profile;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import uzcard.exceptionhandler.AppBadException;
import uzcard.exceptionhandler.AuthBadException;
import uzcard.exceptionhandler.ResourceNotFoundException;
import uzcard.util.jwt.JwtUtil;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private ProfileCustomRepository profileCustomRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public ProfileCreationDTO create(ProfileCreationDTO dto) {
        ProfileEntity checkUsername = profileRepository.findByUsername(dto.getUsername());
        if(checkUsername!=null){
            throw new AppBadException("This username already exist, choose other !");
        }
        ProfileEntity entity = new ProfileEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        //entity.setPassword(dto.getPassword());
        entity.setUsername(dto.getUsername());
        entity.setRole(ProfileRole.ROLE_MODERATOR);
        entity.setStatus(ProfileStatus.ACTIVE);
        entity.setCreatedDate(LocalDateTime.now());
        profileRepository.save(entity);
        dto.setPassword(entity.getPassword());
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

    public String changeStatus(ChangeStatusDTO statusDTO) {
        return "UPDATED "+profileRepository.changeStatus(statusDTO.getId(),statusDTO.getStatus());
    }
}


