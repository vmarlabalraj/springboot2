package com.javainterviewpoint;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;


public interface DocumentDao {
	public List<Document> getDocumentList();
	public void deleteFile(String id);
	public Document getDocumentDetails(String id);
	public Document getDocumentDetailsByLocation(String fileName);
	public void updateDocumentDetails(Document doc, String filetype);
	public Map<String, String> getFileTypeMap();

	
}