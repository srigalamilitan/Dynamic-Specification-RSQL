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
 * Created by KrisnaPutra on 6/1/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@DirtiesContext
public class AppStringInCaseSensitifRsqlTest {
    @Autowired
    TableTestingRsqlServices rp;
    @Test
    public void testStringEquals(){
        List<TableTestingRsql> data=rp.findBySpec("varcharTest==One");
        assertTrue("1 Data Actually",data.size()==1);
    }
    @Test
    public void testStringEqualsWrongValueCriteria(){
        List<TableTestingRsql> data=rp.findBySpec("varcharTest==ONE");
        assertTrue("0 Data Actually",data.size()==0);
    }
    @Test
    public void testStringLikeAndUpperCase(){
        List<TableTestingRsql> data=rp.findBySpec("varcharTest==^ON*");
        assertTrue("1 Data Actually",data.size()==1);
    }
    @Test
    public void testStringLikeStartAndEndAndUpper(){
        List<TableTestingRsql> data=rp.findBySpec("varcharTest==^*ON*");
        assertTrue("1 Data Actually",data.size()==1);
    }
    @Test
    public void testStringNotEqual(){
        List<TableTestingRsql> data=rp.findBySpec("varcharTest!=One");
        System.out.println("Size Actually "+data.size());
        assertTrue("4 Data Actually",data.size()==4);
    }
    @Test
    public void testStringNotEqualUpper(){
        List<TableTestingRsql> data=rp.findBySpec("varcharTest!=^One");
        System.out.println("Size Actually "+data.size());
        assertTrue("4 Data Actually",data.size()==4);
    }
    @Test
    public void testStringNotLikeUpper(){
        List<TableTestingRsql> data=rp.findBySpec("varcharTest!=^*On*");
        System.out.println("Size Actually "+data.size());
        assertTrue("4 Data Actually",data.size()==4);
    }
}
