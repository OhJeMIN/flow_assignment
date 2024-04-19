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

    public boolean addCustom(String extension, boolean checked) {
        if (extension.length() > 20) {
            throw new IllegalArgumentException("확장자 길이가 20자리 이상입니다.");
        }
        // 확장자가 영문자만 포함되어 있는지 검증
        if (!extension.matches("^[a-zA-Z]+$")) {
            throw new IllegalArgumentException("확장자는 영문자만 포함할 수 있습니다.");
        }

        if (exists(extension)) {
            return true;
        }
        Extension newExtension = new Extension(extension, checked, true);
        extensionRepository.save(newExtension);
        return false;
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
        } else {
            throw new IllegalArgumentException("확장자를 찾을 수 없습니다: " + extension);
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
