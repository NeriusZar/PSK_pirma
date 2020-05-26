package cars.decorators;

import javax.enterprise.inject.Default;

@Default
public class MainHomePage implements HomePage {

    @Override
    public String welcome() {
        return "Hello and welcome";
    }
}