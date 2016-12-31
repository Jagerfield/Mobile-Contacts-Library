package jagerfield.app.ContactView.FieldAdapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import jagerfield.mobilecontactslibrary.ElementContainers.EmailContainer;
import com.example.sense.mobilecontactslibrary.R;
import java.util.LinkedList;


public class EmailViewAdapter extends RecyclerView.Adapter<EmailViewAdapter.ViewHolder> {

    private Context context;
    private final LinkedList<EmailContainer> emailList;

    public EmailViewAdapter(Context context, LinkedList<EmailContainer> emailList) {
        this.context = context;
        this.emailList = emailList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.field_list_item_double_prop, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position)
    {
        String value = emailList.get(position).getEmail();
        String type = emailList.get(position).getEmailType();

        holder.tvValue.setText(value);
        holder.tvType.setText(type);
    }

    @Override
    public int getItemCount() {
        return emailList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView tvValue;
        public final TextView tvType;

        public ViewHolder(View view) {
            super(view);
            tvValue = (TextView) view.findViewById(R.id.tvValue);
            tvType = (TextView) view.findViewById(R.id.tvType);
        }
    }
}