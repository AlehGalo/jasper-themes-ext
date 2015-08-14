/**
 * 
 */
package net.sf.jasperreports.chartthemes.handlers;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.geom.Point2D;

import net.sf.jasperreports.engine.util.JRColorUtil;

import org.exolab.castor.mapping.GeneralizedFieldHandler;

/**
 * @author Aleh
 *
 */
public class GradientFieldHandler extends GeneralizedFieldHandler {

	/**
	 * 
	 */
	public GradientFieldHandler() {
	}

	/**
	 *
	 */
	public Object convertUponGet(Object value) {
		if (value == null) {
			return null;
		}
		GradientPaint gradientPaint = (GradientPaint) value;
		Color color1 = gradientPaint.getColor1();
		Color color2 = gradientPaint.getColor2();
		Point2D point1 = gradientPaint.getPoint1();
		Point2D point2 = gradientPaint.getPoint2();
		boolean isCyclic = gradientPaint.isCyclic();
		return "#" + JRColorUtil.getColorHexa(color1) + "#"
				+ JRColorUtil.getColorHexa(color2) + "#" + point1.getX() + "#"
				+ point1.getY() + "#" + point2.getX() + "#" + point2.getY()
				+ "#" + String.valueOf(isCyclic);
	}

	/**
	 *
	 */
	public Object convertUponSet(Object value) {
		if (value == null) {
			return null;
		}
		if (value instanceof String) {
			String arg[] = ((String) value).split("#");
			if (arg.length != 7) {
				throw new IllegalArgumentException(
						"Incorrect number of arguments " + arg.length);
			}
			return new GradientPaint(Float.valueOf(arg[2]),
					Float.valueOf(arg[3]), JRColorUtil.getColor("#" + arg[0],
							null), Float.valueOf(arg[4]),
					Float.valueOf(arg[5]), JRColorUtil.getColor("#" + arg[1],
							null), Boolean.valueOf(arg[6]));
		}
		return null;
	}

	/**
	 *
	 */
	public Class<GradientPaint> getFieldType() {
		return GradientPaint.class;
	}

}
