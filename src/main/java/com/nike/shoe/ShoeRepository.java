package com.nike.shoe;

import com.nike.shoe_adapter.ShoeEntity;

import java.util.List;

public interface ShoeRepository {

    int store(List<ShoeEntity> entities);

    List<ShoeEntity> find(String model);
}
