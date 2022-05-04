package com.nike.v1_0.shoe_resource;


import com.nike.shoe.ShoeDetails;
import com.nike.shoe_resource.ShoeRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ShoeRequestMapper {

    public ShoeDetails map(ShoeRequest request){
        return ShoeDetails.builder().model(request.getModel()).build();
    }
}
