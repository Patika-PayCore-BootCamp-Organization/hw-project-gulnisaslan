package com.patikapaycore.project.repositories;

import com.patikapaycore.project.models.entities.Writer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WriterRepository extends JpaRepository<Writer,Integer> {
}
