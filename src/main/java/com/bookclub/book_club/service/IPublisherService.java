package com.bookclub.book_club.service;

import com.bookclub.book_club.model.Publisher;
import dto.AddPublisherRequest;

import java.util.List;

public interface IPublisherService {

    Publisher addPublisher(AddPublisherRequest addPublisherRequest);
    List<Publisher> getAllPublishers();

}
