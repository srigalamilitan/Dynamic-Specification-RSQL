package com.putracode.service.impl;

import com.putracode.domain.TableTestingRsql;
import com.putracode.repo.TableTestingRepo;
import com.putracode.service.TableTestingRsqlServices;
import com.putracode.utils.RsqlSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by KrisnaPutra on 5/24/2016.
 */
@Service
public class TableTestingRsqlServicesImpl implements TableTestingRsqlServices {
    @Autowired
    TableTestingRepo repo;
    @Override
    public List<TableTestingRsql> findBySpec(String p_filter) {
        return repo.findAll(RsqlSpecification.<TableTestingRsql>rsql(p_filter));
    }
}
