public class Truncated implements TextBlock {

  private TextBlock contents;

  public Truncated(TextBlock text, int maxWidth) throws Exception {
    VComposition temp = new VComposition(new TextLine(""), new TextLine(""));
    if (text.height() == 1) {
      contents = new TextLine(text.row(0).substring(0, maxWidth));
    } else {
      temp = new VComposition(new TextLine(text.row(0).substring(0, maxWidth)), new TextLine(text.row(1).substring(0, maxWidth)));
      for (int i = 2; i < text.height(); i++) {
        temp = new VComposition(temp, new TextLine(text.row(i).substring(0, maxWidth)));
      }
    }
    this.contents = temp;
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
