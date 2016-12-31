package jagerfield.mobilecontactslibrary.FieldElements.NumberElements;

import android.database.Cursor;
import android.provider.ContactsContract;
import jagerfield.mobilecontactslibrary.Abstracts.ElementParent;
import jagerfield.mobilecontactslibrary.Utilities.Utility;
import com.google.gson.annotations.Expose;

public class LabelElement extends ElementParent
{
    @Expose
    private String numberLabel = "";
    @Expose
    private final String elementType;
    public static final String column = ContactsContract.CommonDataKinds.Phone.LABEL;
    public static final String mime = ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE;

    public LabelElement(Cursor cursor)
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
    public String getValue()
    {
        return numberLabel;
    }
    @Override
    public void setValue(Cursor cursor)
    {
        if (cursor==null)
        {
            return;
        }

        numberLabel = Utility.getColumnIndex(cursor, column);

        if (numberLabel == null)
        {
            numberLabel = "";
        }
    }

    public interface ILabelElement
    {
        String getNumberLabel();
    }
}