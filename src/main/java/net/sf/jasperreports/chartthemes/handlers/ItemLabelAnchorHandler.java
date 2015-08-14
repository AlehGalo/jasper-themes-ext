/**
 * 
 */
package net.sf.jasperreports.chartthemes.handlers;

import org.exolab.castor.mapping.GeneralizedFieldHandler;
import org.jfree.chart.labels.ItemLabelAnchor;

/**
 * @author Aleh
 *
 */
public class ItemLabelAnchorHandler extends GeneralizedFieldHandler {

	@Override
	public Object convertUponGet(Object value) {
		if (value == null) {
			return null;
		}
		return ((ItemLabelAnchor) value).toString();

	}

	@Override
	public Object convertUponSet(Object value) {
		if (value == null) {
			return null;
		}
		String val = (String) value;
		return ItemLabelAnchor.CENTER.toString().equalsIgnoreCase(val) ? ItemLabelAnchor.CENTER
				: ItemLabelAnchor.INSIDE1.toString().equalsIgnoreCase(val) ? ItemLabelAnchor.INSIDE1
						: ItemLabelAnchor.OUTSIDE1.toString().equalsIgnoreCase(
								val) ? ItemLabelAnchor.OUTSIDE1 : null;

	}

	@Override
	public Class<ItemLabelAnchor> getFieldType() {
		return ItemLabelAnchor.class;
	}

}
