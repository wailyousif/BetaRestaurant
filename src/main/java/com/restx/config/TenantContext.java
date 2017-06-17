package com.restx.config;

/**
 * Created by wailm.yousif on 6/15/17.
 */

public class TenantContext {

    final public static String DEFAULT_TENANT = "noschema";

    private static ThreadLocal<String> currentTenant = new ThreadLocal<String>()
    {
        @Override
        protected String initialValue() {
            return DEFAULT_TENANT;
        }
    };

    public static void setCurrentTenant(String tenant) {
        currentTenant.set(tenant);
    }

    public static String getCurrentTenant() {
        return currentTenant.get();
    }

    public static void clear() {
        currentTenant.remove();
    }
}