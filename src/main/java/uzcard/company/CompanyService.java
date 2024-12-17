package uzcard.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public CompanyCreationDTO create(CompanyCreationDTO dto) {
        CompanyEntity entity = new CompanyEntity();
        entity.setName(dto.getName());
        entity.setUsername(dto.getUsername());
        entity.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        entity.setContact(dto.getContact());
        entity.setRole(dto.getRole());
        entity.setAddress(dto.getAddress());
        entity.setCreatedDate(LocalDateTime.now());
        entity.setVisible(Boolean.TRUE);
        if(dto.getCode()!=null){
            entity.setCode(dto.getCode());
        }
        companyRepository.save(entity);
        return dto;
    }


    public String updateInfos(UpdateInfoDTO dto, String id) {
        return "UPDATED "+companyRepository.updateInfos(id,dto.getCode(),dto.getContact(),dto.getName(),dto.getAddress(),
        dto.getRole());
    }

    public String updateKeys(UpdateKeysDTO dto, String id) {
        return "UPDATED "+companyRepository.updateKeys(id,bCryptPasswordEncoder.encode(dto.getPassword()),dto.getUsername());
    }
}
