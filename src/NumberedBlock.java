public class NumberedBlock implements TextBlock{
  TextBlock contents;

  public NumberedBlock(TextBlock contents) {
    this.contents = contents;
  }

  public String row (int i) throws Exception{
    if ((i + 1) < 10) {
    return "" + (i + 1) + "   " + this.contents.row(i);
    } else {
      return "" + (i + 1) + "  " + this.contents.row(i);
    }
  }

  public int height() {
    return this.contents.height();
  }

  public int width() {
    return this.contents.width() + 4;
  }
  
}
