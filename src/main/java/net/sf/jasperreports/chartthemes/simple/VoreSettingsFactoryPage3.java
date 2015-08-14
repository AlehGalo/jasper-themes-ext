/**
 * 
 */
package net.sf.jasperreports.chartthemes.simple;

import java.awt.BasicStroke;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.jfree.chart.axis.AxisLocation;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.VerticalAlignment;

import net.sf.jasperreports.charts.type.EdgeEnum;
import net.sf.jasperreports.chartthemes.provider.ColorProvider;
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
public class VoreSettingsFactoryPage3 {

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
		legendSettings.setShowLegend(Boolean.TRUE);
		legendSettings.setPosition(EdgeEnum.BOTTOM);
		legendSettings.getFont().setBold(Boolean.FALSE);
		legendSettings.setHorizontalAlignment(HorizontalAlignment.CENTER);
		legendSettings.setVerticalAlignment(VerticalAlignment.BOTTOM);
		legendSettings.setBorder(0f);

		PlotSettings plotSettings = settings.getPlotSettings();
		plotSettings.setLabelRotation(new Double(0));
		plotSettings.setOutlineVisible(Boolean.FALSE);

		List<PaintProvider> list = new ArrayList<PaintProvider>();
		list.add(new ColorProvider(new Color(153, 51, 0)));
		list.add(new ColorProvider(new Color(0, 204, 101)));

		plotSettings.setSeriesGradientPaintSequence(list);
		plotSettings.setRangeGridlineStroke(new BasicStroke(0.1F));
		plotSettings.setDomainGridlineVisible(false);
		plotSettings.setRangeGridlineVisible(true);

		AxisSettings domainAxisSettings = settings.getDomainAxisSettings();
		domainAxisSettings.setLineVisible(true);
		domainAxisSettings.getTickLabelFont().setBold(Boolean.TRUE);
		domainAxisSettings.getTickLabelFont().setFontName("Arial");

		AxisSettings rangeAxisSettings = settings.getRangeAxisSettings();
		rangeAxisSettings.setLocation(AxisLocation.BOTTOM_OR_LEFT);
		rangeAxisSettings.setTickLabelsVisible(Boolean.TRUE);
		rangeAxisSettings.setAutoAdjustToZero(false);
		return settings;
	}
}
