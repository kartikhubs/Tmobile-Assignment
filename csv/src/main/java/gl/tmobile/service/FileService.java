package gl.tmobile.service;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gl.tmobile.entity.Files;
import gl.tmobile.repository.FileRepo;

@Service
public class FileService {
	@Autowired
	private FileRepo repo;

	String line = "";
	static int insertcount = 0;

	public void saveFileData() { // CREATE operation(saving into file database)
		try {
			insertcount++; // this tells how many times save operation has been executed

			File file = new File("src/main/resources/SampleEmployee(4).csv");
			Files obj = new Files();
			int noofrecords = 0;

			Date date = new Date();
			BufferedReader buff = new BufferedReader(new FileReader(file));
			while ((line = buff.readLine()) != null) {

				noofrecords++; // this tells how may rows inserted
				String[] data = line.split(",");

				obj.setFilename(file.getName()); // inseting file object
				obj.setCreateddate(new SimpleDateFormat("E yyyy.MM.dd").format(date));
				obj.setUpdateddate(new SimpleDateFormat("E yyyy.MM.dd HH:MM:SS").format(file.lastModified()));

			}

			obj.setNoofrecords(Integer.toString(noofrecords));
			obj.setInsertcount(Integer.toString(insertcount));
			repo.save(obj);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public boolean checkDuplicate() { // check duplicate api definition
		int flag = 0;
		Set<String> duplicate = new HashSet<>();
		List<Files> filename = repo.findAll();
		for (Files x : filename) {
			if (duplicate.contains(x.getFilename())) {
				flag = 1;
				break;

			} else {
				duplicate.add(x.getFilename());
			}
		}
		if (flag == 1) {
			return true;
		} else {
			return false;
		}

	}

}
