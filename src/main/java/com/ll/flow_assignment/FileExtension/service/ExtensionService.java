package com.ll.flow_assignment.FileExtension.service;

import com.ll.flow_assignment.FileExtension.entity.Extension;
import com.ll.flow_assignment.FileExtension.repository.ExtensionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExtensionService {

    private final ExtensionRepository extensionRepository;

    public void initData(String extension, boolean checked, boolean custom) {
        if (!exists(extension)) {
            Extension newExtension = new Extension(extension,checked,custom);
            extensionRepository.save(newExtension);
        }
    }

    public void addCustom(String extension, boolean checked) {
        if (extension.length() <= 20 && !exists(extension)) {
            Extension newExtension = new Extension(extension,checked,true);
            extensionRepository.save(newExtension);
        }
    }

    public void update(String extension, boolean checked) {
        Optional<Extension> existingExtension = extensionRepository.findByExtension(extension);
        if (existingExtension.isPresent()) {
            Extension updatedExtension = existingExtension.get();
            updatedExtension.setChecked(checked);
            extensionRepository.save(updatedExtension);
        }
    }
    public void delete(String extension) {
        Optional<Extension> existingExtension = extensionRepository.findByExtension(extension);
        if (existingExtension.isPresent()) {
            extensionRepository.delete(existingExtension.get());
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
