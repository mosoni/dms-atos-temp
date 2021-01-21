package com.moi.dms.delete.documents.web.util;

import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.theme.ThemeDisplay;

/**
 * Utility class for Delete Documents portlet
 * @author Chintan Bhadra.
 *
 */
public class MOIDeleteDocumentsUtil {

	public static String getDownloadURL(long fileEntryId,
			ThemeDisplay themeDisplay, String queryString) {

		FileEntry fileEntry = null;
		String downloadURL = StringPool.BLANK;
		try {
			fileEntry = DLAppServiceUtil.getFileEntry(fileEntryId);
			if (null != fileEntry) {
				downloadURL = DLURLHelperUtil.getDownloadURL(fileEntry,
						fileEntry.getFileVersion(), themeDisplay, queryString);
			}
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return downloadURL;
	}

}
