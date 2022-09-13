package gl.tmobile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import gl.tmobile.service.FileService;

@RestController
public class FileController {

	@Autowired
	public FileService fileservice; // Injecting file service layer

	@GetMapping("/checkduplicate") // API FOR CHECKING DUPLICATE FILES OR NOT
	public String checkDuplicate() {
		if (fileservice.checkDuplicate() == true) {
			return "DUPLICATE FILES PRESENT";
		} else {
			return "UNIQUE FILES ARE THERE";

		}
	}

}
