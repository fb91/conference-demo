package com.fabri.conferencedemo.repositories;

import com.fabri.conferencedemo.models.Speakers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakersRepository extends JpaRepository<Speakers, Long> {
}
