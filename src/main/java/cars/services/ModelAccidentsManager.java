package cars.services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.util.Random;

@ApplicationScoped
@Alternative
public class ModelAccidentsManager implements AccidentsScanner {

    @Override
    public Integer scanForAccidentsOfThisModel(){
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e){
        }
        Integer accidentsCount = new Random().nextInt(100000);
        return accidentsCount;
    }
}
