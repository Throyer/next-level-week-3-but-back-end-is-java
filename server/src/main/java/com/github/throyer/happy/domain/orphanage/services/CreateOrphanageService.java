package com.github.throyer.happy.domain.orphanage.services;

import com.github.throyer.happy.domain.orphanage.models.Orphanage;
import com.github.throyer.happy.domain.orphanage.repositories.OrphanageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateOrphanageService {
  private final OrphanageRepository repository;
  
  public Orphanage create(Orphanage orphanage) {
    return repository.save(orphanage);
  }
}
