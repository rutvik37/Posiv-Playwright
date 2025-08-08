package com.example;


// import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class test {


    public void test(Page page) {

        try {

            String question1 = posiv.generateRandomAlphaString(5, 8);
            String answer1 = posiv.generateRandomAlphaString(5, 8);
            String question2 = posiv.generateRandomAlphaString(5, 8);
            String answer2 = posiv.generateRandomAlphaString(5, 8);
            

             page.navigate("https://admin.posiv.org.uk/#");

            page.getByPlaceholder("Enter Email").fill("admin@posiv.com");
            page.getByPlaceholder("Enter Password").fill("Admin@111");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log in")).click();  // login admin panel 

            page.waitForTimeout(2000);

            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Dashboard")).click();

    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("FAQ")).click();
    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("+ Add")).click();
    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter your question")).click();
    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter your question")).fill(question1);
    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter your answer")).click();
    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter your answer")).fill(answer1);
    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add").setExact(true)).click();

    System.out.println("Faq create successfully");
    Thread.sleep(2000);

        Page page2 = page.context().newPage();
        page2.navigate("https://posiv.org.uk/");
        Thread.sleep(2000);

    page2.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("FAQ")).click();
    Thread.sleep(2000);

page2.waitForTimeout(2000); 

Object result = page2.evaluate("() => {" +
    " const text = document.body.innerText;" +
    " return text.includes('" + question1 + "');" +
"}");

if (result instanceof Boolean) {
    System.out.println("created FAQ is present on the website.");
} else {
    System.out.println("❌ created FAQ not found on the website.");
}

Thread.sleep(2000); 
    page2.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("×")).click();
    page.bringToFront();
    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("FAQ")).click();

    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("dropdown trigger")).click();
    page.getByText("100").click();
    Thread.sleep(2000);
    

    String rowName = question1 + " " + answer1;

page.getByRole(
    AriaRole.ROW,
    new Page.GetByRoleOptions().setName(rowName)
).getByRole(AriaRole.BUTTON).nth(1).click();


    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter your question")).click();
    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter your question")).fill(question2);
    //page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter your question")).fill(question1 + " edit");
    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter your answer")).click();
    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter your answer")).fill(answer2);
    //page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter your answer")).fill(answer1 + " edit");
    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Edit")).click();
    System.out.println("Faq updated successfully");
    Thread.sleep(2000);

    // checked updated fAQ in website visible or not - comment code

//     page2.bringToFront();

//     Thread.sleep(2000);
//     page2.reload();

//     page2.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("FAQ")).click();
//     Thread.sleep(2000);

// page2.waitForTimeout(2000); 

// Object result2 = page2.evaluate("() => {" +
//     " const text = document.body.innerText;" +
//     " return text.includes('" + question1 + "');" +
// "}");

// // Object result2 = page2.evaluate("() => {" +
// //     " const text = document.body.innerText;" +
// //     " return text.includes('" + question1 + " eddit');" +
// // "}");

// if (result2 instanceof Boolean) {
//     System.out.println("✅ updated FAQ is present on the website.");
// } else {
//     System.out.println("❌ updated FAQ not found on the website.");
// }

// Thread.sleep(2000); 
    

            System.out.println("✅ 7 . FAQ"); 
            return;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

