package com.nike.shoe_adapter;

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
public class ShoesRepositoryAdapterTest {

    @InjectMocks
    private ShoeRepositoryAdapter shoeRepositoryAdapter;

    @Mock
    private ShoeJpaClient shoeJpaClient;


    @Test
    public void testShouldSuccessfullyStoreRecords() {
        //Given

        List<ShoeEntity> entityList = Arrays.asList(ShoeEntity.builder().build());
        when(shoeJpaClient.saveAll(entityList)).thenReturn(entityList);

        //When
        int result = shoeRepositoryAdapter.store(entityList);

        //Then
        verify(shoeJpaClient, times(1)).saveAll(entityList);
        Assert.assertTrue(result > 0);
    }

    @Test
    public void testShouldFindShoes() {
        //Given

        List<ShoeEntity> entityList = Arrays.asList(ShoeEntity.builder().maxiPrice(10).miniPrice(5).build());
        when(shoeJpaClient.findWithLike(any())).thenReturn(entityList);
        //When
        List<ShoeEntity> result = shoeRepositoryAdapter.find("Air");

        //Then
        verify(shoeJpaClient, times(1)).findWithLike(any());
        Assert.assertEquals(result.size(), 1);
    }

    @Test(expected = RuntimeException.class)
    public void testShouldFailToStoreRecords() {
        //Given
        List<ShoeEntity> entityList = Arrays.asList(ShoeEntity.builder().build());
        when(shoeJpaClient.saveAll(entityList)).thenThrow(new RuntimeException("Error!"));

        //When
        shoeRepositoryAdapter.store(entityList);

    }
}
