package uzcard.profile.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import uzcard.profile.enums.ProfileStatus;

public class ChangeStatusDTO {
    @NotBlank(message = "not have access without profileId")
    private String id;
    @NotNull(message = "not have access without profileStatus")
    private ProfileStatus status;

    public String getId() {
        return id;
    }

    public void setId() {
        this.id = id;
    }

    public ProfileStatus getStatus() {
        return status;
    }

    public void setStatus(ProfileStatus status) {
        this.status = status;
    }
}
