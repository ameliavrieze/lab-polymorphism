public class RightJustified implements TextBlock {

  TextBlock contents;

  public RightJustified (TextBlock block, int width) throws Exception {

     //Throwing Error if width is too small
     if (width < block.width()) {
      System.err.println("Error: Width is too small!");
      return;
    }

    //If the height = 1, return just a line
    if (block.height() == 1) {
      //Formula for centering: #n spaces, with n being (width - trimmed block width) + the block string
      this.contents = new TextLine(" ".repeat(width - block.row(0).trim().length()) + block.row(0));
      return;
    } else { //Otherwise, return a VComposition that starts with 2 items and adds onto itself
      TextBlock temp = new VComposition(
        new TextLine(" ".repeat(width - block.row(0).trim().length()) + block.row(0)),
        new TextLine(" ".repeat(width - block.row(1).trim().length()) + block.row(1)));
      for (int i = 2; i < block.height(); i++) { //Start from 2 because there are 2 items already inside
        temp = new VComposition(temp, new TextLine(
          " ".repeat(width - block.row(i).trim().length())+ block.row(i)));
      }
      this.contents = temp; //Assign temp to this.contents
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
