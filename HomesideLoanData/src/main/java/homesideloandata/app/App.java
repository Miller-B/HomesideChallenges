/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homesideloandata.app;

import homesideloandata.controller.SalesDataController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author BMMil
 */
public class App {
    
     public static void main(String[] args) {

        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("applicationContext.xml");

        SalesDataController controller = ctx.getBean("controller",
                SalesDataController.class);
        controller.run();

    }
    
}
