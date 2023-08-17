package ua.kuzjka.sh3.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.kuzjka.sh3.dto.*;
import ua.kuzjka.sh3.image.ImageService;
import ua.kuzjka.sh3.model.*;
import ua.kuzjka.sh3.repository.*;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@Service
public class UnitsService {

    private MerchantRepository merchantRepository;
    private WarshipRepository warshipRepository;
    private UBoatRepository uBoatRepository;
    private AircraftRepository aircraftRepository;

    private MerchantPresenceRepository merchantPresenceRepository;
    private WarshipPresenceRepository warshipPresenceRepository;
    private UBoatPresenceRepository uBoatPresenceRepository;
    private AircraftPresenceRepository aircraftPresenceRepository;

    private ImageService imageService;

    public List<UnitEntry<MerchantDto>> getMerchants(UnitFilter filter) {
        List<Merchant> merchants = filterUnits(filter, merchantRepository, merchantPresenceRepository);

        return merchants.stream()
                .sorted(Comparator.comparing(Merchant::getName))
                .map(m -> createEntry(new MerchantDto(m), m.getId()))
                .toList();
    }

    public List<UnitEntry<WarshipDto>> getWarships(UnitFilter filter) {
        List<Warship> warships = filterUnits(filter, warshipRepository, warshipPresenceRepository);

        return warships.stream()
                .sorted(Comparator.comparing(Warship::getName))
                .map(w -> createEntry(new WarshipDto(w), w.getId()))
                .toList();
    }

    public List<UnitEntry<UBoatDto>> getUBoats(UnitFilter filter) {
        List<UBoat> uBoats = filterUnits(filter, uBoatRepository, uBoatPresenceRepository);

        return uBoats.stream()
                .sorted(Comparator.comparing(UBoat::getName))
                .map(u -> createEntry(new UBoatDto(u), u.getId()))
                .toList();
    }

    public List<UnitEntry<AircraftDto>> getAircraft(UnitFilter filter) {
        List<Aircraft> aircraft = filterUnits(filter, aircraftRepository, aircraftPresenceRepository);

        return aircraft.stream()
                .sorted(Comparator.comparing(Aircraft::getName))
                .map(a -> createEntry(new AircraftDto(a), a.getId()))
                .toList();
    }

    public List<UnitSelectionEntry> getMerchantSelection() {
        return merchantRepository.findAll().stream()
                .map(m -> new UnitSelectionEntry(m.getId(), m.getName(), getThumbUrl(m.getId())))
                .sorted(Comparator.comparing(UnitSelectionEntry::getName))
                .toList();
    }

    public List<UnitSelectionEntry> getWarshipSelection() {
        return warshipRepository.findAll().stream()
                .map(w -> new UnitSelectionEntry(w.getId(), w.getName(), getThumbUrl(w.getId())))
                .sorted(Comparator.comparing(UnitSelectionEntry::getName))
                .toList();
    }

    public List<UnitSelectionEntry> getUBoatSelection() {
        return uBoatRepository.findAll().stream()
                .map(u -> new UnitSelectionEntry(u.getId(), u.getName(), getThumbUrl(u.getId())))
                .sorted(Comparator.comparing(UnitSelectionEntry::getName))
                .toList();
    }

    public List<UnitSelectionEntry> getAircraftSelection() {
        return aircraftRepository.findAll().stream()
                .map(a -> new UnitSelectionEntry(a.getId(), a.getName(), getThumbUrl(a.getId())))
                .sorted(Comparator.comparing(UnitSelectionEntry::getName))
                .toList();
    }

    public void saveMerchant(NewUnitRequest<MerchantDto> request) {
        Merchant merchant = request.getUnit().createMerchant();
        merchant = merchantRepository.save(merchant);

        try {
            imageService.saveUnitImage(merchant.getId(), request.getImage());
        } catch (IOException e) {
            throw new SH3ServiceException(e);
        }
    }

    public void saveWarship(NewUnitRequest<WarshipDto> request) {
        Warship warship = request.getUnit().createWarship();
        warship = warshipRepository.save(warship);

        try {
            imageService.saveUnitImage(warship.getId(), request.getImage());
        } catch (IOException e) {
            throw new SH3ServiceException(e);
        }
    }

    public void saveUBoat(NewUnitRequest<UBoatDto> request) {
        UBoat uBoat = request.getUnit().createUBoat();
        uBoat = uBoatRepository.save(uBoat);

        try {
            imageService.saveUnitImage(uBoat.getId(), request.getImage());
        } catch (IOException e) {
            throw new SH3ServiceException(e);
        }
    }

    public void saveAircraft(NewUnitRequest<AircraftDto> request) {
        Aircraft aircraft = request.getUnit().createAircraft();
        aircraft = aircraftRepository.save(aircraft);

        try {
            imageService.saveUnitImage(aircraft.getId(), request.getImage());
        } catch (IOException e) {
            throw new SH3ServiceException(e);
        }
    }

    private <T> UnitEntry<T> createEntry(T dto, int id) {
        return new UnitEntry<T>(dto, getImageUrl(id), getThumbUrl(id));
    }

    private String getImageUrl(int id) {
        return "/api/units/" + id + "/image";
    }

    private String getThumbUrl(int id) {
        return "/api/units/" + id + "/thumb";
    }

    private <T> List<T> filterUnits(
            UnitFilter filter,
            JpaRepository<T, Integer> unitRepository,
            PresenceRepository<T, ? extends Presence<T>> presenceRepository
    ) {
        if (filter.getNations() == null && filter.getYear() == null) {
            return unitRepository.findAll();
        } else if (filter.getNations() == null) {
            return presenceRepository.findByYear(filter.getYear());
        } else if (filter.getYear() == null) {
            return presenceRepository.findByNations(filter.getNations());
        } else {
            return presenceRepository.findByYearAndNations(filter.getYear(), filter.getNations());
        }
    }
}
