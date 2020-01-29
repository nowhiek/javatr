package by.javatr.library.controller.command.impl;

import by.javatr.library.controller.command.Command;
import by.javatr.library.service.comparator.impl.SortUsersById;
import by.javatr.library.service.comparator.impl.SortUsersByName;
import by.javatr.library.service.comparator.impl.SortUsersByRole;
import by.javatr.library.service.impl.UserServiceImpl;

public class SortUsers implements Command {

    @Override
    public String execute(String request) {
        UserServiceImpl impl = new UserServiceImpl();

        String currentSort = request.substring(request.indexOf("?") + 1, request.lastIndexOf("?"));

        switch (currentSort){
            case "SORT_BY_ID" : {
                return impl.sortEntitiesByComparator(new SortUsersById()).toString();
            }
            case "SORT_BY_NAME" : {
                return impl.sortEntitiesByComparator(new SortUsersByName()).toString();
            }
            case "SORT_BY_ROLE" : {
                return impl.sortEntitiesByComparator(new SortUsersByRole()).toString();
            }
            default : {
                return impl.getAll().toString();
            }
        }
    }
}
