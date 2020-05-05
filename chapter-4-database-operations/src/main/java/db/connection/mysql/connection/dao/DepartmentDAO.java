package db.connection.mysql.connection.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import db.connection.mysql.connection.DbSQLQuery;
import db.connection.mysql.connection.model.Department;


public class DepartmentDAO {

	private static final Logger logger = Logger.getLogger(DepartmentDAO.class);

	
	public List<Department> getAll() {
		
		List<Department> departments = new ArrayList<Department>();
		
		// Tüm departman listesini çeken SQL komutunu aşağıdaki satıra yazınız.
		ResultSet resultSet = DbSQLQuery.select("select * from departments");
		
		try {
			if (resultSet==null) {
				return departments;
			}
			else {
				while (resultSet.next()) {
					departments.add(separateResutlt(resultSet));
				}
			}
			
			
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return departments;
	}
	
	public static Department separateResutlt(ResultSet resultSet) throws SQLException {
		String dept_no=resultSet.getString("dept_no");
		String dept_name=resultSet.getString("dept_name");
		
		return new Department(dept_no, dept_name);
		
	}
	
	
	
	
}
