package com.nike.shoe_resource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder(toBuilder = true)
@Getter
public class ShoeRequest {
    private String model;
}
