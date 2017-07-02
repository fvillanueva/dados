package app.io.dados.activities;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import app.io.dados.MainActivity;
import app.io.dados.R;
import app.io.dados.entity.Player;
import app.io.dados.helper.DataBaseManager;
import app.io.dados.utilities.Util;

/*Actividad de Juego
 *
 */

public class PlayerActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonLanzar;
    private Button buttonSave;
    private TextView textScore;
    private TextView textTurno;
    private TextView textResult;
    private ImageView imageDado;
    private int intentos = 2;
    private int score = 0;
    private String name = "";


    DataBaseManager dataBaseManager;
    Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        Intent intent = getIntent();
        name = intent.getStringExtra(Util.PLAYER_NAME);
        dataBaseManager = new DataBaseManager(this);
        buttonLanzar = (Button) findViewById(R.id.buttonLanzar);
        buttonSave = (Button) findViewById(R.id.buttonSave);
        textScore = (TextView) findViewById(R.id.textScore);
        textResult = (TextView) findViewById(R.id.textResult);
        textTurno = (TextView) findViewById(R.id.textTurno);
        imageDado = (ImageView) findViewById(R.id.imageDado);
        buttonLanzar.setOnClickListener(this);
        buttonSave.setOnClickListener(this);

        textResult.setVisibility(View.GONE);
        buttonSave.setVisibility(View.GONE);

        textTurno.setText("Intentos: : " + intentos);
        textScore.setText("Score: " + 0);
        player = new Player();
        validatView();
        setSubTitleActionBar(name);

    }

    public void lanzar(View view) {
        if (intentos > 0 && intentos <= 2) {
            imageDado.setVisibility(View.GONE);
            textResult.setVisibility(View.VISIBLE);
            int dadoResult = generateDado();
            if (dadoResult == 7) {
                score = score + dadoResult + 10;
            } else {
                score += dadoResult;
            }
            textResult.setText("" + dadoResult);
            buttonLanzar.setText("Lanzar Dado 2");
            textScore.setText("Score: " + score);
        } else {
            buttonLanzar.setVisibility(View.GONE);
            buttonSave.setVisibility(View.VISIBLE);
            textResult.setVisibility(View.GONE);
        }
        if (intentos > 0) {
            intentos = intentos - 1;
        } else if (intentos == 0) {
            intentos = 0;
        }
        textTurno.setText("Intentos: " + intentos);
    }

    public Player setPlayer() {
        player.setName(name);
        player.setScore(score);
        return player;
    }

    public int generateDado() {
        int dado = (int) (Math.random() * 12) + 1;
        return dado;
    }

    public void saveData(Player player) {
        dataBaseManager.insert(player);
        Toast.makeText(this.getApplicationContext(), "Sus Datos fueron Guardados", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    @Override
    public void onClick(View v) {
        if (buttonLanzar.getId() == v.getId()) {
            lanzar(null);

        } else if (buttonSave.getId() == v.getId()) {
            saveData(setPlayer());
        }
    }

    public void validatView() {
        if (intentos == 0) {
            buttonLanzar.setVisibility(View.GONE);
        }
    }

    public void setSubTitleActionBar(String subTitleActionBar) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setSubtitle("Player: " + subTitleActionBar);
    }


}
