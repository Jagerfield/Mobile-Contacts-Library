package jagerfield.app.ContactView.FieldAdapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import jagerfield.mobilecontactslibrary.ElementContainers.WebsiteContainer;
import jagerfield.mobilecontactslibrary.R;
import java.util.LinkedList;


public class WebsiteViewAdaptor extends RecyclerView.Adapter<WebsiteViewAdaptor.ViewHolder> {

    private Context context;
    private final LinkedList<WebsiteContainer> websiteList;

    public WebsiteViewAdaptor(Context context, LinkedList<WebsiteContainer> websiteList) {
        this.context = context;
        this.websiteList = websiteList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.field_list_item_single_prop, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position)
    {
        String value = websiteList.get(position).getWebsite();
        holder.tvValue.setText(value);
    }

    @Override
    public int getItemCount() {
        return websiteList.size();
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