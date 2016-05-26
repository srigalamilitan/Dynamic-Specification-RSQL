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
public class AppLocalDateRsqlTesting {
    @Autowired
    TableTestingRsqlServices rp;

    @Test
    public void testLocalDateEquals(){
        List<TableTestingRsql> data=rp.findBySpec("dateTest==2016-05-24");
        assertTrue("1 Data Actually",data.size()==1);
    }
    @Test
    public void testLocalDateNotEquals(){
        List<TableTestingRsql> data=rp.findBySpec("dateTest!=2016-05-24");
        System.out.println("Date "+data.size());
        assertTrue("4 Data Actually",data.size()==4);
    }
    @Test
    public void testLocalDateIn(){
        List<TableTestingRsql> data=rp.findBySpec("dateTest=in=(2016-05-24,2016-05-25)");
        assertTrue("2 Data Actually",data.size()==2);
    }
    @Test
    public void testLocalDateNotIn(){
        List<TableTestingRsql> data=rp.findBySpec("dateTest=out=(2016-05-24,2016-05-25)");
        assertTrue("3 Data Actually",data.size()==3);
    }
    @Test
    public void testLocalDateGreaterThan(){
        List<TableTestingRsql> data=rp.findBySpec("dateTest=gt=2016-05-24");
        assertTrue("4 Data Actually",data.size()==4);
    }
    @Test
    public void testLocalDateGreaterThaEquals(){
        List<TableTestingRsql> data=rp.findBySpec("dateTest=ge=2016-05-24");
        assertTrue("5 Data Actually",data.size()==5);
    }
    @Test
    public void testLocalDateLessThan(){
        List<TableTestingRsql> data=rp.findBySpec("dateTest=lt=2016-05-24");
        assertTrue("0 Data Actually",data.size()==0);
    }
    @Test
    public void testLocalDateLessThaEquals(){
        List<TableTestingRsql> data=rp.findBySpec("dateTest=le=2016-05-24");
        assertTrue("1 Data Actually",data.size()==1);
    }
    @Test
    public void testLocalDateBetween24And28(){
        List<TableTestingRsql> data=rp.findBySpec("dateTest=ge=2016-05-24;dateTest=le=2016-05-28");
        assertTrue("5 Data Actually",data.size()==5);
    }

}
