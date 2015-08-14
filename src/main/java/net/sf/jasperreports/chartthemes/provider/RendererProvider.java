package net.sf.jasperreports.chartthemes.provider;

import org.jfree.chart.renderer.category.CategoryItemRenderer;

/**
 * @author Aleh
 *
 */
public class RendererProvider implements IRendererProvider {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Custom renderer.
	 */
	private CategoryItemRenderer renderer;

	/**
	 * @param renderer
	 */
	public RendererProvider(CategoryItemRenderer renderer) {
		this.renderer = renderer;
	}

	public RendererProvider() {
	}

	@Override
	public CategoryItemRenderer getRenderer() {
		return renderer;
	}

	/**
	 * @param renderer
	 *            the renderer to set
	 */
	public void setRenderer(CategoryItemRenderer renderer) {
		this.renderer = renderer;
	}
}
