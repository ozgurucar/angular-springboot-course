package com.ozgurucar.jpa.repositories;

import com.ozgurucar.jpa.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Integer> {
}
