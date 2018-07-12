package br.com.flexvision.main;

import org.apache.camel.spring.Main;
import org.apache.camel.main.MainListenerSupport;
import org.apache.camel.main.MainSupport;

public class StartCamel {

	private Main main;
	 
    public static void main(String[] args) throws Exception {
        StartCamel example = new StartCamel();
        example.boot();
    }
 
    public void boot() throws Exception {
        // create a Main instance
        main = new Main();
        // Criação de listener
        main.addMainListener(new Events());
        // run until you terminate the JVM
        System.out.println("Starting Camel. Use ctrl + c to terminate the JVM.\n");
        main.run();
    }
 
    public static class MyBean {
        public void callMe() {
            System.out.println("MyBean.callMe method has been called");
        }
    }
 
    public static class Events extends MainListenerSupport {
 
        @Override
        public void afterStart(MainSupport main) {
            System.out.println("StartCamel with Camel is now started!");
        }
 
        @Override
        public void beforeStop(MainSupport main) {
            System.out.println("StartCamel with Camel is now being stopped!");
        }
    }
    
}
