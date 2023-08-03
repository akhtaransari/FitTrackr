package com.eagleyard.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name must not be blank")
    private String nameValue;

    @NotBlank(message = "Mobile must not be blank")
    @Pattern(regexp = "\\d{10}", message = "Mobile number must be a 10-digit number")
    private String mobileValue;

    @NotNull(message = "Start date must not be null")
    private LocalDate startDateValue;

    @NotNull(message = "End date must not be null")
    private LocalDate endDateValue;

    @NotBlank(message = "Gender must not be blank")
    @Size(min = 4, max = 6, message = "Gender should be between 4 and 6 characters")
    private String genderValue;
}
