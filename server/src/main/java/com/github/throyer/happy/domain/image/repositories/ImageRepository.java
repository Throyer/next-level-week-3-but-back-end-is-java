package com.github.throyer.happy.domain.image.repositories;

import com.github.throyer.happy.domain.image.models.Image;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImageRepository extends MongoRepository<Image, String> { }
