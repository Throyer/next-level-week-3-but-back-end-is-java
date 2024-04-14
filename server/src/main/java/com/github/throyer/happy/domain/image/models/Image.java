package com.github.throyer.happy.domain.image.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@NoArgsConstructor
public class Image {
  private String id;
  private String path;
  
  @Field(name = "orphanage_id")
  @JsonProperty("orphanage_id")
  private String orphanageId;

  public Image(String path, String orphanageId) {
    this.path = path;
    this.orphanageId = orphanageId;
  }
}
