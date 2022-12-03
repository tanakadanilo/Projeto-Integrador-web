package com.example.oficinaco.jpa.conversores;

import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.oficinaco.jpa.dao.ModeloDao;
import com.example.oficinaco.jpa.entidade.Modelo;
import com.example.oficinaco.jpa.jsf.ModeloControl;

@Component
@SessionScoped
public class ModeloConverter implements Converter {

	@Autowired
	ModeloControl modeloControl;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null) {
			return null;
		}
		return modeloControl.buscar(value);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
			return null;
		}
		Modelo modelo = (Modelo) value;
		return modelo.getNome();
	}

}
