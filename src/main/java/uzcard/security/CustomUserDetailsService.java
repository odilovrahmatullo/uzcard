package uzcard.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uzcard.exceptionhandler.ResourceNotFoundException;
import uzcard.profile.entity.ProfileEntity;
import uzcard.profile.repository.ProfileRepository;
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private ProfileRepository profileRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ProfileEntity entity = profileRepository.findByUsername(username);
        if (entity == null) {
            throw new ResourceNotFoundException("User not found ");
        }
        return new CustomUserDetails(entity);
    }
}
