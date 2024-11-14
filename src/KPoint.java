import java.util.Objects;

public class KPoint
{
    private int row, col;

    public KPoint(int row, int col)
    {
        this.row = row;
        this.col = col;
    }

    public int getRow()
    {
        return row;
    }

    public int getCol()
    {
        return col;
    }

    @Override
    public String toString()
    {
        return "(KPoint{)" + row +"," + col +')';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KPoint kPoint = (KPoint) o;
        return row == kPoint.row && col == kPoint.col;
    }

}
