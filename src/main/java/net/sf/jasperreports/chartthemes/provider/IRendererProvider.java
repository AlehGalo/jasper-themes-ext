/**
 * 
 */
package net.sf.jasperreports.chartthemes.provider;

import java.io.Serializable;

import org.jfree.chart.renderer.category.CategoryItemRenderer;

/**
 * @author Aleh
 *
 */
public interface IRendererProvider extends Serializable {

	/**
	 * @return
	 */
	CategoryItemRenderer getRenderer();

}
