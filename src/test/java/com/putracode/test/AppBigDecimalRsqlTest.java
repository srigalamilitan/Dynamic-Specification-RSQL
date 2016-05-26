package com.putracode.test;

import com.putracode.App;
import com.putracode.domain.TableTestingRsql;
import com.putracode.service.TableTestingRsqlServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by KrisnaPutra on 5/24/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@DirtiesContext
public class AppBigDecimalRsqlTest {
    @Autowired
    TableTestingRsqlServices rp;

    @Test
    public void testBigDecimalEquals(){
        List<TableTestingRsql> data=rp.findBySpec("bigDecimalTest==1234556.1234567890");
        assertTrue("1 Data Actually",data.size()==1);
    }
    @Test
    public void testBigDecimalEquals2(){
        List<TableTestingRsql> data=rp.findBySpec("bigDecimalTest==32132131");
        assertTrue("1 Data Actually",data.size()==1);
    }
    @Test
    public void testBigDecimalEquals3(){
        List<TableTestingRsql> data=rp.findBySpec("bigDecimalTest==1234556");
        assertTrue("0 Data Actually",data.size()==0);
    }
    @Test
    public void testBigDecimalNotEquals(){
        List<TableTestingRsql> data=rp.findBySpec("bigDecimalTest!=1234556.1234567890");
        assertTrue("4 Data Actually",data.size()==4);
    }
    @Test
    public void testBigDecimalNotEquals2(){
        List<TableTestingRsql> data=rp.findBySpec("bigDecimalTest!=1234556.123456789");
        assertTrue("4 Data Actually",data.size()==4);
    }
    @Test
    public void testBigDecimalNotEquals3(){
        /**
         * Beda 1 angka dibelangkang koma
         */
        List<TableTestingRsql> data=rp.findBySpec("bigDecimalTest!=1234556.123456788");
        assertTrue("4 Data Actually",data.size()==5);
    }
    @Test
     public void testBigDecimalIn(){
        List<TableTestingRsql> data=rp.findBySpec("bigDecimalTest=in=(1234556.123456789,32132131)");
        assertTrue("2 Data Actually",data.size()==2);
    }
    @Test
    public void testBigDecimalNotIn(){
        List<TableTestingRsql> data=rp.findBySpec("bigDecimalTest=out=(1234556.123456789,32132131)");
        assertTrue("3 Data Actually",data.size()==3);
    }
    @Test
    public void testBigDecimalGreaterThan(){
        List<TableTestingRsql> data=rp.findBySpec("bigDecimalTest=gt=1234556.123456789");
        assertTrue("1 Data Actually",data.size()==1);
    }
    @Test
    public void testBigDecimalGreaterThanEquals(){
        List<TableTestingRsql> data=rp.findBySpec("bigDecimalTest=ge=1234556.123456789");
        assertTrue("2 Data Actually",data.size()==2);
    }
    @Test
    public void testBigDecimalLessThan(){
        List<TableTestingRsql> data=rp.findBySpec("bigDecimalTest=lt=1234556.123456789");
        assertTrue("3 Data Actually",data.size()==3);
    }
    @Test
    public void testBigDecimalLessThanEquals(){
        List<TableTestingRsql> data=rp.findBySpec("bigDecimalTest=le=1234556.123456789");
        assertTrue("4 Data Actually",data.size()==4);
    }
    @Test
    public void testBigDecimalGTEAndLTE(){
        List<TableTestingRsql> data=rp.findBySpec("bigDecimalTest=ge=87655;bigDecimalTest=le=1234556.123456789");
        assertTrue("3 Data Actually",data.size()==3);
    }
}
