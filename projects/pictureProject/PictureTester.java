package pixLab.classes;

/**
 * This class contains class (static) methods
 * that will help you test the Picture class
 * methods.  Uncomment the methods and the code
 * in the main to test.
 *
 * @author Barbara Ericson
 */
public class PictureTester {
    /**
     * Method to test zeroBlue
     */

    private static String filePath = "E:\\Code\\Java\\workspace\\AP Computer Science\\projects\\pixLab\\images\\";

    public static void testZeroBlue() {
        Picture pic = new Picture(filePath + "beach.jpg");
        pic.explore();
        pic.zeroBlue();
        pic.explore();
    }

    public static void testKeepOnlyBlue() {
        Picture pic = new Picture(filePath + "beach.jpg");
        pic.keepOnlyBlue();
        pic.explore();
    }

    public static void testNegate() {
        Picture pic = new Picture(filePath + "beach.jpg");
        pic.explore();
        pic.negate();
        pic.explore();
    }

    public static void testGrayscale() {
        Picture pic = new Picture(filePath + "beach.jpg");
        pic.explore();
        pic.grayscale();
        pic.explore();
    }

    public static void testFixUnderwater() {
        Picture pic = new Picture(filePath + "water.jpg");
        pic.explore();
        pic.fixUnderwater();
        pic.explore();
    }

    public static void testMirrorVertical() {
        Picture pic = new Picture(filePath + "caterpillar.jpg");
        pic.explore();
        pic.mirrorVertical();
        pic.explore();
    }

    public static void testMirrorVerticalRightToLeft() {
        Picture pic = new Picture(filePath + "caterpillar.jpg");
        pic.explore();
        pic.mirrorVerticalRightToLeft();
        pic.explore();
    }

    public static void testMirrorHorizontal() {
        Picture pic = new Picture(filePath + "caterpillar.jpg");
        pic.explore();
        pic.mirrorHorizontal();
        pic.explore();
    }

    public static void testMirrorHorizontalBotToTop() {
        Picture pic = new Picture(filePath + "caterpillar.jpg");
        pic.explore();
        pic.mirrorHorizontalBotToTop();
        pic.explore();
    }

    public static void testMirrorTemple() {
        Picture pic = new Picture(filePath + "temple.jpg");
        pic.explore();
        pic.mirrorTemple();
        pic.explore();
    }

    public static void testMirrorDiagonal() {
        Picture pic = new Picture(filePath + "beach.jpg");
        pic.explore();
        pic.mirrorDiagonal();
        pic.explore();
    }

    public static void testMirrorArms() {
        Picture pic = new Picture(filePath + "snowman.jpg");
        pic.explore();
        pic.mirrorArms();
        pic.explore();
    }

    public static void testMirrorGull() {
        Picture pic = new Picture(filePath + "seagull.jpg");
        pic.explore();
        pic.mirrorGull();
        pic.explore();
    }

    public static void testCollage() {
        Picture pic = new Picture(filePath + "640x480.jpg");
        pic.createCollage();
        pic.explore();
    }

    public static void testMyCollage() {
        Picture pic = new Picture(filePath + "640x480.jpg");
        pic.myCollage();
        pic.explore();
    }

    public static void testEdgeDetection() {
        Picture pic = new Picture(filePath + "swan.jpg");
        pic.explore();
        pic.edgeDetection(10);
        pic.explore();
    }

    public static void testEdgeDetection2() {
        Picture pic = new Picture(filePath + "swan.jpg");
        pic.explore();
        pic.edgeDetection2(10);
        pic.explore();
    }

    public static void main(String[] args) {
        // uncomment a call here to run a test
        // and comment out the ones you don't want
        // to run
        //testZeroBlue();
        //testKeepOnlyBlue();
        //testKeepOnlyRed();
        //testKeepOnlyGreen();
        //testNegate();
        //testGrayscale();
        //testFixUnderwater();
        //testMirrorVertical();
        //testMirrorVerticalRightToLeft();
        //testMirrorHorizontal();
        //testMirrorHorizontalBotToTop();
        //testMirrorTemple();
        //testMirrorArms();
        //testMirrorGull();
        //testMirrorDiagonal();
        //testCollage();
        //testMyCollage();
        //testCopy();
        //testCopy2();
        //testEdgeDetection();
        //testEdgeDetection2();
        //testChromakey();
        //testEncodeAndDecode();
        //testGetCountRedOverValue(250);
        //testSetRedToHalfValueInTopHalf();
        //testClearBlueOverValue(200);
        //testGetAverageForColumn(0);
    }
}