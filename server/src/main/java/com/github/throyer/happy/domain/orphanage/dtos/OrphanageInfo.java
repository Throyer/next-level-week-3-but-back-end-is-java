package com.github.throyer.happy.domain.orphanage.dtos;

import com.github.throyer.happy.domain.image.models.Image;
import com.github.throyer.happy.domain.orphanage.models.Orphanage;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

@Getter
public class OrphanageInfo {
  private final String id;
  private final String name;
  private final BigDecimal latitude;
  private final BigDecimal longitude;
  private final String about;
  private final String instructions;
  private final String opening_hours;
  private final Boolean open_on_weekends;
  private final List<String> images;

  public OrphanageInfo(Orphanage orphanage, List<Image> images) {
    this.id = orphanage.getId();
    this.name = orphanage.getName();
    this.latitude = orphanage.getLatitude();
    this.longitude = orphanage.getLongitude();
    this.about = orphanage.getAbout();
    this.instructions = orphanage.getInstructions();
    this.opening_hours = orphanage.getOpeningHours();
    this.open_on_weekends = orphanage.getOpenOnWeekends();
    this.images = images.stream().map(Image::getPath).toList();
  }
}
