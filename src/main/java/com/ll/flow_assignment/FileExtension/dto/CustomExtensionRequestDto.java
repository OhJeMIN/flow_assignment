package com.ll.flow_assignment.FileExtension.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomExtensionRequestDto {
    @Size(max = 25)
    @NotEmpty(message = "확장자명은 필수항목입니다.")
    private String customExtension;

    private boolean checked;
}
