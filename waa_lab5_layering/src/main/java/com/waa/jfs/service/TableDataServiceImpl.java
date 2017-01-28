package com.waa.jfs.service;

import java.io.Serializable;
import java.util.ArrayList;

import javax.inject.Inject;

import com.waa.jfs.controller.Name;
import com.waa.jfs.repository.TableDataRepository;

public class TableDataServiceImpl implements  TableDataService, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private TableDataRepository tableDataRepository;
	
	@Override
	public void deleteRow(Name name) {
		tableDataRepository.deleteRow(name);

	}

	@Override
	public String saveName() {
		tableDataRepository.saveName();
		return null;
	}

	@Override
	public void addName(Name name) {
		tableDataRepository.addName(name);

	}

	@Override
	public ArrayList<Name> getNames() {
		return tableDataRepository.getNames();
		
	}

}
