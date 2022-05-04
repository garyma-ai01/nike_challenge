package com.nike.shoe;

import com.nike.shoe_adapter.ShoeEntity;

import java.util.List;

public interface ShoeService {

    List<ShoeEntity> find(ShoeDetails shoeDetails);
}
