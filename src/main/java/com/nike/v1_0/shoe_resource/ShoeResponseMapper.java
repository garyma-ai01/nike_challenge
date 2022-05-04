package com.nike.v1_0.shoe_resource;


import com.nike.shoe_adapter.ShoeEntity;
import com.nike.shoe_resource.ShoeResponse;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ShoeResponseMapper {

    private static final String BEST_PRICE = "Best time to buy";
    private static final String PEEK_PRICE = "Can wait for discount";
    private static final String MID_PRICE = "Moderate state, can buy now!";

    public ShoeResponse map(List<ShoeEntity> shoeEntities) {

        List<ShoeResponse.Shoe> shoes = shoeEntities.stream().map(e -> {
            int curr = RandomUtils.nextInt(Math.max(e.getMiniPrice() - 50, 10), e.getMaxiPrice() + 100);
            String tips = curr > e.getMaxiPrice() ? PEEK_PRICE : curr < e.getMiniPrice() ? BEST_PRICE : MID_PRICE;

            return ShoeResponse.Shoe.builder().model(e.getModel()).curPrice(curr).tips(tips).build();
        }).collect(Collectors.toList());

        return ShoeResponse.builder().shoes(shoes).build();
    }
}
