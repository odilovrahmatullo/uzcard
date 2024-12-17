package uzcard.profile.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import uzcard.profile.enums.ProfileStatus;
@Getter
@Setter
public class ChangeStatusDTO {
    @NotBlank(message = "not have access without profileId")
    private String id;
    @NotNull(message = "not have access without profileStatus")
    private ProfileStatus status;
}
