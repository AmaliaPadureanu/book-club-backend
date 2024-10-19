package dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AuthorDto {

    private Long id;
    private String firstName;
    private String lastName;
    private List<BookDto> books = new ArrayList<>();
}
