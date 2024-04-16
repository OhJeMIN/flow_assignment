package com.ll.flow_assignment.FileExtension.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "fileExtensions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Extension {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, unique = true)
    private String extension;

    @Column(name = "is_checked")
    private boolean isChecked;

    @Column(name = "is_custom")
    private boolean isCustom;

    public Extension(String extension, boolean isChecked, boolean isCustom) {
    }
}
