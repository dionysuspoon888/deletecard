package com.example.deletecard;


        import android.content.Context;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;


        import java.util.ArrayList;

//Define the adapter
public class JsonRecyclerViewAdapter extends RecyclerView.Adapter<JsonRecyclerViewAdapter.ViewHolder> {

    private ArrayList<JSONItem> list;
    private OnItemClickListener listener;
    private Boolean show = false;

    private Context ctx;

    //OnClick UI
    public interface OnItemClickListener {
        void onItemClick(int position,TextView textView);
    }

    public void setOnItemClickListener(OnItemClickListener listeners) {
        listener = listeners;
    }

    public JsonRecyclerViewAdapter(Context context, ArrayList<JSONItem> lists,boolean show) {
        ctx = context;
        list = lists;
        this.show = show;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Create ViewHolder when not enough
        View v = LayoutInflater.from(ctx).inflate(R.layout.item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //Define the data shows in the card View
        JSONItem currentItem = list.get(position);

        String imageUrl = currentItem.getImageUrl();
        String creatorName = currentItem.getCreator();


        if(!show) {
            holder.textViewCreator.setVisibility(View.GONE);
        }else{
            holder.textViewCreator.setVisibility(View.VISIBLE);
        }


        //Picasso.with(ctx).load(imageUrl).fit().centerInside().into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //ViewHolder set up(mandatory for RecyclerView)
        public ImageView imageView;
        public TextView textViewCreator;


        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            textViewCreator = itemView.findViewById(R.id.text_view_creator);



            textViewCreator.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position,textViewCreator);

                        }
                    }
                }
            });
        }
    }


}