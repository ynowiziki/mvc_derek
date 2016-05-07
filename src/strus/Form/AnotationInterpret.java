package strus.Form;


import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import annotation.AnnotationAction;
import annotation.AnnotationConfig;

public class AnotationInterpret {
	
	
	  private static final String PACKAGETOSCAN = "strus.action";

	    private static Map<String, AnotationBean> actionMap = new HashMap<String, AnotationBean>();

	    public static Map<String, AnotationBean> strutsAnotationInterpret() {
	        List<String> classes = new ArrayList<String>();
	        getClasses(classes, null);
	        interpretAction(classes);
	        return actionMap;
	    }

	    private static void getClasses(List<String> classes, String packs) {
	        String classpath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
	        String[] packages = null;
	        if (packs != null) {
	            packages = packs.split(",");
	        } else {
	            packages = PACKAGETOSCAN.split(",");
	        }
	        for (String pack : packages) {
	            File file = new File(classpath + pack.replace(".", "/"));
	            File[] files = file.listFiles();
	            for (File f : files) {
	                String fname = f.getName().substring(0, f.getName().lastIndexOf("."));
	                if (!f.isDirectory()) {
	                    synchronized (classes) {
	                        classes.add(pack + "." + fname);
	                    }
	                } else {
	                    getClasses(classes, pack + "." + fname);
	                }
	            }
	        }
	    }

	    @SuppressWarnings("rawtypes")
	    private static void interpretAction(List<String> classes) {
	        for (String clazzStr : classes) {
	            try {
	                Class cls = Class.forName(clazzStr);
	                if (cls.isAnnotationPresent(AnnotationConfig.class)) {
		                
	                	AnnotationConfig c = (AnnotationConfig)cls.getAnnotation(AnnotationConfig.class);
	                    if (c != null) {
	                    	AnotationBean a = new AnotationBean();
	                        a.setPath(c.path());
	                        a.setActionClass(c.actionClass());
	                        a.setActionType(clazzStr);
	                        a.setFormClass(c.formClass());
	                        
	                        Map<String,String> actionForward = new HashMap();
	                        AnnotationAction[] mapurl = c.mapUrl();
	                        for(int i=0;i<mapurl.length;i++){
	                        	actionForward.put(mapurl[i].name(), mapurl[i].action());
	                        }
	                        a.setActionForward(actionForward);
	                        actionMap.put(c.path(), a);
	                    }
		                
	                }
	            } catch (Exception e) {
	               
	                e.printStackTrace();
	            }
	        }
	    }
	    
	    public static void main(String[] args) {
	    	
	    	Map<String, AnotationBean> testMap = strutsAnotationInterpret();
	    	AnotationBean s = testMap.get("sss");
	    	System.out.print(s.getActionClass());
	    	
	    }

}
