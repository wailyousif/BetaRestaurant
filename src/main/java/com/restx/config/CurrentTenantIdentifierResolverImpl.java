package com.restx.config;

import org.apache.log4j.Logger;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;

/**
 * Created by wailm.yousif on 6/14/17.
 */

@Component
public class CurrentTenantIdentifierResolverImpl implements CurrentTenantIdentifierResolver
{
    final static Logger logger = Logger.getLogger(CurrentTenantIdentifierResolverImpl.class);

    @Override
    public String resolveCurrentTenantIdentifier()
    {
        logger.debug("resolveCurrentTenantIdentifier has been called");
        return TenantContext.getCurrentTenant();
    }

    @Override
    public boolean validateExistingCurrentSessions()
    {
        return true;
    }
}
