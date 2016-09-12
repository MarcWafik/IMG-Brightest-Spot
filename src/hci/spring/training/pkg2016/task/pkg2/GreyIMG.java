package hci.spring.training.pkg2016.task.pkg2;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;

public class GreyIMG {

	final static float Accuracy = 0.06F; // max value should not pass 1.0  
	BufferedImage OriginalIMG;
	BufferedImage GreyIMG;
	BufferedImage BrightSpotsIMG;
	BufferedImage MostBriSpotIMG;
	int h;
	int w;
	float MAXLumi = 0F;

	public GreyIMG(String Filename) throws IOException {
		Load(Filename);
		getGrayScale();
		BrightPixles();
		//		MostBrightSpot();
		Save();
	}

	public void getGrayScale() {
		h = OriginalIMG.getHeight();
		w = OriginalIMG.getWidth();
		GreyIMG = getGrayScale(OriginalIMG);
	}

	public void Load(String Filename) throws IOException {
		OriginalIMG = LoadS(Filename);
	}

	public void Save() throws IOException {
		Save(GreyIMG, "GrayImage.jpg");
		Save(BrightSpotsIMG, "BrightSpots.jpg");
		//				Save(MostBriSpotIMG, "MostBriSpotIMG.jpg");
	}

	public void Print() {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				System.out.print(Luminance(GreyIMG.getRGB(i, j)) + "\t");
			}
			System.out.print("\n");
		}
	}

	public void getMAXLumi() {
		if (MAXLumi == 0) {
			for (int y = 0; y < h; y++) {
				for (int x = 0; x < w; x++) {
					float temp = Luminance(BrightSpotsIMG.getRGB(x, y));
					if (temp > MAXLumi) {
						MAXLumi = temp;
					}
					if (MAXLumi == 1.0) {
						break;
					}
				}
			}
		}
	}

	public boolean isBright(int x, int y) {
		return (MAXLumi - Accuracy <= Luminance(GreyIMG.getRGB(x, y))) && (MAXLumi + Accuracy >= Luminance(GreyIMG.getRGB(x, y)));
	}

	public void BrightPixles() {
		BrightSpotsIMG = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		Graphics g = BrightSpotsIMG.getGraphics();
		g.drawImage(GreyIMG, 0, 0, null); // draw over the GreyIMG
		g.dispose();
		getMAXLumi();
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				if (isBright(x, y)) {
					BrightSpotsIMG.setRGB(x, y, Color.red.getRGB());
				}
			}
		}
	}

	int Visited[][];

	public void MostBrightSpot() {
		System.out.println(h + "   " + w);
		Visited = new int[w][h];
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				Visited[i][j] = 0;
			}
		}
		ArrayList<Spot> spots = new ArrayList<>();

		MostBriSpotIMG = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		Graphics g = MostBriSpotIMG.getGraphics();
		g.drawImage(GreyIMG, 0, 0, null);
		for (int y = 1; y < h; y++) {
			for (int x = 1; x < w; x++) {
				if (isBright(x, y)) {
					if (spots.isEmpty()) {
						Spot temp = new Spot();
						temp.Loc.add(new Point(x, y));
						spots.add(temp);
						Visited[x][y] = spots.size() - 1;
					} else if (x != 0 && y != 0) {
						if (isBright(x - 1, y)) {
							spots.get(Visited[x - 1][y]).Loc.add(new Point(x, y));
						} else if (isBright(x, y - 1)) {
							spots.get(Visited[x][y - 1]).Loc.add(new Point(x, y));
						} else if (isBright(x - 1, y - 1)) {
							spots.get(Visited[x - 1][y - 1]).Loc.add(new Point(x, y));
						} else {
							Spot temp = new Spot();
							temp.Loc.add(new Point(x, y));
							spots.add(temp);
							Visited[x][y] = spots.size() - 1;
						}
					}
				}
			}
		}
		System.out.println(spots.size());
		Spot most_bright = new Spot();
		for (int i = 0; i < spots.size(); i++) {
			if (most_bright.TotalLumi() < spots.get(i).TotalLumi()) {
				most_bright = spots.get(i);
			}
		}
		for (int i = 0; i < most_bright.Loc.size(); i++) {
			MostBriSpotIMG.setRGB(most_bright.Loc.get(i).x, most_bright.Loc.get(i).y, Color.red.getRGB());
		}
	}

	//================================================  Static   ==============================================================================
	public static BufferedImage getGrayScale(BufferedImage inputImage) {
		BufferedImage img = new BufferedImage(inputImage.getWidth(), inputImage.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
		Graphics g = img.getGraphics();
		g.drawImage(inputImage, 0, 0, null);
		g.dispose();
		return img;
	}

	public static BufferedImage LoadS(String Filename) throws IOException {
		BufferedInputStream IS = new BufferedInputStream(new FileInputStream(Filename));
		return ImageIO.read(IS);
	}

	public static void Save(BufferedImage inputImage, String FileName) throws IOException {
		File GrayIamgeOutPut = new File(FileName);
		//create File To store The Image
		ImageIO.write(inputImage, "jpg", GrayIamgeOutPut);
	}

	public static float Luminance(int RGB) {
		int red = (RGB >>> 16) & 0xFF;
		int green = (RGB >>> 8) & 0xFF;
		int blue = (RGB >>> 0) & 0xFF;

		// calc luminance in range 0.0 ~ 1.0; using SRGB luminance constants				
		return (red * 0.2126f + green * 0.7152f + blue * 0.0722f) / 255;					// i got that formula from 
		//https://github.com/atduskgreg/opencv-processing-book/blob/master/book/tracking/brightest_point.md
	}

	public class Spot {

		ArrayList<Point> Loc;
		float Lumi = 0;

		public Spot() {
			this.Loc = new ArrayList();
		}

		float TotalLumi() {
			if (Lumi != 0) {
				return Lumi;
			}
			for (int x = 0; x < Loc.size(); w++) {
				Lumi = Lumi + Luminance(GreyIMG.getRGB(Loc.get(x).x, Loc.get(x).y));
			}
			return Lumi;
		}
	}
}

/*
			BufferedInputStream IS;
			BufferedImage image;
			BufferedImage imageAsGrayScale;
			Mat ImageMat;
			Mat GrayImageMat;

			public ImageToGrayScale()
			{System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}

			public void GetInput(String Filename) throws IOException
			{
						IS = new BufferedInputStream(new FileInputStream(Filename));
						image = ImageIO.read(IS);
			}

			public void turnToGrayScale() throws IOException
			{
						byte[] imagedata = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
						// Create array of bytes that represent the data in The image .
						ImageMat = new Mat(image.getHeight(), image.getWidth(), CvType.CV_8UC3);
						//Declaring a Mat variable [matrix] .
						ImageMat.put(0, 0, imagedata);
						//putting The Image Data into The Mat Matrix.[it doesn't change The Image Itself]
						GrayImageMat = new Mat(image.getHeight(), image.getWidth(), CvType.CV_8UC3);
						//Create the Mat Matrix that Will Hold the Data Of the grayScale Image .
						Imgproc.cvtColor(ImageMat, GrayImageMat, Imgproc.COLOR_RGB2GRAY);
						//Take the data from ImageData , Convert in to Gray then apply The conversion on GrayImageData.
						byte[] grayimageData = new byte[(GrayImageMat.rows()) * (GrayImageMat.cols()) * ((int) GrayImageMat.elemSize())];
						//create array of  bytes to represent the data in the grayScale Image  
						//The Size of the array equals to the number of rows X number of colons X The Size Of each element in the Image
						GrayImageMat.get(0, 0, grayimageData);
						//putting the image data into the Mat Matrix and Changing The new Image To GrayScale
						imageAsGrayScale = new BufferedImage(GrayImageMat.cols(), GrayImageMat.rows(), BufferedImage.TYPE_BYTE_GRAY);
						//Declare the Image Buffer to make "image.jpg" File .
						imageAsGrayScale.getRaster().setDataElements(0, 0, GrayImageMat.cols(), GrayImageMat.rows(), grayimageData);
						//put the Buffered Data from the GrayImageData matrix  to the Image Raster.
						File GrayIamgeOutPut = new File("GrayImage.jpg");
						//create File To store The Image
						ImageIO.write(imageAsGrayScale, "jpg", GrayIamgeOutPut);
						//writing the image into the file.
			}
 */
