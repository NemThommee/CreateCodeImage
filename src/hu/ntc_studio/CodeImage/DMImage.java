/**
 * Nos ide kell majd leírás ...
 * dokumentációs célzattal... 
 */

package hu.ntc_studio.CodeImage;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;

import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class DMImage {
	DMImage() {
		/* ekkor kívül setterkedünk ;) */ };

	DMImage(String text, String filepath) {
		this.setText(text);
		this.setFilePath(filepath);
	};

	DMImage(String text, String filepath, String charset) {
		this.setText(text);
		this.setFilePath(filepath);
		this.setCharSet(charset);
	};

	DMImage(String text, String filepath, String charset, int meret) {
		this.setText(text);
		this.setFilePath(filepath);
		this.setCharSet(charset);
		this.setMeret(meret);
	};

	private String text;
	private String filePath;

	private String charSet = "ISO-8859-1";
	private int meret = 200;

	public String getText() { return text; }
	public void setText(String text) { this.text = utfToIso(text); }
	
	public String getCharSet() { return charSet; }
	public void setCharSet(String charSet) { this.charSet = charSet; }

	public String getFilePath() { return filePath; }
	public void setFilePath(String filePath) { this.filePath = filePath; }

	public int getMeret() {	return this.meret; };
	public void setMeret(int meret) { this.meret = meret; };

	public BitMatrix getImage() {
		try {
			Map<EncodeHintType, ErrorCorrectionLevel> 
			hintMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();

			hintMap.put(EncodeHintType.ERROR_CORRECTION, 
					ErrorCorrectionLevel.L);

			BitMatrix 
			matrix = new MultiFormatWriter().encode(
					new String(text.getBytes(this.getCharSet()), 
							this.getCharSet()), 
					BarcodeFormat.DATA_MATRIX, 
					meret,
					meret, 
					hintMap);

			return matrix;

		} catch (Exception e) {

			System.err.println(e);
			return null;
		}
	}

	public void writeImage(BitMatrix image) {
		try {
								
			MatrixToImageWriter.writeToPath(  
					image, 
					filePath.substring(filePath.lastIndexOf(".") + 1),
					new File(filePath).toPath());

		} catch (Exception e) {
			System.err.println(e);
		}

	}
	
	private String utfToIso(String inp) {
				
		return inp.replace("ű","ü").replace("Ű","Ü").replace("ő","ö")
				.replace("Ő","Ö").replace("í","i").replace("Í","I");
		}
}
