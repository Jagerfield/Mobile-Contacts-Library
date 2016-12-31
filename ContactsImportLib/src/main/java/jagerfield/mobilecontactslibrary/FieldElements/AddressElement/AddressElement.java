package jagerfield.mobilecontactslibrary.FieldElements.AddressElement;

import android.database.Cursor;
import android.provider.ContactsContract;
import jagerfield.mobilecontactslibrary.Abstracts.ElementParent;
import jagerfield.mobilecontactslibrary.Utilities.Utility;
import com.google.gson.annotations.Expose;

public class AddressElement extends ElementParent
{
    @Expose
    private String address = "";
    @Expose
    private final String elementType;
    public static final String column = ContactsContract.CommonDataKinds.StructuredPostal.FORMATTED_ADDRESS;
    public static final String mime = ContactsContract.CommonDataKinds.StructuredPostal.CONTENT_ITEM_TYPE;


    public AddressElement(Cursor cursor)
    {
        elementType = this.getClass().getSimpleName();
        setValue(cursor);
    }

    @Override
    public String getValue() {
        return elementType;
    }
    @Override
    public void setValue(Cursor cursor)
    {
        if (cursor==null)
        {
            return;
        }

        address = Utility.getColumnIndex(cursor, column);

        if (address == null)
        {
            address = "";
        }
    }

    @Override
    public String getElementType()
    {
        return getClass().getSimpleName();
    }
}