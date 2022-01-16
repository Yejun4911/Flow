package com.flow.backend.repository;

import com.flow.backend.domain.Fix;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FixRepository extends JpaRepository<Fix,Integer> {
}
