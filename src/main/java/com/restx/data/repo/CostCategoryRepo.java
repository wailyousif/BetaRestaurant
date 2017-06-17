package com.restx.data.repo;

import com.restx.data.codestabs.CostCategory;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by wailm.yousif on 6/17/17.
 */
public interface CostCategoryRepo extends PagingAndSortingRepository<CostCategory, String> {
}
