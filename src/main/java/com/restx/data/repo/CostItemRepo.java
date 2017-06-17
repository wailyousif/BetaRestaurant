package com.restx.data.repo;

import com.restx.data.datatabs.CostItem;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by wailm.yousif on 6/17/17.
 */
public interface CostItemRepo extends PagingAndSortingRepository<CostItem, Long> {
}
