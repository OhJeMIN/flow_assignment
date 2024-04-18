package com.ll.flow_assignment.FileExtension.service;

import com.ll.flow_assignment.FileExtension.entity.Extension;
import com.ll.flow_assignment.FileExtension.repository.ExtensionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExtensionService {

    private final ExtensionRepository extensionRepository;

    public void add(String extension, boolean Checked, boolean Custom) {
        if (extension.length() <= 20 && !exists(extension)) {
            Extension newExtension = new Extension(extension,Checked,Custom);
            extensionRepository.save(newExtension);
        }
    }

    public boolean exists(String extension) {
        return extensionRepository.findByExtension(extension).isPresent();
    }

    public List<Extension> findNotCustom(){
        return extensionRepository.findByCustom(false);
    }

    public List<Extension> findCustom() {
        return extensionRepository.findByCustom(true);
    }
}
