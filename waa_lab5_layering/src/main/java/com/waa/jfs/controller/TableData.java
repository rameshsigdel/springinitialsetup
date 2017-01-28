package com.waa.jfs.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.waa.jfs.service.TableDataService;

@Named("tableData")
@SessionScoped
public class TableData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	TableDataService tableDataService;
	/*
	 * private List<Name> names = new ArrayList<>();
	 * 
	 * public TableData() { names.add(new Name("William", "Dupont"));
	 * names.add(new Name("Anna", "Keeney")); names.add(new Name("Mariko",
	 * "Randor")); names.add(new Name("John", "Wilson")); }
	 */
	Name name = new Name();

	public Name getName() {
		return this.name;
	}

	public List<Name> getNames() {
		return tableDataService.getNames();
	}

	public String saveName() {
		tableDataService.saveName();
		return null;
	}

	public String deleteRow(Name nameToDelete) {
		tableDataService.deleteRow(nameToDelete);
		return null;
	}

	public Name getItem() {
		return this.name;
	}

	public String addName() {

		tableDataService.addName(this.name);

		name = new Name();

		return "index";
	}
}
