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
public class AppDateTimeRsqlTests {
    @Autowired
    TableTestingRsqlServices rp;

    @Test
    public void testLocalDateTimeEquals(){
        List<TableTestingRsql> data=rp.findBySpec("dateTimeTest==2016-05-24T15:03:56");
        assertTrue("1 Data Actually",data.size()==1);
    }
    @Test
    public void testLocalDateTimeEqualasDifferenceOneSeconds(){
        List<TableTestingRsql> data=rp.findBySpec("dateTimeTest==2016-05-24T15:03:57");
        assertTrue("0 Data Actually",data.size()==0);
    }
    @Test
    public void testLocalDateTimeEqualasOnlyDateParamater(){
        List<TableTestingRsql> data=rp.findBySpec("dateTimeTest==2016-05-24T00:00:00");
        assertTrue("0 Data Actually",data.size()==0);
    }
    @Test
    public void testLocalDateTimeNotEqualFakeTime(){
        //Fake Date
        List<TableTestingRsql> data=rp.findBySpec("dateTimeTest!=2016-05-24T00:00:00");
        assertTrue("5 Data Actually",data.size()==5);
    }
    @Test
    public void testLocalDateTimeNotEqualRealTime(){
        //Real DateTime
        List<TableTestingRsql> data=rp.findBySpec("dateTimeTest!=2016-05-24T15:03:56");
        assertTrue("4 Data Actually",data.size()==4);
    }
    @Test
    public void testLocalDateTimeGreaterThan(){
        //Real DateTime
        List<TableTestingRsql> data=rp.findBySpec("dateTimeTest=gt=2016-05-24T15:03:56");
        System.out.println(data.size());
        assertTrue("4 Data Actually",data.size()==4);
    }
    @Test
    public void testLocalDateTimeGreaterThanEqual(){
        //Real DateTime
        List<TableTestingRsql> data=rp.findBySpec("dateTimeTest=ge=2016-05-24T15:03:56");
        System.out.println(data.size());
        assertTrue("5 Data Actually",data.size()==5);
    }
    @Test
    public void testLocalDateTimeLessThan(){
        List<TableTestingRsql> data=rp.findBySpec("dateTimeTest=lt=2016-05-28T15:03:56");
        System.out.println(data.size());
        assertTrue("4 Data Actually",data.size()==4);
    }
    @Test
    public void testLocalDateTimeLessThanEquals(){
        List<TableTestingRsql> data=rp.findBySpec("dateTimeTest=le=2016-05-28T15:06:14");
        System.out.println(data.size());
        assertTrue("5 Data Actually",data.size()==5);
    }
    @Test
    public void testLocalDateTimeBetween(){
        List<TableTestingRsql> data=rp.findBySpec("dateTimeTest=le=2016-05-28T15:06:14;dateTimeTest=ge=2016-05-24T15:03:56");
        System.out.println(data.size());
        assertTrue("5 Data Actually",data.size()==5);
    }
}
