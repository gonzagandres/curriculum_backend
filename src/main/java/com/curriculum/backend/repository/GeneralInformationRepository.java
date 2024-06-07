package com.curriculum.backend.repository;

import com.curriculum.backend.models.GeneralInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneralInformationRepository extends JpaRepository<GeneralInformation, Long> {
}
