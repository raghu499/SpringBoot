

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

public class HelloWorld {

	public static void main(String[] args) {
		/*  first, get and initialize an engine*/
        VelocityEngine ve = new VelocityEngine();
        ve.init();
        /*  next get the Template  */
        Template t = ve.getTemplate("./src/helloworld.vm");
        /*  create a context and add data */
        VelocityContext context = new VelocityContext();
        context.put("name", "World");
        context.put("raghu", "Raghu from ADS");
        
        /* now render the template into a StringWriter */
        StringWriter writer = new StringWriter();
        t.merge( context, writer );
        /* show the World */
        System.out.println( writer.toString() );     
	}
}
