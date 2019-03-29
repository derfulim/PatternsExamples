package ua.training.command;

//Concrete command
public class StartCommand implements Command {
    Comp computer;

    public StartCommand (Comp comp) {
        this.computer = comp;
    }

    public void execute() {
        computer.start();
    }

}
