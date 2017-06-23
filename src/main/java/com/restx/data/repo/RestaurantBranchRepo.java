package com.restx.data.repo;

import com.restx.data.datatabs.RestaurantBranch;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by wailm.yousif on 6/23/17.
 */
public interface RestaurantBranchRepo extends PagingAndSortingRepository<RestaurantBranch, Long> {
}
