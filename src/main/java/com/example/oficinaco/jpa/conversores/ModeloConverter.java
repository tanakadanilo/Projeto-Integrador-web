package com.example.oficinaco.jpa.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.oficinaco.jpa.entidade.Modelo;
import com.example.oficinaco.jpa.jsf.ModeloControl;

@FacesConverter(value = "modeloConverter")
public class ModeloConverter implements Converter {

	@Autowired
	ModeloControl modeloControl;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null) {
			return null;
		}
		String nomeModelo = value.substring(0, value.indexOf("-")).trim();
		String nomeMarca = value.substring(value.indexOf("-")).trim();
		return modeloControl.buscar(nomeModelo, nomeMarca);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
			return null;
		}
		Modelo modelo = (Modelo) value;
		return modelo.getNome() + " - " + modelo.getMarca();
	}

}
