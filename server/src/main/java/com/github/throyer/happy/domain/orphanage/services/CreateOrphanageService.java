package com.github.throyer.happy.domain.orphanage.services;

import com.github.throyer.happy.domain.orphanage.dtos.CreateOrphanageData;
import com.github.throyer.happy.domain.orphanage.dtos.OrphanageInfo;
import com.github.throyer.happy.domain.orphanage.models.Image;
import com.github.throyer.happy.domain.orphanage.models.Orphanage;
import com.github.throyer.happy.domain.orphanage.repositories.OrphanageRepository;
import com.github.throyer.happy.infra.envs.ImageServerProperties;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

import static com.aventrix.jnanoid.jnanoid.NanoIdUtils.randomNanoId;

@Service
@AllArgsConstructor
public class CreateOrphanageService {
  private final OrphanageRepository orphanageRepository;
  private final UploadImageService uploadService;
  private final ImageServerProperties statics;
  
  public OrphanageInfo image(CreateOrphanageData data) {
    var files = Optional.ofNullable(data.getImages()).map(List::of).orElse(List.of());
    
    var images = files.stream()
      .map(this::image)
      .toList();

    var orphanage = orphanageRepository.save(new Orphanage(data, images));
    
    return new OrphanageInfo(orphanage, statics);
  }
  
  public Image image(MultipartFile file) {
    try {
      var filename = String.format("%s-%s", randomNanoId(), file.getOriginalFilename());
      uploadService.upload(file.getBytes(), filename);
      return new Image(filename);
    } catch (Exception exception) {
      return null;
    }
  };
}
