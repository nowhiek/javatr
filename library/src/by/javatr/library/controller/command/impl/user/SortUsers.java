package by.javatr.library.controller.command.impl.user;

import by.javatr.library.controller.command.Command;
import by.javatr.library.exception.service.ServiceException;
import by.javatr.library.service.comparator.impl.SortUsersById;
import by.javatr.library.service.comparator.impl.SortUsersByName;
import by.javatr.library.service.comparator.impl.SortUsersByRole;
import by.javatr.library.service.factory.ServiceFactory;
import by.javatr.library.service.impl.UserServiceImpl;

public class SortUsers implements Command {

    @Override
    public String execute(String request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserServiceImpl libraryService = serviceFactory.getUserService();

        String currentSort = request.substring(request.indexOf("?") + 1, request.lastIndexOf("?"));

        try {
            switch (currentSort) {
                case "SORT_BY_ID": {
                    return libraryService.sortEntitiesByComparator(new SortUsersById()).toString();
                }
                case "SORT_BY_NAME": {
                    return libraryService.sortEntitiesByComparator(new SortUsersByName()).toString();
                }
                case "SORT_BY_ROLE": {
                    return libraryService.sortEntitiesByComparator(new SortUsersByRole()).toString();
                }
                default: {
                    return libraryService.getAll().toString();
                }
            }
        } catch (ServiceException e){
            return e.getMessage();
        }
    }
}
