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

@RestController
public class TripPricerController {

    private Logger logger = LoggerFactory.getLogger(TripPricerController.class);

    @Autowired
    TripPricerService tripPricerService;

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