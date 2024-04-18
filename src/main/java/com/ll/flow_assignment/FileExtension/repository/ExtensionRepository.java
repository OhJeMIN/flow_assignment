package com.ll.flow_assignment.FileExtension.repository;
import com.ll.flow_assignment.FileExtension.entity.Extension;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExtensionRepository extends JpaRepository<Extension, Long> {
    Optional<Extension> findByExtension(String extension);
    List<Extension> findByCustom(boolean custom);
}
