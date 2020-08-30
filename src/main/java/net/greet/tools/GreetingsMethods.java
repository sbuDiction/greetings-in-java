package net.greet.tools;

import java.util.ArrayList;
import java.util.List;

public class GreetingsMethods {
    List<String> greeted_names = new ArrayList<>();

    public Boolean checkName(String name) {
        if (!greeted_names.contains(name)) {
            greeted_names.add(name);
        } else {
            return false;
        }
        return true;
    }

    public List<String> getGreeted_names() {
        return greeted_names;
    }
}
