/**
 * 
 */
package net.sf.jasperreports.chartthemes.simple;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.plot.IntervalMarker;
import org.jfree.chart.plot.Marker;
import org.jfree.chart.renderer.category.LayeredBarRenderer;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.LengthAdjustmentType;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.StandardGradientPaintTransformer;
import org.jfree.ui.TextAnchor;
import org.jfree.ui.VerticalAlignment;

import net.sf.jasperreports.charts.type.EdgeEnum;
import net.sf.jasperreports.chartthemes.provider.ColorProvider;
import net.sf.jasperreports.chartthemes.provider.GradientPaintProvider;
import net.sf.jasperreports.chartthemes.provider.PaintProvider;
import net.sf.jasperreports.chartthemes.settings.AxisSettings;
import net.sf.jasperreports.chartthemes.settings.ChartSettings;
import net.sf.jasperreports.chartthemes.settings.ChartThemeSettings;
import net.sf.jasperreports.chartthemes.settings.LegendSettings;
import net.sf.jasperreports.chartthemes.settings.PlotSettings;

/**
 * @author Aleh
 *
 */
public class VoreSettingsFactoryPage2 {

	/**
	 *
	 */
	public static final ChartThemeSettings createChartThemeSettings() {
		ChartThemeSettings settings = new ChartThemeSettings();

		ChartSettings chartSettings = settings.getChartSettings();
		chartSettings.setBackgroundPaint(new ColorProvider(Color.white));
		chartSettings.setBorderPaint(new ColorProvider(Color.white));

		LegendSettings legendSettings = settings.getLegendSettings();
		legendSettings.setShowLegend(Boolean.TRUE);
		legendSettings.setPosition(EdgeEnum.BOTTOM);
		legendSettings.getFont().setBold(Boolean.FALSE);
		legendSettings.setHorizontalAlignment(HorizontalAlignment.CENTER);
		legendSettings.setVerticalAlignment(VerticalAlignment.BOTTOM);
		legendSettings.setBorder(0f);

		PlotSettings plotSettings = settings.getPlotSettings();
		plotSettings.setLabelRotation(new Double(0));
		plotSettings.setOutlineVisible(Boolean.FALSE);
		// plotSettings.setMarker(createMarker());
		// RendererProvider provider = new RendererProvider();
		// provider.setRenderer(createBarRenderer());
		// plotSettings.setRendererProvider(provider);
		plotSettings.setSeriesBarWidthSequence(Arrays.asList(0.99 * 0.9,
				0.99 * 0.89 * 0.9, 0.79 * 0.87 * 0.9));

		List<PaintProvider> list = new ArrayList<PaintProvider>();
		list.add(new GradientPaintProvider(0.0f, 0.0f, new Color(0, 0,
				64), 0.0f, 0.0f, Color.blue));
		list.add(new GradientPaintProvider(0.0f, 10.0f,
				new Color(0, 64, 0), 0.0f, 0.0f, new Color(152, 203, 0), true));
		list.add(new GradientPaintProvider(0.0f, 10.0f,
				new Color(0, 94, 0), 0.0f, 0.0f, new Color(160, 245, 0), true));

		plotSettings.setSeriesGradientPaintSequence(list);
		plotSettings.setDomainGridlineVisible(Boolean.TRUE);

		AxisSettings rangeAxisSettings = settings.getRangeAxisSettings();
		rangeAxisSettings.setLocation(AxisLocation.BOTTOM_OR_LEFT);
		rangeAxisSettings.setTickLabelsVisible(Boolean.TRUE);
		rangeAxisSettings.setTickInterval(new Float(0.2));
		rangeAxisSettings.setTickCount(11);
		rangeAxisSettings.getTickLabelFont().setBold(Boolean.TRUE);
		rangeAxisSettings.getTickLabelFont().setFontName("Arial");

		return settings;
	}

	@Deprecated
	private static Marker createMarker() {
		Marker optimal = new IntervalMarker(0.998, 1.001);
		optimal.setLabelOffsetType(LengthAdjustmentType.EXPAND);
		optimal.setPaint(new Color(219, 237, 219));
		optimal.setLabel("Ziel");
		optimal.setLabelFont(new java.awt.Font("Arial", Font.BOLD, 11));
		optimal.setLabelPaint(new Color(0, 128, 0));
		optimal.setLabelAnchor(RectangleAnchor.TOP);
		optimal.setLabelTextAnchor(TextAnchor.TOP_CENTER);
		return optimal;
	}

	private static LayeredBarRenderer createBarRenderer() {
		// disable bar outlines...
		LayeredBarRenderer renderer = new LayeredBarRenderer();
		renderer.setDrawBarOutline(false);

		// set up gradient paints for series...
		GradientPaint gp0 = new GradientPaint(0.0f, 0.0f, new Color(0, 0, 64),
				0.0f, 0.0f, Color.blue);
		GradientPaint gp2 = new GradientPaint(0.0f, 10.0f, new Color(0, 64, 0),
				0.0f, 0.0f, new Color(152, 203, 0), true);
		GradientPaint gp1 = new GradientPaint(0.0f, 10.0f, new Color(0, 94, 0),
				0.0f, 0.0f, new Color(160, 245, 0), true);

		renderer.setGradientPaintTransformer(new StandardGradientPaintTransformer(
				GradientPaintTransformType.CENTER_VERTICAL));
		renderer.setSeriesPaint(0, gp0);
		renderer.setSeriesPaint(1, gp1);
		renderer.setSeriesPaint(2, gp2);
		renderer.setDrawBarOutline(false);

		// int numBars = dataset.getColumnKeys().size();
		// if (numBars > 2) {
		// renderer.setSeriesBarWidth(0, 0.99);
		// renderer.setSeriesBarWidth(1, 0.99 * 0.89);
		// renderer.setSeriesBarWidth(2, 0.79 * 0.87);
		// } else if (numBars == 2) {
		renderer.setSeriesBarWidth(0, 0.99 * 0.9);
		renderer.setSeriesBarWidth(1, 0.99 * 0.89 * 0.9);
		renderer.setSeriesBarWidth(2, 0.79 * 0.87 * 0.9);
		// } else {
		// renderer.setSeriesBarWidth(0, 0.99 * 0.6);
		// renderer.setSeriesBarWidth(1, 0.99 * 0.89 * 0.6);
		// renderer.setSeriesBarWidth(2, 0.79 * 0.87 * 0.6);
		// }
		return renderer;

	}
}
