package jagerfield.mobilecontactslibrary.FieldElements.NumberElements;

import android.database.Cursor;
import android.provider.ContactsContract;
import jagerfield.mobilecontactslibrary.Abstracts.ElementParent;
import jagerfield.mobilecontactslibrary.Utilities.Utility;
import com.google.gson.annotations.Expose;

public class NumberElement extends ElementParent
{
    @Expose
    private String mobileNumber = "";
    @Expose
    private final String elementType;
    public static final String column = ContactsContract.CommonDataKinds.Phone.NUMBER;
    public static final String mime = ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE;

    public NumberElement(Cursor cursor)
    {
        elementType = getClass().getSimpleName();
        setValue(cursor);
    }
    @Override
    public String getElementType() { return elementType; }
    @Override
    public String getValue()  {  return mobileNumber; }
    @Override
    public void setValue(Cursor cursor)
    {
        if (cursor==null)
        {
            return;
        }

        mobileNumber = Utility.getColumnIndex(cursor, column);

        if (mobileNumber == null)
        {
            mobileNumber = "";
        }
    }

}