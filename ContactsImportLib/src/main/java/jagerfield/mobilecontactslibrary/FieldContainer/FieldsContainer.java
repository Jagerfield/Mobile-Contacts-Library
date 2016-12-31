package jagerfield.mobilecontactslibrary.FieldContainer;

import android.database.Cursor;
import jagerfield.mobilecontactslibrary.Abstracts.FieldParent;
import jagerfield.mobilecontactslibrary.ContactFields.AddressField;
import jagerfield.mobilecontactslibrary.ContactFields.EmailField;
import jagerfield.mobilecontactslibrary.ContactFields.EventField;
import jagerfield.mobilecontactslibrary.ContactFields.NameField;
import jagerfield.mobilecontactslibrary.ContactFields.NickNameField;
import jagerfield.mobilecontactslibrary.ContactFields.NoteField;
import jagerfield.mobilecontactslibrary.ContactFields.NumberField;
import jagerfield.mobilecontactslibrary.ContactFields.WebsiteField;
import com.google.gson.annotations.Expose;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FieldsContainer
{
    @Expose
    private NameField nameField;
    @Expose
    private NumberField numberField;
    @Expose
    private EmailField emailField;
    @Expose
    private WebsiteField websiteField;
    @Expose
    private AddressField addressField;
    @Expose
    private NoteField noteField;
    @Expose
    private EventField eventField;
    @Expose
    private NickNameField nickNameField;

    private ArrayList<FieldParent> contactFieldsList;

    public FieldsContainer() {
        Instantiate();
    }

    private void Instantiate() {
        nameField = new NameField();
        numberField = new NumberField();
        emailField = new EmailField();
        websiteField = new WebsiteField();
        addressField = new AddressField();
        noteField = new NoteField();
        eventField = new EventField();
        nickNameField = new NickNameField();

        contactFieldsList = new ArrayList<>();
        contactFieldsList.add(nameField);
        contactFieldsList.add(numberField);
        contactFieldsList.add(emailField);
        contactFieldsList.add(websiteField);
        contactFieldsList.add(addressField);
        contactFieldsList.add(noteField);
        contactFieldsList.add(eventField);
        contactFieldsList.add(nickNameField);
    }

    /**
     * fetch field contact data from mobile
     */
    public void execute(String mime, Cursor cursor) {
        for (int i = 0; i < contactFieldsList.size(); i++) {
            contactFieldsList.get(i).execute(mime, cursor);
        }
    }

    /**
     * Get available field columns to form a projection for the cursor build
     */
    public Set<String> getElementsColumns() {
        Set<String> columns = new HashSet<>();

        for (int i = 0; i < contactFieldsList.size(); i++) {
            columns.addAll(contactFieldsList.get(i).registerElementsColumns());
        }

        return columns;
    }

    public NameField getNameField() { return nameField; }
    public NumberField getNumberField() {
        return numberField;
    }
    public EmailField getEmailField() {
        return emailField;
    }
    public WebsiteField getWebsiteField() {
        return websiteField;
    }
    public AddressField getAddressField() {return addressField; }
    public NoteField getNoteField() { return noteField; }
    public EventField getEventField() { return eventField;}
    public NickNameField getNickNameField() { return nickNameField;}


    public interface IFieldContainer extends NameField.INameField, NumberField.INumberField, EmailField.IEmailField, WebsiteField.IWebsiteField,
            AddressField.IAddressField, NoteField.INoteField, EventField.IEventField, NickNameField.INickNameField
    {

    }

}
