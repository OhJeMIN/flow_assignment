package com.ll.flow_assignment.FileExtension.controller;

import com.ll.flow_assignment.FileExtension.service.ExtensionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
