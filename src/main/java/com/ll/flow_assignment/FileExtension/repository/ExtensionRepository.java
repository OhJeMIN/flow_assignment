package com.ll.flow_assignment.FileExtension.repository;
import com.ll.flow_assignment.FileExtension.entity.Extension;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExtensionRepository extends JpaRepository<Extension, Long> {
    Optional<Object> findByExtension(String extension);
}
