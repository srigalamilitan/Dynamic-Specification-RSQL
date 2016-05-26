package com.putracode.test;

import com.putracode.App;
import com.putracode.domain.TableTestingRsql;
import com.putracode.service.TableTestingRsqlServices;
import org.junit.Ignore;
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
public class AppFloatRsqlTests {
    @Autowired
    TableTestingRsqlServices rp;

    @Test
    public void testFloatEquals(){
        List<TableTestingRsql> data=rp.findBySpec("floatTest==1.1");
        System.out.println(data.size());
        assertTrue("1 Data Actually",data.size()==1);
    }
    @Test
    public void testFloatNotEquals(){
        List<TableTestingRsql> data=rp.findBySpec("floatTest!=1.1");
        assertTrue("4 Data Actually",data.size()==4);
    }
    @Test
    @Ignore
    public void testFloatIn(){
        List<TableTestingRsql> data=rp.findBySpec("floatTest=in=(1.1f,2.2f)");
        System.out.println(data.size());
        assertTrue("2 Data Actually",data.size()==2);
    }
    @Test
    @Ignore
    public void testFloatNotIn(){
        List<TableTestingRsql> data=rp.findBySpec("floatTest=out=(1.1,2.2)");
        assertTrue("3 Data Actually",data.size()==3);
    }
    @Test
    public void testFloatLessThan(){
        List<TableTestingRsql> data=rp.findBySpec("floatTest=lt=5.5");
        assertTrue("3 Data Actually",data.size()==4);
    }
    @Test
    public void testFloatLessThanEquals(){
        List<TableTestingRsql> data=rp.findBySpec("floatTest=le=5.5");
        assertTrue("3 Data Actually",data.size()==5);
    }
    @Test
    public void testFloatGreaterThan(){
        List<TableTestingRsql> data=rp.findBySpec("floatTest=gt=5.5");
        assertTrue("0 Data Actually",data.size()==0);
    }
    @Test
    public void testFloatGreaterThanEquals(){
        List<TableTestingRsql> data=rp.findBySpec("floatTest=ge=5.5");
        assertTrue("1 Data Actually",data.size()==1);
    }
    @Test
    public void testFloatGreaterThanEquals1AndLessEquals3(){
        List<TableTestingRsql> data=rp.findBySpec("floatTest=ge=1.1;floatTest=le=3.3");
        assertTrue("2 Data Actually",data.size()==3);
    }
    
}
