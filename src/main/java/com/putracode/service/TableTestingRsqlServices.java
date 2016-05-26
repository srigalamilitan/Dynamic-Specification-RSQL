package com.putracode.service;

import com.putracode.domain.TableTestingRsql;

import java.util.List;

/**
 * Created by KrisnaPutra on 5/24/2016.
 */
public interface TableTestingRsqlServices {
    List<TableTestingRsql> findBySpec(String p_filter);
}
