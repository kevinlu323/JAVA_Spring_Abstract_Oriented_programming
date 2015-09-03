package com.linkui.spring;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.*;
import org.dom4j.io.*;

public class ClassPathXmlApplicationContext implements BeanFactory {
	private Map<String, Object> beans = new HashMap<>();

	public ClassPathXmlApplicationContext() throws Exception {
		SAXReader sb = new SAXReader();
		Document doc = sb.read(this.getClass().getClassLoader().getResourceAsStream("bean.xml"));
		Element root = doc.getRootElement();
		List list = root.elements("bean");
		for (int i = 0; i < list.size(); i++) {
			Element element = (Element) list.get(i);
			String id = element.attributeValue("id");
			String clazz = element.attributeValue("class");
			System.out.println(id + ":" + clazz);
			Object o = Class.forName(clazz).newInstance(); // create
			System.out.println(id);
			System.out.println(clazz);
			beans.put(id, o);

			for (Element propertyElement : (List<Element>) element.elements("property")) {
				String name = propertyElement.attributeValue("name");
				String bean = propertyElement.attributeValue("bean");
				Object beanObject = beans.get(bean);

				String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
				System.out.println("method name = " + methodName);

				Method m = o.getClass().getMethod(methodName, beanObject.getClass().getInterfaces()[0]);
				m.invoke(o, beanObject);
			}
		}

	}

	@Override
	public Object getBean(String name) {
		return beans.get(name);
	}

}
