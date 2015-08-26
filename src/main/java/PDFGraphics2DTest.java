import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;

/**
 * 
 */

/**
 * @author aleh.bahatyrou
 *
 */
public class PDFGraphics2DTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	private static void createGradientImageByGraphics2D() {
		System.out.println("Start");
		BufferedImage image = new BufferedImage(300, 100, BufferedImage.TYPE_4BYTE_ABGR);
		Graphics2D gr = image.createGraphics();
		gr.setPaint(new GradientPaint(new Point(0, 0), Color.BLUE, new Point(20, 0), Color.GREEN, true));
		gr.fill(new Rectangle(0, 0, 250, 90));
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			ImageIO.write(image, "png", out);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Files.copy(new ByteArrayInputStream(out.toByteArray()),
					Paths.get(ChartThemesApp.TMP_DIR + System.currentTimeMillis() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("End");
	}
	
	private static void createGradientImageByGraphics2D() {
		System.out.println("Start");
		PdfContentByte pdfContentByte = new PdfContentByte(new PdfWriter());
		BufferedImage image = new BufferedImage(300, 100, BufferedImage.TYPE_4BYTE_ABGR);
		Graphics2D gr = image.createGraphics();
		gr.setPaint(new GradientPaint(new Point(0, 0), Color.BLUE, new Point(20, 0), Color.GREEN, true));
		gr.fill(new Rectangle(0, 0, 250, 90));
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			ImageIO.write(image, "png", out);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Files.copy(new ByteArrayInputStream(out.toByteArray()),
					Paths.get(ChartThemesApp.TMP_DIR + System.currentTimeMillis() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("End");
	}

}