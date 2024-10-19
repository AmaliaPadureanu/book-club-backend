package dto;

import com.bookclub.book_club.model.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
public class BookDto {

    private Long id;
    private CategoryDtoSimplified category;
    private List<AuthorDtoSimplified> authors;
    private String title;
    private int numberOfPages;
    private String description;
    private PublisherDtoSimplified publisher;
    private List<Review> reviews;
    private BigDecimal price;
    private int inventory;
    private AvailabilityStatus availabilityStatus;
    private Double rating;
    private Language language;
    private LocalDate publicationDate;
}
