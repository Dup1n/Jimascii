package org.dupin;

import ij.IJ;
import ij.ImagePlus;
import ij.process.ImageConverter;
import ij.process.ImageProcessor;

import java.util.Arrays;

public class ASCIIConverter {
    private static final String GRAY_RAMP = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/|()1{}[]?-_+~<>i!lI;:,\"^`'. ";
    private static final int RAMP_LENGTH = GRAY_RAMP.length();
    private static final int MAXIMUM_WIDTH = 100;
    private static final int MAXIMUM_HEIGHT = 180;
    private final ImagePlus image;

    public ASCIIConverter(String imageURL) {
        image = IJ.openImage(imageURL);
        ImageConverter img = new ImageConverter(image);
        int width = clampDimension(image.getWidth(), MAXIMUM_HEIGHT,(double) MAXIMUM_HEIGHT / image.getHeight());
        int height = clampDimension(image.getHeight(), MAXIMUM_WIDTH, (double) MAXIMUM_WIDTH / image.getWidth());
        ImageProcessor processor = image.getProcessor().resize(width, height);
        image.setProcessor(processor);
        img.convertToGray8();
    }

    public int clampDimension(int dimension, int maximum, double ratio) {
        return ratio <= 1.0 ? (int) Math.floor(dimension * ratio) : maximum;
    }

    public String getCharacterForGrayScale(int grayScale) {
        return String.valueOf(GRAY_RAMP.charAt((int) Math.ceil(((double)(RAMP_LENGTH - 1) * grayScale / 255))));
    }

    public void show() {
        StringBuilder result = new StringBuilder();
        for (int y = 0; y < image.getHeight(); y++) {
           for (int x = 0; x < image.getWidth(); x++) {
                result.append(getCharacterForGrayScale(Arrays.stream(image.getPixel(x, y)).sum()));
            }
            result.append("\n");
        }
        System.out.println(result);
        image.show();
    }
}
