package jagerfield.app.Utilities;

import android.graphics.Bitmap;
import android.support.v7.graphics.Palette;


public class C
{
    public static final String CONTACTLIST = "CONTACTLIST";
    public static final String POSITION = "POSITION";
    public static final String CONTACT = "CONTACT";

    public static final int LIGHT_VIBRANT= 1;
    public static final int VIBRANT= 2;
    public static final int DARK_VIBRANT= 3;
    public static final int LIGHT_MUTED= 4;
    public static final int MUTED= 5;
    public static final int DARK_MUTED= 6;


    // Return a palette's vibrant swatch after checking that it exists
    public static Palette.Swatch getImageColor(int colorType, Bitmap bitmap)
    {
        Palette p = Palette.from(bitmap).generate();

        if (p==null)
        {
            return null;
        }

        Palette.Swatch vibrant = null;

        switch(colorType)
        {
            case LIGHT_VIBRANT:
                vibrant = p.getLightVibrantSwatch();
                break;

            case VIBRANT:
                vibrant = p.getVibrantSwatch();
                break;

            case DARK_VIBRANT:
                vibrant = p.getDarkVibrantSwatch();
                break;

            case LIGHT_MUTED:
                vibrant = p.getLightMutedSwatch();
                break;

            case MUTED:
                vibrant = p.getMutedSwatch();
                break;

            case DARK_MUTED:
                vibrant = p.getDarkMutedSwatch();
                break;

        }

        return vibrant;
    }

}
