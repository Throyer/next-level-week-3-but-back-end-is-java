package com.github.throyer.happy.domain.orphanage.controllers;

import com.github.throyer.happy.domain.orphanage.models.Orphanage;
import com.github.throyer.happy.domain.orphanage.repositories.OrphanageRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orphanages")
@AllArgsConstructor
public class ListAllOrphanagesController {
  private final OrphanageRepository repository;
  
  @GetMapping
  public List<Orphanage> index() {
    return repository.findAll();
  }
}
