/**
 * 
 */
package net.sf.jasperreports.chartthemes.provider;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Paint;

import net.sf.jasperreports.engine.JRConstants;

/**
 * @author Aleh
 *
 */
public class GradientPaintProvider implements PaintProvider {

	/**
	 * Serial version id.
	 */
	private static final long serialVersionUID = JRConstants.SERIAL_VERSION_UID;

	/**
	 *
	 */
	private Color color1;
	private Color color2;

	/**
	 * 
	 */
	private float x1, x2, y1, y2;

	private boolean cyclic;

	/**
	 * @param x1
	 * @param y1
	 * @param color1
	 * @param x2
	 * @param y2
	 * @param color2
	 * @param color12
	 * @param color22
	 * @param x12
	 * @param x22
	 * @param y12
	 * @param y22
	 * @param cyclic
	 */
	public GradientPaintProvider(float x1, float y1,
			Color color1, float x2, float y2, Color color2, boolean cyclic) {
		this(x1, y1, color1, x2, y2, color2);
		this.cyclic = cyclic;
	}

	/**
	 * @param paint
	 *            to be extracted.
	 */
	public GradientPaintProvider(GradientPaint paint) {
		this((float) paint.getPoint1().getX(),
				(float) paint.getPoint1().getY(), paint.getColor1(),
				(float) paint.getPoint2().getX(), (float) paint.getPoint2()
						.getY(), paint.getColor2(), paint.isCyclic());
	}

	/**
	 * @param x1
	 * @param y1
	 * @param color1
	 * @param x2
	 * @param y2
	 * @param color2
	 */
	public GradientPaintProvider(float x1, float y1,
			Color color1, float x2, float y2, Color color2) {
		this.color1 = color1;
		this.color2 = color2;
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}

	/**
	 * 
	 */
	public GradientPaintProvider() {
	}

	/**
	 * @param color1
	 * @param color2
	 */
	public GradientPaintProvider(Color color1, Color color2) {
		this.color1 = color1;
		this.color2 = color2;
	}

	/**
	 * @return the cyclic
	 */
	public boolean isCyclic() {
		return cyclic;
	}

	/**
	 * @param cyclic
	 *            the cyclic to set
	 */
	public void setCyclic(boolean cyclic) {
		this.cyclic = cyclic;
	}

	/**
	 * @return the color1
	 */
	public Color getColor1() {
		return color1;
	}

	/**
	 * @param color1
	 *            the color1 to set
	 */
	public void setColor1(Color color1) {
		this.color1 = color1;
	}

	/**
	 * @return the color2
	 */
	public Color getColor2() {
		return color2;
	}

	/**
	 * @param color2
	 *            the color2 to set
	 */
	public void setColor2(Color color2) {
		this.color2 = color2;
	}

	/**
	 * @return the x1
	 */
	public float getX1() {
		return x1;
	}

	/**
	 * @param x1
	 *            the x1 to set
	 */
	public void setX1(float x1) {
		this.x1 = x1;
	}

	/**
	 * @return the x2
	 */
	public float getX2() {
		return x2;
	}

	/**
	 * @param x2
	 *            the x2 to set
	 */
	public void setX2(float x2) {
		this.x2 = x2;
	}

	/**
	 * @return the y1
	 */
	public float getY1() {
		return y1;
	}

	/**
	 * @param y1
	 *            the y1 to set
	 */
	public void setY1(float y1) {
		this.y1 = y1;
	}

	/**
	 * @return the y2
	 */
	public float getY2() {
		return y2;
	}

	/**
	 * @param y2
	 *            the y2 to set
	 */
	public void setY2(float y2) {
		this.y2 = y2;
	}

	@Override
	public Paint getPaint() {
		return new GradientPaint(x1, y1, color1, x2, y2, color2, cyclic);
	}
}
