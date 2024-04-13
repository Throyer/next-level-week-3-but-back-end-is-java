package com.github.throyer.happy.domain.orphanage.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Document("orphanages")
public class Orphanage {
  private String id;
  
  @NotBlank
  private String name;
  
  @NotNull
  private BigDecimal latitude;
  
  @NotNull
  private BigDecimal longitude;
  
  @NotBlank
  private String about;

  @NotBlank
  private String instructions;

  @NotBlank
  @Field(name = "opening_hours")
  @JsonProperty("opening_hours")
  private String openingHours;  
  
  @Field(name = "open_on_weekends")
  @JsonProperty("open_on_weekends")
  private Boolean openOnWeekends = false;
}
