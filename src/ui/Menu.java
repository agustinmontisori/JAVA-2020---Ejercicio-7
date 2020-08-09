package ui;

import java.util.LinkedList;
import java.util.Scanner;

import entities.*;
import logic.Login;

public class Menu {
	Scanner s = null;
	Login ctrlLogin = new Login();

	public void start() {
		s = new Scanner(System.in);
		Persona p = login();
		System.out.println("Bienvenido " + p.getNombre() + " " + p.getApellido());
		System.out.println();

		String command;
		do {
			command = getCommand();
			executeCommand(command);
			System.out.println();

		} while (!command.equalsIgnoreCase("exit"));

		s.close();
	}

	private void executeCommand(String command) {
		switch (command) {
		case "list":
			System.out.println(ctrlLogin.getAll());
			break;
		case "find":
			System.out.println(find());
			break;
		case "search":
			System.out.println(ctrlLogin.getByApellido(search()));
			break;
		case "new":
			System.out.println();
			ctrlLogin.add(insertPersona());
			break;
		case "edit":
			System.out.println();
			ctrlLogin.edit(editPersona());
			break;
		case "delete":
			System.out.println();
			ctrlLogin.remove(removePersona());
			break;
		default:
			break;
		}
	}

	private String getCommand() {
		System.out.println("Ingrese el comando segÃºn la opciÃ³n que desee realizar");
		System.out.println("list\t\tlistar todos");
		System.out.println("find\t\tbuscar por tipo y nro de documento"); // solo debe devolver 1
		System.out.println("search\t\tlistar por apellido"); // puede devolver varios
		System.out.println("new\t\tcrea una nueva persona y asigna un rol existente"); // 1) el add no incluye la parte de roles
		System.out.println("edit\t\tbusca por tipo y nro de documento y actualiza todos los datos");// 3)completo
		System.out.println("delete\t\tborra por tipo y nro de documento");// 4)completo
		System.out.println();
		System.out.print("comando: ");
		return s.nextLine();
	}

	public Persona login() {
		Persona p = new Persona();

		System.out.print("Email: ");
		p.setEmail(s.nextLine());

		System.out.print("password: ");
		p.setPassword(s.nextLine());

		p = ctrlLogin.validate(p);

		return p;

	}

	private Persona find() {
		System.out.println();
		Persona p = new Persona();
		Documento d = new Documento();
		p.setDocumento(d);
		System.out.print("Tipo doc: ");
		d.setTipo(s.nextLine());

		System.out.print("Nro doc: ");
		d.setNro(s.nextLine());

		return ctrlLogin.getByDocumento(p);
	}

	
	private Persona search() {
		System.out.println(); 
		Persona p=new Persona();
		System.out.println("Ingrese Apellido: ");
		p.setApellido(s.nextLine());
	  
	  return p;
	  
	  }
	
	private Persona insertPersona() {
		System.out.println();
		Persona p=new Persona();
		Documento d = new Documento();	
		p.setDocumento(d);
		
		System.out.print("Tipo doc: ");
		d.setTipo(s.nextLine());

		System.out.print("Nro doc: ");
		d.setNro(s.nextLine());
		
		p.setDocumento(d);
		
		System.out.print("Nombre: ");
		p.setNombre(s.nextLine());
		
		System.out.print("Apellido: ");
		p.setApellido(s.nextLine());
		
		System.out.print("email: ");
		p.setEmail(s.nextLine());
		
		System.out.print("Password: ");
		p.setPassword(s.nextLine());

		System.out.print("telefono: ");
		p.setTel(s.nextLine());

		System.out.print("¿Esta habilitado?: ");
		p.setHabilitado(Boolean.parseBoolean(s.nextLine()));
				
	return p;
	
	}
	
	private Persona editPersona() {
		System.out.println(); 
		Persona p=new Persona();
		Documento d = new Documento();	
		System.out.println("Ingrese Id de persona a editar: ");
		p.setId(Integer.parseInt(s.nextLine()));
	  
		System.out.print("Tipo doc: ");
		d.setTipo(s.nextLine());

		System.out.print("Nro doc: ");
		d.setNro(s.nextLine());
		
		p.setDocumento(d);
		
		System.out.print("Nombre: ");
		p.setNombre(s.nextLine());
		
		System.out.print("Apellido: ");
		p.setApellido(s.nextLine());
		
		System.out.print("email: ");
		p.setEmail(s.nextLine());
		
		System.out.print("Password: ");
		p.setPassword(s.nextLine());

		System.out.print("telefono: ");
		p.setTel(s.nextLine());

		System.out.print("¿Esta habilitado?: ");
		p.setHabilitado(Boolean.parseBoolean(s.nextLine()));
		
		
	return p;
	
	}
	
	private Persona removePersona() {

		System.out.println(); 
		Persona p=new Persona();
		System.out.println("Ingrese Id a eliminar: ");
		p.setId(Integer.parseInt(s.nextLine()));	
	
	return p;
	
	}
}
