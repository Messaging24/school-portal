package com.jm.project.schooljournal.repository;

import com.jm.project.schooljournal.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RoleRepository extends JpaRepository<RoleModel, Long> {
    RoleModel findByRole(String role);
}
