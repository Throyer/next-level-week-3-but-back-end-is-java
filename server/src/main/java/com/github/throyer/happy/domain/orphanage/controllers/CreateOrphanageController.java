package com.github.throyer.happy.domain.orphanage.controllers;

import com.github.throyer.happy.domain.orphanage.models.Orphanage;
import com.github.throyer.happy.domain.orphanage.services.CreateOrphanageService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/orphanages")
@AllArgsConstructor
public class CreateOrphanageController {
  private final CreateOrphanageService service;
  
  @PostMapping
  public ResponseEntity<Orphanage> create(
    @RequestBody @Valid Orphanage data
  ) {
    return ok(service.create(data));
  }
}
