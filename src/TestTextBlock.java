/**
 * TestTextBlock is a series of tests to confirm that the TextBlock 
 * classes and methods are working correctly.
 * @author Amelia Vrieze
 * @author Siho Kim
 */

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTextBlock {
  
  @Test
  public void testTextLineEquivalence() throws Exception {
    TextLine oneLine = new TextLine("Hello");
    TextLine otherLine = new TextLine("Hi");
    TextLine empty = new TextLine("");
    TextLine newAddress = new TextLine("Hello");
    assertEquals(TBUtils.equal(oneLine, newAddress), true, "Two TextLines with the same content");
    assertEquals(TBUtils.equal(oneLine, otherLine), false, "Two different TextLines");
    assertEquals(TBUtils.equal(empty, empty), true, "Empty TextLines");
    assertEquals(TBUtils.eqv(oneLine, newAddress), true, "Testing eqv");
    assertEquals(TBUtils.eq(oneLine, oneLine), true, "Testing eq with the same object");
    assertEquals(TBUtils.eq(oneLine, newAddress), false, "Testing eq with \"equal\" objects");
  }

  @Test
  public void testBoxedBlockEquivalence() throws Exception{
    BoxedBlock oneLine = new BoxedBlock(new TextLine("Hello"));
    BoxedBlock empty = new BoxedBlock(new TextLine(""));
    BoxedBlock flippedBack = new BoxedBlock(new HorizontallyFlipped(new HorizontallyFlipped(new TextLine("Hello"))));
    assertEquals(TBUtils.equal(oneLine, flippedBack), true, "Testing equal with something flipped twice");
    assertEquals(TBUtils.eqv(oneLine, flippedBack), false, "Testing eqv with something flipped twice");
  }

  @Test
  public void testCentered() throws Exception{
    TextLine centeredString = new TextLine("  Hello  ");
    Centered centeredBlock = new Centered(new TextLine("Hello"), 9);
    assertEquals(TBUtils.equal(centeredString, centeredBlock), true, "Manual vs methodical centering");
  }

  @Test
  public void testHorizontallyFlipped() throws Exception{
    TextLine first = new TextLine("First");
    TextLine second = new TextLine("Second");
    HComposition both = new HComposition(first, second);
    TextLine manual = new TextLine("dnoceStsriF");
    assertEquals(TBUtils.equal(new HorizontallyFlipped(both), manual), true);
    assertEquals(new HorizontallyFlipped(new TextLine("")).row(0), "", "Empty Horizontal flip");

  }

  @Test
  public void testReverseTruncate() throws Exception{
    RightJustified top = new RightJustified(new TextLine("Hello"), 7);
    RightJustified bottom = new RightJustified(new TextLine("Goodbye"), 7);
    VComposition both = new VComposition(top, bottom);
    assertEquals(new ReverseTruncate(both, 4).row(0), "llo");
    assertEquals(new ReverseTruncate(both, 4).row(1), "bye");

  }

  @Test
  public void testRightJustified() throws Exception {
    TextLine original = new TextLine("Hello");
    TextLine manual = new TextLine("   Hello");
    assertEquals(TBUtils.equal(new RightJustified(original, 8), manual), true);

  }

  @Test
  public void testTruncated() throws Exception{
    TextLine original = new TextLine("Good morning");
    TextLine manual = new TextLine("Good m");
    assertEquals(TBUtils.equal(new Truncated(original, 6), manual), true);
    assertEquals(new Truncated(original, 0).row(0), "", "Width of zero");
    assertEquals(new Truncated(original, 12).row(0), "Good morning", "Original width");

  }

  @Test
  public void testVerticallyFlipped() throws Exception{
    TextLine first = new TextLine("Hello");
    TextLine second = new TextLine("Goodbye");
    VComposition both = new VComposition(first, second);
    assertEquals(new VerticallyFlipped(both).row(0), both.row(1));
    assertEquals(new VerticallyFlipped(both).row(1), both.row(0));
    assertEquals(new VerticallyFlipped(new TextLine("")).row(0), "", "Empty Vertical flip");

  }
  
}
