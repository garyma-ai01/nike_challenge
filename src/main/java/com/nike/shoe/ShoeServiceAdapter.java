package com.nike.shoe;

import com.nike.shoe_adapter.ShoeEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class ShoeServiceAdapter implements ShoeService {

    private ShoeRepository shoeRepository;

    @Override
    public List<ShoeEntity> find(ShoeDetails shoeDetail) {
        return shoeRepository.find(shoeDetail.getModel());
    }
}
