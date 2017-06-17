package com.restx.data.repo;

import com.restx.data.codestabs.JobType;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by wailm.yousif on 6/9/17.
 */
public interface JobTypeRepo extends PagingAndSortingRepository<JobType, Long> {
}
