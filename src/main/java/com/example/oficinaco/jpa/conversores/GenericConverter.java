package com.example.oficinaco.jpa.conversores;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.springframework.stereotype.Component;


@Component
@FacesConverter("converter")
public class GenericConverter implements Converter{

	private static Map<String, Object> mapaObj = new HashMap<>();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return mapaObj.get(value);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		try {
			Field field = value.getClass().getDeclaredField("id");
			field.setAccessible(true);
			Object id = field.get(value);
			String key = String.format("%s:%s", value.getClass().getName(), id.toString());
			mapaObj.put(key, value);
			return key;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
