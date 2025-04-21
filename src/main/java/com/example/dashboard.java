package com.example;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class dashboard {

    public void dashboard(Page page) {
        try {

            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Dashboard")).click();
            page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Total Customers")).click();
            Thread.sleep(1000);
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Dashboard")).click();

            page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Total Advertisment")).click();
            Thread.sleep(1000);
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Dashboard")).click();

            page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Total Post")).click();
            Thread.sleep(1000);
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Dashboard")).click();

            page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Total Earnings")).click();
            Thread.sleep(1000);
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Dashboard")).click();

            page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Total Contact Request")).click();
            Thread.sleep(1000);
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Dashboard")).click();

            System.out.println("✅  Dashboard");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

