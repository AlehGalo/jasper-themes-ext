import java.awt.Color;
import java.awt.GradientPaint;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;

import javax.imageio.ImageIO;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.ModuloAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.TickUnits;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.IntervalMarker;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LayeredBarRenderer;
import org.jfree.data.Range;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.Layer;
import org.jfree.ui.LengthAdjustmentType;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.StandardGradientPaintTransformer;
import org.jfree.ui.TextAnchor;

import com.lowagie.text.Font;

import net.sf.jasperreports.engine.JRException;

/**
 * 
 */

/**
 * @author aleh.bahatyrou
 *
 */
public class Vore2Chart {

	public void generateReport() {
		final CategoryDataset dataset = createDatasetVorsorgeSituationChart();
		final JFreeChart chart = createChartVorsorgeSituation(dataset);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			ImageIO.write(chart.createBufferedImage(757, 244), "png", out);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Files.copy(new ByteArrayInputStream(out.toByteArray()),
					Paths.get(ChartThemesApp.TMP_DIR + System.currentTimeMillis() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private CategoryDataset createDatasetVorsorgeSituationChart() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(1.0, "Unterversorgung", "Pension");
//		dataset.addValue(0.5, "private und betriebliche Versorgung", "Pension");
//		dataset.addValue(0.3, "gesetzliche Versorgung", "Pension");
		return dataset;
	}

	private static JFreeChart createChartVorsorgeSituation(CategoryDataset dataset) {

		// create the chart...
		JFreeChart chart = ChartFactory.createBarChart("", // chart
															// title
				"", // domain axis label
				"", // range axis label
				dataset, // data
				PlotOrientation.HORIZONTAL, // orientation
				true, // include legend
				false, // tooltips?
				false // URLs?
		);

		// plot.setRangePannable(true);
		// plot.setRangeZeroBaselineVisible(true);

		TickUnits standardUnits = new TickUnits();
		standardUnits.add(new NumberTickUnit(0.0, new DecimalFormat("##0%")));
		standardUnits.add(new NumberTickUnit(0.2, new DecimalFormat("##0%")));
		standardUnits.add(new NumberTickUnit(0.4, new DecimalFormat("##0%")));
		standardUnits.add(new NumberTickUnit(0.6, new DecimalFormat("##0%")));
		standardUnits.add(new NumberTickUnit(0.8, new DecimalFormat("##0%")));
		standardUnits.add(new NumberTickUnit(1.0, new DecimalFormat("##0%")));
		standardUnits.add(new NumberTickUnit(1.2, new DecimalFormat("##0%")));
		standardUnits.add(new NumberTickUnit(1.4, new DecimalFormat("##0%")));
		standardUnits.add(new NumberTickUnit(1.6, new DecimalFormat("##0%")));
		standardUnits.add(new NumberTickUnit(1.8, new DecimalFormat("##0%")));
		standardUnits.add(new NumberTickUnit(2.0, new DecimalFormat("##0%")));

		// set the range axis to display integers only...
		ModuloAxis rangeAxis = new ModuloAxis("", new Range(-0.000001, 2.1));
		rangeAxis.setStandardTickUnits(standardUnits);
		// rangeAxis.setFixedAutoRange(200.0);

		rangeAxis.setDisplayRange(-0.000001, 2.1);
		// get a reference to the plot for further customisation...
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		plot.setDomainGridlinesVisible(true);
		plot.setRangeAxis(rangeAxis);
		plot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
		plot.setBackgroundPaint(null);
		plot.setOutlineVisible(false);

		DecimalFormat labelFormatter = new DecimalFormat("##0%");
		rangeAxis.setNumberFormatOverride(labelFormatter);
		rangeAxis.setTickLabelFont(new java.awt.Font("Arial", Font.BOLD, 16));

		// disable bar outlines...
		LayeredBarRenderer renderer = new LayeredBarRenderer();
		renderer.setDrawBarOutline(false);

		// set up gradient paints for series...
		GradientPaint gp0 = new GradientPaint(0.0f, 0.0f, new Color(0, 0, 64), 0.8f, 0.8f, Color.blue);
		GradientPaint gp2 = new GradientPaint(0.0f, 10.0f, new Color(0, 64, 0), 0.0f, 0.0f, new Color(152, 203, 0),
				true);
		GradientPaint gp1 = new GradientPaint(0.0f, 10.0f, new Color(0, 94, 0), 0.0f, 0.0f, new Color(160, 245, 0),
				true);

		renderer.setGradientPaintTransformer(
				new StandardGradientPaintTransformer(GradientPaintTransformType.CENTER_VERTICAL));
		renderer.setSeriesPaint(0, gp0);
		renderer.setSeriesPaint(1, gp1);
		renderer.setSeriesPaint(2, gp2);
		renderer.setDrawBarOutline(false);

		// legend order and assign legend colors to items
		LegendItemCollection legendItemCollection = new LegendItemCollection();
		final LegendItem getzlVersorgungLegendItem = new LegendItem("gesetzliche Versorgung");
		getzlVersorgungLegendItem.setFillPaint(gp2);
		legendItemCollection.add(getzlVersorgungLegendItem);

		final LegendItem privVersorgungLegendItem = new LegendItem("private und betriebliche Versorgung");
		privVersorgungLegendItem.setFillPaint(gp1);
		legendItemCollection.add(privVersorgungLegendItem);

		final LegendItem unterversorgungLegendItem = new LegendItem("Vorsorgelücke");
		unterversorgungLegendItem.setFillPaint(gp0);
		legendItemCollection.add(unterversorgungLegendItem);
		plot.setFixedLegendItems(legendItemCollection);

		int numBars = dataset.getColumnKeys().size();
		if (numBars > 2) {
			renderer.setSeriesBarWidth(0, 0.99);
			renderer.setSeriesBarWidth(1, 0.99 * 0.89);
			renderer.setSeriesBarWidth(2, 0.79 * 0.87);
		} else if (numBars == 2) {
			renderer.setSeriesBarWidth(0, 0.99 * 0.9);
			renderer.setSeriesBarWidth(1, 0.99 * 0.89 * 0.9);
			renderer.setSeriesBarWidth(2, 0.79 * 0.87 * 0.9);
		} else {
			renderer.setSeriesBarWidth(0, 0.99 * 0.6);
			renderer.setSeriesBarWidth(1, 0.99 * 0.89 * 0.6);
			renderer.setSeriesBarWidth(2, 0.79 * 0.87 * 0.6);
		}

//		org.jfree.chart.plot.Marker optimal = new IntervalMarker(0.998, 1.001);
//		optimal.setLabelOffsetType(LengthAdjustmentType.EXPAND);
//		optimal.setPaint(new Color(219, 237, 219));
//		optimal.setLabel("Ziel");
//		optimal.setLabelFont(new java.awt.Font("Arial", Font.BOLD, 11));
//		optimal.setLabelPaint(new Color(0, 128, 0));
//		optimal.setLabelAnchor(RectangleAnchor.TOP);
//		optimal.setLabelTextAnchor(TextAnchor.TOP_CENTER);
//		plot.addRangeMarker(optimal, Layer.BACKGROUND);

		plot.getDomainAxis().setTickLabelFont(new java.awt.Font("Arial", Font.BOLD, 16));
		// rückt die Kategorien näher zusammen und macht sie breiter
		plot.getDomainAxis().setCategoryMargin((numBars > 3) ? -0.2 : -0.1);

		plot.setRenderer(renderer);
		chart.getLegend().setFrame(BlockBorder.NONE);
		chart.getLegend().setItemFont(new java.awt.Font("Arial", Font.NORMAL, 16));
		// einzelne Legends weiter auseinander
		chart.getLegend().setLegendItemGraphicPadding(new RectangleInsets(0.0, 60.0, 0.0, 0.0));

		return chart;
	}

	public static void main(String[] args) throws JRException {
		System.out.println("Started");
		long time = System.currentTimeMillis();
		new Vore2Chart().generateReport();
		System.out.println("Finished: " + (System.currentTimeMillis() - time));
	}
}
