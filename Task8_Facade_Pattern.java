class Amplifier {
    public void on() {
        System.out.println("Amplifier is on");
    }

    public void off() {
        System.out.println("Amplifier is off");
    }

    public void setVolume(int volume) {
        System.out.println("Setting amplifier volume to " + volume);
    }
}

class DVDPlayer {
    public void on() {
        System.out.println("DVD Player is on");
    }

    public void off() {
        System.out.println("DVD Player is off");
    }

    public void play(String movie) {
        System.out.println("Playing DVD: " + movie);
    }
}

class Projector {
    public void on() {
        System.out.println("Projector is on");
    }

    public void off() {
        System.out.println("Projector is off");
    }

    public void setInput(String input) {
        System.out.println("Setting projector input to " + input);
    }
}

class HomeTheater {
    private Amplifier amplifier;
    private DVDPlayer dvdPlayer;
    private Projector projector;

    public HomeTheater() {
        amplifier = new Amplifier();
        dvdPlayer = new DVDPlayer();
        projector = new Projector();
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie.....'--'");
        amplifier.on();
        amplifier.setVolume(7);
        dvdPlayer.on();
        dvdPlayer.play(movie);
        projector.on();
        projector.setInput("DVD");
    }

    public void endMovie() {
        System.out.println("Shutting down the home theater...");
        amplifier.off();
        dvdPlayer.off();
        projector.off();
    }
}

class FacadePatternDemo {
    public static void main(String[] args) {
        HomeTheater homeTheater = new HomeTheater();

        System.out.println("----- Watching a Movie -----");
        homeTheater.watchMovie("The Matrix");

        System.out.println("\n----- Ending the Movie -----");
        homeTheater.endMovie();
    }
}