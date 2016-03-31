package strus.Form;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;




public class xmlInterpret {
	
	public xmlInterpret() {
		
	}
	
	public static Map<String, xmlBean> interpret(String path) throws Exception {
		SAXBuilder build = new SAXBuilder();
		Document document = build.build(new File(path));
		Element root = document.getRootElement();
		Map<String, xmlBean> rmap = new HashMap<String, xmlBean>();
		
		Element actionRoot = root.getChild("action-mapping");
		List<Element> actions = actionRoot.getChildren();
		xmlBean xmlObj = new xmlBean();
		
		for(Element e: actions) {
			String name = e.getAttributeValue("name");
			Element actionForm = root.getChild("formbeans");
			List<Element> forms = actionForm.getChildren();
			for(Element elmt: forms) {
				if(name.equals(elmt.getAttributeValue("name"))) {
					String className = elmt.getAttributeValue("class");
					xmlObj.setActionClass(className);
					break;
				}
			xmlObj.setBeanName(name);
			String type = e.getAttributeValue("type");
			xmlObj.setActionType(type);
			String urlpath = e.getAttributeValue("path");
		    xmlObj.setPath(urlpath);
		    
		    List<Element> forwardVal = e.getChildren();
		    Map<String, String> fwdMap = new HashMap<String, String>();
			for(Element e1: forwardVal) {
				String name1 = e1.getAttributeValue("name");
				String value = e1.getAttributeValue("value");	
				fwdMap.put(name1, value);
			}
			xmlObj.setActionForward(fwdMap);
			rmap.put(path, xmlObj);
		}
	  }
		return rmap;
			
			
	}

}
