import java.io.PrintWriter;
import javax.swing.Box;

/**
 * A series of experiments with the text block layout classes.
 * 
 * @author Samuel A. Rebelsky
 * @author Your Name Here
 */
public class TBExpt {
  // +------+--------------------------------------------------------------
  // | Main |
  // +------+

  public static void main(String[] args) throws Exception {
    // Prepare for input and output
    PrintWriter pen = new PrintWriter(System.out, true);

    // Create a block to use
    TextBlock block = new TextLine("");
    BoxedBlock box = new BoxedBlock(block);
    BoxedBlock boxBox = new BoxedBlock(box);

    TextBlock first = new TextLine("Hello");
    TextBlock second = new TextLine("Goodbye");
    VComposition vertical = new VComposition(first, second);
    BoxedBlock vertBox = new BoxedBlock(vertical);
    BoxedBlock hello = new BoxedBlock(first);
    BoxedBlock goodbye = new BoxedBlock(second);
    VComposition vertBox2 = new VComposition(hello, goodbye);
    HComposition hcomp = new HComposition(second, hello);
    HComposition hcomp2 = new HComposition(hello, second);
    /* 
    TBUtils.print(pen, vertBox);
    TBUtils.print(pen, vertBox2);
    TBUtils.print(pen, hcomp);
    TBUtils.print(pen, hcomp2);
    */
    TBUtils.print(pen, new HorizontallyFlipped(vertical));
    TBUtils.print(pen, new VerticallyFlipped(vertical));

    //Truncated t = new Truncated(vertBox2, 4);

    // Print out the block
    //TBUtils.print(pen, t);

    // Clean up after ourselves.
    pen.close();
  } // main(String[])

} // class TBExpt
