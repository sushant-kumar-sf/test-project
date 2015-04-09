package sushant.struts2.form_submission;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class Form_submit_action {
	
	private String first_name, last_name;
	 
	private File sushant_File;
	private String sushant_FileFileName;
	private String sushant_FileFileContentType;
	private String dest_path="D:/uploaded_files/";
	
	public String execute() throws Exception
	{
		try{
			System.out.println("source file name is:  "+sushant_File);
			System.out.println("destination file name is:  "+ sushant_FileFileName);
			
			File dest_file = new File(dest_path, sushant_FileFileName);
			FileUtils.copyFile(sushant_File, dest_file);
		}
		catch(IOException ioe)
		{
			System.out.println(ioe);
			return "error";
		}
		return "success";
	}
	

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getSushant_FileFileName() {
		return sushant_FileFileName;
	}


	public void setSushant_FileFileName(String sushant_FileFileName) {
		this.sushant_FileFileName = sushant_FileFileName;
	}


	public String getSushant_FileFileContentType() {
		return sushant_FileFileContentType;
	}


	public void setSushant_FileFileContentType(
			String sushant_FileFileContentType) {
		this.sushant_FileFileContentType = sushant_FileFileContentType;
	}


	public File getSushant_File() {
		return sushant_File;
	}


	public void setSushant_File(File sushant_File) {
		this.sushant_File = sushant_File;
	}
	

}
