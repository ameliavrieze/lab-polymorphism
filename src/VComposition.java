/**
 * The vertical composition of two text blocks.
 * 
 * @author Samuel A. Rebelsky
 * @author Amelia Vrieze
 * @author Siho Kim
 */
public class VComposition implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The top portion of the composition.
   */
  TextBlock top;

  /**
   * The bottom portion of the composition.
   */
  TextBlock bottom;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new block by composing top and bottom vertically.
   */
  public VComposition(TextBlock top, TextBlock bottom) {
    this.top = top;
    this.bottom = bottom;
  } // VComposition(String)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   * 
   * @pre 0 <= i < this.height()
   * @exception Exception if the precondition is not met
   */
  public String row(int i) throws Exception {
    // Gather some basic information
    int th = this.top.height();
    int bh = this.bottom.height();
    int tw = this.top.width();
    int bw = this.bottom.width();
    int h = th + bh;

    // Determine padding
    String padtop = "";
    String padbot = "";
    if (tw > bw) {
      padbot = TBUtils.spaces(tw - bw);
    } else {
      padtop = TBUtils.spaces(bw - tw);
    } // the bottom is wider

    if ((i < 0) || (i >= h)) {
      throw new Exception("Invalid row " + i);
    } else if (i < th) {
      return this.top.row(i) + padtop;
    } else {
      return this.bottom.row(i - th) + padbot;
    } // if the row is in the bottom half
  } // row(int)

  /**
   * Determine how many rows are in the block.
   */
  public int height() {
    // The height is the sum of the heights of the top and bottom
    // blocks.
    return this.top.height() + this.bottom.height();
  } // height()

  /**
   * Determine how many columns are in the block.
   */
  public int width() {
    // The width is the greater of the widths of the top and bottom
    // blocks.
    return Math.max(this.top.width(), this.bottom.width());
  } // width()

  public boolean equals(TextBlock other) {
    if (other instanceof VComposition) {
      VComposition temp = (VComposition) other;
      return this.top.equals(temp.top) && this.bottom.equals(temp.bottom);
    } else {
      return false;
    }
  }

} // class VComposition
