/**
 * ReverseTruncate: a TextBlock that contains the inputted TextBlock, but only starting at the 
 * inputted width index
 * @author Siho Kim
 * @author Amelia Vrieze
 */

public class ReverseTruncate implements TextBlock {
  
  TextBlock contents;

  public ReverseTruncate(TextBlock text, int index) throws Exception {

    if (index < 0) {
      System.err.println("Error: Index for truncation cannot be below 1");
    } else if (index > text.width()) {
      System.err.println("Error: Cannot truncate beyond width of string");
    }
    
    if (text.height() == 1) { //If text is just 1 line, return truncated line
      contents = new TextLine(text.row(0).substring(index)); //Substring(index) is truncation
    } else { //Otherwise, make a VComposition starting with 2 items that adds onto itself continually
      VComposition temp = new VComposition(
        new TextLine(text.row(0).substring(index)), 
        new TextLine(text.row(1).substring(index)));
      for (int i = 2; i < text.height(); i++) {
        temp = new VComposition(temp, new TextLine(text.row(i).substring(index)));
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

  public boolean equals(TextBlock other) {
    if (other instanceof ReverseTruncate) {
      ReverseTruncate temp = (ReverseTruncate) other;
      return this.contents.equals(temp.contents);
    } else {
      return false;
    }
  }

}

