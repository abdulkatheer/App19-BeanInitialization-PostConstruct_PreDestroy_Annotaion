package beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Greeting implements InitializingBean, DisposableBean {
    static {
        System.out.println("Greeting bean class loading...");
    }

    public Greeting() {
        System.out.println("Greeting bean class instantiating...");
    }

    private String name;
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("Initializing 'name' using setName() method...");
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        System.out.println("Initializing 'message' using setMessage() method...");
        this.message = message;
    }

    public void greetUser() {
        System.out.println("Hello " + this.getName() + ". " + this.getMessage());
    }

    @PostConstruct
    public void init1() {
        System.out.println("PostConstruct::init() method called...");
        System.out.println("Initializing 'name' and 'method' using PostConstruct::init() method");
        this.name = "Katheer";
        this.message = "Good Morning! Have a nice day!!";
    }

    @PreDestroy
    public void destroy1(){
        System.out.println("PreDestroy::destroy() method called...");
    }

    public void init2() {
        System.out.println("Custom::init() method called...");
        System.out.println("Initializing 'name' and 'method' using Custom::init() method");
        this.name = "Abdul";
        this.message = "Good Afternoon! Have a good lunch!!";
    }

    public void destroy2() {
        System.out.println("Custom::destroy() method called...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean::destroy() method called...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean::afterPropertiesSet() method called...");
        System.out.println("Initializing 'name' and 'method' using InitializingBean::afterPropertiesSet() method");
        this.name = "Abdul";
        this.message = "Good Evening! Have a Nice tea!!";
    }
}
