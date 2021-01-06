package core.basesyntax.model;

public class Game {
    private String sport;
    private String team1;
    private String team2;

    public Game(String sport, String team1, String team2) {
        this.sport = sport;
        this.team1 = team1;
        this.team2 = team2;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    @Override
    public String toString() {
        return "Game{"
                + "sport='" + sport + '\''
                + ", team1='" + team1 + '\''
                + ", team2='" + team2 + '\''
                + '}';
    }
}
