package com.nike.shoe_adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ShoeJpaClient extends JpaRepository<ShoeEntity,Long>  {

    @Query(value = "select t from ShoeEntity t where t.model like %?1% ")
    List<ShoeEntity> findWithLike(String model);


}
