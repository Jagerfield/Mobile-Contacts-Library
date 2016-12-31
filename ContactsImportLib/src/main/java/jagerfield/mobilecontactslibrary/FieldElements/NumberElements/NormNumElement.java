package jagerfield.mobilecontactslibrary.FieldElements.NumberElements;

import android.database.Cursor;
import android.provider.ContactsContract;
import jagerfield.mobilecontactslibrary.Abstracts.ElementParent;
import jagerfield.mobilecontactslibrary.Utilities.Utility;
import com.google.gson.annotations.Expose;

public class NormNumElement extends ElementParent
{
    @Expose
    private String normalizedNumber = "";
    @Expose
    private final String elementType;
    public static final String column = ContactsContract.CommonDataKinds.Phone.NORMALIZED_NUMBER;
    public static final String mime = ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE;

    public NormNumElement(Cursor cursor)
    {
        elementType = getClass().getSimpleName();
        setValue(cursor);
    }
    @Override
    public String getElementType()
    {
        return elementType;
    }
    @Override
    public String getValue() {
        return normalizedNumber;
    }
    @Override
    public void setValue(Cursor cursor)
    {
        if (cursor==null)
        {
            return;
        }

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN)
        {
            normalizedNumber = Utility.getColumnIndex(cursor, column);
        }

        if (normalizedNumber == null)
        {
            normalizedNumber = "";
        }
    }

    public interface INormalizedNumElement
    {
        String getNormalizedNumber();
    }

}