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

    /**
     * Get a list of providers based on user preferences
     *
     * @param apiKey a string of the key needed, not used at the moment in final method getProviderName
     * @param attractionId the UUID of the attractionId in a form of a string
     * @param adults int of the number of adults
     * @param children int of the number of children
     * @param nightsStay int of the number of nights stay
     * @param rewardsPoints int of the reward points
     * @return a list of providers based on user preferences
     */
    public List<Provider> getPriceTripPricer(String apiKey, UUID attractionId, int adults, int children,
                                             int nightsStay,
                                             int rewardsPoints) {
        logger.debug("getPriceTripPricer");
        return tripPricer.getPrice(apiKey, attractionId, adults, children, nightsStay, rewardsPoints);
    }
}
