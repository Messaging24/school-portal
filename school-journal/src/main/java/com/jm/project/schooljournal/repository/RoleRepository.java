package com.jm.project.schooljournal.repository;

import com.jm.project.schooljournal.model.ERole;
import com.jm.project.schooljournal.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel, Long> {
  Optional<RoleModel> findByName(ERole name);
}
