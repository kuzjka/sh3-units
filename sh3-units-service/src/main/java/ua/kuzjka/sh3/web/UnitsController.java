package ua.kuzjka.sh3.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.kuzjka.sh3.dto.*;
import ua.kuzjka.sh3.service.UnitsService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UnitsController {
    private UnitsService unitsService;

    public UnitsController(UnitsService unitsService) {
        this.unitsService = unitsService;
    }

    @GetMapping("/merchants")
    public List<UnitEntry<MerchantDto>> getMerchants(
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) List<String> nations
    ) {
        UnitFilter filter = new UnitFilter(year, nations);
        return unitsService.getMerchants(filter);
    }

    @GetMapping("/warships")
    public List<UnitEntry<WarshipDto>> getWarships(
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) List<String> nations
    ) {
        UnitFilter filter = new UnitFilter(year, nations);
        return unitsService.getWarships(filter);
    }

    @GetMapping("/uboats")
    public List<UnitEntry<UBoatDto>> getUBoats(
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) List<String> nations
    ) {
        UnitFilter filter = new UnitFilter(year, nations);
        return unitsService.getUBoats(filter);
    }

    @GetMapping("/aircraft")
    public List<UnitEntry<AircraftDto>> getAircraft(
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) List<String> nations
    ) {
        UnitFilter filter = new UnitFilter(year, nations);
        return unitsService.getAircraft(filter);
    }
}
