package cars.use_cases;

import cars.interceptors.LoggedInvocation;
import cars.services.ModelAccidentsManager;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class ScanCarAccidentsCount implements Serializable {
    @Inject
    ModelAccidentsManager generator;

    private Integer result = null;

    private CompletableFuture<Integer> generationTask = null;

    @LoggedInvocation
    public String scan(){
        generationTask = CompletableFuture.supplyAsync(() -> generator.scanForAccidentsOfThisModel());

        return "index?faces-redirect=true";
    }

    public boolean isScanning() {
        return generationTask != null && !generationTask.isDone();
    }

    public String getScanningStatus() throws ExecutionException, InterruptedException {
        if (generationTask == null) {
            return null;
        } else if (isScanning()) {
            return "Scanning all the accidents of this model...";
        }
        if (result == null)
            result = generationTask.get();
        return "  Accidents count - : " + result;
    }

}
