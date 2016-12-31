package jagerfield.mobilecontactslibrary.ContactFields;

import android.database.Cursor;
import android.provider.ContactsContract;

import jagerfield.mobilecontactslibrary.Abstracts.FieldParent;
import jagerfield.mobilecontactslibrary.ElementContainers.EmailContainer;
import com.google.gson.annotations.Expose;
import java.util.LinkedList;
import java.util.Set;

public class EmailField extends FieldParent
{
    public final String fieldMime = ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE;
    @Expose
    private LinkedList<EmailContainer> emails = new LinkedList<>();

    public EmailField()
    {

    }

    @Override
    public void execute(String mime, Cursor cursor)
    {
        if (mime.equals(fieldMime))
        {
            emails.add(new EmailContainer(cursor));
        }

    }

    @Override
    public Set<String> registerElementsColumns()
    {
        return EmailContainer.getFieldColumns();
    }

    public LinkedList<EmailContainer> getEmails()
    {
        return emails;
    }

    public interface IEmailField
    {
        public LinkedList<EmailContainer> getEmails();
    }

}
