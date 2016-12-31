package jagerfield.mobilecontactslibrary.FieldElements.EmailElements;

import android.database.Cursor;
import android.provider.ContactsContract;
import jagerfield.mobilecontactslibrary.Abstracts.ElementParent;
import jagerfield.mobilecontactslibrary.Utilities.Utilities;
import com.google.gson.annotations.Expose;

public class EmailTypeElement extends ElementParent
{
    @Expose
    private String emailType = "";
    @Expose
    private final String elementType;
    public static final String column = ContactsContract.CommonDataKinds.Email.TYPE;
    public static final String mime = ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE;

    public EmailTypeElement(Cursor cursor)
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
        return emailType;
    }
    @Override
    public void setValue(Cursor cursor)
    {
        if (cursor==null)
        {
            return;
        }

        emailType = Utilities.getEmailType(Utilities.getColumnIndex(cursor, column));

        if (emailType == null)
        {
            emailType = "OTHER";
        }
    }

}