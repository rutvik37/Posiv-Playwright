package com.example;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class profile {

    public void edit_profile(Page page) {

        try {
        
            page.locator("#headlessui-menu-button-1").click();
            page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Edit Profile")).click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save changes")).click(); // Profile Updated
            System.out.println("Profile updated");


            page.locator("#headlessui-menu-button-1").click();
            page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Change Password")).click();
            
            page.getByPlaceholder("Enter old password").fill("Admin@111");
            
            page.getByPlaceholder("Enter new password").fill("Admin@111");
            page.getByPlaceholder("Enter confirm password").fill("Admin@111");

            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save changes")).click();
            Thread.sleep(3000);

            page.getByPlaceholder("Enter old password").fill("Admin@111");

   
            page.getByPlaceholder("Enter new password").fill("Admin@222");
    
            page.getByPlaceholder("Enter confirm password").fill("Admin@222");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save changes")).click();
            System.out.println("Password change to Admin@222");
            Thread.sleep(3000);
            
            page.locator("#headlessui-menu-button-1").click();
          
            page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Change Password")).click();
            page.getByPlaceholder("Enter old password").fill("Admin@222");
    
            page.getByPlaceholder("Enter confirm password").fill("Admin@111");
          
            page.getByPlaceholder("Enter new password").fill("Admin@111");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save changes")).click();
            System.out.println("Password change to Admin@111");
            Thread.sleep(3000);

            page.locator("#headlessui-menu-button-1").click();
            page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Log Out")).click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Yes, Log Me Out!")).click(); // logout functionality

            page.getByPlaceholder("Enter Email").fill("admin@posiv.com");
            page.getByPlaceholder("Enter Password").fill("Admin@111");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log in")).click(); // login again
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Dashboard")).click(); // dashboard


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
