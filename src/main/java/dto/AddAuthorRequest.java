package dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddAuthorRequest {

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
}
