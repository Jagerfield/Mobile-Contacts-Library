package jagerfield.mobilecontactslibrary.FieldElements.NameElements;

import android.database.Cursor;
import android.provider.ContactsContract;
import jagerfield.mobilecontactslibrary.Abstracts.ElementParent;
import jagerfield.mobilecontactslibrary.Utilities.Utility;
import com.google.gson.annotations.Expose;

public class FirstNameElement extends ElementParent
{
    @Expose
    private String firstName = "";
    @Expose
    private final String elementType;
    public static final String column = ContactsContract.CommonDataKinds.StructuredName.GIVEN_NAME;
    public static final String mime = ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE;

    public FirstNameElement(Cursor cursor) {
        elementType = getClass().getSimpleName();
        setValue(cursor);
    }

    @Override
    public String getElementType() {
        return elementType;
    }
    @Override
    public String getValue() { return firstName;  }
    @Override
    public void setValue(Cursor cursor)
    {
        if (cursor==null)
        {
            return;
        }

        firstName = Utility.getColumnIndex(cursor, column);

        if (firstName == null)
        {
            firstName = "";
        }
    }

    public interface IFirstNameElement
    {
        String getFirstName();
    }

}
