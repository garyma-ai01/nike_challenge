package com.nike.shoe;

import lombok.Builder;
import lombok.Getter;

@Builder(toBuilder = true)
@Getter
public class ShoeDetails {
    private String model;
}
