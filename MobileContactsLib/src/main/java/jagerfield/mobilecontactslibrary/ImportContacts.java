package jagerfield.mobilecontactslibrary;

import android.Manifest;
import android.app.Activity;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.Toast;

import jagerfield.mobilecontactslibrary.FieldContainer.FieldsContainer;
import jagerfield.mobilecontactslibrary.Contact.Contact;
import jagerfield.mobilecontactslibrary.Utilities.Utilities;
import utilities.lib.AppUtilities;

import com.google.gson.annotations.Expose;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;


public class ImportContacts
{
    private Activity activity;
    private LinkedHashMap<Long, Contact> contactsIdMap;
    @Expose
    private ArrayList<Contact> contacts;

    public ArrayList<Contact> getContacts()
    {
        return getMobileContacts();
    }

    public void insertContact(Contact contact)
    {
        this.contacts.add(contact);
    }

    public ImportContacts(Activity activity)
    {
        this.activity = activity;
    }

    private String[] getKeyWord() {
        return null;
    }

    private String getFilter()
    {
        return null;
    }

    private String[] getColumns()
    {
        Set<String> columns = new HashSet<>();

        FieldsContainer fieldsContainer = new FieldsContainer();
        columns.addAll(fieldsContainer.getElementsColumns());
        columns.add(ContactsContract.RawContacts.CONTACT_ID);
        columns.add(ContactsContract.Data.MIMETYPE);
        columns.add(ContactsContract.Data.PHOTO_URI);

        return columns.toArray(new String[columns.size()]);
    }

    public ArrayList<Contact> getMobileContacts()
    {
        boolean flag = AppUtilities.getPermissionUtil(activity).isPermissionGranted(Manifest.permission.READ_CONTACTS);

        if (!flag)
        {
            Toast.makeText(activity, "Missing permission READ_CONTACTS", Toast.LENGTH_LONG).show();
            Log.i(Utilities.TAG_CONTACTS_LIB, "Missing permission READ_CONTACTS");
            return new ArrayList<Contact>();
        }
                
        Cursor cursor = activity.getContentResolver().
                query(ContactsContract.Data.CONTENT_URI, // The content URI of the words table
                getColumns(),                            // The columns to return for each row
                getFilter(),                             // Selection criteria
                getKeyWord(),                            // Selection criteria
                ContactsContract.Data.DISPLAY_NAME);     // The sort order for the returned rows

        if (cursor != null)
        {
            long id ;
            String photoUri;
            String columnIndex;
            contactsIdMap = new LinkedHashMap<>();
            contacts = new ArrayList<>();

            while (cursor.moveToNext())
            {
                id = Utilities.getLong(cursor, ContactsContract.RawContacts.CONTACT_ID);

                Contact contact = contactsIdMap.get(id);
                if (contact==null)
                {
                    contact = new Contact(id);
                    contactsIdMap.put(id, contact);
                    insertContact(contact);
                }

                try
                {
                    photoUri = Utilities.getColumnIndex(cursor, ContactsContract.Data.PHOTO_URI);
                    if (photoUri != null && !photoUri.isEmpty())
                    {
                        contact.setPhotoUri(photoUri);
                    }
                }
                catch (Exception e)
                {
                    photoUri = "";
                }

                columnIndex =  Utilities.getColumnIndex(cursor, ContactsContract.Data.MIMETYPE);
                contact.execute(cursor, columnIndex);
            }

            cursor.close();
        }

        if (contacts.isEmpty())
        {
            Toast.makeText(activity, "No contacts found", Toast.LENGTH_LONG).show();
        }

        return contacts;
    }

}



