//package MP2;

public class Centered implements TextBlock {

  TextBlock contents;

  public Centered (TextBlock block, int width) throws Exception {
    if (block.height() == 1) {
      this.contents = new TextLine(" ".repeat((width - block.row(0).length())/2)
      + block.row(0)
      + " ".repeat((width - block.row(0).length())/2));
      return;
    } else {
      TextBlock temp = new VComposition(
        new TextLine(" ".repeat((width - block.row(0).length())/2) + block.row(0) + " ".repeat((width - block.row(0).length())/2)),
        new TextLine(" ".repeat((width - block.row(1).length())/2) + block.row(1) + " ".repeat((width - block.row(1).length())/2)));
      for (int i = 2; i < block.height(); i++) {
        temp = new VComposition(temp, new TextLine(
          " ".repeat((width - block.row(i).length())/2)
          + block.row(i)
          + " ".repeat((width - block.row(i).length())/2)));
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
