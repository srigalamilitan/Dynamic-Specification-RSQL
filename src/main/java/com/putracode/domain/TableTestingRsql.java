package com.putracode.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by KrisnaPutra on 5/24/2016.
 */
@Data
@Entity
@Table(name = "TABLE_TESTING_RSQL")
public class TableTestingRsql {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private BigInteger idTest;
    @Column(name = "DATE_TEST")
    private LocalDate dateTest;
    @Column(name = "BIG_DECIMAL_TEST")
    private BigDecimal bigDecimalTest;
    @Column(name = "DATE_TIME_TEST")
    private LocalDateTime dateTimeTest;
    @Column(name = "VARCHAR_TEST")
    private String varcharTest;
    @Column(name = "INT_TEST")
    private Integer intTest;
    @Column(name = "FLOAT_TEST",precision =10 ,scale =1 )
    private Float floatTest;
    @Column(name = "CHAR_TEST")
    private Character charTest;
    @Column(name = "DOUBLE_TEST")
    private Double doubleTest;
}
