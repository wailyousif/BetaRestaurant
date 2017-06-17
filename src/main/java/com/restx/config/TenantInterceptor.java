package com.restx.config;

import com.restx.services.Utils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wailm.yousif on 6/15/17.
 */

@Component
public class TenantInterceptor extends HandlerInterceptorAdapter {

    final static Logger logger = Logger.getLogger(TenantInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
            throws Exception {

        logger.debug("Interceptor2 has been called");

        String tenantId = req.getHeader(Utils.TENANT_HEADER);

        if (!StringUtils.isEmpty(tenantId))
        {
            logger.debug("tenantId found in header =" + tenantId + "#");
            TenantContext.setCurrentTenant(tenantId);
            return true;
        }
        else if (req.getSession().getAttribute("tenantId") != null)
        {
            tenantId = (String)req.getSession().getAttribute("tenantId");
            //req.setAttribute("CURRENT_TENANT_IDENTIFIER", tenantId);
            logger.debug("tenantId found in session =" + tenantId + "#");
            TenantContext.setCurrentTenant(tenantId);
            return true;
        }
        else
        {
            res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            //res.setContentType(MediaType.APPLICATION_JSON_VALUE);
            //res.getWriter().write("Restaurant Branch is Unknown");
            //res.getWriter().flush();
            logger.debug("tenantId is null");
            return true;
        }
    }

    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
        TenantContext.clear();
    }
}