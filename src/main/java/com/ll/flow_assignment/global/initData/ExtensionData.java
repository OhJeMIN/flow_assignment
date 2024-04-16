package com.ll.flow_assignment.global.initData;

import com.ll.flow_assignment.FileExtension.service.ExtensionService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExtensionData {
    @Bean
    public ApplicationRunner initExtensionData(
            ExtensionService extensionService
    ){
        return args -> {
            String[] extensions = {"bat", "cmd", "com", "cpl", "exe", "scr", "js"};
            for (String extension : extensions) {
                extensionService.add(extension, false, false);
            }
        };
    }
}
