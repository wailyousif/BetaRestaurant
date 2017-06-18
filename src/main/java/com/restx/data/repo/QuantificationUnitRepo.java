package com.restx.data.repo;

import com.restx.data.codestabs.QuantificationUnit;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by wailm.yousif on 6/19/17.
 */
public interface QuantificationUnitRepo extends PagingAndSortingRepository<QuantificationUnit, Long> {
    public QuantificationUnit findByCode(String code);
}
