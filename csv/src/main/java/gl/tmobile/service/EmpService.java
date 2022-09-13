package gl.tmobile.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gl.tmobile.entity.Employee;
import gl.tmobile.entity.Files;
import gl.tmobile.repository.EmpRepo;

@Service
public class EmpService {
	@Autowired
	private EmpRepo repository;

	public void saveEmpdata() { // CREATE operation(saving into employee db)
		try {
			String line = "";
			BufferedReader buff = new BufferedReader(new FileReader("src/main/resources/SampleEmployee(4).csv"));
			line = buff.readLine(); // This is required to skip the headers(First Name, MiddleName, Last Name, Age,
									// Salary, EmailID)
			while ((line = buff.readLine()) != null) {

				String[] data = line.split(",");

				Employee emp = new Employee();
				Files file = new Files();
				emp.setFirstname(data[0]);
				emp.setMiddlename(data[1]);
				emp.setLastname(data[2]);
				emp.setAge(data[3]);
				emp.setSalary(data[4]);
				emp.setEmail(data[5]);
				repository.save(emp);

			}

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public boolean validateFile() { // validate api definition
		int flag = 0;

		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		List<Employee> emplist = repository.findAll();
		for (Employee x : emplist) {
			Matcher matcher = pattern.matcher(x.getEmail());
			if (x.getFirstname().isEmpty() || x.getLastname().isEmpty()
					|| Integer.parseInt(x.getAge()) < Integer.parseInt("20") || matcher.matches() == false) {
				flag = 1;
				break;

			} else {
				flag = 0;
			}

		}
		if (flag == 1) {
			return true;
		} else {
			return false;
		}

	}
}
