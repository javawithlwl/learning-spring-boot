package com.careerit.springdata.repo;

import com.careerit.springdata.domain.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PassportRepo extends JpaRepository<Passport, UUID> {
}
