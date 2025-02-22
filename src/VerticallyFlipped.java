/**
 * VerticallyFlipped: a TextBlock that contains the inputted TextBlock flipped so that 
 * they are reverse order top to bottom.
 * @author Amelia Vrieze
 * @author Siho Kim
 */

public class VerticallyFlipped implements TextBlock{
  TextBlock contents;

  public VerticallyFlipped(TextBlock contents) {
    this.contents = contents;
  }

  public String row(int i) throws Exception{
    int lastindex = contents.height() - 1;
    return this.contents.row(lastindex - i);
  }

  public int height() {
    return this.contents.height();

  }
  public int width() {
    return this.contents.width();
  }

  
public boolean equals(TextBlock other) {
  if (other instanceof VerticallyFlipped) {
    VerticallyFlipped temp = (VerticallyFlipped) other;
    return this.contents.equals(temp.contents);
  } else {
    return false;
  }
}
  
}
