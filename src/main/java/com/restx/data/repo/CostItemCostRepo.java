package com.restx.data.repo;

import com.restx.data.datatabs.CostItem;
import com.restx.data.datatabs.CostItemCost;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by wailm.yousif on 6/24/17.
 */
public interface CostItemCostRepo extends PagingAndSortingRepository<CostItemCost, Long> {

    @Query(value = "SELECT c.* FROM Cost_Item_Cost c where c.cost_item_id = :costItemId and c.end_date is null", nativeQuery = true)
    public CostItemCost findOpenedOne(@Param("costItemId") Long costItemId);

    @Query(value = "SELECT COUNT(*) FROM Cost_Item_Cost c where c.cost_item_id = :costItemId and c.end_date >= :startDate", nativeQuery = true)
    public Integer findEndDatesAfter(@Param("costItemId") Long costItemId, @Param("startDate") Date startDate);

    @Query(value = "SELECT COUNT(*) FROM Cost_Item_Cost c where c.cost_item_id = :costItemId and c.start_date <= :endDate and id != :excludedId", nativeQuery = true)
    public Integer findStartDatesBefore(@Param("costItemId") Long costItemId, @Param("endDate") Date endDate, @Param("excludedId") Long excludedId);

    @Query(value = "SELECT COUNT(*) FROM Cost_Item_Cost c where c.cost_item_id = :costItemId and ((:startDate between c.start_date and COALESCE(c.end_date,'9999-12-31')) or (:endDate between c.start_date and COALESCE(c.end_date,'9999-12-31')))", nativeQuery = true)
    public Integer findConflictingDates(@Param("costItemId") Long costItemId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);


    @Query(value = "SELECT c.* from Cost_Item_Cost c where c.cost_item_id = :costItemId order by c.id", nativeQuery = true)
    public List<CostItemCost> findByCostItemOrdered(@Param("costItemId") Long costItemId);

    public static final String findByCostItemQuery = "select d.id, d.start_date, d.end_date, r.lang_code, d.cost, d.creation_time, a.username,\n" +
            "d.disabled, d.disabled_on from cost_item_cost d, recurrence_trans r, app_user a where\n" +
            "d.recurrence_id = r.recurrence_id and d.created_by_id = a.id and \n" +
            "d.cost_item_id = :costItemId\n" +
            "order by d.id";

    @Query(value = findByCostItemQuery, nativeQuery = true)
    public List<Object[]> findByCostItemOrdered2(@Param("costItemId") Long costItemId);
}
