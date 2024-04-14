package com.github.throyer.happy.domain.orphanage.controllers;

import com.github.throyer.happy.domain.orphanage.models.Orphanage;
import com.github.throyer.happy.domain.orphanage.repositories.OrphanageRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/orphanages")
@AllArgsConstructor
public class ShowOrphanageByIdController {
  private final OrphanageRepository repository;

  @GetMapping("/{orphanage_id}")
  public ResponseEntity<Orphanage> index(@PathVariable(name = "orphanage_id") String id) {
    return repository.findById(id)
      .map(ResponseEntity::ok)
      .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "orphanage '%s' not found".formatted(id)));
  }
}
