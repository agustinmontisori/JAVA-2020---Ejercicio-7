package logic;

import java.util.LinkedList;

import data.*;
import entities.*;

public class Login {
	private DataPersona dp;
	
	public Login() {
		dp=new DataPersona();
	}
	
	public Persona validate(Persona p) {
		/* para hacer mas seguro el manejo de passwords este sera un lugar 
		 * adecuado para generar un hash de la password utilizando un cifrado
		 * asimetrico como sha256 y utilizar el hash en lugar de la password en plano 
		 */
		return dp.getByUser(p);
	}

	public LinkedList<Persona> getAll(){
		return dp.getAll();
	}

	public Persona getByDocumento(Persona per) {
		return dp.getByDocumento(per);
	}
		
	public LinkedList<Persona> getByApellido(Persona perApe) {
		return dp.getByApellido(perApe);
	}
	
	public void add(Persona perIns) {
		dp.add(perIns);
		return;
	}
	
	public void edit(Persona perEd) {
		dp.edit(perEd);
		return;
	}
	public void remove(Persona perRem) {
		dp.remove(perRem);
		return;
	}	
	
}
