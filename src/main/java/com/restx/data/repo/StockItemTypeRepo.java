package com.restx.data.repo;

import com.restx.data.codestabs.StockItemType;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by wailm.yousif on 6/19/17.
 */
public interface StockItemTypeRepo extends PagingAndSortingRepository<StockItemType, Long> {
    public StockItemType findByCode(String code);
}
