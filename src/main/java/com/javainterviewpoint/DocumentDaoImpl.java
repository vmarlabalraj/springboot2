package com.javainterviewpoint;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
@Component(value = "DocumentDAO")
public class DocumentDaoImpl  implements DocumentDao {

	private static final Logger logger = LoggerFactory(DocumentDaoImpl.class);
    private String userName;
	@Autowired
	protected Properties sqlProperties;
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	@Autowired
	protected JdbcTemplate jdbcRegTemplate;
	public List<Document> getDocumentList() {
		List<String> documentlist = new ArrayList<String>();
		List<Document> doculist = new ArrayList<Document>();
		try {
			List<String> docList = null;
			String filename=null;
			Stream<Path> walk = Files.walk(Paths.get("C:\\Users\\Vasudev\\Desktop\\changedfiles"));
			docList = walk.filter(Files::isRegularFile).map(x -> x.toString()).collect(Collectors.toList());
			documentlist.addAll(docList);
			for (String doc : docList) {
				String filetype = FilenameUtils.getExtension(doc);
				String filenamewithext = FilenameUtils.getName(doc);
				String filecode = "";
				int index = filenamewithext.lastIndexOf(".");
				if(index!=-1) {
				 filename = filenamewithext.substring(0, index);
				}
				else {
				 filename=filenamewithext;
				}
				String querydoc = "SELECT * FROM CSS_DOCUMENT_DETAILS DD,CSS_FILE_TYPE FT WHERE  DD.FILE_NAME=? AND DD.DOC_TYPE=?;";
				List<Document> document = jdbcTemplate.query(querydoc,
						new Object[] { filename, filetype }, new DocumentRowMapper());
				if (document.size() == 0) {
					String query = "INSERT INTO CSS_DOCUMENT_DETAILS (LOCATION, FILE_NAME, DOC_TYPE,FILE_CODE) VALUES(?,?,?,?)";
					  jdbcTemplate.update(query, doc, filename, filetype,filecode);
					  
					
					}
			}
			docList.forEach(System.out::println);
			String query = "SELECT * FROM CSS_DOCUMENT_DETAILS";
            doculist = jdbcTemplate.query(query, new DocumentRowMapper());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return doculist;
	}
	private static Logger LoggerFactory(Class<DocumentDaoImpl> class1) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Map<String, String> getFileTypeMap() {
		Map<String, String> FileTypeMap = new HashMap<String, String>();
		try {
			String query = "SELECT * FROM CSS_FILE_TYPE";
			List<FileType> filecodes = jdbcTemplate.query(query,
					new RowMapper<FileType>() {
						public FileType mapRow(ResultSet rs, int rowNum) throws SQLException {
							FileType FileType = new FileType();
							FileType.setFileCode(rs.getString("FILE_CODE"));
							FileType.setFileType(rs.getString("FILE_TYPE"));
							return FileType;
						}
					});

			if (!CollectionUtils.isEmpty(filecodes)) {
				for (FileType filecode : filecodes) {
					FileTypeMap.put(filecode.getFileCode(), filecode.getFileType());
				}
			}
			return FileTypeMap;
		} catch (Exception e) {
			logger.error("Error Retrieving Token", e);
			return null;
		}
	}
	public void deleteFile(String id) {
		String query = "DELETE FROM CSS_DOCUMENT_DETAILS WHERE ID =?";
		jdbcTemplate.update(query, id);
	}

class DocumentRowMapper implements RowMapper<Document> {

	public Document mapRow(ResultSet rs, int rowNum) throws SQLException {
		Document doc = new Document();
		doc.setId(rs.getString("ID"));
		doc.setFilename(rs.getString("FILE_NAME"));
		String accnum=doc.getFilename().substring(0, doc.getFilename().indexOf("_"));
		doc.setAccnum(accnum);
		doc.setLocation(rs.getString("LOCATION"));
		doc.setFilecode(rs.getString("FILE_CODE"));
		doc.setDoctype(rs.getString("DOC_TYPE"));
		doc.setFilecode(rs.getString("FILE_CODE"));
		return doc;
	}
}

public Document getDocumentDetails(String id) {
	String query = "Select * FROM CSS_DOCUMENT_DETAILS WHERE ID =?";
	Document document = jdbcTemplate.queryForObject(query,
			new Object[] { id }, new RowMapper<Document>() {
				public Document mapRow(ResultSet rs, int rowNum) throws SQLException {

					Document doc = new Document();
					doc.setId(rs.getString("ID"));
					doc.setFilename(rs.getString("FILE_NAME"));
					String accnum=doc.getFilename().substring(0, doc.getFilename().indexOf("_"));
					doc.setAccnum(accnum);
					doc.setLocation(rs.getString("LOCATION"));
					doc.setFiletype(rs.getString("DOC_TYPE"));
					doc.setFilecode(rs.getString("FILE_CODE"));
					return doc;
				}
			});
	return document;
}


public void updateDocumentDetails(Document doc,String filetype){
	String query = "Select count(*) FROM CSS_DOCUMENT_DETAILS WHERE FILE_NAME =?";
	String recordCount = jdbcTemplate.queryForObject(query,
			String.class, doc.getFilename());
   if(!recordCount.equals("0")) {
       String updatequery ="UPDATE CSS_DOCUMENT_DETAILS SET FILE_CODE =? WHERE FILE_NAME =?";
	   jdbcTemplate.update(updatequery,filetype,doc.getFilename());

   }
}


public Document getDocumentDetailsByLocation(String fileName) {
	
	String query = "Select * FROM CSS_DOCUMENT_DETAILS WHERE FILE_NAME =?";
	Document document = jdbcTemplate.queryForObject(query,
			new Object[] {fileName}, new RowMapper<Document>() {
				public Document mapRow(ResultSet rs, int rowNum) throws SQLException {
					Document doc = new Document();
					doc.setId(rs.getString("ID"));
					doc.setFilename(rs.getString("FILE_NAME"));
					String accnum=doc.getFilename().substring(0, doc.getFilename().indexOf("_"));
					doc.setAccnum(accnum);
					doc.setLocation(rs.getString("LOCATION"));
					doc.setFiletype(rs.getString("DOC_TYPE"));
					doc.setFilecode(rs.getString("FILE_CODE"));
					return doc;
				}
			});
	return document;
}
}


