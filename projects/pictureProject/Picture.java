package pixLab.classes;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * A class that represents a picture.  This class inherits from
 * SimplePicture and allows the student to add functionality to
 * the Picture class.
 *
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture {

    private static String filePath = "E:\\Code\\Java\\workspace\\AP Computer Science\\projects\\pixLab\\images\\";

    ///////////////////// constructors //////////////////////////////////

    /**
     * Constructor that takes no arguments
     */
    public Picture() {
        /* not needed but use it to show students the implicit call to super()
         * child constructors always call a parent constructor
         */
        super();
    }

    /**
     * Constructor that takes a file name and creates the picture
     *
     * @param fileName the name of the file to create the picture from
     */
    public Picture(String fileName) {
        // let the parent class handle this fileName
        super(fileName);
    }

    /**
     * Constructor that takes the width and height
     *
     * @param height the height of the desired picture
     * @param width  the width of the desired picture
     */
    public Picture(int height, int width) {
        // let the parent class handle this width and height
        super(width, height);
    }

    /**
     * Constructor that takes a picture and creates a
     * copy of that picture
     *
     * @param copyPicture the picture to copy
     */
    public Picture(Picture copyPicture) {
        // let the parent class do the copy
        super(copyPicture);
    }

    /**
     * Constructor that takes a buffered image
     *
     * @param image the buffered image to use
     */
    public Picture(BufferedImage image) {
        super(image);
    }

    ////////////////////// methods ///////////////////////////////////////

    /**
     * Method to return a string with information about this picture.
     *
     * @return a string with information about the picture such as fileName,
     * height and width.
     */
    public String toString() {
        String output = "Picture, filename " + getFileName() +
                " height " + getHeight()
                + " width " + getWidth();
        return output;

    }

    /**
     * Method to set the red to 0
     */
    public void zeroRed() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] row : pixels) {
            for (Pixel col : row) {
                col.setRed(0);
            }
        }
    }

    // Method to set green and blue to 0
    public void keepOnlyRed() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] row : pixels) {
            for (Pixel col : row) {
                col.setGreen(0);
                col.setBlue(0);
            }
        }
    }

    /**
     * Method to set the green to 0
     */
    public void zeroGreen() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] row : pixels) {
            for (Pixel col : row) {
                col.setGreen(0);
            }
        }
    }

    // Method to set red and blue to 0
    public void keepOnlyGreen() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] row : pixels) {
            for (Pixel col : row) {
                col.setRed(0);
                col.setBlue(0);
            }
        }
    }

    /**
     * Method to set the blue to 0
     */
    public void zeroBlue() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] row : pixels) {
            for (Pixel col : row) {
                col.setBlue(0);
            }
        }
    }

    // Method to set red and green to 0
    public void keepOnlyBlue() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] row : pixels) {
            for (Pixel col : row) {
                col.setRed(0);
                col.setGreen(0);
            }
        }
    }

    public void negate() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] row : pixels) {
            for (Pixel col : row) {
                col.setRed(255 - col.getRed());
                col.setGreen(255 - col.getGreen());
                col.setBlue(255 - col.getBlue());
            }
        }
    }

    public void grayscale() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] row : pixels) {
            for (Pixel col : row) {
                int avg = (col.getRed() + col.getGreen() + col.getBlue()) / 3;
                col.setRed(avg);
                col.setGreen(avg);
                col.setBlue(avg);
            }
        }
    }

    /**
     * Some ideas for fixUnderwater() - which is supposed to distinguish the "fish":
     * -Take the average RGB values from a sample of a "fish" and use that to discover other "fish" in the JPG.
     * When going throught he JPG, if another "fish" pixel is found, distinguish it from other pixels
     * (e.g. increase blue for it and decrease for others.
     * -Change the picture in general. (e.g. increase overall red values by @param factor).
     * <p>
     * Other ideas to come.
     */
    public void fixUnderwater() {
        int factor = 5;
    }

    /**
     * Method that mirrors the picture around a
     * vertical mirror in the center of the picture
     * from left to right
     */
    public void mirrorVertical() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < width / 2; col++) {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    /**
     * Method that mirrors the picture around a
     * vertical mirror in the center of the picture
     * from right to left
     */
    public void mirrorVerticalRightToLeft() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < width / 2; col++) {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                leftPixel.setColor(rightPixel.getColor());
            }
        }
    }

    /**
     * Method that mirrors the picture around a
     * horizontal mirror in the center of the picture
     * from top to bottom
     */
    public void mirrorHorizontal() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        int height = pixels.length;
        for (int col = 0; col < pixels[0].length; col++) {
            for (int row = 0; row < pixels.length; row++) {
                topPixel = pixels[row][col];
                bottomPixel = pixels[height - 1 - row][col];
                bottomPixel.setColor(topPixel.getColor());
            }
        }
    }

    /**
     * Method that mirrors the picture around a
     * horizontal mirror in the center of the picture
     * from bottom to top
     */
    public void mirrorHorizontalBotToTop() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        int height = pixels.length;
        for (int col = 0; col < pixels[0].length; col++) {
            for (int row = 0; row < pixels.length; row++) {
                topPixel = pixels[row][col];
                bottomPixel = pixels[height - 1 - row][col];
                topPixel.setColor(bottomPixel.getColor());
            }
        }
    }

    /**
     * Mirror just part of a picture of a temple
     */
    public void mirrorTemple() {
        int mirrorPoint = 276;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows
        for (int row = 27; row < 97; row++) {
            // loop from 13 to just before the mirror point
            for (int col = 13; col < mirrorPoint; col++) {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row]
                        [mirrorPoint - col + mirrorPoint];
                rightPixel.setColor(leftPixel.getColor());
                count++;
            }
        }
        System.out.print(count);
    }

    /**
     * Will mirror a square part of the image from the bottom left to the top right of the same diagonal
     */
    public void mirrorDiagonal() {
        Pixel[][] pixels = this.getPixels2D();

        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col <= row; col++) {
                pixels[col][row].setColor(pixels[row][col].getColor());
            }
        }
    }

    /**
     * Takes a part of an image and copies it immediately below
     */
    public void mirrorArms() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel copyPixel = null;
        Pixel newPixel = null;
        int mirrorPoint = 191;

        for (int row = 159; row < 191; row++) {
            for (int col = 105; col < 170; col++) {
                copyPixel = pixels[row][col];
                newPixel = pixels[mirrorPoint - row + mirrorPoint][col];
                newPixel.setColor(copyPixel.getColor());
            }
        }

        mirrorPoint += 4;
        for (int row = 172; row < 195; row++) {
            for (int col = 239; col < 293; col++) {
                copyPixel = pixels[row][col];
                newPixel = pixels[mirrorPoint - row + mirrorPoint][col];
                newPixel.setColor(copyPixel.getColor());
            }
        }
    }

    /**
     * Takes the part of the image that contained the seagull and copies it immediately to the left
     */
    public void mirrorGull() {
        int mirrorPoint = 347;
        Pixel rightPixel = null;
        Pixel leftPixel = null;
        Pixel[][] pixels = this.getPixels2D();

        for (int row = 235; row < 323; row++) {
            for (int col = 238; col < 343; col++) {
                rightPixel = pixels[row][col];
                leftPixel = pixels[row][mirrorPoint - col + 116];
                leftPixel.setColor(rightPixel.getColor());
            }
        }
    }

    /**
     * copy from the passed fromPic to the
     * specified startRow and startCol in the
     * current picture
     *
     * @param fromPic  the picture to copy from
     * @param startRow the start row to copy to
     * @param startCol the start col to copy to
     */
    public void copy(Picture fromPic, int startRow, int startCol) {
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = fromPic.getPixels2D();
        for (int fromRow = 0, toRow = startRow;
             fromRow < fromPixels.length && toRow < toPixels.length;
             fromRow++, toRow++) {
            for (int fromCol = 0, toCol = startCol;
                 fromCol < fromPixels[0].length &&
                         toCol < toPixels[0].length;
                 fromCol++, toCol++) {
                fromPixel = fromPixels[fromRow][fromCol];
                toPixel = toPixels[toRow][toCol];
                toPixel.setColor(fromPixel.getColor());
            }
        }
    }

    /**
     * Copy Method that takes said parameters and makes a new image withing those limits
     *
     * @param fromPic  gives the starting image
     * @param startRow gives the starting row
     * @param endRow   gives the ending row
     * @param startCol gives the starting column
     * @param endCol   gives the ending column
     */
    public void copy2(Picture fromPic, int startRow, int endRow, int startCol, int endCol) {
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = fromPic.getPixels2D();
        for (int fromRow = 0, toRow = startRow;
             fromRow < fromPixels.length && toRow < endRow;
             fromRow++, toRow++) {
            for (int fromCol = 0, toCol = startCol;
                 fromCol < fromPixels[0].length && toCol < endCol;
                 fromCol++, toCol++) {
                fromPixel = fromPixels[fromRow][fromCol];
                toPixel = toPixels[toRow][toCol];
                toPixel.setColor(fromPixel.getColor());
            }
        }
    }

    /**
     * Method to create a collage of several pictures
     */
    public void createCollage() {
        Picture flower1 = new Picture(filePath + "flower1.jpg");
        Picture flower2 = new Picture(filePath + "flower2.jpg");
        this.copy(flower1, 0, 0);
        this.copy(flower2, 100, 0);
        this.copy(flower1, 200, 0);
        Picture flowerNoBlue = new Picture(flower2);
        flowerNoBlue.zeroBlue();
        this.copy(flowerNoBlue, 300, 0);
        this.copy(flower1, 400, 0);
        this.copy(flower2, 500, 0);
        this.mirrorVertical();
        this.write(filePath + "collage.jpg");
    }

    public void myCollage() {
        Picture[] flower = new Picture[4];
        flower[0] = new Picture(filePath + "flower1.jpg");
        flower[1] = new Picture(filePath + "flower2.jpg");
        flower[2] = new Picture(flower[0]);
        flower[3] = new Picture(flower[1]);

        flower[2].zeroBlue();
        flower[3].zeroBlue();

        int curCol = 0;
        int rowNum = 0;

        for (int i = 0; i < flower.length; i++, rowNum += 100) {
            this.copy(flower[i], rowNum, curCol);
            flower[i] = new Picture(flower[i]);
            flower[i].negate();
            this.copy(flower[i], rowNum, curCol + 100);
        }

        Picture snowman = new Picture(filePath + "snowman.jpg");
        this.copy2(snowman, 200, 440, 0, 400);

        this.mirrorVertical();

    }

    /**
     * Method to show large changes in color
     *
     * @param edgeDist the distance for finding edges
     */
    public void edgeDetection(int edgeDist) {
        Pixel myPixel = null;
        Pixel rightPixel = null;
        Pixel bottomPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Color rightColor = null;
        for (int row = 0; row < pixels.length - 1; row++) {
            for (int col = 0; col < pixels[0].length - 1; col++) {
                myPixel = pixels[row][col];
                rightPixel = pixels[row][col + 1];
                bottomPixel = pixels[row + 1][col];
                if (myPixel.colorDistance(rightPixel.getColor()) > edgeDist
                        || myPixel.colorDistance(bottomPixel.getColor()) > edgeDist)
                    myPixel.setColor(Color.BLACK);
                else
                    myPixel.setColor(Color.WHITE);
            }
        }
    }

    public void edgeDetection2(int edgeDist) {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel topPixel = null;
        Pixel bottomPixel = null;
    }


    /**
     * Main method for testing - each class in Java can have a main
     * method
     */
    public static void main(String[] args) {
        Picture beach = new Picture(filePath + "beach.jpg");
        beach.explore();
        beach.zeroBlue();
        beach.explore();
    }

} // this } is the end of class Picture, put all new methods before this
