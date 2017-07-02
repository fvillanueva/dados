package app.io.dados.activities;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import app.io.dados.R;
import app.io.dados.adapters.PlayerAdapter;
import app.io.dados.entity.Player;
import app.io.dados.helper.DataBaseManager;
import app.io.dados.utilities.Util;

public class PlayerScoreActivity extends AppCompatActivity {

    private RecyclerView viewListPlayer;
    private List<Player> players;
    DataBaseManager dataBaseManager;
    PlayerAdapter playerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_score);
        dataBaseManager=new DataBaseManager(this);

        players=getPlayers();
        playerAdapter=new PlayerAdapter(players);
        viewListPlayer=(RecyclerView)findViewById(R.id.viewListPlayer);
        viewListPlayer.setHasFixedSize(true);
        viewListPlayer.setAdapter(playerAdapter);
        viewListPlayer.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    }

    /**
     *
     * @return Lista de Jugadores
     *
     */
    private List<Player> getPlayers(){
        List<Player> playerList=new ArrayList<>();
        Cursor cursor=dataBaseManager.getDataPlayer();
        try {
            while (cursor.moveToNext()){
                Player player=new Player();
                player.setName(cursor.getString(1));
                player.setScore(cursor.getInt(2));
                player.setTimeStamp(cursor.getString(3));
                String fecha=cursor.getString(3);
                Date d=Util.getFormatDate(fecha);
                System.out.println("Fecha: "+fecha);
                System.out.println("Date: "+d);
                playerList.add(player);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return playerList;
    }

}
