package com.example.oficinaco.jpa;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.oficinaco.jpa.dao.MunicipioDao;
import com.example.oficinaco.jpa.entidade.EnumUf;
import com.example.oficinaco.jpa.entidade.Municipio;
import com.example.oficinaco.jpa.jsf.MunicipioControl;

public class temp {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		try (BufferedReader br = new BufferedReader(
				new FileReader("src\\main\\java\\com\\example\\oficinaco\\jpa\\municipios.txt"))) {

			String linha = br.readLine();
			String[] dados = new String[1];

			MunicipioControl municipioDao = new MunicipioControl();
			// Nome Municipio
			// código IBGE
			// código IBGE 2?
			// Sigla Estado
			linha = br.readLine();
			while (linha != null) {
				dados = linha.split(";");
				Municipio m = new Municipio();
				m.setNome(dados[0].substring(2));
				m.setCodigoIbge(Integer.parseInt(dados[1]));
				m.setUf(Enum.valueOf(EnumUf.class, dados[3]));
				municipioDao.setMunicipio(m);
				municipioDao.salvar();
				linha = br.readLine();
			}

		}
	}
}
