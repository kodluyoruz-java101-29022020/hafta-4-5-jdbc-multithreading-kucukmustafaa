package db.connection.mysql.connection.service;

import java.util.List;

import db.connection.mysql.connection.dao.ManagerDAO;
import db.connection.mysql.connection.model.Manager;

public class ManagerService {

	private ManagerDAO managerDAO;
	
	public ManagerService(ManagerDAO managerDAO) {
		this.managerDAO = managerDAO;
	}
	
	public List<Manager> getActiveManagers() {
		return managerDAO.loadAllActiveManagers();
	}
	
	
}
