package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.models.User;
import com.qacart.todo.pages.NewTodoPage;
import com.qacart.todo.pages.RegisterPage;
import com.qacart.todo.pages.TodoPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TodoTest extends BaseTest {
    @Test(description = "Should be able to add a todo")
    public void shouldBeAbleToAddATodo() {
        User user = new User();
        RegisterPage.getInstance().load(driver.get());
        RegisterPage.getInstance().registerUsingApi(driver.get(), user);
        TodoPage.getInstance().clickOnPlusButton(driver.get());
        NewTodoPage.getInstance().addTodo(driver.get(), "Learn Selenium");
        String text =  TodoPage.getInstance().getTodoText(driver.get());
        Assert.assertEquals(text,"Learn Selenium");
    }

    @Test(description = "Should be able to delete a todo")
    public void shouldBeAbleToDeleteATodo() {
        User user = new User();
        RegisterPage.getInstance().load(driver.get());
        RegisterPage.getInstance().registerUsingApi(driver.get(), user);
        NewTodoPage.getInstance().addTodoUsingApi(user, "Learn Selenium");
        TodoPage.getInstance().load(driver.get());
        TodoPage.getInstance().deleteTodo(driver.get());
        boolean isNoTodosDisplayed =  TodoPage.getInstance().isNoTodoMessageDisplayed(driver.get());
        Assert.assertTrue(isNoTodosDisplayed);
    }
}
