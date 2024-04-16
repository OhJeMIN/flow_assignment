package com.ll.flow_assignment.FileExtension.service;

import com.ll.flow_assignment.FileExtension.entity.Extension;
import com.ll.flow_assignment.FileExtension.repository.ExtensionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class ExtensionService {
    private ExtensionRepository extensionRepository;

    public void add(String extension, boolean isChecked, boolean isCustom) {
        if (extension.length() <= 20) {
            Extension newExtension = new Extension(extension, isChecked, isCustom);
            extensionRepository.save(newExtension);
        }
    }
}
