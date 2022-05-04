package com.nike.shoe_adapter;

import com.opencsv.bean.CsvBindByPosition;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@Builder(toBuilder = true)
@Getter
@Entity
@NoArgsConstructor
@Table(name = "SHOE")
public class ShoeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    @Column(name = "ID")
    private Integer id;

    @Column(name = "MODEL")
    @CsvBindByPosition(position = 1)
    private String model;

    @Column(name = "MINI_PRICE")
    @CsvBindByPosition(position = 2)
    private Integer miniPrice;

    @Column(name = "MAXI_PRICE")
    @CsvBindByPosition(position = 3)
    private Integer maxiPrice;

}
