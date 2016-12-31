package jagerfield.mobilecontactslibrary.FieldElements.EmailElements;

import android.database.Cursor;
import android.provider.ContactsContract;
import jagerfield.mobilecontactslibrary.Abstracts.ElementParent;
import jagerfield.mobilecontactslibrary.Utilities.Utilities;
import com.google.gson.annotations.Expose;

public class EmailLabelElement extends ElementParent
{
    @Expose
    private String emailLabel = "";
    @Expose
    private final String elementType;
    public static final String column = ContactsContract.CommonDataKinds.Email.LABEL;
    public static final String mime = ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE;

    public EmailLabelElement (Cursor cursor)
    {
        elementType = this.getClass().getSimpleName();
        setValue(cursor);
    }
    @Override
    public String getElementType()
    {
        return elementType;
    }
    @Override
    public String getValue() {
        return emailLabel;
    }
    @Override
    public void setValue(Cursor cursor)
    {
        if (cursor==null)
        {
            return;
        }

        emailLabel = Utilities.getColumnIndex(cursor, column);

        if (emailLabel == null)
        {
            emailLabel = "";
        }
    }

}