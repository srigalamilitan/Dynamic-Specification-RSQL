package com.putracode.repo;

import com.putracode.domain.TableTestingRsql;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.math.BigInteger;

/**
 * Created by KrisnaPutra on 5/24/2016.
 */
public interface TableTestingRepo extends JpaRepository<TableTestingRsql, BigInteger>,JpaSpecificationExecutor<TableTestingRsql> {


}
