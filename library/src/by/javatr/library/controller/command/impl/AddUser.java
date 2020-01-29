package by.javatr.library.controller.command.impl;

import by.javatr.library.controller.command.Command;
import by.javatr.library.entity.Role;
import by.javatr.library.entity.User;
import by.javatr.library.service.impl.UserServiceImpl;

public class AddUser implements Command {

    @Override
    public String execute(String request) {
        UserServiceImpl impl = new UserServiceImpl();

        String[] split = request.substring(request.lastIndexOf("?") + 1).split(PARAM_DELIMITER);

        System.out.println("A TYT");

        int id = Integer.parseInt(split[0]);
        String userName = split[1];
        String password = split[2];

        User user = new User(id, userName, password, Role.USER);

        return impl.create(user) ? "User added." : "User not added.";
    }
}
