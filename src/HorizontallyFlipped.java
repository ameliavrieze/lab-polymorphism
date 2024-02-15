/**
 * HorizontallyFlipped: a TextBlock that flips the inputted TextBlock horizontally
 * @author Amelia Vrieze
 * @author Siho Kim
 */


public class HorizontallyFlipped implements TextBlock{
TextBlock contents;

public HorizontallyFlipped(TextBlock contents) {
  this.contents = contents;
}

public String row(int i) throws Exception {
  char[] contArray = this.contents.row(i).toCharArray();
  char[] temp = new char[contArray.length];
  int k = 0;
  for (int j = contArray.length - 1; j >= 0; j--) {
    temp[k] = contArray[j];
    k++;
  }
  return String.valueOf(temp);
}

public int height() {
  return this.contents.height();
}

public int width() {
  return this.contents.width();
}

public boolean equals(TextBlock other) {
  if (other instanceof HorizontallyFlipped) {
    HorizontallyFlipped temp = (HorizontallyFlipped) other;
    return this.contents.equals(temp.contents);
  } else {
    return false;
  }
}


  
}
