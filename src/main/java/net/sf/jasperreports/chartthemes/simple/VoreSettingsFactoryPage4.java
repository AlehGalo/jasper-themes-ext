/**
 * 
 */
package net.sf.jasperreports.chartthemes.simple;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.StandardGradientPaintTransformer;
import org.jfree.ui.TextAnchor;

import net.sf.jasperreports.chartthemes.provider.ColorProvider;
import net.sf.jasperreports.chartthemes.provider.GradientPaintProvider;
import net.sf.jasperreports.chartthemes.settings.ChartSettings;
import net.sf.jasperreports.chartthemes.settings.ChartThemeSettings;
import net.sf.jasperreports.chartthemes.settings.LegendSettings;
import net.sf.jasperreports.chartthemes.settings.PlotSettings;

/**
 * @author Aleh
 *
 */
public class VoreSettingsFactoryPage4 {

	private static final GradientPaint gp0 = new GradientPaint(0.0f, 10.0f,
			new Color(155, 205, 32), 0.0f, 0.0f, new Color(229, 242, 190), true);
	private static final GradientPaint gp1 = new GradientPaint(0.0f, 0.0f,
			new Color(23, 47, 119), 0.0f, 0.0f, new Color(50, 101, 253), true);

	/**
	 *
	 */
	public static final ChartThemeSettings createChartThemeSettings() {
		ChartThemeSettings settings = new ChartThemeSettings();

		settings.getTitleSettings().setForegroundPaint(
				new ColorProvider(new Color(0, 96, 160)));

		ChartSettings chartSettings = settings.getChartSettings();
		chartSettings.setBackgroundPaint(new ColorProvider(Color.white));
		chartSettings.setBorderPaint(new ColorProvider(Color.white));

		LegendSettings legendSettings = settings.getLegendSettings();
		legendSettings.setShowLegend(false);

		PlotSettings plotSettings = settings.getPlotSettings();
		plotSettings.setLabelRotation(new Double(0));
		plotSettings.setOutlineVisible(false);
		plotSettings
				.setGradientPaintTransformer(new StandardGradientPaintTransformer(
						GradientPaintTransformType.CENTER_HORIZONTAL));
		plotSettings
				.setSeriesGradientPaintSequence(Arrays.asList(
						new GradientPaintProvider(gp0),
						new GradientPaintProvider(gp1)));

		List<Stroke> list1 = new ArrayList<Stroke>();
		list1.add(new BasicStroke(2f));
		plotSettings.setSeriesStrokeSequence(list1);
		plotSettings.setDomainGridlineVisible(true);
		plotSettings.setRangeGridlineStroke(new BasicStroke(0.1F));

		plotSettings.setBaseItemLabelsVisible(true);
		plotSettings.setBaseItemLabelPaint(new ColorProvider(Color.black));
		plotSettings.getBaseItemLabelFont().setFontName("Arial");
		plotSettings.getBaseItemLabelFont().setBold(true);
		plotSettings.getBaseItemLabelFont().setFontSize(10f);
		plotSettings.setItemLabelPosition(new ItemLabelPosition(
				ItemLabelAnchor.CENTER, TextAnchor.CENTER, TextAnchor.CENTER,
				10d));

		return settings;
	}
}
