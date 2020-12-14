package com.moi.dms.trace.request.web.portlet.action;

import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.moi.dms.trace.request.model.MOITraceRequest;
import com.moi.dms.trace.request.service.MOITraceRequestServiceUtil;
import com.moi.dms.trace.request.web.constants.MOITraceRequestCommandNames;
import com.moi.dms.trace.request.web.constants.MOITraceRequestConstants;
import com.moi.dms.trace.request.web.constants.MOITraceRequestPortletKeys;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.osgi.service.component.annotations.Component;

/**
 * Resource action to export MOI Trace Request excel report.
 * @author Chintan Bhadra
 *
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + MOITraceRequestPortletKeys.MOITraceRequest,
		"mvc.command.name=" + MOITraceRequestCommandNames.EXPORT_TRACE_REQUESTS
	},
	service = MVCResourceCommand.class
)
public class MOITraceRequestExportAction implements MVCResourceCommand {

	/**
	 * String to store column names
	 */
	private static final String[] columnNames = {
			MOITraceRequestConstants.REQUESTED_BY_LABEL,
			MOITraceRequestConstants.REQUEST_INCOMING_DATE_LABEL,
			MOITraceRequestConstants.REQUESTED_CONSUMER_NAME_LABEL,
			MOITraceRequestConstants.REQUESTED_OPERATION_LABEL,
			MOITraceRequestConstants.REQUESTED_DOCUMENT_TYPE_LABEL,
			MOITraceRequestConstants.REQUEST_VALID_LABEL,
			MOITraceRequestConstants.REQUEST_RESULT_LABEL };

	/**
	 * Export MOI Trace request data.
	 * 
	 * @param resourceRequest
	 * @param resourceResponse
	 * @return boolean
	 * @throws PortletException
	 */
	@Override
	public boolean serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws PortletException {

		String fromDate = ParamUtil.getString(resourceRequest,
				MOITraceRequestConstants.FROM_DATE);
		String toDate = ParamUtil.getString(resourceRequest,
				MOITraceRequestConstants.TO_DATE);
		String keywords = ParamUtil.getString(resourceRequest,
				MOITraceRequestConstants.KEYWORDS);

		if (Validator.isNotNull(fromDate)) {
			fromDate += MOITraceRequestConstants.FROM_TIME;
		}

		if (Validator.isNotNull(toDate)) {
			toDate += MOITraceRequestConstants.TO_TIME;
		}

		List<MOITraceRequest> traceRequests = MOITraceRequestServiceUtil
				.getMOITraceRequestBySearchCriteria(keywords, fromDate, toDate);

		try {
			createExcelData(traceRequests, resourceRequest, resourceResponse);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Exports XLS workbook for MOITraceRequest.
	 * 
	 * @param traceRequests
	 * @param resourceRequest
	 * @param resourceResponse
	 * @throws IOException
	 */
	private void createExcelData(List<MOITraceRequest> traceRequests,
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException {
		// Blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook();

		// Create a blank sheet
		XSSFSheet sheet = workbook
				.createSheet(MOITraceRequestConstants.EXPORT_SHEET_NAME);

		CellStyle headerCellStyle = createHeaderCellStyle(workbook);
		CellStyle contentCellStyle = createContentCellStyle(workbook);
		CellStyle dateCellStyle = createDateCellStyle(workbook);

		// Create a Row
		Row headerRow = sheet.createRow(0);

		// Create cells
		for (int i = 0; i < columnNames.length; i++) {
			Cell cell = createCell(i, headerRow, headerCellStyle);
			cell.setCellValue(columnNames[i]);
		}

		// Create Other rows and cells with trace requests data
		int rowNum = 1;
		for (MOITraceRequest traceRequest : traceRequests) {
			Row contentRow = sheet.createRow(rowNum++);

			createCell(0, contentRow, contentCellStyle)
					.setCellValue(traceRequest.getRequestedBy());
			createCell(1, contentRow, dateCellStyle)
					.setCellValue(traceRequest.getRequestIncomingDate());
			createCell(2, contentRow, contentCellStyle)
					.setCellValue(traceRequest.getRequestedConsumerName());
			createCell(3, contentRow, contentCellStyle)
					.setCellValue(traceRequest.getRequestedOperation());
			createCell(4, contentRow, contentCellStyle)
					.setCellValue(traceRequest.getRequestedDocumentType());
			createCell(5, contentRow, contentCellStyle)
					.setCellValue(traceRequest.getRequestValid());
			createCell(6, contentRow, contentCellStyle)
					.setCellValue(traceRequest.getRequestResult());
		}

		// Resize all columns to fit the content size
		for (int i = 0; i < columnNames.length; i++) {
			sheet.autoSizeColumn(i);
		}

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			workbook.write(bos);
		} finally {
			bos.close();
			workbook.close();
		}

		byte[] bytes = bos.toByteArray();
		String fileName = MOITraceRequestConstants.EXPORT_FILE_NAME_XLS;
		try {
			PortletResponseUtil.sendFile(resourceRequest, resourceResponse,
					fileName, bytes, ContentTypes.APPLICATION_VND_MS_EXCEL);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create cells with the style provided
	 * 
	 * @param i
	 * @param row
	 * @param cellStyle
	 * @return Cell
	 */
	private Cell createCell(int i, Row row, CellStyle cellStyle) {
		Cell cell = row.createCell(i);
		cell.setCellStyle(cellStyle);
		return cell;
	}

	/**
	 * Created Header cell style oject.
	 * 
	 * @param workbook
	 * @return CellStyle
	 */
	private CellStyle createHeaderCellStyle(XSSFWorkbook workbook) {

		// Create a Font for styling header cells
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) 11);
		headerFont.setColor(IndexedColors.WHITE.getIndex());

		// Create a CellStyle with the font
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);
		headerCellStyle.setAlignment(HorizontalAlignment.CENTER);
		headerCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		headerCellStyle
				.setFillForegroundColor(IndexedColors.BLUE1.getIndex());
		headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		return setCellBorder(headerCellStyle);
	}

	/**
	 * Create content cell type object
	 * 
	 * @param workbook
	 * @return CellStyle
	 */
	private CellStyle createContentCellStyle(XSSFWorkbook workbook) {

		// Create a Font for styling content cells
		Font contentFont = workbook.createFont();
		contentFont.setFontHeightInPoints((short) 10);

		// Create a CellStyle with the font
		CellStyle contentCellStyle = workbook.createCellStyle();
		contentCellStyle.setFont(contentFont);
		contentCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

		return setCellBorder(contentCellStyle);
	}

	/**
	 * Create Date cell type object
	 * 
	 * @param workbook
	 * @return CellStyle
	 */
	private CellStyle createDateCellStyle(XSSFWorkbook workbook) {

		// CreationHelper to create instances of for DataFormat
		CreationHelper createHelper = workbook.getCreationHelper();

		// Create a Font for styling content cells
		Font contentFont = workbook.createFont();
		contentFont.setFontHeightInPoints((short) 10);

		// Create a CellStyle with the font
		CellStyle dateCellStyle = workbook.createCellStyle();

		// Create Cell Style for formatting Date
		dateCellStyle.setDataFormat(createHelper.createDataFormat()
				.getFormat(MOITraceRequestConstants.DATE_FORMAT));
		dateCellStyle.setFont(contentFont);
		dateCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

		return setCellBorder(dateCellStyle);
	}

	/**
	 * Set normal borders in a cell
	 * 
	 * @param cellStyle
	 * @return CellStyle
	 */
	private CellStyle setCellBorder(CellStyle cellStyle) {
		// Set borders
		cellStyle.setBorderBottom(BorderStyle.THIN);
		cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		cellStyle.setBorderRight(BorderStyle.THIN);
		cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
		cellStyle.setBorderTop(BorderStyle.THIN);
		cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
		cellStyle.setBorderLeft(BorderStyle.THIN);
		cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());

		return cellStyle;
	}
}
