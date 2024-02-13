public class Truncated implements TextBlock {

  private TextBlock contents;

  public Truncated(TextBlock text, int maxWidth) throws Exception {

    //Throwing error if width is too large
    if (maxWidth > text.width()) {
      System.err.println("Error: Width is too large to truncate the given string.");
      return;
    }

    if (text.height() == 1) { //If text is just 1 line, return truncated line
      contents = new TextLine(text.row(0).substring(0, maxWidth)); //Substring(0, maxWidth) is truncation
    } else { //Otherwise, make a VComposition starting with 2 items that adds onto itself continually
      VComposition temp = new VComposition(
        new TextLine(text.row(0).substring(0, maxWidth)), 
        new TextLine(text.row(1).substring(0, maxWidth)));
      for (int i = 2; i < text.height(); i++) {
        temp = new VComposition(temp, new TextLine(text.row(i).substring(0, maxWidth)));
      }
      this.contents = temp; //Assign temp to thiscontents
    }
  }

  public String row(int i) throws Exception {
    return this.contents.row(i);
  }

  public int height() {
    return this.contents.height();
  }

  public int width() {
    return this.contents.width();
  }

}
