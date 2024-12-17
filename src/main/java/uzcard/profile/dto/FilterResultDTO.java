package uzcard.profile.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
@Getter
@Setter
public class FilterResultDTO<T> {
    List<T> contents;
    private Long total;

    public FilterResultDTO(List<T> contents, Long total) {
        this.contents = contents;
        this.total = total;
    }
}
