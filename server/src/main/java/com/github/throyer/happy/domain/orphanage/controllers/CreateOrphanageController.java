package com.github.throyer.happy.domain.orphanage.controllers;

import com.github.throyer.happy.domain.orphanage.dtos.CreateOrphanageData;
import com.github.throyer.happy.domain.orphanage.dtos.OrphanageInfo;
import com.github.throyer.happy.domain.orphanage.models.Orphanage;
import com.github.throyer.happy.domain.orphanage.services.CreateOrphanageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static java.util.Optional.ofNullable;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;
import static org.springframework.http.ResponseEntity.ok;

@Controller
@RequestMapping("/orphanages")
@AllArgsConstructor
public class CreateOrphanageController {
  private final CreateOrphanageService service;
  
  @ResponseStatus(CREATED)
  @PostMapping(consumes = MULTIPART_FORM_DATA_VALUE)
  public ResponseEntity<OrphanageInfo> create(@ModelAttribute @Validated CreateOrphanageData data) {
    return ok(service.create(data));
  }
}
