package jagerfield.mobilecontactslibrary.ContactFields;

import android.database.Cursor;
import android.provider.ContactsContract;
import jagerfield.mobilecontactslibrary.Abstracts.FieldParent;
import jagerfield.mobilecontactslibrary.ElementContainers.WebsiteContainer;
import com.google.gson.annotations.Expose;
import java.util.LinkedList;
import java.util.Set;

public class WebsiteField extends FieldParent
{
    public final String fieldMime = ContactsContract.CommonDataKinds.Website.CONTENT_ITEM_TYPE;
    @Expose
    private LinkedList<WebsiteContainer> websites = new LinkedList<>();

    public WebsiteField()
    {

    }

    @Override
    public void execute(String mime, Cursor cursor)
    {
        if (mime.equals(fieldMime))
        {
            websites.add(new WebsiteContainer(cursor));
        }

    }

    @Override
    public Set<String> registerElementsColumns()
    {
        return WebsiteContainer.getFieldColumns();
    }

    public LinkedList<WebsiteContainer> getWebsites()
    {
        return websites;
    }

    public interface IWebsiteField
    {
        public LinkedList<WebsiteContainer> getWebsites();
    }

}
