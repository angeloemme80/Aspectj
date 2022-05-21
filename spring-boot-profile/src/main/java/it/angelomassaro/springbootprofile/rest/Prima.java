package it.angelomassaro.springbootprofile.rest;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.angelomassaro.springbootprofile.annotazioni.MyAnnotation;

@RestController
public class Prima {

	    @Value("${mia.proprieta}")
	    private String miaProprieta;
	    @MyAnnotation(value = "PRIMO", operazione = "VISUALIZZAZIONE")
	    @GetMapping("/primo")
	    @ResponseBody
	    public Map<String, Object> primo(@RequestHeader MultiValueMap<String, String> headers) {
	        Map<String, Object> data = new HashMap<String, Object>();
	        Map<String, Object> dataMap = new HashMap<String, Object>();
	        
	        dataMap.put("primo","PRIMO REST");
	        dataMap.put("miaProprieta",miaProprieta);
	        
	        data.put("data", dataMap);
	        return data;
	    }
	    
	    @MyAnnotation(value = "SECONDO", operazione = "DOWNLOAD")
	    @GetMapping("/secondo")
	    @ResponseBody
	    public Map<String, Object> secondo(@RequestHeader MultiValueMap<String, String> headers, @RequestParam(name = "p") String parametro) {
	        
	    	//this.leggiAnnotazione();
	    	
	    	Map<String, Object> data = new HashMap<String, Object>();
	        Map<String, Object> dataMap = new HashMap<String, Object>();
	        
	        dataMap.put("primo","SECONDO REST");
	        dataMap.put("miaProprieta",parametro);
	        
	        data.put("data", dataMap);
	        return data;
	    }
	    
	    private void leggiAnnotazione() {
	    	// Using reflection, get the public method "testDefaults", which is this method with no args
	        Method method;
			try {
				method = Prima.class.getMethod("secondo", MultiValueMap.class ,String.class);
				
				// Fetch the Annotation that is of type MyAnnotation from the Method
		        MyAnnotation annotation = (MyAnnotation)method.getAnnotation(MyAnnotation.class);

		        // Print out the settings of the Annotation
		        System.out.println(annotation.value());
		        
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        
	    }
	    
}
