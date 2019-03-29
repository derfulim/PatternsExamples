package ua.training.command;

//Concrete command
public class ResetCommand implements Command {
    Comp computer;

    public ResetCommand (Comp comp) {
        this.computer = comp;
    }

    public void execute() {
        computer.reset();
    }

}
