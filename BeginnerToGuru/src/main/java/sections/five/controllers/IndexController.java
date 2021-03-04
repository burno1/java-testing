package sections.five.controllers;

import sections.five.exceptions.ValueNotFoundException;

public class IndexController {

    public String index() {

        return "index";
    }

    public String oopsHandler() {
        throw new ValueNotFoundException();
    }
}
