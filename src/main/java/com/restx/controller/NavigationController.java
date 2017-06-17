package com.restx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wailm.yousif on 3/5/17.
 */

@Controller
public class NavigationController
{
    private static final String loginPage = "/pages/open/login";
    private static final String licenseTermsPage = "/pages/open/license.jsp";

    @RequestMapping(value = "/{restBranch}", method = RequestMethod.GET)
    public String root(HttpServletRequest request, Model model, @PathVariable String restBranch)
    {
        model.addAttribute("restBranch", restBranch);
        return loginPage;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public void invalidUrl1(HttpServletResponse response) throws IOException
    {
        response.getWriter().write("Invalid URL");
        response.getWriter().flush();
    }

    @RequestMapping(value = "/mvc/license/terms", method = RequestMethod.GET)
    public String showLicenseTermsPage()
    {
        System.out.println("Showing license terms");
        return "forward:" + licenseTermsPage;
    }
}
