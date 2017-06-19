package com.restx.controller.mvc;

import com.restx.data.datatabs.AppUser;
import com.restx.dto.ResponseObject;
import com.restx.data.repo.AppUserRepo;
import com.restx.data.repo.UserRoleRepo;
import com.restx.services.Utils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wailm.yousif on 6/10/17.
 */

@Controller
@RequestMapping(path = "/mvc/method/user")
public class MvcUserController
{
    private final static Logger logger = Logger.getLogger(MvcUserController.class);

    private static final String logoutPage = "/pages/open/logout";
    private static final String securePath = "/pages/secure/";

    @Autowired
    private AppUserRepo appUserRepo;

    @Autowired
    private UserRoleRepo userRoleRepo;

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ResponseEntity<ResponseObject> login(HttpServletRequest request, String username, String pass)
    {
        logger.info("User (" + username + "): log-in attempt.");
        logger.debug("User (" + username + "): password = " + pass);

        ResponseObject responseObject = new ResponseObject(false, 10, "Incorrect Credentials");
        ResponseEntity<ResponseObject> responseEntity;

        try
        {
            logger.debug("Before setting db type");
            //DbContextHolder.setDbType(DbType.REPLICA1);
            logger.debug("After setting db type");

            AppUser appUser = appUserRepo.findByUsernameAndPassword(username, pass);
            logger.debug("After finding credentials");

            if (appUser != null)
            {
                if (appUser.isEnabled() == false)
                {
                    logger.info("User (" + username + "): is disabled.");
                    responseObject.setResponseCode(20);
                    responseObject.setResponseString("User is Disabled!");
                }
                else
                {
                    responseObject.setSuccess(true);
                    responseObject.setResponseCode(0);
                    logger.info("User (" + username + "): logged in successfully.");

                    request.getSession().setAttribute("appUser", appUser);
                    String tenantId = request.getHeader(Utils.TENANT_HEADER);
                    logger.info("User (" + username + "): tenantId from request header =" + tenantId);
                    request.getSession().setAttribute("tenantId", tenantId);

                    String userRole = appUser.getUserRole().getRole();
                    String defaultPage = (userRoleRepo.findByRole(userRole)).getDefaultPage();
                    responseObject.setResponseString(securePath + defaultPage);
                }
            }
            else
            {
                logger.info("User (" + username + "): incorrect credentials.");
            }
            responseEntity = new ResponseEntity<>(responseObject, HttpStatus.OK);
        }
        catch (Exception ex)
        {
            logger.error("Handled Exception", ex);
            responseObject.setSuccess(false);
            responseEntity = new ResponseEntity<>(responseObject, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        finally {
            //DbContextHolder.clearDbType();
        }

        return responseEntity;
    }



    @RequestMapping(value = "/mvc/user/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request)
    {
        request.getSession().invalidate();
        return logoutPage;
    }
}
