package sections.petclinic.controllers;

import sections.petclinic.exceptions.ValueNotFoundException;

public class IndexController {

    public String index() {

        return "index";
    }

    public String oopsHandler() {
        throw new ValueNotFoundException();
    }
}
