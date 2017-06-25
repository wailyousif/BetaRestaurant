package com.restx.data.repo;

import com.restx.data.datatabs.CostItemCost;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;

/**
 * Created by wailm.yousif on 6/24/17.
 */
public interface CostItemCostRepo extends PagingAndSortingRepository<CostItemCost, Long> {

    @Query(value = "SELECT c.* FROM Cost_Item_Cost c where c.cost_item_id = :costItemId and c.end_date is null", nativeQuery = true)
    public CostItemCost findOpenedOne(@Param("costItemId") Long costItemId);

    @Query(value = "SELECT COUNT(*) FROM Cost_Item_Cost c where c.cost_item_id = :costItemId and c.end_date >= :startDate", nativeQuery = true)
    public Integer findEndDatesAfter(@Param("costItemId") Long costItemId, @Param("startDate") Date startDate);
}
