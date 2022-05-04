package com.nike.shoe_resource;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Builder(toBuilder = true)
@Getter
@ToString
public class ShoeResponse {

    private List<Shoe> shoes;

    @Builder
    @Getter
     public static class Shoe {
        private String model;
        private Integer curPrice;
        public String tips;
    }

}
