package ua.training.mediator;

import java.util.ArrayList;
import java.util.List;

public class MediatorApp {
    public static void main(String[] args) {
        TextChat chat = new TextChat();

        User admit = new Admin(chat,"Ivan");
        User u1 = new SimpleUser(chat, "Vova");
        User u2 = new SimpleUser(chat,"Petya");
        User u3 = new SimpleUser(chat,"Sasha");
        u2.setEnable(false);

        chat.setAdmin(admit);
        chat.addUser(u1);
        chat.addUser(u2);
        chat.addUser(u3);

//        u1.sendMessage("Привет, я пользователь.");
        admit.sendMessage("АДМИН зашел в чат!");
    }
}

abstract class User{
    Chat chat;
    String name;
    boolean isEnable = true;

    public boolean isEnable() {return isEnable;}

    public String getName() {
        return name;
    }

    public void setEnable(boolean isEnable) {
        this.isEnable = isEnable;
    }

    public User(Chat chat, String name) {
        this.chat = chat;
        this.name = name;
    }



    void sendMessage(String message) {
        chat.sendMessage(message,this);
    }

    abstract void getMessage(String message);
}

interface Chat {
    void sendMessage (String message, User user);
}

class TextChat implements Chat {
    User admin;
    List<User> users = new ArrayList<>();

    public void setAdmin (User admin) {
        if((admin!=null)&&(admin instanceof Admin)) {
            this.admin = admin;
        }
        else throw new RuntimeException("Не хватает прав");
    }

    public void addUser(User u) {

        if (admin==null) {
            throw new RuntimeException("В чате нет админа");
        }

        if (u instanceof SimpleUser) {
            users.add(u);
        }
        else throw new RuntimeException("Админ не может входить в другой чат");

    }

    @Override
    public void sendMessage(String message, User user) {
        if (user instanceof Admin){
            for (User u:users) {
                u.getMessage(u.getName() + ": " +message);
            }
        }

        if (user instanceof SimpleUser) {
            for (User u:users) {
                if(u!=user && u.isEnable())
                    u.getMessage((user.getName() + ": " + message));
            }

            if(admin.isEnable()) {
                admin.getMessage((user.getName() + ": " + message));
            }
        }

    }
}

class Admin extends User{

    public Admin(Chat chat, String name) {
    super(chat,name);}

    @Override
    public void getMessage(String message) {
        System.out.println("Администратор " + getName() + "получает сообщение '" + message +"'");
    }
}
class SimpleUser extends User{

    public SimpleUser(Chat chat, String name) {
    super(chat,name);}

    @Override
    public void getMessage(String message) {
        System.out.println("Пользователь "+ getName()+ " получает сообщение '" + message +"'");
    }

}
