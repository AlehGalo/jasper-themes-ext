/**
 * 
 */
package net.sf.jasperreports.chartthemes.handlers;

import org.exolab.castor.mapping.GeneralizedFieldHandler;
import org.jfree.ui.TextAnchor;

/**
 * @author Aleh
 *
 */
public class TextAnchorHandler extends GeneralizedFieldHandler {

	/**
	 * Default constructor.
	 */
	public TextAnchorHandler() {
	}

	@Override
	public Object convertUponGet(Object value) {
		if (value == null) {
			return null;
		}
		return ((TextAnchor) value).toString();
	}

	@Override
	public Object convertUponSet(Object value) {
		if (value == null) {
			return null;
		}
		String val = (String) value;
		return TextAnchor.BASELINE_CENTER.toString().equalsIgnoreCase(val) ? TextAnchor.BASELINE_CENTER
				: TextAnchor.BASELINE_LEFT.toString().equalsIgnoreCase(val) ? TextAnchor.BASELINE_LEFT
						: TextAnchor.BASELINE_RIGHT.toString()
								.equalsIgnoreCase(val) ? TextAnchor.BASELINE_RIGHT
								: TextAnchor.BOTTOM_CENTER.toString()
										.equalsIgnoreCase(val) ? TextAnchor.BOTTOM_CENTER
										: TextAnchor.BOTTOM_LEFT.toString()
												.equalsIgnoreCase(val) ? TextAnchor.BOTTOM_LEFT
												: TextAnchor.BOTTOM_RIGHT
														.toString()
														.equalsIgnoreCase(val) ? TextAnchor.BOTTOM_RIGHT
														: TextAnchor.CENTER
																.toString()
																.equalsIgnoreCase(
																		val) ? TextAnchor.CENTER
																: TextAnchor.CENTER_LEFT
																		.toString()
																		.equalsIgnoreCase(
																				val) ? TextAnchor.CENTER_LEFT
																		: TextAnchor.CENTER_RIGHT
																				.toString()
																				.equalsIgnoreCase(
																						val) ? TextAnchor.CENTER_RIGHT
																				: TextAnchor.TOP_RIGHT
																						.toString()
																						.equalsIgnoreCase(
																								val) ? TextAnchor.TOP_RIGHT
																						: TextAnchor.TOP_LEFT
																								.toString()
																								.equalsIgnoreCase(
																										val) ? TextAnchor.TOP_LEFT
																								: TextAnchor.TOP_CENTER
																										.toString()
																										.equalsIgnoreCase(
																												val) ? TextAnchor.TOP_CENTER
																										: TextAnchor.HALF_ASCENT_RIGHT
																												.toString()
																												.equalsIgnoreCase(
																														val) ? TextAnchor.HALF_ASCENT_RIGHT
																												: TextAnchor.HALF_ASCENT_LEFT
																														.toString()
																														.equalsIgnoreCase(
																																val) ? TextAnchor.HALF_ASCENT_LEFT
																														: TextAnchor.HALF_ASCENT_CENTER
																																.toString()
																																.equalsIgnoreCase(
																																		val) ? TextAnchor.HALF_ASCENT_CENTER
																																: null;
	}

	@Override
	public Class<org.jfree.ui.TextAnchor> getFieldType() {
		return org.jfree.ui.TextAnchor.class;
	}

}
