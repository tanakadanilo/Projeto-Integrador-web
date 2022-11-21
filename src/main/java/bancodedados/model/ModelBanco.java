package bancodedados.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class ModelBanco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;

	
	public ModelBanco() {
		super();
	}

	public ModelBanco(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}