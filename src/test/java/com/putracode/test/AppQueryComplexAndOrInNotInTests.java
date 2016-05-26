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
public class AppQueryComplexAndOrInNotInTests {
    @Autowired
    TableTestingRsqlServices rp;

    @Test
    public void testCombainLogical_OR_AND(){
        System.out.println("Where ( DATE_TEST IN ('2016-05-24','2016-05-25') AND INT_TEST IN (1,4) )OR ID=5");
        System.out.println("Where ( dateTest=in=(2016-05-24,2016-05-25);intTest=in=(1,4)),idTest==5");
        List<TableTestingRsql> data=rp.findBySpec("( dateTest=in=(2016-05-24,2016-05-25);intTest=in=(1,4)),idTest==5");
        assertTrue("2 Data Actually",data.size()==2);
    }
}
