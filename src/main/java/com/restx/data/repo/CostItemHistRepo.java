package com.restx.data.repo;

import com.restx.data.datatabs.CostItemHist;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by wailm.yousif on 6/25/17.
 */
public interface CostItemHistRepo extends PagingAndSortingRepository<CostItemHist, Long> {
}
