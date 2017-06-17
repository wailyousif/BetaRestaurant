package com.restx.data.repo;

import com.restx.data.datatabs.AuthToken;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by wailm.yousif on 3/27/17.
 */
public interface AuthTokenRepo extends PagingAndSortingRepository<AuthToken, Long> {
    public AuthToken findByTokenString(String tokenString);
}
