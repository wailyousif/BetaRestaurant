package com.restx.config;

import com.restx.data.datatabs.AppUser;
import com.restx.data.repo.AuthTokenRepo;
import com.restx.data.repo.JobTypeRepo;
import org.apache.log4j.Logger;
import org.springframework.core.env.Environment;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wailm.yousif on 2/7/17.
 */
@WebFilter(filterName = "AuthFilter")
public class AuthFilter implements Filter
{
    final static Logger logger = Logger.getLogger(AuthFilter.class);

    //@Autowired
    private AuthTokenRepo authTokenRepo;
    private JobTypeRepo jobTypeRepo;

    private double guiTimeout;

    public AuthFilter(Environment env)
    {
        guiTimeout = Double.parseDouble(env.getRequiredProperty("gui.timeout"));
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException
    {
        //Test of repo initialization inside filter. This code didn't work
        //SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        //SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(authTokenRepo);

        /*
        //Test of repo initialization inside filter. This code worked.
        if (jobTypeRepo == null)
        {
            ServletContext servletContext = request.getServletContext();
            WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
            jobTypeRepo = webApplicationContext.getBean(JobTypeRepo.class);
        }
        JobType jobType = jobTypeRepo.findOne(-1L);
        System.out.println("job type: " + jobType.getDescription());
        */

        HttpServletRequest req = ((HttpServletRequest) request);
        HttpServletResponse resp = ((HttpServletResponse) response);

        //for testing
        //req.getSession().setAttribute("tenantid", "rest1");
        //req.getSession().setAttribute("tenantid", "public");

        String requestURI = req.getRequestURI();
        String remoteUser = req.getRemoteUser();
        String remoteAddr = req.getRemoteAddr();
        String remoteHost = req.getRemoteHost();
        String userIdentifier = "remoteUser(" + remoteUser + ") " + "remoteAddr(" + remoteAddr + ") remoteHost(" + remoteHost + ")";
        logger.info("Access to URI(" + requestURI + ") by " + userIdentifier);

        if (requestURI.equals("/mvc/method/user/login"))
        {
            chain.doFilter(req, resp);
        }
        else
        {
            if (req.getSession().getAttribute("appUser") != null)
            {
                AppUser appUser = (AppUser)req.getSession().getAttribute("appUser");
                chain.doFilter(req, resp);
            }
            else
            {
                logger.info("Session expired for " + userIdentifier);
                resp.getWriter().write("SESSION_EXPIRED");
            }
        }

        /*
        System.out.println("guiTimeout=" + guiTimeout);
        System.out.println("Passed through the WebFilter for URL=" +
            req.getRequestURI());

        boolean AuthKeyValid = false;
        boolean sessionExpired = false;
        Long userId = 0L;

        String xAuthKey = req.getHeader("x-authorization-key");
        if (xAuthKey != null)
        {
            TokenMaster tm = new TokenMaster();
            userId = tm.validateTokenAndGetUserId(xAuthKey);
            if (userId != null)
            {
                AuthKeyValid = true;

                System.out.println("User is not null...");
                if (authTokenRepo == null)
                {
                    ServletContext servletContext = request.getServletContext();
                    WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
                    authTokenRepo = webApplicationContext.getBean(AuthTokenRepo.class);
                }
                AuthToken authToken = authTokenRepo.findByTokenString(xAuthKey);
                System.out.println("Last Call = " + authToken.getLastCallTime());
                Double diffMinutes =
                        ((new Date()).getTime() - authToken.getLastCallTime().getTime()) / (1000.0 * 60.0);

                if (diffMinutes <= guiTimeout)
                {
                    authToken.setNumOfCalls(authToken.getNumOfCalls()+1);
                    authToken.setLastCallTime(new Date());
                    authTokenRepo.save(authToken);
                }
                else
                {
                    sessionExpired = true;
                }
            }
        }

        if (AuthKeyValid)
        {
            if (sessionExpired == false)
            {
                System.out.println("Processing request normally");
                req.setAttribute("userId", userId);
                req.setAttribute("tokenString", xAuthKey);
                chain.doFilter(req, resp);
            }
            else
            {
                System.out.println("Session expired");
                resp.addHeader("session-expired", "1");
            }
        }
        else
        {
            System.out.println("Invalid Authorization");
            resp.addHeader("x-invalid-auth", "1");
            resp.getWriter().write("Invalid Authorization.");
        }
        */
    }


    public void init(FilterConfig config) throws ServletException {

    }

}