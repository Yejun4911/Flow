package com.flow.backend.repository;

import com.flow.backend.domain.Variable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VariableRepository extends JpaRepository<Variable,Integer> {
    boolean existsByName(String name);
}
