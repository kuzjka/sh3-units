package ua.kuzjka.sh3.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.kuzjka.sh3.dto.NationEntry;
import ua.kuzjka.sh3.dto.NewUnitRequest;
import ua.kuzjka.sh3.dto.OrderOfBattleDto;
import ua.kuzjka.sh3.dto.PresenceDto;
import ua.kuzjka.sh3.image.ImageService;
import ua.kuzjka.sh3.model.*;
import ua.kuzjka.sh3.repository.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class NationsService {
    private NationRepository nationRepository;
    private MerchantRepository merchantRepository;
    private WarshipRepository warshipRepository;
    private UBoatRepository uBoatRepository;
    private AircraftRepository aircraftRepository;
    private MerchantPresenceRepository merchantPresenceRepository;
    private WarshipPresenceRepository warshipPresenceRepository;
    private UBoatPresenceRepository uBoatPresenceRepository;
    private AircraftPresenceRepository aircraftPresenceRepository;
    private ImageService imageService;

    public NationsService(
            NationRepository nationRepository,
            MerchantRepository merchantRepository,
            WarshipRepository warshipRepository,
            UBoatRepository uBoatRepository,
            AircraftRepository aircraftRepository,
            MerchantPresenceRepository merchantPresenceRepository,
            WarshipPresenceRepository warshipPresenceRepository,
            UBoatPresenceRepository uBoatPresenceRepository,
            AircraftPresenceRepository aircraftPresenceRepository,
            ImageService imageService
    ) {
        this.nationRepository = nationRepository;
        this.merchantRepository = merchantRepository;
        this.warshipRepository = warshipRepository;
        this.uBoatRepository = uBoatRepository;
        this.aircraftRepository = aircraftRepository;
        this.merchantPresenceRepository = merchantPresenceRepository;
        this.warshipPresenceRepository = warshipPresenceRepository;
        this.uBoatPresenceRepository = uBoatPresenceRepository;
        this.aircraftPresenceRepository = aircraftPresenceRepository;
        this.imageService = imageService;
    }

    public List<NationEntry> getNations() {
        return this.nationRepository.findAllByOrderByNameAsc().stream()
                .map(n -> new NationEntry(n.getId(), n.getName(),
                        "/api/nations/" + n.getId() + "/flag"))
                .toList();
    }

    public void saveNation(NewUnitRequest<String> request) {
        Nation nation = new Nation();
        nation.setName(request.getUnit());
        nation = nationRepository.save(nation);

        try {
            imageService.saveNationFlag(nation.getId(), request.getImage());
        } catch (IOException e) {
            throw new SH3ServiceException(e);
        }
    }

    @Transactional
    public void saveOrderOfBattle(OrderOfBattleDto request) {
        Nation nation = nationRepository.findById(request.getNationId()).orElseThrow();
        deleteCurrentOrderOfBattle(nation);

//        request.getMerchants().forEach(p -> {
//            Merchant merchant = merchantRepository.findById(p.getUnitId()).orElseThrow();
//            MerchantPresence presence = new MerchantPresence();
//            presence.setNation(nation);
//            presence.setUnit(merchant);
//            presence.setStart(p.getStart());
//            presence.setEnd(p.getEnd());
//            merchant.getPresences().add(presence);
//            nation.getMerchants().add(presence);
//        });
//
//        request.getWarships().forEach(p -> {
//            Warship warship = warshipRepository.findById(p.getUnitId()).orElseThrow();
//            WarshipPresence presence = new WarshipPresence();
//            presence.setNation(nation);
//            presence.setUnit(warship);
//            presence.setStart(p.getStart());
//            presence.setEnd(p.getEnd());
//            warship.getPresences().add(presence);
//            nation.getWarships().add(presence);
//        });
//
//        request.getUboats().forEach(p -> {
//            UBoat uBoat = uBoatRepository.findById(p.getUnitId()).orElseThrow();
//            UBoatPresence presence = new UBoatPresence();
//            presence.setNation(nation);
//            presence.setUnit(uBoat);
//            presence.setStart(p.getStart());
//            presence.setEnd(p.getEnd());
//            uBoat.getPresences().add(presence);
//            nation.getUboats().add(presence);
//        });
//
//        request.getAircraft().forEach(p -> {
//            Aircraft aircraft = aircraftRepository.findById(p.getUnitId()).orElseThrow();
//            AircraftPresence presence = new AircraftPresence();
//            presence.setNation(nation);
//            presence.setUnit(aircraft);
//            presence.setStart(p.getStart());
//            presence.setEnd(p.getEnd());
//            aircraft.getPresences().add(presence);
//            nation.getAircrafts().add(presence);
//        });

        List<MerchantPresence> merchants = request.getMerchants().stream()
                .map(e -> {
                    Merchant merchant = merchantRepository.findById(e.getUnitId()).orElseThrow();
                    return new MerchantPresence(nation, merchant, e.getStart(), e.getEnd());
                }).toList();
        merchantPresenceRepository.saveAll(merchants);

        List<WarshipPresence> warships = request.getWarships().stream()
                .map(e -> {
                    Warship warship = warshipRepository.findById(e.getUnitId()).orElseThrow();
                    return new WarshipPresence(nation, warship, e.getStart(), e.getEnd());
                }).toList();
        warshipPresenceRepository.saveAll(warships);

        List<UBoatPresence> uboats = request.getUboats().stream()
                .map(e -> {
                    UBoat uBoat = uBoatRepository.findById(e.getUnitId()).orElseThrow();
                    return new UBoatPresence(nation, uBoat, e.getStart(), e.getEnd());
                }).toList();
        uBoatPresenceRepository.saveAll(uboats);

        List<AircraftPresence> aircraftPresences = request.getAircraft().stream()
                .map(e -> {
                    Aircraft aircraft = aircraftRepository.findById(e.getUnitId()).orElseThrow();
                    return new AircraftPresence(nation, aircraft, e.getStart(), e.getEnd());
                }).toList();
        aircraftPresenceRepository.saveAll(aircraftPresences);
    }

    private void deleteCurrentOrderOfBattle(Nation nation) {
//        nation.getMerchants().forEach(p -> p.getUnit().getPresences().remove(p));
//        nation.getWarships().forEach(p -> p.getUnit().getPresences().remove(p));
//        nation.getUboats().forEach(p -> p.getUnit().getPresences().remove(p));
//        nation.getAircrafts().forEach(p -> p.getUnit().getPresences().remove(p));
//
//        merchantPresenceRepository.deleteAll(nation.getMerchants());
//        warshipPresenceRepository.deleteAll(nation.getWarships());
//        uBoatPresenceRepository.deleteAll(nation.getUboats());
//        aircraftPresenceRepository.deleteAll(nation.getAircrafts());
//
//        nation.setMerchants(new ArrayList<>());
//        nation.setWarships(new ArrayList<>());
//        nation.setUboats(new ArrayList<>());
//        nation.setAircrafts(new ArrayList<>());

        merchantPresenceRepository.deleteAllByNation(nation);
        warshipPresenceRepository.deleteAllByNation(nation);
        uBoatPresenceRepository.deleteAllByNation(nation);
        aircraftPresenceRepository.deleteAllByNation(nation);
    }
}
