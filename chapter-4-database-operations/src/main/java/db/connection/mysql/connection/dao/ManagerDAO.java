package db.connection.mysql.connection.dao;

import java.beans.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import db.connection.mysql.connection.DbSQLQuery;
import db.connection.mysql.connection.model.Department;
import db.connection.mysql.connection.model.Employee;
import db.connection.mysql.connection.model.Manager;

public class ManagerDAO {

	

	public List<Manager> loadAllActiveManagers() {
		

		List<Manager> managers = new ArrayList<Manager>();
		
		try {
			ResultSet resultSet=DbSQLQuery.select("select dept.dept_name ,emp.* ,deptM.*  \n" + 
					"from employees emp \n" + 
					"left join dept_manager deptM on emp.emp_no = deptM.emp_no \n" + 
					"left join departments dept  on deptM.dept_no = dept.dept_no \n" + 
					"where deptM.to_date >= NOW() \n");
			
			if (resultSet==null) {
				return managers;
			}
			else {
				while (resultSet.next()) {
					managers.add(separateAndCreateManager(resultSet));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Burada halen aktif olarak yöneticilik yapan tüm çalışanları departman isimleriyle birlikte liste halinde hazırlayınız.
		// Manager sınıfını sizin oluşturdum. 
		// İpucu: Bu sorgunun bir benzerini derste anlatmıştım. Hatta "sql_query_samples.sql" dosyası içinde benzeri mevcut.
		
		return managers;
	}
	
	public static Manager separateAndCreateManager(ResultSet resultSet) throws SQLException {
		
		String dept_name=resultSet.getString("dept_name");
		Employee employee=new Employee();
		employee.setId(resultSet.getLong("emp_no"));
		employee.setName(resultSet.getString("first_name"));
		employee.setLastName(resultSet.getString("last_name"));
		employee.setGender(resultSet.getString("gender"));
		employee.setHireDate(resultSet.getDate("hire_date"));
		employee.setBirthDate(resultSet.getDate("birth_date"));
		Manager manager=new Manager(employee, dept_name);

		return manager;

	}
	
	
}
