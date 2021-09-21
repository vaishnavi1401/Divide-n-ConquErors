package com.reconnect.utility;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.fileupload.FileItem;

public class CommonUtils {

	public static String getFieldValue(List<FileItem> fileItemsList,String fieldName) {
		String fieldValue = null;
		for (FileItem item : fileItemsList) {
		    if (item.isFormField()) {
		    	if(item.getFieldName().equals(fieldName)) {
		    		//System.out.println(item.getFieldName());
		    		fieldValue=item.getString();
		    	}
		    }
		}
		//System.out.println(fieldName+" "+fieldValue);
		return fieldValue;
		
	}
}
