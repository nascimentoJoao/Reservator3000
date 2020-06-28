package edu.pucrs.verval.data;

import java.util.HashMap;

import edu.pucrs.verval.entities.Collaborator;

public class CollaboratorGen {
	//Testing Sonar
	private HashMap<Integer, Collaborator> collaborators;
	private HashMap<Integer, Double> collaborator_cost;
	
	public static CollaboratorGen instance = new CollaboratorGen();

	public CollaboratorGen() {
		this.collaborators = new HashMap<>();
		this.collaborator_cost = new HashMap<>();
		
		for(int i = 0; i <= 10; i++) {
			this.collaborator_cost.put(i, 0.0);
		}
		
		this.collaborators.put(1, new Collaborator(1,  "12345",  "Chiara Paskulin",     "chiara.paskulin@mail.com"));
		this.collaborators.put(2, new Collaborator(2,  "56931",  "Guilherme Munaretto", "guilherme.muna@mail.com"));
		this.collaborators.put(3, new Collaborator(3,  "93750",  "Henrique Kops",       "henrique.kops@mail.com"));
		this.collaborators.put(4, new Collaborator(4,  "48513",  "Rodrigo Mello",       "rodrigo.mello@mail.com"));
		this.collaborators.put(5, new Collaborator(5,  "82941",  "Larissa Salerno",     "lari.salerno@mail.com"));
		this.collaborators.put(6, new Collaborator(6,  "93859",  "João Nascimento",     "joao.nascimento@mail.com"));
		this.collaborators.put(7, new Collaborator(7,  "11404",  "Tiago Ferracini",     "tiago.ferracini@mail.com"));
		this.collaborators.put(8, new Collaborator(8,  "39512",  "Alexandre Agusteto",  "alexandre.agusteto@mail.com"));
		this.collaborators.put(9, new Collaborator(9,  "22415",  "Avelino Arrozo",      "avelino.arrozo@mail.com"));
		this.collaborators.put(10, new Collaborator(10, "91852",  "Eduardo Zoruda",      "eduardo.zoruda@mail.com"));
	}
	
	public HashMap<Integer, Collaborator> getCollaborators() {
		return this.collaborators;
	}
	
	public HashMap<Integer, Double> getCollaboratorCost() {
		return this.collaborator_cost;
	}
	
	public static CollaboratorGen getInstance() {
		return instance;
	}
}
