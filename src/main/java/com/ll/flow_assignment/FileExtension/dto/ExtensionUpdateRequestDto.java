package com.ll.flow_assignment.FileExtension.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExtensionUpdateRequestDto {
    private String extension;
    private boolean checked;
}