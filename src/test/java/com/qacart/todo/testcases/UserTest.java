package com.qacart.todo.testcases;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.models.User;
import com.qacart.todo.pages.RegisterPage;
import com.qacart.todo.pages.TodoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserTest extends BaseTest {

    @Test(description = "Should be able to signup")
    public void shouldBeAbleToRegisterToTheApplication() {
        User user = new User();
        RegisterPage.getInstance().load(driver.get());
        RegisterPage.getInstance().register(driver.get(), user);
        boolean isWelcomeDisplayed =  TodoPage.getInstance().isWelcomeMessageDisplayed(driver.get());
        Assert.assertTrue(isWelcomeDisplayed);
    }
}
