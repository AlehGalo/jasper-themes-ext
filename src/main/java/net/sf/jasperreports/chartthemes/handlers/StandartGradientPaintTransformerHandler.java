package net.sf.jasperreports.chartthemes.handlers;

import org.exolab.castor.mapping.GeneralizedFieldHandler;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.StandardGradientPaintTransformer;

public class StandartGradientPaintTransformerHandler extends GeneralizedFieldHandler {

	/**
	 *
	 */
	public Object convertUponGet(Object value) {
		if (value == null) {
			return null;
		}
		return ((StandardGradientPaintTransformer) value).getType().toString();
	}

	/**
	 *
	 */
	public Object convertUponSet(Object value) {
		if (value == null) {
			return null;
		}
		GradientPaintTransformType type = GradientPaintTransformType.CENTER_HORIZONTAL.toString().equals(value)
				? GradientPaintTransformType.CENTER_HORIZONTAL
				: GradientPaintTransformType.CENTER_VERTICAL.toString().equals(value)
						? GradientPaintTransformType.CENTER_VERTICAL
						: GradientPaintTransformType.HORIZONTAL.toString().equals(value)
								? GradientPaintTransformType.HORIZONTAL
								: GradientPaintTransformType.VERTICAL.toString().equals(value)
										? GradientPaintTransformType.VERTICAL : null;
		if (type != null) {
			return new StandardGradientPaintTransformer(type);
		}
		return null;
	}

	@Override
	public Class<StandardGradientPaintTransformer> getFieldType() {
		return StandardGradientPaintTransformer.class;
	}

}
