package com.restx.data.repo;

import com.restx.data.datatabs.ContactInfo;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by wailm.yousif on 3/22/17.
 */
public interface ContactInfoRepo extends PagingAndSortingRepository<ContactInfo, Long> {
}
