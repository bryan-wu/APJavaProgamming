import java.awt.Color;


/**
 * Represents a tile of the specified color (colored block).
 *
 * @author George Peck
 * @version Nov 25, 2007
 *
 * @author Sources: Cay Horstmann
 */
public class Tile
{
    private Color color;


    /**
     * Tile constructor.
     * 
     * @param color
     *            color
     */
    public Tile( Color color )
    {
        this.color = color;
    }


    /**
     * This method returns the color of the tile.
     * 
     * @return color color
     */
    public Color getColor()
    {
        return color;
    }


    /**
     * This method sets the color of the tile.
     * 
     * @param color
     *            color
     */
    public void setColor( Color color )
    {
        this.color = color;
    }


    /**
     * This method returns the text of the tile.
     * 
     * @return text text
     */
    public String getText()
    {
        return "";
    }
}
