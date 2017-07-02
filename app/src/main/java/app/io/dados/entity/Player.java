package app.io.dados.entity;


/**
 * Entidad del Jugador
 * [id] : ID Unico del Jugador
 * [name]: Nombre del Jugador
 * [score]: Puntaje del Jugador
 * [timeStamp]: Hora y Fecha del Juego realizado
 */


public class Player {
    private int id;
    private String name;
    private int score;
    private String timeStamp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
