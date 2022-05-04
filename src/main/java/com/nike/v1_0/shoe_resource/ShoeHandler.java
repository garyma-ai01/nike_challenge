package com.nike.v1_0.shoe_resource;


import com.nike.shoe.ShoeService;
import com.nike.shoe_resource.ShoeRequest;
import com.nike.shoe_resource.ShoeResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ShoeHandler {

    private ShoeService shoeService;
    private ShoeRequestMapper shoeRequestMapper;
    private ShoeResponseMapper shoeResponseMapper;


    public ShoeResponse handle(ShoeRequest request) {

        return shoeResponseMapper.map(shoeService.find(shoeRequestMapper.map(request)));
    }


}
