package tripPricer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tripPricer.Provider;
import tripPricer.TripPricer;

import java.util.List;
import java.util.UUID;

@Service
public class TripPricerService {

    private Logger logger = LoggerFactory.getLogger(TripPricerService.class);
    private TripPricer tripPricer = new TripPricer();


    public List<Provider> getPriceTripPricer(String apiKey, UUID attractionId, int adults, int children,
                                             int nightsStay,
                                             int rewardsPoints) {
        logger.debug("getPriceTripPricer");
        return tripPricer.getPrice(apiKey, attractionId, adults, children, nightsStay, rewardsPoints);
    }
}