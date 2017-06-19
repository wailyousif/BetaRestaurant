package com.restx.data.repo;

import com.restx.data.datatabs.Supplier;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by wailm.yousif on 6/20/17.
 */
public interface SupplierRepo extends PagingAndSortingRepository<Supplier, Long> {
    public Supplier findByName(String name);
}
