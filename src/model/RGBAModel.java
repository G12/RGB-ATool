package model;

import java.util.Observable;

import android.graphics.Color;

/**
 * The model holds the data.
 *
 * Model color.
 * Based on red, green, blud and alpha (transparency).
 *
 * RGB: integer values in the domain range of 0 to 255 (inclusive).
 * Alpha: integer value in the domain range of 0 to 255 (inclusive).
 *
 * @author Thomas Wiegand wieg0002
 * @version 1.0
 */

public class RGBAModel extends Observable {

	public static final Integer MAX_ALPHA;
	public static final Integer MAX_RGB;
	public static final Integer MIN_ALPHA;
	public static final Integer MIN_RGB;
	
	// Static initializer block. Initialize all class variables here.
	static {
		MAX_ALPHA = 100;
		MAX_RGB = 255;
		MIN_ALPHA = 0;
		MIN_RGB = 0;
	}

	private Integer alpha;
	private Integer red;
	private Integer green;
	private Integer blue;
	
	/**
	 * 
	 */
	public RGBAModel() {
		this( MAX_RGB, MAX_RGB, MAX_RGB, MAX_ALPHA );
	}
	
	/**
	 * Class constructor specifying RGB and alpha values.
	 * @param red
	 * @param green
	 * @param blue
	 * @param alpha
	 */
	public RGBAModel( Integer red, Integer green, Integer blue, Integer alpha)
	{
	    super();

	    this.red = red;
	    this.green = green;
	    this.blue = blue;
	    this.alpha = alpha;
	}
	
	/**
	 * 
	 */
	public void asBlack() {
	    this.setRGB( MIN_RGB, MIN_RGB, MIN_RGB );
	}

	/**
	 * 
	 */
	public void asBlue() {
	    this.setRGB( MIN_RGB, MIN_RGB, MAX_RGB );
	}
	
	/**
	 * 
	 */
	public void asCyan() {
	    this.setRGB( MIN_RGB, MAX_RGB, MAX_RGB );
	}

	/**
	 * 
	 */
	public void asGreen() {
	    this.setRGB( MIN_RGB, MAX_RGB, MIN_RGB );
	}

	/**
	 * 
	 */
	public void asMagenta() {
	    this.setRGB( MAX_RGB, MIN_RGB, MAX_RGB );
	}

	/**
	 * 
	 */
	public void asRed() {
	    this.setRGB( MAX_RGB, MIN_RGB, MIN_RGB );
	}

	/**
	 * 
	 */
	public void asWhite() {
	    this.setRGB( MAX_RGB, MAX_RGB, MAX_RGB );
	}

	/**
	 * 
	 */
	public void asYellow() {
	    this.setRGB( MAX_RGB, MAX_RGB, MIN_RGB );
	}
	
	/**
	 * @return the alpha
	 */
	public Integer getAlpha() {
		return alpha;
	}

	/**
	 * @param alpha the alpha to set
	 */
	public void setAlpha(Integer alpha) {
		if(alpha > MAX_ALPHA || alpha < MIN_ALPHA)
		{
			//throw new 
		}
		this.alpha = alpha;
		//The models state has changed
		this.updateObservers();
	}

	/**
	 * @return the red
	 */
	public Integer getRed() {
		return red;
	}

	/**
	 * @param red the red to set
	 */
	public void setRed(Integer red) {
		this.red = red;
		//The models state has changed
		this.updateObservers();
	}

	/**
	 * @return the green
	 */
	public Integer getGreen() {
		return green;
	}

	/**
	 * @param green the green to set
	 */
	public void setGreen(Integer green) {
		this.green = green;
		//The models state has changed
		this.updateObservers();
	}

	/**
	 * @return the blue
	 */
	public Integer getBlue() {
		return blue;
	}

	/**
	 * @param blue the blue to set
	 */
	public void setBlue(Integer blue) {
		this.blue = blue;
		//The models state has changed
		this.updateObservers();
	}

	/**
	 * @return
	 */
	public int getColor() {
	    return Color.rgb( red, green, blue );
	}

	/**
	 * @param red
	 * @param green
	 * @param blue
	 */
	public void setRGB( Integer red, Integer green, Integer blue ) {
	    this.red = red;
	    this.green = green;
	    this.blue = blue;

	    // the model's state has changed!
	    this.updateObservers();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RGB-A [r=" + red + " g=" + green + " b=" + blue + " alpha=" + alpha + "]";
	}
	
	/**
	 * The model's state has changed!
	 *
	 * Notify all registered observers that this model has changed
	 * state, and the registered observers should change too.
	 */
	private void updateObservers() {		
	    this.setChanged();
	    this.notifyObservers();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RGBAModel model = new RGBAModel( 127, 127, 127, 255 );
		System.out.println(model);
	}

}
