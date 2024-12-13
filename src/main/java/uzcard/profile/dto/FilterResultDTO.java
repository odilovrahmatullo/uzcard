package uzcard.profile.dto;

import java.util.List;

public class FilterResultDTO<T> {
    List<T> contents;
    private Long total;

    public FilterResultDTO(List<T> contents, Long total) {
        this.contents = contents;
        this.total = total;
    }

    public List<T> getContents() {
        return contents;
    }

    public void setContents(List<T> contents) {
        this.contents = contents;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
