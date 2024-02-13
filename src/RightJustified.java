//package MP2;

public class RightJustified implements TextBlock {

  TextBlock contents;

  public RightJustified (TextBlock block, int width) throws Exception {
    if (block.height() == 1) {
      this.contents = new TextLine(" ".repeat(width - block.row(0).trim().length()) + block.row(0));
      return;
    } else {
      TextBlock temp = new VComposition(
        new TextLine(" ".repeat(width - block.row(0).trim().length()) + block.row(0)),
        new TextLine(" ".repeat(width - block.row(1).trim().length()) + block.row(1)));
      for (int i = 2; i < block.height(); i++) {
        temp = new VComposition(temp, new TextLine(
          " ".repeat(width - block.row(i).trim().length())+ block.row(i)));
      }
      this.contents = temp;
    }   
  }

  public String row(int i) throws Exception {
    return this.contents.row(i);
  }

  /**
   * Determine how many rows are in the block.
   */
  public int height() {
    return this.contents.height();
  }

  /**
   * Determine how many columns are in the block.
   */
  public int width() {
    return this.contents.width();
  }
  
}
