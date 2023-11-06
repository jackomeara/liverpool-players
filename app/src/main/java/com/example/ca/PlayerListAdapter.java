package com.example.ca;

//public class PlayerRecycleAdapter extends BaseAdapter {
//    private Context context;
//    private List<Player> playerList;
//
//    public PlayerRecycleAdapter(Context context, List<Player> playerList) {
//        this.context = context;
//        this.playerList = playerList;
//    }
//
//    @Override
//    public int getCount() {
//        return playerList.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return playerList.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        if (convertView == null) {
//            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = inflater.inflate(R.layout.player_card, null);
//        }
//
//        // Bind data to views in player_details_layout
//        Player player = playerList.get(position);
//        ImageView playerImage = convertView.findViewById(R.id.player_img);
//        TextView playerName = convertView.findViewById(R.id.name);
//        TextView playerPosition = convertView.findViewById(R.id.position);
//        Log.w("wtf", "position: " + player.getPosition());
//        // Set player data in the views
//        playerName.setText(player.getName());
//        playerPosition.setText(player.getPosition());
//        int imageResource = this.context.getResources().getIdentifier(player.getImage(), "drawable", this.context.getPackageName());
//        playerImage.setImageResource(imageResource);
//
//        return convertView;
//    }
//}

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Adapter class for displaying a list of players in a RecyclerView.
 * This class extends RecyclerView.Adapter and is designed to work with a RecyclerView to display a
 * list of players.
 */
public class PlayerListAdapter extends RecyclerView.Adapter<PlayerListAdapter.ViewHolder> {
    Context context;
    int layout;
    List<Player> playerList;

    RecyclerViewInterface recyclerViewInterface;

    public PlayerListAdapter(Context context, int layout, List<Player> playerList, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.layout = layout;
        this.playerList = playerList;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(this.playerList.get(position).getName());
        holder.position.setText(this.playerList.get(position).getPosition());
        int imageResource = this.context.getResources().getIdentifier(this.playerList.get(position).getImage(),
                "drawable", this.context.getPackageName());
        holder.image.setImageResource(imageResource);
    }

    @Override
    public int getItemCount() { return this.playerList.size(); }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflate the layout and return a viewholder
        View view = LayoutInflater.from(this.context).inflate(this.layout, parent, false);

        return new PlayerListAdapter.ViewHolder(view, recyclerViewInterface);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView position;
        ImageView image;

        public ViewHolder(View item, RecyclerViewInterface recyclerViewInterface) {
            super(item);

            this.name = item.findViewById(R.id.name);
            this.position = item.findViewById(R.id.position);
            this.image = item.findViewById(R.id.player_img);

            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    recyclerViewInterface.onItemClick(position);
                }
            });
        }
    }
}
