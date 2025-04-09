package com.example;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class edit_profile {

    public void edit_profile(Page page) {

        try {
        
            page.locator("#headlessui-menu-button-1").click();
            page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Edit Profile")).click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save changes")).click();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
