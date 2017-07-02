package app.io.dados.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import app.io.dados.R;
import app.io.dados.entity.Player;

/**
 * Adaptador de Datos del Jugador
 */

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.ViewHolder> {


    private List<Player> data;

    public PlayerAdapter(List<Player> data) {
        this.data = data;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imagePlayer;
        private TextView textPlayer_name;
        private TextView textPlayer_score;
        private TextView textPlayer_date;

        public ViewHolder(View itemView) {
            super(itemView);
            imagePlayer = (ImageView) itemView.findViewById(R.id.imagePlayer);
            textPlayer_name = (TextView) itemView.findViewById(R.id.textPlayer_name);
            textPlayer_score = (TextView) itemView.findViewById(R.id.textPlayer_score);
            textPlayer_date = (TextView) itemView.findViewById(R.id.textPlayer_date);
        }

    }

    @Override
    public PlayerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_player, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(PlayerAdapter.ViewHolder holder, int position) {
        Player player = data.get(position);
        holder.textPlayer_name.setText(player.getName());
        holder.textPlayer_score.setText("Score: " + player.getScore());
        holder.textPlayer_date.setText("Fecha: " + player.getTimeStamp());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}
