package com.restx.data.repo;

import com.restx.data.datatabs.Restaurant;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by wailm.yousif on 6/23/17.
 */
public interface RestaurantRepo extends PagingAndSortingRepository<Restaurant, Long> {
}
