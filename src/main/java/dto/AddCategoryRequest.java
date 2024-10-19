package dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddCategoryRequest {

    @NotBlank
    private String name;
}
