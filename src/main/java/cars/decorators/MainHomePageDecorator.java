package cars.decorators;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public class MainHomePageDecorator implements HomePage{

    @Inject
    @Delegate
    @Any
    MainHomePage homePage;

    @Override
    public String welcome() {
        return homePage.welcome();
    }
}