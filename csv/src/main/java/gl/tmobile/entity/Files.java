package gl.tmobile.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "filediary")
public class Files {

	// data members
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String filename;
	private String insertcount;
	private String noofrecords;
	private String createddate;
	private String updateddate;

	// getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getInsertcount() {
		return insertcount;
	}

	public void setInsertcount(String insertcount) {
		this.insertcount = insertcount;
	}

	public String getNoofrecords() {
		return noofrecords;
	}

	public void setNoofrecords(String noofrecords) {
		this.noofrecords = noofrecords;
	}

	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	public String getUpdateddate() {
		return updateddate;
	}

	public void setUpdateddate(String updateddate) {
		this.updateddate = updateddate;
	}

	// parameterized constructor
	public Files(Long id, String filename, String insertcount, String noofrecords, String createddate,
			String updateddate) {
		super();
		this.id = id;
		this.filename = filename;
		this.insertcount = insertcount;
		this.noofrecords = noofrecords;
		this.createddate = createddate;
		this.updateddate = updateddate;
	}

	// default constructor
	public Files() {
		super();
	}

}
