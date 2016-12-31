package jagerfield.mobilecontactslibrary.ContactFields;

import android.database.Cursor;
import android.provider.ContactsContract;
import jagerfield.mobilecontactslibrary.Abstracts.FieldParent;
import jagerfield.mobilecontactslibrary.ElementContainers.EventContainer;
import com.google.gson.annotations.Expose;
import java.util.LinkedList;
import java.util.Set;

public class EventField extends FieldParent
{
    public final String fieldMime = ContactsContract.CommonDataKinds.Event.CONTENT_ITEM_TYPE;
    @Expose
    private LinkedList<EventContainer> events = new LinkedList<>();

    public EventField()
    {

    }

    @Override
    public void execute(String mime, Cursor cursor)
    {
        if (mime.equals(fieldMime))
        {
            events.add(new EventContainer(cursor));
        }
    }

    @Override
    public Set<String> registerElementsColumns()
    {
        return EventContainer.getFieldColumns();
    }

    public LinkedList<EventContainer> getEvents()
    {
        return events;
    }

    public interface IEventField
    {
        public LinkedList<EventContainer> getEvents();
    }

}