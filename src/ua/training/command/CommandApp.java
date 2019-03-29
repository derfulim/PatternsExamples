package ua.training.command;

public class CommandApp {
    public static void main(String[] args) {
        Comp comp = new Comp();
        User u = new User(new StartCommand(comp),new StopCommand(comp),new ResetCommand(comp));
        u.startComputer();
        u.stopComputer();
        u.resetComputer();
    }
}
