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
public class AppIntegerRsqlTests {
    @Autowired
    TableTestingRsqlServices rp;

    @Test
    public void testIntegerEquals(){
        List<TableTestingRsql> data=rp.findBySpec("intTest==1");
        assertTrue("1 Data Actually",data.size()==1);
    }
    @Test
     public void testIntegerNotEqual(){
        List<TableTestingRsql> data=rp.findBySpec("intTest!=1");
        assertTrue("4 Data Actually",data.size()==4);
    }
    @Test
    public void testIntegerIn(){
        List<TableTestingRsql> data=rp.findBySpec("intTest=in=(1,2)");
        assertTrue("3 Data Actually",data.size()==2);
    }
    @Test
    public void testIntegerNotIn(){
        List<TableTestingRsql> data=rp.findBySpec("intTest=out=(1,2)");
        assertTrue("3 Data Actually",data.size()==3);
    }
    @Test
     public void testIntegerGreaterThan(){
        List<TableTestingRsql> data=rp.findBySpec("intTest=gt=1");
        assertTrue("4 Data Actually",data.size()==4);
    }
    @Test
    public void testIntegerGreaterThanEquals(){
        List<TableTestingRsql> data=rp.findBySpec("intTest=ge=1");
        assertTrue("5 Data Actually",data.size()==5);
    }

    @Test
    public void testIntegerLessThan(){
        List<TableTestingRsql> data=rp.findBySpec("intTest=lt=5");
        assertTrue("4 Data Actually",data.size()==4);
    }
    @Test
    public void testIntegerLessThanEquals(){
        List<TableTestingRsql> data=rp.findBySpec("intTest=le=5");
        assertTrue("5 Data Actually",data.size()==5);
    }
    @Test
    public void testIntegerBetween(){
        List<TableTestingRsql> data=rp.findBySpec("intTest=le=5;intTest=ge=2");
        assertTrue("4 Data Actually",data.size()==4);
    }
}
