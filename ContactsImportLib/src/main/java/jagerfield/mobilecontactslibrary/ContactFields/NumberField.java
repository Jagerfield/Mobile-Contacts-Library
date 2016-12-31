package jagerfield.mobilecontactslibrary.ContactFields;

import android.database.Cursor;
import android.provider.ContactsContract;
import jagerfield.mobilecontactslibrary.Abstracts.FieldParent;
import jagerfield.mobilecontactslibrary.ElementContainers.NumberContainer;
import com.google.gson.annotations.Expose;
import java.util.LinkedList;
import java.util.Set;

public class NumberField extends FieldParent
{
    public final String fieldMime = ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE;
    @Expose
    private LinkedList<NumberContainer> numbers = new LinkedList<>();

    public NumberField()
    {

    }

    @Override
    public void execute(String mime, Cursor cursor)
    {
        if (mime.equals(fieldMime))
        {
            numbers.add(new NumberContainer(cursor));
        }

    }

    @Override
    public Set<String> registerElementsColumns()
    {
        return NumberContainer.getFieldColumns();
    }

    public LinkedList<NumberContainer> getNumbers()
    {
        return numbers;
    }


    public interface INumberField
    {
        public LinkedList<NumberContainer> getNumbers();
    }

}
