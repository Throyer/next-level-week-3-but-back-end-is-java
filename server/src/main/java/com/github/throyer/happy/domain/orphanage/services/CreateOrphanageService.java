package com.github.throyer.happy.domain.orphanage.services;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import com.github.throyer.happy.domain.image.models.Image;
import com.github.throyer.happy.domain.image.repositories.ImageRepository;
import com.github.throyer.happy.domain.image.services.UploadImageService;
import com.github.throyer.happy.domain.orphanage.dtos.CreateOrphanageData;
import com.github.throyer.happy.domain.orphanage.dtos.OrphanageInfo;
import com.github.throyer.happy.domain.orphanage.models.Orphanage;
import com.github.throyer.happy.domain.orphanage.repositories.OrphanageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static com.aventrix.jnanoid.jnanoid.NanoIdUtils.randomNanoId;

@Service
@AllArgsConstructor
public class CreateOrphanageService {
  private final ImageRepository imageRepository;
  private final OrphanageRepository orphanageRepository;
  private final UploadImageService uploadService;
  
  public OrphanageInfo create(CreateOrphanageData data) {
    var orphanage = orphanageRepository.save(new Orphanage(data));
    
    var files = Optional.ofNullable(data.getImages()).map(List::of).orElse(List.of());
    
    var images = files.stream()
      .map(file -> create(file, orphanage.getId()))
      .toList();
    
    return new OrphanageInfo(orphanage, images);
  }
  
  public Image create(MultipartFile file, String orphanageId) {
    try {
      var filename = String.format("%s-%s", randomNanoId(), file.getOriginalFilename());
      uploadService.upload(file.getBytes(), filename);
      var image = new Image(filename, orphanageId);
      return imageRepository.save(image);
    } catch (Exception exception) {
      return null;
    }
  };
}
