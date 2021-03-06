
/*
 * JasperReports - Free Java Reporting Library.
 * Copyright (C) 2001 - 2014 TIBCO Software Inc. All rights reserved.
 * http://www.jaspersoft.com
 *
 * Unless you have purchased a commercial license agreement from Jaspersoft,
 * the following license terms apply:
 *
 * This program is part of JasperReports.
 *
 * JasperReports is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JasperReports is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with JasperReports. If not, see <http://www.gnu.org/licenses/>.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.Assert;

import net.sf.jasperreports.chartthemes.simple.AegeanSettingsFactory;
import net.sf.jasperreports.chartthemes.simple.SimpleSettingsFactory;
import net.sf.jasperreports.chartthemes.simple.VoreSettingsFactoryPage2;
import net.sf.jasperreports.chartthemes.simple.VoreSettingsFactoryPage3;
import net.sf.jasperreports.chartthemes.simple.VoreSettingsFactoryPage4;
import net.sf.jasperreports.chartthemes.simple.VoreSettingsFactoryPage5;
import net.sf.jasperreports.chartthemes.simple.XmlChartTheme;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.data.JRCsvDataSource;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.oasis.JROdsExporter;
import net.sf.jasperreports.engine.export.oasis.JROdtExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRPptxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.AbstractSampleApp;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
import net.sf.jasperreports.export.SimpleOdsReportConfiguration;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;

/**
 * @author sanda zaharia (shertage@users.sourceforge.net)
 */
public class ChartThemesApp extends AbstractSampleApp {

	private static final String ALL_CHARTS_REPORT_JRPRINT = "AllChartsReport.jrprint";
	private static final String ALL_CHARTS_REPORT_JASPER = "AllChartsReport.jasper";
	public static final String TMP_DIR = System.getProperty("java.io.tmpdir");

	/**
	 *
	 */
	public static void main(String[] args) {
		main(new ChartThemesApp(), new String[] { "test" });
	}

	/**
	 *
	 */
	public void test() throws JRException {
		try {
			themes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		compile();
		fill();
		// print();
		pdf();
		// xmlEmbed();
		// xml();
		// html();
		// rtf();
		// xls();
		// jxl();
		// csv();
		// odt();
		// ods();
		// docx();
		// xlsx();
		// pptx();
		// xhtml();
	}

	private boolean shouldProcess(File file) {
		// return file == null ? true : !file.exists();
		return true;
	}

	/**
	 *
	 */
	public void compile() throws JRException {
		long start = System.currentTimeMillis();
		File file = new File(TMP_DIR + ALL_CHARTS_REPORT_JASPER);
		if (shouldProcess(file)) {
			JasperCompileManager.compileReportToFile(findFile("reports/AllChartsReport.jrxml").getPath(),
					file.getPath());
		}
		System.err.println("Compiling : " + (System.currentTimeMillis() - start));
	}

	/**
	 * @throws IOException
	 *
	 */
	public void themes() throws JRException, IOException {
		long start = System.currentTimeMillis();

		XmlChartTheme.saveSettings(SimpleSettingsFactory.createChartThemeSettings(),
				new FileWriter(findFile("net/sf/jasperreports/chartthemes/simple/simple.jrctx")));

		XmlChartTheme.saveSettings(AegeanSettingsFactory.createChartThemeSettings(),
				new FileWriter(findFile("net/sf/jasperreports/chartthemes/simple/aegean.jrctx")));

		XmlChartTheme.saveSettings(VoreSettingsFactoryPage2.createChartThemeSettings(),
				new FileWriter(findFile("net/sf/jasperreports/chartthemes/simple/vore2.jrctx")));

		XmlChartTheme.saveSettings(VoreSettingsFactoryPage3.createChartThemeSettings(),
				new FileWriter(findFile("net/sf/jasperreports/chartthemes/simple/vore3.jrctx")));

		XmlChartTheme.saveSettings(VoreSettingsFactoryPage4.createChartThemeSettings(),
				new FileWriter(findFile("net/sf/jasperreports/chartthemes/simple/vore4.jrctx")));

		XmlChartTheme.saveSettings(VoreSettingsFactoryPage5.createChartThemeSettings(),
				new FileWriter(findFile("net/sf/jasperreports/chartthemes/simple/vore5.jrctx")));

		System.err.println("Theme saving time : " + (System.currentTimeMillis() - start));
	}

	/**
	 * @throws FileNotFoundException
	 *
	 */
	public void fill() throws JRException {
		long start = System.currentTimeMillis();
		File file = new File(TMP_DIR + ALL_CHARTS_REPORT_JRPRINT);
		if (shouldProcess(file)) {
			Map<String, Object> parameters = new HashMap<String, Object>();
			putDataSources(parameters);
			JasperFillManager.fillReportToFile(TMP_DIR + ALL_CHARTS_REPORT_JASPER, file.getPath(), parameters,
					new JREmptyDataSource());
		}
		System.err.println("Filling time : " + (System.currentTimeMillis() - start));
	}

	/**
	 *
	 */
	public void print() throws JRException {
		long start = System.currentTimeMillis();
		try {
			JasperPrintManager.printReport(new FileInputStream(new File(TMP_DIR + ALL_CHARTS_REPORT_JRPRINT)), true);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.err.println("Printing time : " + (System.currentTimeMillis() - start));
	}

	/**
	 *
	 */
	public void pdf() throws JRException {
		long start = System.currentTimeMillis();
		JasperExportManager.exportReportToPdfFile(TMP_DIR + ALL_CHARTS_REPORT_JRPRINT,
				TMP_DIR + System.currentTimeMillis() + ".pdf");
		System.err.println("PDF creation time : " + (System.currentTimeMillis() - start));
	}

	/**
	 *
	 */
	public void xml() throws JRException {
		long start = System.currentTimeMillis();
		JasperExportManager.exportReportToXmlFile(TMP_DIR + ALL_CHARTS_REPORT_JRPRINT, false);
		System.err.println("XML creation time : " + (System.currentTimeMillis() - start));
	}

	/**
	 *
	 */
	public void xmlEmbed() throws JRException {
		long start = System.currentTimeMillis();
		JasperExportManager.exportReportToXmlFile(TMP_DIR + ALL_CHARTS_REPORT_JRPRINT, true);
		System.err.println("XML creation time : " + (System.currentTimeMillis() - start));
	}

	/**
	 *
	 */
	public void html() throws JRException {
		long start = System.currentTimeMillis();
		JasperExportManager.exportReportToHtmlFile(TMP_DIR + ALL_CHARTS_REPORT_JRPRINT);
		System.err.println("HTML creation time : " + (System.currentTimeMillis() - start));
	}

	/**
	 *
	 */
	public void rtf() throws JRException {
		long start = System.currentTimeMillis();
		File sourceFile = new File(TMP_DIR + ALL_CHARTS_REPORT_JRPRINT);

		JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(sourceFile);

		File destFile = new File(sourceFile.getParent(), jasperPrint.getName() + ".rtf");

		JRRtfExporter exporter = new JRRtfExporter();

		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleWriterExporterOutput(destFile));

		exporter.exportReport();

		System.err.println("RTF creation time : " + (System.currentTimeMillis() - start));
	}

	/**
	 *
	 */
	public void xls() throws JRException {
		long start = System.currentTimeMillis();
		File sourceFile = new File(TMP_DIR + ALL_CHARTS_REPORT_JRPRINT);
		Map<String, String> dateFormats = new HashMap<String, String>();
		dateFormats.put("EEE, MMM d, yyyy", "ddd, mmm d, yyyy");
		JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(sourceFile);
		File destFile = new File(sourceFile.getParent(), jasperPrint.getName() + ".xls");

		JRXlsExporter exporter = new JRXlsExporter();

		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(destFile));
		SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration();
		configuration.setOnePagePerSheet(true);
		configuration.setDetectCellType(true);
		configuration.setFormatPatternsMap(dateFormats);
		exporter.setConfiguration(configuration);

		exporter.exportReport();

		System.err.println("XLS creation time : " + (System.currentTimeMillis() - start));
	}

	/**
	 *
	 */
	@SuppressWarnings("deprecation")
	public void jxl() throws JRException {
		long start = System.currentTimeMillis();
		File sourceFile = new File(TMP_DIR + ALL_CHARTS_REPORT_JRPRINT);

		JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(sourceFile);

		File destFile = new File(sourceFile.getParent(), jasperPrint.getName() + ".jxl.xls");

		net.sf.jasperreports.engine.export.JExcelApiExporter exporter = new net.sf.jasperreports.engine.export.JExcelApiExporter();

		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(destFile));
		net.sf.jasperreports.export.SimpleJxlReportConfiguration configuration = new net.sf.jasperreports.export.SimpleJxlReportConfiguration();
		configuration.setOnePagePerSheet(true);
		exporter.setConfiguration(configuration);

		exporter.exportReport();

		System.err.println("XLS creation time : " + (System.currentTimeMillis() - start));
	}

	/**
	 *
	 */
	public void csv() throws JRException {
		long start = System.currentTimeMillis();
		File sourceFile = new File(TMP_DIR + ALL_CHARTS_REPORT_JRPRINT);

		JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(sourceFile);

		File destFile = new File(sourceFile.getParent(), jasperPrint.getName() + ".csv");

		JRCsvExporter exporter = new JRCsvExporter();

		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleWriterExporterOutput(destFile));

		exporter.exportReport();

		System.err.println("CSV creation time : " + (System.currentTimeMillis() - start));
	}

	/**
	 *
	 */
	public void odt() throws JRException {
		long start = System.currentTimeMillis();
		File sourceFile = new File(TMP_DIR + ALL_CHARTS_REPORT_JRPRINT);

		JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(sourceFile);

		File destFile = new File(sourceFile.getParent(), jasperPrint.getName() + ".odt");

		JROdtExporter exporter = new JROdtExporter();

		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(destFile));

		exporter.exportReport();

		System.err.println("ODT creation time : " + (System.currentTimeMillis() - start));
	}

	/**
	 *
	 */
	public void ods() throws JRException {
		long start = System.currentTimeMillis();
		File sourceFile = new File(TMP_DIR + ALL_CHARTS_REPORT_JRPRINT);

		JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(sourceFile);

		File destFile = new File(sourceFile.getParent(), jasperPrint.getName() + ".ods");

		JROdsExporter exporter = new JROdsExporter();

		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(destFile));
		SimpleOdsReportConfiguration configuration = new SimpleOdsReportConfiguration();
		configuration.setOnePagePerSheet(true);
		exporter.setConfiguration(configuration);

		exporter.exportReport();

		System.err.println("ODS creation time : " + (System.currentTimeMillis() - start));
	}

	/**
	 *
	 */
	public void docx() throws JRException {
		long start = System.currentTimeMillis();
		File sourceFile = new File(TMP_DIR + ALL_CHARTS_REPORT_JRPRINT);

		JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(sourceFile);

		File destFile = new File(sourceFile.getParent(), jasperPrint.getName() + ".docx");

		JRDocxExporter exporter = new JRDocxExporter();

		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(destFile));

		exporter.exportReport();

		System.err.println("DOCX creation time : " + (System.currentTimeMillis() - start));
	}

	/**
	 *
	 */
	public void xlsx() throws JRException {
		long start = System.currentTimeMillis();
		File sourceFile = new File(TMP_DIR + ALL_CHARTS_REPORT_JRPRINT);
		Map<String, String> dateFormats = new HashMap<String, String>();
		dateFormats.put("EEE, MMM d, yyyy", "ddd, mmm d, yyyy");
		JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(sourceFile);
		File destFile = new File(sourceFile.getParent(), jasperPrint.getName() + ".xlsx");

		JRXlsxExporter exporter = new JRXlsxExporter();

		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(destFile));
		SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
		configuration.setOnePagePerSheet(true);
		configuration.setDetectCellType(true);
		configuration.setFormatPatternsMap(dateFormats);
		exporter.setConfiguration(configuration);

		exporter.exportReport();

		System.err.println("XLSX creation time : " + (System.currentTimeMillis() - start));
	}

	/**
	 *
	 */
	public void pptx() throws JRException {
		long start = System.currentTimeMillis();
		File sourceFile = new File(TMP_DIR + ALL_CHARTS_REPORT_JRPRINT);

		JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(sourceFile);

		File destFile = new File(sourceFile.getParent(), jasperPrint.getName() + ".pptx");

		JRPptxExporter exporter = new JRPptxExporter();

		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(destFile));

		exporter.exportReport();

		System.err.println("PPTX creation time : " + (System.currentTimeMillis() - start));
	}

	/**
	 *
	 */
	@SuppressWarnings("deprecation")
	public void xhtml() throws JRException {
		long start = System.currentTimeMillis();
		File sourceFile = new File(TMP_DIR + ALL_CHARTS_REPORT_JRPRINT);

		JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(sourceFile);

		File destFile = new File(sourceFile.getParent(), jasperPrint.getName() + ".x.html");

		net.sf.jasperreports.engine.export.JRXhtmlExporter exporter = new net.sf.jasperreports.engine.export.JRXhtmlExporter();

		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleHtmlExporterOutput(destFile));

		exporter.exportReport();

		System.err.println("XHTML creation time : " + (System.currentTimeMillis() - start));
	}

	/**
	 *
	 */
	public static final void putDataSources(Map<String, Object> parameters) throws JRException {
		try {
			JRCsvDataSource cds1 = new JRCsvDataSource(JRLoader.getLocationInputStream("data/categoryDatasource.csv"),
					"UTF-8");
			cds1.setRecordDelimiter("\r\n");
			cds1.setUseFirstRowAsHeader(true);
			parameters.put("categoryDatasource1", cds1);

			JRCsvDataSource cds2 = new JRCsvDataSource(JRLoader.getLocationInputStream("data/categoryDatasource.csv"),
					"UTF-8");
			cds2.setRecordDelimiter("\r\n");
			cds2.setUseFirstRowAsHeader(true);
			parameters.put("categoryDatasource2", cds2);

			JRCsvDataSource cds3 = new JRCsvDataSource(JRLoader.getLocationInputStream("data/categoryDatasource.csv"),
					"UTF-8");
			cds3.setRecordDelimiter("\r\n");
			cds3.setUseFirstRowAsHeader(true);
			parameters.put("categoryDatasource3", cds3);

			JRCsvDataSource cds4 = new JRCsvDataSource(JRLoader.getLocationInputStream("data/categoryDatasource.csv"),
					"UTF-8");
			cds4.setRecordDelimiter("\r\n");
			cds4.setUseFirstRowAsHeader(true);
			parameters.put("categoryDatasource4", cds4);

			JRCsvDataSource cds5 = new JRCsvDataSource(JRLoader.getLocationInputStream("data/categoryDatasource.csv"),
					"UTF-8");
			cds5.setRecordDelimiter("\r\n");
			cds5.setUseFirstRowAsHeader(true);
			parameters.put("categoryDatasource5", cds5);

			JRCsvDataSource cds6 = new JRCsvDataSource(JRLoader.getLocationInputStream("data/categoryDatasource.csv"),
					"UTF-8");
			cds6.setRecordDelimiter("\r\n");
			cds6.setUseFirstRowAsHeader(true);
			parameters.put("categoryDatasource6", cds6);

			JRCsvDataSource cds7 = new JRCsvDataSource(JRLoader.getLocationInputStream("data/categoryDatasource.csv"),
					"UTF-8");
			cds7.setRecordDelimiter("\r\n");
			cds7.setUseFirstRowAsHeader(true);
			parameters.put("categoryDatasource7", cds7);

			JRCsvDataSource pds1 = new JRCsvDataSource(JRLoader.getLocationInputStream("data/pieDatasource.csv"),
					"UTF-8");
			pds1.setRecordDelimiter("\r\n");
			pds1.setUseFirstRowAsHeader(true);
			parameters.put("pieDatasource1", pds1);

			JRCsvDataSource pds2 = new JRCsvDataSource(JRLoader.getLocationInputStream("data/pieDatasource.csv"),
					"UTF-8");
			pds2.setRecordDelimiter("\r\n");
			pds2.setUseFirstRowAsHeader(true);
			parameters.put("pieDatasource2", pds2);

			JRCsvDataSource tpds1 = new JRCsvDataSource(
					JRLoader.getLocationInputStream("data/timePeriodDatasource.csv"), "UTF-8");
			tpds1.setRecordDelimiter("\r\n");
			tpds1.setUseFirstRowAsHeader(true);
			parameters.put("timePeriodDatasource1", tpds1);

			JRCsvDataSource tsds1 = new JRCsvDataSource(
					JRLoader.getLocationInputStream("data/timeSeriesDatasource.csv"), "UTF-8");
			tsds1.setRecordDelimiter("\r\n");
			tsds1.setUseFirstRowAsHeader(true);
			tsds1.setDateFormat(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
			parameters.put("timeSeriesDatasource1", tsds1);

			JRCsvDataSource tsds2 = new JRCsvDataSource(
					JRLoader.getLocationInputStream("data/timeSeriesDatasource.csv"), "UTF-8");
			tsds2.setRecordDelimiter("\r\n");
			tsds2.setUseFirstRowAsHeader(true);
			tsds2.setDateFormat(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
			parameters.put("timeSeriesDatasource2", tsds2);

			JRCsvDataSource tsds3 = new JRCsvDataSource(
					JRLoader.getLocationInputStream("data/timeSeriesDatasource.csv"), "UTF-8");
			tsds3.setRecordDelimiter("\r\n");
			tsds3.setUseFirstRowAsHeader(true);
			tsds3.setDateFormat(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
			parameters.put("timeSeriesDatasource3", tsds3);

			JRCsvDataSource xyds1 = new JRCsvDataSource(JRLoader.getLocationInputStream("data/xyDatasource.csv"),
					"UTF-8");
			xyds1.setRecordDelimiter("\r\n");
			xyds1.setUseFirstRowAsHeader(true);
			parameters.put("xyDatasource1", xyds1);

			JRCsvDataSource xyds2 = new JRCsvDataSource(JRLoader.getLocationInputStream("data/xyDatasource.csv"),
					"UTF-8");
			xyds2.setRecordDelimiter("\r\n");
			xyds2.setUseFirstRowAsHeader(true);
			parameters.put("xyDatasource2", xyds2);

			JRCsvDataSource xyds3 = new JRCsvDataSource(JRLoader.getLocationInputStream("data/xyDatasource.csv"),
					"UTF-8");
			xyds3.setRecordDelimiter("\r\n");
			xyds3.setUseFirstRowAsHeader(true);
			parameters.put("xyDatasource3", xyds3);

			JRCsvDataSource xyds4 = new JRCsvDataSource(JRLoader.getLocationInputStream("data/xyDatasource.csv"),
					"UTF-8");
			xyds4.setRecordDelimiter("\r\n");
			xyds4.setUseFirstRowAsHeader(true);
			parameters.put("xyDatasource4", xyds4);

			JRCsvDataSource xyds5 = new JRCsvDataSource(JRLoader.getLocationInputStream("data/xyDatasource.csv"),
					"UTF-8");
			xyds5.setRecordDelimiter("\r\n");
			xyds5.setUseFirstRowAsHeader(true);
			parameters.put("xyDatasource5", xyds5);
		} catch (UnsupportedEncodingException e) {
			throw new JRException(e);
		}
	}

	/**
	 * @param fileName
	 *            to be found on a class path.
	 * @return file found on class path.
	 */
	public final static File findFile(String fileName) {
		Assert.hasLength(fileName);
		URL url = ChartThemesApp.class.getResource(fileName);
		Assert.notNull(url);
		return new File(url.getFile());
	}

}
