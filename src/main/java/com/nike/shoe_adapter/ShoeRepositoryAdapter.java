package com.nike.shoe_adapter;

import com.nike.shoe.ShoeRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class ShoeRepositoryAdapter implements ShoeRepository {

    private ShoeJpaClient salesJpaClient;

    @Override
    public int store(List<ShoeEntity> entities) {
        salesJpaClient.saveAll(entities);
        return entities.size();
    }

    @Override
    public List<ShoeEntity> find(String model) {
        if(StringUtils.isNoneBlank(model)) {
            return salesJpaClient.findWithLike(model);
        }
        return salesJpaClient.findAll();
    }
}
