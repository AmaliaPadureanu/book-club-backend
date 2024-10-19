package dto;

import com.bookclub.book_club.model.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
public class AddBookRequest {

    @NotBlank
    private Category category;
    @NotEmpty
    private List<Author> authors;
    @NotBlank
    private String title;
    @Positive(message = "Number of pages must be a positive number") @Min(1)
    private int numberOfPages;
    private String description;
    @NotBlank
    private Publisher publisher;
    @Positive(message = "Price must be a positive number")
    private BigDecimal price;
    @Positive(message = "Inventory number must be positive")
    private int inventory;
    @NotBlank
    private AvailabilityStatus availabilityStatus;
    @NotBlank
    private Language language;
    @NotNull(message = "Publication date is required")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate publicationDate;
}
