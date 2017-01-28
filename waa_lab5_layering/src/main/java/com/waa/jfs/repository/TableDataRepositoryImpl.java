package com.waa.jfs.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import com.waa.jfs.controller.Name;

public class TableDataRepositoryImpl implements TableDataRepository, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private ArrayList<Name> names = new ArrayList<Name>(Arrays.asList(
		      new Name("Anna", "Keeney"),
		      new Name("John", "Wilson"),
		      new Name("Mariko", "Randor"),
		      new Name("William", "Dupont")
		   ));
	
	@Override
	public ArrayList<Name> getNames() {
		return names;
	}
	
	@Override
	public void saveName() {
		for (Name name : names)
			name.setEditable(false);
	}
	
	@Override
	public void deleteRow(Name nameToDelete) {
		names.remove(nameToDelete);
		
	}
	
	@Override
	public void addName(Name name) {

		names.add(name);
		
	}

}
