package com.ll.flow_assignment.FileExtension.controller;

import com.ll.flow_assignment.FileExtension.dto.CustomExtensionRequestDto;
import com.ll.flow_assignment.FileExtension.dto.ExtensionUpdateRequestDto;
import com.ll.flow_assignment.FileExtension.service.ExtensionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class ExtensionController {
    private final ExtensionService extensionService;

    @GetMapping("/")
    public String showExtensions(Model model) {
        model.addAttribute("fixedExtensions", extensionService.findNotCustom());
        model.addAttribute("customExtensions", extensionService.findCustom());
        return "extensions";
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateExtensionStatus(@RequestBody ExtensionUpdateRequestDto dto) {
        extensionService.update(dto.getExtension(), dto.isChecked());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/addCustom")
    public ResponseEntity<?> addCustomExtension(@RequestBody CustomExtensionRequestDto dto) {
        boolean duplication = extensionService.addCustom(dto.getCustomExtension(), dto.isChecked());
        if (duplication) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("중복된 확장자입니다.");
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteCustom/{extension}")
    public ResponseEntity<?> deleteCustomExtension(@PathVariable String extension) {
        extensionService.delete(extension);
        return ResponseEntity.ok().build();
    }
}
