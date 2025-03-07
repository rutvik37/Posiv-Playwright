package com.example;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class posiv {
    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://admin.posiv.org.uk/#");

            page.getByPlaceholder("Enter Email").fill("admin@posiv.com");
            page.getByPlaceholder("Enter Password").fill("Admin@121");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log in")).click(); 



            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Dashboard")).click();
      page.locator("#headlessui-menu-button-1").click();
      page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Edit Profile")).click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save changes")).click();
      page.locator("#headlessui-menu-button-1").click();
      page.getByLabel("").click();
      page.getByLabel("Close").click();


      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Customers").setExact(true)).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Reported Customers")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Advertisement")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Posts")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Reported Content")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Report Reasons")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Document Verification")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Directory Services")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Story Stickers")).click();
     
      
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Leader Board")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Joining Waitlist")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Survey Records")).click();
    
      page.getByText("DashboardCustomersReported").click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Survey Records")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Earnings")).click();
      
     
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Manage Subadmin")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Send Notification")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Contact Us")).click();
      
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("FAQ")).click();
      page.getByText("DashboardCustomersReported").click();
      
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("CMS")).click();
      
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("About Us")).click();
      //page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("About Us")).press("ArrowDown");
      
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Privacy Policy")).click();
   
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Terms & Condition")).click();
      
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Why Posiv")).click();

      page.locator("#headlessui-menu-button-1").click();
      page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Log Out")).click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Yes, Log Me Out!")).click();

            

        
            // try {d
            //     Thread.sleep(5000);
            // } catch (Exception e) {

            // }

            playwright.close();
            browser.close();

        }

    }
}