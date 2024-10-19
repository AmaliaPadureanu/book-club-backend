package dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddPublisherRequest {

    @NotBlank
    private String name;
}
