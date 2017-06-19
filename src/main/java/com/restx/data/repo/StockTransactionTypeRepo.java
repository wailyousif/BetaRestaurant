package com.restx.data.repo;

import com.restx.data.codestabs.StockTransactionType;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by wailm.yousif on 6/20/17.
 */
public interface StockTransactionTypeRepo extends PagingAndSortingRepository<StockTransactionType, Long> {
    public StockTransactionType findByCode(String code);
}
