package com.bookclub.book_club.controller;

import com.bookclub.book_club.exceptions.EntityAlreadyExistsException;
import com.bookclub.book_club.model.Publisher;
import com.bookclub.book_club.service.IPublisherService;
import dto.AddPublisherRequest;
import dto.ApiResponse;
import dto.PublisherDto;
import dto.PublisherDtoSimplified;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.CONFLICT;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.prefix}/publishers")
public class PublisherController {

    private final IPublisherService publisherService;
    private final ModelMapper modelMapper;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllPublishers() {
        List<PublisherDto> publisherDtos = new ArrayList<>();
        publisherService.getAllPublishers().forEach(publisher -> {
            PublisherDto publisherDto = modelMapper.map(publisher, PublisherDto.class);
            publisherDtos.add(publisherDto);

        });
        return ResponseEntity.ok(new ApiResponse("Success!", publisherDtos));
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addPublisher(@RequestBody AddPublisherRequest addPublisherRequest) {
        try {
            Publisher publisher = publisherService.addPublisher(addPublisherRequest);
            PublisherDtoSimplified publisherDtoSimplified = modelMapper.map(publisher, PublisherDtoSimplified.class);
            return ResponseEntity.ok(new ApiResponse("Publisher was added!", publisherDtoSimplified));
        } catch (EntityAlreadyExistsException e) {
            return ResponseEntity.status(CONFLICT).body(new ApiResponse(e.getMessage(), null));
        }
    }
}
