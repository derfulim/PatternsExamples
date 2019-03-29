package ua.training.command;

//Concrete command
public class StopCommand implements Command {
    Comp computer;

    public StopCommand (Comp comp) {
        this.computer = comp;
    }

    public void execute() {
        computer.stop();
    }

}
