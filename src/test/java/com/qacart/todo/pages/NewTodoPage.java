package com.qacart.todo.pages;

import com.qacart.todo.apis.TodoApi;
import com.qacart.todo.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewTodoPage {

    private static NewTodoPage newTodoPage;

    // Elements
    private final By newTodoInput = By.cssSelector("[data-testid=\"new-todo\"]");
    private final By newTodoSubmit = By.cssSelector("[data-testid=\"submit-newTask\"]");

    // Constructor
    private NewTodoPage() {}

    public static NewTodoPage getInstance() {
        if(newTodoPage == null) {
            newTodoPage = new NewTodoPage();
        }
        return  newTodoPage;
    }

    // Method, Steps
    public void addTodo(WebDriver driver, String item) {
        driver.findElement(newTodoInput).sendKeys(item);
        driver.findElement(newTodoSubmit).click();
    }

    public void addTodoUsingApi(User user, String item) {
        TodoApi.getInstance().addTodo(user, item);
    }

}
