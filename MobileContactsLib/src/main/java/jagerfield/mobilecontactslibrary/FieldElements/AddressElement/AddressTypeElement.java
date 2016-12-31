package jagerfield.mobilecontactslibrary.FieldElements.AddressElement;

import android.database.Cursor;
import android.provider.ContactsContract;
import jagerfield.mobilecontactslibrary.Abstracts.ElementParent;
import jagerfield.mobilecontactslibrary.Utilities.Utility;
import com.google.gson.annotations.Expose;

public class AddressTypeElement extends ElementParent {
    @Expose
    private String addressType = "";
    @Expose
    private final String elementType;
    public static final String column = ContactsContract.CommonDataKinds.Phone.TYPE;
    public static final String mime = ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE;


    public AddressTypeElement(Cursor cursor) {
        elementType = this.getClass().getSimpleName();
        setValue(cursor);
    }

    @Override
    public String getValue() {
        return elementType;
    }

    @Override
    public void setValue(Cursor cursor) {
        if (cursor == null) {
            return;
        }

        addressType = Utility.getAddressType(Utility.getColumnIndex(cursor, column));

        if (addressType == null) {
            addressType = "OTHER";
        }
    }

    @Override
    public String getElementType()
    {
        return getClass().getSimpleName();
    }
}