public class Centered implements TextBlock {

  TextBlock contents;

  public Centered(TextBlock block, int width) throws Exception {

    //Throwing Error if width is too small
    if (width < block.width()) {
      System.err.println("Error: Width is too small!");
      return;
    }

    if (block.height() == 1) { //If the height = 1, return just a line
      //Formula for centering: #n spaces, with n being (width - block width)/2 + the block string + #n spaces again
      this.contents = new TextLine(" ".repeat((width - block.row(0).trim().length()) / 2)
          + block.row(0)
          + " ".repeat((width - block.row(0).length()) / 2));
      return;
    } else { //Otherwise, return a VComposition that starts with 2 items and adds onto itself
      TextBlock temp = new VComposition(
          new TextLine(
              " ".repeat((width - block.row(0).trim().length()) / 2)
                  + block.row(0)
                  + " ".repeat((width - block.row(0).trim().length()) / 2)),
          new TextLine(
              " ".repeat((width - block.row(1).trim().length()) / 2)
                  + block.row(1)
                  + " ".repeat((width - block.row(1).trim().length()) / 2)));
      for (int i = 2; i < block.height(); i++) { //Start from 2 because there are 2 items already inside
        temp = new VComposition(temp, new TextLine(
            " ".repeat((width - block.row(i).trim().length()) / 2)
                + block.row(i)
                + " ".repeat((width - block.row(i).trim().length()) / 2)));
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

  public boolean equals(TextBlock other) {
    if (other instanceof Centered) {
      Centered temp = (Centered) other;
      return this.contents.equals(temp.contents);
    } else {
      return false;
    }
  }

}
