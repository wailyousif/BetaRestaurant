package com.restx.data.repo;

import com.restx.data.datatabs.StockItemsTransactions;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by wailm.yousif on 6/20/17.
 */
public interface StockItemsTransactionsRepo extends PagingAndSortingRepository<StockItemsTransactions, Long> {
}
