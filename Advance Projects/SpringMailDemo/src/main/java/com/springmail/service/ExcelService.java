package com.springmail.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springmail.entity.Recipient;

@Service
public class ExcelService 
{
	public List<Recipient> readExcelFile(MultipartFile file) 
			throws Exception, IOException
	{
//		to store data, create an arraylist
		List<Recipient> recipients = new ArrayList<Recipient>();
		
		
		try(Workbook workbook = WorkbookFactory.create(file.getInputStream()))
		{
			Sheet sheet = workbook.getSheetAt(0);
			
			DataFormatter formatter = new DataFormatter();
			
			for(int i=1; i<=sheet.getLastRowNum();i++)
			{
				Row row = sheet.getRow(i);
				
				if(row==null)
					continue;
				
				String name = formatter.formatCellValue(row.getCell(0)).trim();
				
				String email = formatter.formatCellValue(row.getCell(1)).trim();
				
				if(!name.isEmpty() && !email.isEmpty())
				{
					System.out.println("Name : "+name+"\tEmail : "+email);
					recipients.add(new Recipient(name, email));
				}
			}
		}
		return recipients;
	}
}
// to read data from the excel file and putmdata in properformat
// so that we can send email to multiple people.
