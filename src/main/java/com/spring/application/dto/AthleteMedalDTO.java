package com.spring.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AthleteMedalDTO {
    private String name;
    private String country;
    private int gold;
    private int silver;
    private int bronze;
}
