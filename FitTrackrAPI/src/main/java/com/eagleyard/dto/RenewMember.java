package com.eagleyard.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RenewMember {
	private LocalDate startDateValue;
	private LocalDate endDateValue;
}
