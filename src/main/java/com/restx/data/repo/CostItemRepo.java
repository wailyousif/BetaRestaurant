package com.restx.data.repo;

import com.restx.data.datatabs.CostItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by wailm.yousif on 6/17/17.
 */
public interface CostItemRepo extends PagingAndSortingRepository<CostItem, Long> {

    @Query(value = "SELECT c from CostItem c order by id", nativeQuery = false)
    public List<CostItem> findAllSortedById();

    //@Query(value = "SELECT cost_item_id, start_date, end_date, cost from Cost_Item_Cost", nativeQuery = true)
    //public List<Object[]> findAllWithCurrentCost();

    public static final String getCostItemsWithCostQuery = "select m.id, m.name, m.description, m.creation_time, m.enabled, \n" +
            "m.lang_code, m.display_name, coalesce(d.cost,0.0) current_cost from\n" +
            "(\n" +
            "    select h.id, h.name, h.description, h.creation_time, h.enabled, t.lang_code, \n" +
            "    a.display_name from cost_item h, cost_category_trans t, app_user a where\n" +
            "    h.cost_category_id = t.cost_category_id and h.created_by_id = a.id and \n" +
            "    h.id = 1\n" +
            ") m left join\n" +
            "(\n" +
            "    select cost_item_id, cost, start_date, end_date from cost_item_cost \n" +
            "    where CURRENT_DATE between start_date and end_date\n" +
            ") d on m.id = d.cost_item_id\n" +
            "order by m.id desc";

    @Query(value = getCostItemsWithCostQuery, nativeQuery = true)
    public List<Object[]> findAllWithCurrentCost();
}
