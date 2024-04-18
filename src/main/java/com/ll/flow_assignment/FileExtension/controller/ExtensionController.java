package com.ll.flow_assignment.FileExtension.controller;

import com.ll.flow_assignment.FileExtension.service.ExtensionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    public ResponseEntity<?> updateExtensionStatus(@RequestBody Map<String, Object> payload) {
        String extension = (String) payload.get("extension");
        boolean checked = (Boolean) payload.get("checked");
        extensionService.update(extension, checked);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/addCustom")
    public ResponseEntity<?> addCustomExtension(@RequestBody Map<String, Object> payload) {
        String extension = (String) payload.get("customExtension");
        boolean checked = (Boolean) payload.get("checked");
        extensionService.addCustom(extension, checked);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteCustom/{extension}")
    public ResponseEntity<?> deleteCustomExtension(@PathVariable String extension) {
        extensionService.delete(extension);
        return ResponseEntity.ok().build();
    }
}
