package cars.use_cases;

import cars.decorators.HomePage;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
@Model
@RequestScoped
public class Welcome {
    @Inject
    private HomePage homePage;


    public String welcome() {
        return homePage.welcome();
    }
}
