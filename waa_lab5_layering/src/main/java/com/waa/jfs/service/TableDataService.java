package com.waa.jfs.service;

import java.util.ArrayList;

import com.waa.jfs.controller.Name;

public interface TableDataService {
	void deleteRow(Name name);

	String saveName();

	void addName(Name name);

	ArrayList<Name> getNames();

}
