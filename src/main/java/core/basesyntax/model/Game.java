package core.basesyntax.model;

public class Game {
    private String sport;
    private String firstTeam;
    private String secondTeam;

    public Game(String sport, String firstTeam, String secondTeam) {
        this.sport = sport;
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getFirstTeam() {
        return firstTeam;
    }

    public void setFirstTeam(String firstTeam) {
        this.firstTeam = firstTeam;
    }

    public String getSecondTeam() {
        return secondTeam;
    }

    public void setSecondTeam(String secondTeam) {
        this.secondTeam = secondTeam;
    }

    @Override
    public String toString() {
        return "Game{"
                + "sport='" + sport + '\''
                + ", first team='" + firstTeam + '\''
                + ", second team='" + secondTeam + '\''
                + '}';
    }
}
