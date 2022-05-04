package com.nike.shoe;

import com.nike.shoe_adapter.ShoeEntity;
import com.nike.shoe_adapter.ShoeJpaClient;
import com.nike.shoe_adapter.ShoeRepositoryAdapter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ShoesServiceAdapterTest {

    @InjectMocks
    private ShoeServiceAdapter shoeService;

    @Mock
    private ShoeRepository shoeRepository;


    @Test
    public void testShouldAbleToGetShoes() {
        //Given
        ShoeDetails shoeDetails = ShoeDetails.builder().build();
        List<ShoeEntity> entityList = Arrays.asList(ShoeEntity.builder().build());
        when(shoeRepository.find(any())).thenReturn(entityList);

        //When
        List<ShoeEntity> result = shoeService.find(shoeDetails);

        //Then
        Assert.assertEquals(result.size(), 1);
    }

}
