package gl.tmobile.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import gl.tmobile.service.EmpService;
import gl.tmobile.service.FileService;

@RestController
public class EmpController {
	@Autowired
	private EmpService empservice; // Injecting employee service layer

	@Autowired
	FileService fileservice;

	@PostMapping("/POST") // API FOR SAVING FILES INTO THE DATABASE
	public void setvalues() {

		empservice.saveEmpdata();
		fileservice.saveFileData();

	}

	@GetMapping("/validatefile") // calling validate api
	public String validateData() throws NumberFormatException, IOException {
		if (empservice.validateFile()) {
			return "File data invalid";
		} else {
			return "File data valid";
		}

	}

}
