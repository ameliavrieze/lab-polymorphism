import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

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
  public void testHorizontallyFlipped() {

  }

  @Test
  public void testReverseTruncate() {

  }

  @Test
  public void testRightJustified() {

  }

  @Test
  public void testTruncated() {

  }

  @Test
  public void testVerticallyFlipped() {

  }









  
}
