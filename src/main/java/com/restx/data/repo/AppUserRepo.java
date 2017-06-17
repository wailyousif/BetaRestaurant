package com.restx.data.repo;

import com.restx.data.datatabs.AppUser;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by wailm.yousif on 3/22/17.
 */
public interface AppUserRepo extends PagingAndSortingRepository<AppUser, Long> {

    public AppUser findByUsername(String username);

    public AppUser findByUsernameAndPassword(String username, String password);
}
