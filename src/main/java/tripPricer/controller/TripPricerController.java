package tripPricer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tripPricer.Provider;
import tripPricer.exception.UUIDException;
import tripPricer.service.TripPricerService;

import java.util.List;
import java.util.UUID;

/**
 * TRIP PRICER CONTROLLER USED AS A MICROSERVICE FOR THE MAIN APP TOUR-GUIDE
 */
@RestController
public class TripPricerController {

    private Logger logger = LoggerFactory.getLogger(TripPricerController.class);

    @Autowired
    TripPricerService tripPricerService;

    /**
     *
     * @param apiKey a string of the key needed, not used at the moment in final method getProviderName
     * @param attractionId the UUID of the attractionId in a form of a string
     * @param adults int of the number of adults
     * @param children int of the number of children
     * @param nightsStay int of the number of nights stay
     * @param rewardsPoints int of the reward points
     * @return a list of providers based on user preferences
     * @throws UUIDException
     */
    @GetMapping("/getPrice")
    public List<Provider> getPriceServer(@RequestParam String apiKey, String attractionId, int adults, int children,
                                         int nightsStay, int rewardsPoints) throws UUIDException {
        UUID attractionIdUUID = null;
        try {
            logger.debug("Start getPriceServer at /getPrice for userId : " + attractionId );
            attractionIdUUID = UUID.fromString(attractionId);
        } catch (IllegalArgumentException e) {
            throw new UUIDException(attractionId);
        }
        return tripPricerService.getPriceTripPricer(apiKey, attractionIdUUID, adults, children, nightsStay, rewardsPoints);
    }
}
