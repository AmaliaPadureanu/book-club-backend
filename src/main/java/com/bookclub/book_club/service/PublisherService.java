package com.bookclub.book_club.service;

import com.bookclub.book_club.exceptions.EntityAlreadyExistsException;
import com.bookclub.book_club.model.Publisher;
import com.bookclub.book_club.repository.PublisherRepository;
import dto.AddPublisherRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PublisherService  implements IPublisherService {

    private final PublisherRepository publisherRepository;

    @Override
    public Publisher addPublisher(AddPublisherRequest addPublisherRequest) {
        Optional<Publisher> publisher = publisherRepository.findByName(addPublisherRequest.getName());
        if (publisher.isPresent()) {
            throw new EntityAlreadyExistsException("Publisher already exists!");
        }

        Publisher newPublisher = new Publisher(addPublisherRequest.getName());
        return publisherRepository.save(newPublisher);
    }

    @Override
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }
}
