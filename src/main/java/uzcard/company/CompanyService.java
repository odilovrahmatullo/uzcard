package uzcard.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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

    public PageImpl<CompanyDTO> getByPagination(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CompanyEntity> pageList = companyRepository.getByPagination(pageable);
        List<CompanyDTO> dtoList = pageList.stream().map(this::mapperToDTO).toList();
        return new PageImpl<>(dtoList,pageable,pageList.getTotalPages());
    }

    public CompanyDTO mapperToDTO (CompanyEntity entity){
        CompanyDTO dto = new CompanyDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setContact(entity.getContact());
        dto.setAddress(entity.getAddress());
        dto.setCode(entity.getCode());
        dto.setRole(entity.getRole());
        return dto;
    }
}
