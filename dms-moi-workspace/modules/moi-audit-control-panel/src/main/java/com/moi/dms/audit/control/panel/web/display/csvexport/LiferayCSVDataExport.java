package com.moi.dms.audit.control.panel.web.display.csvexport;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.moi.dms.audit.control.panel.constants.MOIAuditControlPanelPortletKeys;
import com.moi.dms.audit.control.panel.web.constants.MOIAuditPortletKeys;
import com.moi.dms.audit.control.panel.web.constants.MVCCommandNames;
import com.moi.dms.audit.model.MOIAudit;
import com.moi.dms.audit.service.MOIAuditLocalServiceUtil;
import com.moi.dms.audit.service.MOIAuditServiceUtil;

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

@Component(immediate = true, property = {
		"javax.portlet.name="
				+ MOIAuditControlPanelPortletKeys.MOIAUDITCONTROLPANEL,
		"mvc.command.name="
				+ MVCCommandNames.EXPORT_MOI_AUDIT}, service = MVCResourceCommand.class)
public class LiferayCSVDataExport implements MVCResourceCommand {
	public static String[] columnNames = {
			MVCCommandNames.ACTIONED_PERFORMED_BY_LABEL,
			MVCCommandNames.ACTION_PERFORMED_DATE_LABEL,
			MVCCommandNames.ACTION_DESCRIPTION_LABEL,
			MVCCommandNames.ACTION_STATUS_LABEL,
			MVCCommandNames.ACTION_CONSUMER_LABEL
			};
	public static final String CSV_SEPARATOR = ",";

	@Override
	public boolean serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws PortletException {
		String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);
		
		String fromDate = ParamUtil.getString(resourceRequest,
				MVCCommandNames.FROM_DATE);
		String toDate = ParamUtil.getString(resourceRequest,
				MVCCommandNames.TO_DATE);
		String keywords = ParamUtil.getString(resourceRequest,
				MVCCommandNames.KEYWORDS);
		
		/*
		 * int start = Integer.parseInt(ParamUtil.getString(resourceRequest,
		 * MVCCommandNames.START)); System.out.println("start=========>"+start);
		 * int end =
		 * Integer.parseInt(ParamUtil.getString(resourceRequest,MVCCommandNames.
		 * END)); System.out.println("end=========>"+end);
		 */
		int start = 0;
		int end = 20;
		
		System.out.println("Debug 1========>");
		if (Validator.isNotNull(fromDate)) {
			fromDate += MVCCommandNames.FROM_TIME;
		}

		if (Validator.isNotNull(toDate)) {
			toDate += MVCCommandNames.TO_TIME;
		}
		System.out.println("Debug 2========>");
		 OrderByComparator<MOIAudit> moiAuditComparator =
				  OrderByComparatorFactoryUtil .create("MOITraceRequest",
				  MVCCommandNames.Audit_ID, "desc"); 
		
		
		List<MOIAudit> moiAuditRequests = MOIAuditServiceUtil.getMOIAuditBySearchCriteria(keywords, fromDate, toDate, start, end, moiAuditComparator);
		System.out.println("Debug 3========>");
		try {
			createExcelData(moiAuditRequests, resourceRequest, resourceResponse);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		/*
		 * try { exportCSVData(resourceRequest, resourceResponse);
		 * 
		 * if (cmd.equals("exportCSV")) { exportCSVData(resourceRequest,
		 * resourceResponse); }else if(cmd.equals("exportHTMLCSV")){
		 * //exportHTMLCSVData(resourceRequest, resourceResponse); }
		 * 
		 * } catch (Exception e) { _log.error(e, e); }
		 */

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
	private void createExcelData(List<MOIAudit> moiAuditRequests,
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException {
		// Blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook();

		// Create a blank sheet
		XSSFSheet sheet = workbook
				.createSheet(MVCCommandNames.EXPORT_SHEET_NAME);

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
		for (MOIAudit moiAudit : moiAuditRequests) {
			Row contentRow = sheet.createRow(rowNum++);

			createCell(0, contentRow, contentCellStyle)
					.setCellValue(moiAudit.getActionPerformedBy());
			createCell(1, contentRow, dateCellStyle)
					.setCellValue(moiAudit.getActionPerformedDate());
			createCell(2, contentRow, contentCellStyle)
					.setCellValue(moiAudit.getActionDescription());
			createCell(3, contentRow, contentCellStyle)
					.setCellValue(moiAudit.getActionStatus());
			createCell(4, contentRow, contentCellStyle)
					.setCellValue(moiAudit.getActionConsumer());
			/*
			 * createCell(5, contentRow, contentCellStyle)
			 * .setCellValue(moiAudit.getGroupId);
			 */
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
		String fileName = MVCCommandNames.EXPORT_FILE_NAME_XLS;
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
				.getFormat(MVCCommandNames.DATE_FORMAT));
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
	protected String getCSVFormattedValue(String value) {
		StringBundler sb = new StringBundler(3);
		sb.append(CharPool.QUOTE);
		sb.append(StringUtil.replace(value, CharPool.QUOTE,
				StringPool.DOUBLE_QUOTE));
		sb.append(CharPool.QUOTE);
		return sb.toString();
	}

	protected void exportCSVData(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws Exception {
		StringBundler sb = new StringBundler();
		for (String columnName : columnNames) {
			sb.append(getCSVFormattedValue(columnName));
			sb.append(CSV_SEPARATOR);
		}
		sb.setIndex(sb.index() - 1);
		sb.append(CharPool.NEW_LINE);
		List<MOIAudit> moiAuditList = MOIAuditLocalServiceUtil.getMOIAudits(0,
				MOIAuditLocalServiceUtil.getMOIAuditsCount());
		for (MOIAudit moiAudit : moiAuditList) {
			sb.append(getCSVFormattedValue(
					String.valueOf(moiAudit.getActionPerformedBy())));
			sb.append(CSV_SEPARATOR);
			sb.append(getCSVFormattedValue(
					String.valueOf(moiAudit.getActionPerformedDate())));
			sb.append(CSV_SEPARATOR);
			sb.append(getCSVFormattedValue(
					String.valueOf(moiAudit.getActionDescription())));
			sb.append(CSV_SEPARATOR);
			sb.append(getCSVFormattedValue(
					String.valueOf(moiAudit.getActionStatus())));
			sb.append(CSV_SEPARATOR);
			sb.append(getCSVFormattedValue(
					String.valueOf(moiAudit.getActionConsumer())));
			sb.append(CSV_SEPARATOR);
			sb.setIndex(sb.index() - 1);
			sb.append(CharPool.NEW_LINE);
		}

		String fileName = "portalMOIAudit.csv";
		byte[] bytes = sb.toString().getBytes();
		String contentType = ContentTypes.APPLICATION_TEXT;
		PortletResponseUtil.sendFile(resourceRequest, resourceResponse,
				fileName, bytes, contentType);
	}
	private static Log _log = LogFactoryUtil.getLog(LiferayCSVDataExport.class);

}