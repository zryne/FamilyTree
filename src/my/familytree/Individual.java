package my.familytree;

import java.util.ArrayList;

public class Individual {
	private static int            id;
	private String                name;
	private String                birth;
	private String                death;
	private Individual            father;
	private Individual            mother;
	private ArrayList<Individual> children;
	
	public Individual() {
		Individual.id++;
		name     = "";
		birth    = "";
		death    = "";
		father   = null;
		mother   = null;
		children = null;
	}
	
	public Individual(String dob) {
		Individual.id++;
		name     = "";
		birth    = dob;
		death    = "";
		father   = null;
		mother   = null;
		children = null;
	}
	
	public Individual(String n, String dob) {
		Individual.id++;
		name     = n;
		birth    = dob;
		death    = "";
		father   = null;
		mother   = null;
		children = null;
	}
}
