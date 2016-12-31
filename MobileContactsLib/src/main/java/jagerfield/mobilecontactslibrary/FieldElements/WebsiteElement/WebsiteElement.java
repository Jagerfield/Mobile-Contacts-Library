package jagerfield.mobilecontactslibrary.FieldElements.WebsiteElement;

import android.database.Cursor;
import android.provider.ContactsContract;
import jagerfield.mobilecontactslibrary.Abstracts.ElementParent;
import jagerfield.mobilecontactslibrary.Utilities.Utility;
import com.google.gson.annotations.Expose;

public class WebsiteElement extends ElementParent
{
    @Expose
    private String website = "";
    @Expose
    private final String elementType;
    public static final String column = ContactsContract.CommonDataKinds.Website.URL;
    public static final String mime = ContactsContract.CommonDataKinds.Website.URL;

    public WebsiteElement(Cursor cursor)
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
        return website;
    }
    @Override
    public void setValue(Cursor cursor)
    {
        if (cursor==null)
        {
            return;
        }

        website = Utility.getColumnIndex(cursor, column);

        if (website == null)
        {
            website = "";
        }
    }

}