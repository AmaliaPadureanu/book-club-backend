package dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
public class PublisherDto {

    private Long id;
    private String name;
    private List<BookDto> books = new ArrayList<>();
}
