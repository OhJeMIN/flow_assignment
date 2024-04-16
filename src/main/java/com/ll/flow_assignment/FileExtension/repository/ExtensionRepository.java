package com.ll.flow_assignment.FileExtension.repository;
import com.ll.flow_assignment.FileExtension.entity.Extension;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExtensionRepository extends JpaRepository<Extension, Long> {
}
