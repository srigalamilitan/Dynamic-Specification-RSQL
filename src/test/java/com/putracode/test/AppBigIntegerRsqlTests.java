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
public class AppBigIntegerRsqlTests {
    @Autowired
    TableTestingRsqlServices rp;

    @Test
    public void testBigIntegerEquals(){
        List<TableTestingRsql> data=rp.findBySpec("idTest==1");
        assertTrue("1 Data Actually",data.size()==1);
    }
    @Test
    public void testBigIntegerNotEquals(){
        List<TableTestingRsql> data=rp.findBySpec("idTest!=1");
        assertTrue("4 Data Actually",data.size()==4);
    }
    @Test
    public void testBigIntegerIn(){
        List<TableTestingRsql> data=rp.findBySpec("idTest=in=(1,2)");
        assertTrue("2 Data Actually",data.size()==2);
    }
    @Test
    public void testBigIntegerNotIn(){
        List<TableTestingRsql> data=rp.findBySpec("idTest=out=(1,2)");
        assertTrue("3 Data Actually",data.size()==3);
    }
    @Test
    public void testBigIntegerLessThan(){
        List<TableTestingRsql> data=rp.findBySpec("idTest=lt=5");
        assertTrue("3 Data Actually",data.size()==4);
    }
    @Test
    public void testBigIntegerLessThanEquals(){
        List<TableTestingRsql> data=rp.findBySpec("idTest=le=5");
        assertTrue("3 Data Actually",data.size()==5);
    }
    @Test
    public void testBigIntegerGreaterThan(){
        List<TableTestingRsql> data=rp.findBySpec("idTest=gt=5");
        assertTrue("0 Data Actually",data.size()==0);
    }
    @Test
    public void testBigIntegerGreaterThanEquals(){
        List<TableTestingRsql> data=rp.findBySpec("idTest=ge=5");
        assertTrue("1 Data Actually",data.size()==1);
    }
    @Test
    public void testBigIntegerGreaterThanEquals1AndLessEquals3(){
        List<TableTestingRsql> data=rp.findBySpec("idTest=ge=1;idTest=le=3");
        assertTrue("2 Data Actually",data.size()==3);
    }

}
