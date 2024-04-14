package com.github.throyer.happy.domain.orphanage.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Image {
  private String path;

  public Image(String path) {
    this.path = path;
  }
}
