package jagerfield.mobilecontactslibrary.ContactFields;

import android.database.Cursor;
import android.provider.ContactsContract;
import jagerfield.mobilecontactslibrary.Abstracts.FieldParent;
import jagerfield.mobilecontactslibrary.ElementContainers.NickNameContainer;
import com.google.gson.annotations.Expose;
import java.util.LinkedList;
import java.util.Set;

public class NickNameField extends FieldParent
{
    public final String fieldMime = ContactsContract.CommonDataKinds.Nickname.CONTENT_ITEM_TYPE;
    @Expose
    private LinkedList<NickNameContainer> nickNames = new LinkedList<>();

    public NickNameField() {

    }

    @Override
    public void execute(String mime, Cursor cursor) {
        if (mime.equals(fieldMime))
        {
            nickNames.add(new NickNameContainer(cursor));
        }

    }

    @Override
    public Set<String> registerElementsColumns() {
        return NickNameContainer.getFieldColumns();
    }

    public LinkedList<NickNameContainer> getNickNames() {
        return nickNames;
    }

    public interface INickNameField {
        public LinkedList<NickNameContainer> getNickNames();
    }

}
