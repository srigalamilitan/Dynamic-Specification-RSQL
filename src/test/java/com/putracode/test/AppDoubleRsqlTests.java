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
 * Created by KrisnaPutra on 5/25/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@DirtiesContext
public class AppDoubleRsqlTests {
    @Autowired
    TableTestingRsqlServices rp;
    @Test
    public void testDoubleEquals(){
        List<TableTestingRsql> data=rp.findBySpec("doubleTest==156789.56789");
        System.out.println(data.size());
        assertTrue("1 Data Actually",data.size()==1);
    }
    @Test
    public void testDoubleNotEquals(){
        List<TableTestingRsql> data=rp.findBySpec("doubleTest!=1.456789");
        assertTrue("4 Data Actually",data.size()==4);
    }
    @Test
    public void testDoubleIn(){
        List<TableTestingRsql> data=rp.findBySpec("doubleTest=in=(1.456789,156789.56789)");
        System.out.println(data.size());
        assertTrue("2 Data Actually",data.size()==2);
    }
    @Test
    public void testDoubleNotIn(){
        List<TableTestingRsql> data=rp.findBySpec("doubleTest=out=(1.456789,156789.56789)");
        assertTrue("3 Data Actually",data.size()==3);
    }
    @Test
    public void testDoubleLessThan(){
        List<TableTestingRsql> data=rp.findBySpec("doubleTest=lt=156789.56789");
        assertTrue("3 Data Actually",data.size()==4);
    }
    @Test
    public void testDoubleLessThanEquals(){
        List<TableTestingRsql> data=rp.findBySpec("doubleTest=le=156789.56789");
        assertTrue("3 Data Actually",data.size()==5);
    }
    @Test
    public void testDoubleGreaterThan(){
        List<TableTestingRsql> data=rp.findBySpec("doubleTest=gt=156789.56789");
        assertTrue("0 Data Actually",data.size()==0);
    }
    @Test
    public void testDoubleGreaterThanEquals(){
        List<TableTestingRsql> data=rp.findBySpec("doubleTest=ge=156789.56789");
        assertTrue("1 Data Actually",data.size()==1);
    }
    @Test
    public void testDoubleGreaterThanEquals1AndLessEquals3(){
        List<TableTestingRsql> data=rp.findBySpec("doubleTest=ge=0.654321;doubleTest=le=8.56789");
        assertTrue("2 Data Actually",data.size()==4);
    }
}
