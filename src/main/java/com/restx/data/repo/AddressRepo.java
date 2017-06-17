package com.restx.data.repo;

import com.restx.data.datatabs.Address;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by wailm.yousif on 3/22/17.
 */
public interface AddressRepo extends PagingAndSortingRepository<Address, Long> {
}
