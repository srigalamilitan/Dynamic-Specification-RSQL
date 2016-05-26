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
public class AppCharacterRsqlTest {
    @Autowired
    TableTestingRsqlServices rp;


    @Test
    public void testStringIn(){
        List<TableTestingRsql> data=rp.findBySpec("charTest=in=(A,B)");
        assertTrue("2 Data Actually",data.size()==2);
    }
    @Test
    public void testStringNotIn(){
        List<TableTestingRsql> data=rp.findBySpec("charTest=out=(A,B)");
        assertTrue("3 Data Actually",data.size()==3);
    }
    @Test
    public void testStringEquals(){
        List<TableTestingRsql> data=rp.findBySpec("charTest==A");
        assertTrue("1 Data Actually",data.size()==1);
    }
    @Test
    public void testStringLikeEnd(){
        List<TableTestingRsql> data=rp.findBySpec("charTest==A");
        assertTrue("1 Data Actually",data.size()==1);
    }
    @Test
    public void testStringLikeStart(){
        List<TableTestingRsql> data=rp.findBySpec("charTest==A");
        assertTrue("1 Data Actually",data.size()==1);
    }
}
