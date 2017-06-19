package com.restx.data.repo;

import com.restx.data.datatabs.StockItem;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by wailm.yousif on 6/20/17.
 */
public interface StockItemRepo extends PagingAndSortingRepository<StockItem, Long> {
    public StockItem findByName(String name);
}
