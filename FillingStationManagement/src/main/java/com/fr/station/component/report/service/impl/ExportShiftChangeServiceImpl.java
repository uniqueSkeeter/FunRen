package com.fr.station.component.report.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fr.station.common.bean.report.ClassChangeBean;
import com.fr.station.common.data.ApplicationContext;
import com.fr.station.component.report.dao.ClassChangeDAO;
import com.fr.station.component.report.service.ExportShiftChangeService;
import com.fr.station.component.system.service.impl.AbstractBaseService;

@SuppressWarnings("rawtypes")
@Service
public class ExportShiftChangeServiceImpl extends AbstractBaseService implements ExportShiftChangeService {

	// ------- Constants (static final) ----------------------------------------

	private static Logger log = Logger.getLogger(ExportShiftChangeServiceImpl.class);

	// ------- Static Variables (static) ---------------------------------------

	private ClassChangeDAO classChangeDaoImpl;

	// ------- Instance Variables (private) ------------------------------------

	// ------- Constructors ----------------------------------------------------
	public ExportShiftChangeServiceImpl() {
		super();
	}

	// ------- Instance Methods (public) ---------------------------------------

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public HSSFWorkbook generateShiftChangeExcel(ClassChangeBean classChangeBean) {
		return this.createShiftChangeTemplate(classChangeBean);
	}

	@Autowired
	public void setClassChangeDAO(ClassChangeDAO classChangeDaoImpl) {
		super.setBaseDao(classChangeDaoImpl);
		this.classChangeDaoImpl = classChangeDaoImpl;
	}

	// ------- Instance Methods (protected) ------------------------------------

	// ------- Instance Methods (private) --------------------------------------

	private HSSFWorkbook createShiftChangeTemplate(ClassChangeBean classChangeBean) {
		HSSFWorkbook workbook = new HSSFWorkbook();
		// create sheet
		HSSFSheet sheet = this.createSheet(workbook);
		// create cell style
		HSSFCellStyle cellStyle = this.createCellStyle(workbook);
		// get result data
		ClassChangeBean resultBean = this.getShiftChangeData(classChangeBean);
		// create data row
		HSSFRow dataRow = sheet.createRow(0);
		// create header info
		dataRow = this.createHeaderInfo(sheet, cellStyle, resultBean, dataRow);
		// create content header info
		this.createContentHeader(sheet, cellStyle, resultBean, dataRow);
		// fill excel
		this.createExcelContent(sheet, resultBean);
		// create reciept content
		this.createRecieptContent(sheet, cellStyle, resultBean);
		// set default cell style
		this.createDefaultCellStyle(workbook);
		// prepare export shiftchange report path
		FileOutputStream outPutStream = this.preExportPath();
		//export shift change report
		this.exportShiftChangeReport(workbook, outPutStream);
		return workbook;
	}

	private void createDefaultCellStyle(HSSFWorkbook workbook) {
		HSSFCellStyle cellStyle;
		cellStyle = workbook.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.VERTICAL_CENTER);
		cellStyle.setWrapText(true);
	}

	private void exportShiftChangeReport(HSSFWorkbook workbook, FileOutputStream outPutStream) {
		try {
			workbook.write(outPutStream);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (outPutStream != null) {
					outPutStream.flush();
					outPutStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private FileOutputStream preExportPath() {
		String shiftChangeDataPath = "C:\\班结报表";
		String fileName = "ShiftChange Report.xls";
		return this.preExportShiftChangeDataPath(shiftChangeDataPath, fileName);
	}

	private void createRecieptContent(HSSFSheet sheet, HSSFCellStyle cellStyle, ClassChangeBean resultBean) {
		HSSFRow dataRow;
		HSSFCell dataCell;
		int index = 10 + resultBean.getCardStorageList().size() + 1;
		dataRow = sheet.createRow(index);
		log.info("add title3");
		dataCell = dataRow.createCell(0);
		dataCell.setCellType(HSSFCell.CELL_TYPE_STRING);
		dataCell.setCellStyle(cellStyle);
		dataCell.setCellValue("发票统计表");

		dataRow = sheet.createRow(index + 1);
		log.info("add Invoice Amount");
		dataCell = dataRow.createCell(1);
		dataCell.setCellType(HSSFCell.CELL_TYPE_STRING);
		dataCell.setCellStyle(cellStyle);
		dataCell.setCellValue("发票金额");
		log.info("add Invoice Num");
		dataCell = dataRow.createCell(2);
		dataCell.setCellType(HSSFCell.CELL_TYPE_STRING);
		dataCell.setCellStyle(cellStyle);
		dataCell.setCellValue("发票数量");

		dataRow = sheet.createRow(index + 2);
		log.info("add Total");
		dataCell = dataRow.createCell(0);
		dataCell.setCellType(HSSFCell.CELL_TYPE_STRING);
		dataCell.setCellStyle(cellStyle);
		dataCell.setCellValue("合计");
		dataCell = dataRow.createCell(1);
		dataCell.setCellValue(String.valueOf(resultBean.getInvoiceTotalAmount()));
		dataCell = dataRow.createCell(2);
		dataCell.setCellValue(String.valueOf(resultBean.getInvoiceTotalCount()));
	}

	private void createExcelContent(HSSFSheet sheet, ClassChangeBean resultBean) {
		HSSFRow dataRow;
		HSSFCell dataCell;
		for (int i = 0; i < resultBean.getCardStorageList().size(); i++) {
			dataRow = sheet.createRow(10 + i);
			dataCell = dataRow.createCell(0);
			dataCell.setCellValue("合计");
			dataCell = dataRow.createCell(1);
			switch (resultBean.getCardStorageList().get(i).getCardType()) {
				case "01":
					dataCell.setCellValue("用户卡");
					break;
				case "02":
					dataCell.setCellValue("员工卡");
					break;
				case "04":
					dataCell.setCellValue("管理卡");
					break;
				case "05":
					dataCell.setCellValue("检泵卡");
					break;
				case "06":
					dataCell.setCellValue("维修");
					break;

				default:
					break;
			}
			dataCell = dataRow.createCell(2);
			dataCell.setCellValue(resultBean.getCardStorageList().get(i).getCardQuantityBegin());
			dataCell = dataRow.createCell(3);
			dataCell.setCellValue(resultBean.getCardStorageList().get(i).getCardQuantityEnd());
			dataCell = dataRow.createCell(4);
			dataCell.setCellValue(resultBean.getCardStorageList().get(i).getCardQuantity());
			dataCell = dataRow.createCell(5);
			dataCell.setCellValue(resultBean.getCardStorageList().get(i).getTradeCount());
		}
	}

	private void createContentHeader(HSSFSheet sheet, HSSFCellStyle cellStyle, ClassChangeBean resultBean, HSSFRow dataRow) {
		HSSFCell dataCell;
		dataCell = dataRow.createCell(1);
		dataCell.setCellValue((ApplicationContext.getInstance().getStationName()));
		dataCell = dataRow.createCell(2);
		dataCell.setCellValue(String.valueOf(resultBean.getChargeFromCash()));
		dataCell = dataRow.createCell(3);
		dataCell.setCellValue(String.valueOf(resultBean.getChargeFromICCard()));
		dataCell = dataRow.createCell(4);
		dataCell.setCellValue(String.valueOf(resultBean.getChargeFromCheque()));
		dataCell = dataRow.createCell(5);
		dataCell.setCellValue(String.valueOf(resultBean.getReturnAmount()));
		dataCell = dataRow.createCell(6);
		dataCell.setCellValue(String.valueOf(resultBean.getReceiveForegiftAmount()));
		dataCell = dataRow.createCell(7);
		dataCell.setCellValue(String.valueOf(resultBean.getReturnForegiftAmount()));
		dataCell = dataRow.createCell(8);
		dataCell.setCellValue(String.valueOf(resultBean.getTotalMoney()));

		dataRow = sheet.createRow(8);
		log.info("add title3");
		dataCell = dataRow.createCell(0);
		dataCell.setCellType(HSSFCell.CELL_TYPE_STRING);
		dataCell.setCellStyle(cellStyle);
		dataCell.setCellValue("卡库存统计表");

		dataRow = sheet.createRow(9);
		log.info("add Card Type");
		dataCell = dataRow.createCell(1);
		dataCell.setCellType(HSSFCell.CELL_TYPE_STRING);
		dataCell.setCellStyle(cellStyle);
		dataCell.setCellValue("卡片类型");
		log.info("add Card Quantity Begin");
		dataCell = dataRow.createCell(2);
		dataCell.setCellType(HSSFCell.CELL_TYPE_STRING);
		dataCell.setCellStyle(cellStyle);
		dataCell.setCellValue("期初数量");
		log.info("add Card Quantity Begin");
		dataCell = dataRow.createCell(3);
		dataCell.setCellType(HSSFCell.CELL_TYPE_STRING);
		dataCell.setCellStyle(cellStyle);
		dataCell.setCellValue("期末数量");
		log.info("add Card Quantity");
		dataCell = dataRow.createCell(4);
		dataCell.setCellType(HSSFCell.CELL_TYPE_STRING);
		dataCell.setCellStyle(cellStyle);
		dataCell.setCellValue("卡片数量");
		log.info("add Trade Num");
		dataCell = dataRow.createCell(5);
		dataCell.setCellType(HSSFCell.CELL_TYPE_STRING);
		dataCell.setCellStyle(cellStyle);
		dataCell.setCellValue("交易次数");
	}

	private HSSFRow createHeaderInfo(HSSFSheet sheet, HSSFCellStyle cellStyle, ClassChangeBean resultBean, HSSFRow dataRow) {
		HSSFCell dataCell = null;
		log.info("add title1");
		dataCell = dataRow.createCell(0);
		dataCell.setCellType(HSSFCell.CELL_TYPE_STRING);
		dataCell.setCellStyle(cellStyle);
		dataCell.setCellValue("班次信息");

		dataRow = sheet.createRow(1);
		// HSSFCell cell = null;
		int columnSize = 5;
		log.info("add ShiftNo");
		dataCell = dataRow.createCell(0);
		dataCell.setCellType(HSSFCell.CELL_TYPE_STRING);
		dataCell.setCellStyle(cellStyle);
		dataCell.setCellValue("班次号");
		log.info("add Shift Status");
		dataCell = dataRow.createCell(1);
		dataCell.setCellType(HSSFCell.CELL_TYPE_STRING);
		dataCell.setCellStyle(cellStyle);
		dataCell.setCellValue("班次状态");
		log.info("add User ID");
		dataCell = dataRow.createCell(2);
		dataCell.setCellType(HSSFCell.CELL_TYPE_STRING);
		dataCell.setCellStyle(cellStyle);
		dataCell.setCellValue("管理员编号");
		log.info("add Start Date");
		dataCell = dataRow.createCell(3);
		dataCell.setCellType(HSSFCell.CELL_TYPE_STRING);
		dataCell.setCellStyle(cellStyle);
		dataCell.setCellValue("起始日期");
		log.info("add End Date");
		dataCell = dataRow.createCell(4);
		dataCell.setCellType(HSSFCell.CELL_TYPE_STRING);
		dataCell.setCellStyle(cellStyle);
		dataCell.setCellValue("结束日期");

		dataRow = sheet.createRow(2);
		dataCell = null;
		dataCell = dataRow.createCell(0);
		dataCell.setCellValue(resultBean.getClassNo());
		dataCell = dataRow.createCell(1);
		if (resultBean.getClassStatus().equals("1")) {
			dataCell.setCellValue("已开班");
		} else if (resultBean.getClassStatus().equals("2")) {
			dataCell.setCellValue("已结班");
		}
		dataCell = dataRow.createCell(2);
		dataCell.setCellValue(resultBean.getUserId());
		dataCell = dataRow.createCell(3);
		dataCell.setCellValue(resultBean.getStartTime());
		dataCell = dataRow.createCell(4);
		dataCell.setCellValue(resultBean.getEndTime());

		dataRow = sheet.createRow(4);
		log.info("add title2");
		dataCell = dataRow.createCell(0);
		dataCell.setCellType(HSSFCell.CELL_TYPE_STRING);
		dataCell.setCellStyle(cellStyle);
		dataCell.setCellValue("交易统计信息");

		dataRow = sheet.createRow(5);
		log.info("add Station Name");
		dataCell = dataRow.createCell(1);
		dataCell.setCellType(HSSFCell.CELL_TYPE_STRING);
		dataCell.setCellStyle(cellStyle);
		dataCell.setCellValue("站点名");
		log.info("add Cash Amount");
		dataCell = dataRow.createCell(2);
		dataCell.setCellType(HSSFCell.CELL_TYPE_STRING);
		dataCell.setCellStyle(cellStyle);
		dataCell.setCellValue("现金充值");
		log.info("add Card Amount");
		dataCell = dataRow.createCell(3);
		dataCell.setCellType(HSSFCell.CELL_TYPE_STRING);
		dataCell.setCellStyle(cellStyle);
		dataCell.setCellValue("银行卡充值");
		log.info("add Cheque Amount");
		dataCell = dataRow.createCell(4);
		dataCell.setCellType(HSSFCell.CELL_TYPE_STRING);
		dataCell.setCellStyle(cellStyle);
		dataCell.setCellValue("支票充值");
		log.info("add Return Amount");
		dataCell = dataRow.createCell(5);
		dataCell.setCellType(HSSFCell.CELL_TYPE_STRING);
		dataCell.setCellStyle(cellStyle);
		dataCell.setCellValue("销户退款");
		log.info("add Receive foregift Amount");
		dataCell = dataRow.createCell(6);
		dataCell.setCellType(HSSFCell.CELL_TYPE_STRING);
		dataCell.setCellStyle(cellStyle);
		dataCell.setCellValue("押金收入");
		log.info("add Return foregift Amount");
		dataCell = dataRow.createCell(7);
		dataCell.setCellType(HSSFCell.CELL_TYPE_STRING);
		dataCell.setCellStyle(cellStyle);
		dataCell.setCellValue("押金退还");
		log.info("add Total Amount");
		dataCell = dataRow.createCell(8);
		dataCell.setCellType(HSSFCell.CELL_TYPE_STRING);
		dataCell.setCellStyle(cellStyle);
		dataCell.setCellValue("收支合计");

		dataRow = sheet.createRow(6);
		log.info("add Total");
		dataCell = dataRow.createCell(0);
		dataCell.setCellType(HSSFCell.CELL_TYPE_STRING);
		dataCell.setCellStyle(cellStyle);
		dataCell.setCellValue("合计");
		return dataRow;
	}

	private ClassChangeBean getShiftChangeData(ClassChangeBean classChangeBean) {
		ClassChangeBean resultBean = this.classChangeDaoImpl.getClassSummaryRecordsByCriteria(classChangeBean);
		return resultBean;
	}

	private HSSFCellStyle createCellStyle(HSSFWorkbook workbook) {
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		HSSFFont font = workbook.createFont();
		font.setFontName("Arial");
		font.setFontHeightInPoints((short) 11);
		font.setItalic(false);
		font.setStrikeout(false);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		cellStyle.setFont(font);
		return cellStyle;
	}

	private HSSFSheet createSheet(HSSFWorkbook workbook) {
		HSSFSheet sheet = workbook.createSheet("Shift Change Data");
		sheet.createFreezePane(0, 1, 0, 1);
		sheet.setDefaultColumnWidth(15);
		sheet.setDefaultRowHeight((short) 20);
		return sheet;
	}

	private FileOutputStream preExportShiftChangeDataPath(String shiftChangeDataPath, String fileName) {

		FileOutputStream fos = null;
		try {
			File shiftChangeDataTemplateDir = new File(shiftChangeDataPath);
			if(!shiftChangeDataTemplateDir.exists()){
				shiftChangeDataTemplateDir.mkdirs();
			}
			File shiftChangeSourceTemplateFile = new File(shiftChangeDataPath, fileName);
			if(shiftChangeSourceTemplateFile.exists()){
				shiftChangeSourceTemplateFile.delete();
			}
			shiftChangeSourceTemplateFile.createNewFile();
			fos = new FileOutputStream(shiftChangeSourceTemplateFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fos;
	}

	// ------- Static Methods --------------------------------------------------

	// ------- Optional Inner Class ------------------------------------------

}
