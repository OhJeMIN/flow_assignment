package com.ll.flow_assignment.FileExtension.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "fileExtensions")
@Getter
@Setter
@NoArgsConstructor
public class Extension {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, unique = true)
    private String extension;

    @Column(name = "checked")
    private boolean checked;

    @Column(name = "custom")
    private boolean custom;

    public Extension(String extension, boolean Checked, boolean Custom) {
        this.extension = extension;
        this.checked = Checked;
        this.custom = Custom;
    }
}
