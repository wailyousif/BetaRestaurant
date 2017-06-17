package com.restx.data.repo;

import com.restx.data.datatabs.UserRole;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by wailm.yousif on 6/10/17.
 */
public interface UserRoleRepo extends PagingAndSortingRepository<UserRole, Long> {

    public UserRole findByRole(String role);
}
