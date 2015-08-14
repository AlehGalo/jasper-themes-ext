/**
 * 
 */
package net.sf.jasperreports.chartthemes.provider;

import java.awt.Font;
import java.awt.Paint;
import java.util.List;

import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LayeredBarRenderer;
import org.jfree.ui.StandardGradientPaintTransformer;

/**
 * @author Aleh
 *
 */
public class LayeredBarRendererProvider implements IRendererProvider,
		IApplyProperties {

	/**
	 * Default serial version id.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private LayeredBarRenderer renderer;

	/**
	 * 
	 */
	private Boolean drawBarOutline, baseItemLabelsVisible;

	/**
	 * 
	 */
	private StandardGradientPaintTransformer gradientPaintTransformer;

	/** The base item label font. */
	private Font baseItemLabelFont;

	/**
	 * 
	 */
	private PaintProvider baseItemLabelPaint;

	/**
	 * 
	 */
	private CategoryItemLabelGenerator baseItemLabelGenerator;

	/**
	 * 
	 */
	private ItemLabelPosition positiveItemLabelPosition;

	/**
	 * 
	 */
	private List<Double> seriesBarWidth;

	/**
	 * 
	 */
	private List<PaintProvider> seriesPaint;

	/**
	 * 
	 */
	public LayeredBarRendererProvider() {
		renderer = new LayeredBarRenderer();
	}

	@Override
	public CategoryItemRenderer getRenderer() {
		return renderer;
	}

	/**
	 * @return the drawBarOutline
	 */
	public Boolean getDrawBarOutline() {
		return drawBarOutline;
	}

	/**
	 * @param drawBarOutline
	 *            the drawBarOutline to set
	 */
	public void setDrawBarOutline(Boolean drawBarOutline) {
		this.drawBarOutline = drawBarOutline;
	}

	/**
	 * @return the baseItemLabelsVisible
	 */
	public Boolean getBaseItemLabelsVisible() {
		return baseItemLabelsVisible;
	}

	/**
	 * @param baseItemLabelsVisible
	 *            the baseItemLabelsVisible to set
	 */
	public void setBaseItemLabelsVisible(Boolean baseItemLabelsVisible) {
		this.baseItemLabelsVisible = baseItemLabelsVisible;
	}

	/**
	 * @return the gradientPaintTransformer
	 */
	public StandardGradientPaintTransformer getGradientPaintTransformer() {
		return gradientPaintTransformer;
	}

	/**
	 * @param gradientPaintTransformer
	 *            the gradientPaintTransformer to set
	 */
	public void setGradientPaintTransformer(
			StandardGradientPaintTransformer gradientPaintTransformer) {
		this.gradientPaintTransformer = gradientPaintTransformer;
	}

	/**
	 * @return the baseItemLabelFont
	 */
	public Font getBaseItemLabelFont() {
		return baseItemLabelFont;
	}

	/**
	 * @param baseItemLabelFont
	 *            the baseItemLabelFont to set
	 */
	public void setBaseItemLabelFont(Font baseItemLabelFont) {
		this.baseItemLabelFont = baseItemLabelFont;
	}

	/**
	 * @return the baseItemLabelPaint
	 */
	public PaintProvider getBaseItemLabelPaint() {
		return baseItemLabelPaint;
	}

	/**
	 * @param baseItemLabelPaint
	 *            the baseItemLabelPaint to set
	 */
	public void setBaseItemLabelPaint(PaintProvider baseItemLabelPaint) {
		this.baseItemLabelPaint = baseItemLabelPaint;
	}

	/**
	 * @return the baseItemLabelGenerator
	 */
	public CategoryItemLabelGenerator getBaseItemLabelGenerator() {
		return baseItemLabelGenerator;
	}

	/**
	 * @param baseItemLabelGenerator
	 *            the baseItemLabelGenerator to set
	 */
	public void setBaseItemLabelGenerator(
			CategoryItemLabelGenerator baseItemLabelGenerator) {
		this.baseItemLabelGenerator = baseItemLabelGenerator;
	}

	/**
	 * @return the positiveItemLabelPosition
	 */
	public ItemLabelPosition getPositiveItemLabelPosition() {
		return positiveItemLabelPosition;
	}

	/**
	 * @param positiveItemLabelPosition
	 *            the positiveItemLabelPosition to set
	 */
	public void setPositiveItemLabelPosition(
			ItemLabelPosition positiveItemLabelPosition) {
		this.positiveItemLabelPosition = positiveItemLabelPosition;
	}

	/**
	 * @return the seriesBarWidth
	 */
	public List<Double> getSeriesBarWidth() {
		return seriesBarWidth;
	}

	/**
	 * @param seriesBarWidth
	 *            the seriesBarWidth to set
	 */
	public void setSeriesBarWidth(List<Double> seriesBarWidth) {
		this.seriesBarWidth = seriesBarWidth;
	}

	/**
	 * @return the seriesPaint
	 */
	public List<PaintProvider> getSeriesPaint() {
		return seriesPaint;
	}

	/**
	 * @param seriesPaint
	 *            the seriesPaint to set
	 */
	public void setSeriesPaint(List<PaintProvider> seriesPaint) {
		this.seriesPaint = seriesPaint;
	}

	@Override
	public void applyProperties() {
		Object obj = getDrawBarOutline();
		if (isNotNull(obj)) {
			renderer.setDrawBarOutline((Boolean) obj);
		}
		obj = getBaseItemLabelsVisible();
		if (isNotNull(obj)) {
			renderer.setBaseItemLabelsVisible((Boolean) obj);
		}
		obj = getGradientPaintTransformer();
		if (isNotNull(obj)) {
			renderer.setGradientPaintTransformer((StandardGradientPaintTransformer) obj);
		}
		obj = getBaseItemLabelFont();
		if (isNotNull(obj)) {
			renderer.setBaseItemLabelFont((Font) obj);
		}
		obj = getBaseItemLabelPaint();
		if (isNotNull(obj)) {
			renderer.setBaseItemLabelPaint((Paint) obj);
		}
		obj = getBaseItemLabelGenerator();
		if (isNotNull(obj)) {
			renderer.setBaseItemLabelGenerator((CategoryItemLabelGenerator) obj);
		}
		obj = getPositiveItemLabelPosition();
		if (isNotNull(obj)) {
			renderer.setBasePositiveItemLabelPosition((ItemLabelPosition) obj);
		}
		obj = getSeriesBarWidth();
		if (isNotNull(obj)) {
			@SuppressWarnings("unchecked")
			List<Double> list = (List<Double>) obj;
			for (int i = 0; i < list.size(); i++) {
				renderer.setSeriesBarWidth(i, list.get(i));
			}
		}
		obj = getSeriesPaint();
		if (isNotNull(obj)) {
			@SuppressWarnings("unchecked")
			List<GradientPaintProvider> list = (List<GradientPaintProvider>) obj;
			for (int i = 0; i < list.size(); i++) {
				renderer.setSeriesPaint(i, list.get(i).getPaint());
			}
		}
	}

	/**
	 * @param obj
	 * @return
	 */
	private boolean isNotNull(Object obj) {
		return obj != null;
	}
}
