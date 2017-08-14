package app.io.dados;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import app.io.dados.activities.InfoActivity;
import app.io.dados.activities.PlayerActivity;
import app.io.dados.activities.PlayerScoreActivity;
import app.io.dados.utilities.Util;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private boolean beforePlay = false;
    private Button buttonPlay;
    private Button buttonScore;
    private Button buttonExit;
    private EditText inputName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonPlay = (Button) findViewById(R.id.buttonPlay);
        buttonScore = (Button) findViewById(R.id.buttonScore);
        buttonExit = (Button) findViewById(R.id.buttonExit);
        inputName = (EditText) findViewById(R.id.inputName);
        inputName.setVisibility(View.GONE);
        buttonPlay.setOnClickListener(this);
        buttonScore.setOnClickListener(this);
        buttonExit.setOnClickListener(this);


    }

    /**
     * @param view Ir a la Actividad PlayerActivity
     */
    private void homeNavigatorPlayer(View view) {
        if (beforePlay == false) {
            inputName.setVisibility(View.VISIBLE);
            beforePlay = true;
        } else {
            String namePlayer = inputName.getText().toString().trim();
            if (beforePlay == true && !namePlayer.isEmpty()) {
                Intent intent = new Intent(this, PlayerActivity.class);
                intent.putExtra(Util.PLAYER_NAME, namePlayer);
                startActivity(intent);
            } else {
                Toast.makeText(this.getApplication(), "Ingrese un Nombre", Toast.LENGTH_SHORT).show();
            }
        }

    }

    /**
     * @param view Ir a la Actividad PlayerScoreActivity
     */
    private void homeNavigatorViewScore(View view) {
        Intent intent = new Intent(this, PlayerScoreActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if (buttonPlay.getId() == v.getId()) {
            homeNavigatorPlayer(null);
        }
        if (buttonScore.getId() == v.getId()) {
            homeNavigatorViewScore(null);
        }
        if (buttonExit.getId()==v.getId()){
            homeNavigateInfoMobile();
        }
    }


    private void homeNavigateInfoMobile() {
        Intent inten=new Intent(this, InfoActivity.class);
        startActivity(inten);

    }

}
