package com.reconnect.utility;

import java.util.List;

import org.apache.commons.fileupload.FileItem;

public class CommonUtils {

	public static String getFieldValue(List<FileItem> fileItemsList, String fieldName) {
		String fieldValue = null;
		for (FileItem item : fileItemsList) {
			if (item.isFormField()) {
				if (item.getFieldName().equals(fieldName)) {
					// System.out.println(item.getFieldName());
					fieldValue = item.getString();
				}
			}
		}
		// System.out.println(fieldName+" "+fieldValue);
		return fieldValue;
	}

	public static FileItem getImage(List<FileItem> fileItemsList) {
		FileItem image = null;
		for (FileItem item : fileItemsList) {
			if (!item.isFormField() && item.getSize() != 0) {
				image = item;
			}
		}
		return image;
	}
}
