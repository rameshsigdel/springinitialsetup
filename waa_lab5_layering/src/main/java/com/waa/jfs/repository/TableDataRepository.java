package com.waa.jfs.repository;

import java.util.ArrayList;

import com.waa.jfs.controller.Name;

public interface TableDataRepository {

	public ArrayList<Name> getNames();
	public void saveName();
	public void deleteRow(Name nameToDelete);
	public void addName(Name name);
}
