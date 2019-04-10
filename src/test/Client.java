package test;

import beans.Greeting;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        /*
        Order of execution:
        -------------------
        1. Bean class loading
        2. Bean class instantiation
        3. Initialization through property tag (i.e. through setter methods)
        4. Initialization through PostConstruct annotation's init() method
        5. Initialization through InitializingBean::afterPropertiesSet() method
        6. Initialization through Custom::init() method
        7. PreDestroy annotation's destroy() method
        8. DisposableBean:: destroy() method
        9. Custom::destroy() method
         */

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("resources/applicationContext.xml");
        Greeting g = (Greeting) context.getBean("greeting");
        g.greetUser();
        context.registerShutdownHook();
    }
}
