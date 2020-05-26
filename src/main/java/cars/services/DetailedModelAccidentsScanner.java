package cars.services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.util.Random;

@ApplicationScoped
@Alternative
public class DetailedModelAccidentsScanner implements AccidentsScanner{

    @Override
    public Integer scanForAccidentsOfThisModel(){
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e){
        }
        Integer accidentsCount = new Random().nextInt(1000000);
        return accidentsCount;
    }
}
