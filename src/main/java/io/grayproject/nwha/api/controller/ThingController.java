package io.grayproject.nwha.api.controller;

import io.grayproject.nwha.api.dto.RecentlyAddedThingDTO;
import io.grayproject.nwha.api.dto.ThingDTO;
import io.grayproject.nwha.api.service.ThingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * @author Ilya Avkhimenya
 */
@RestController
@RequestMapping("/thing")
public class ThingController {
    private final ThingService thingService;

    @Autowired
    public ThingController(ThingService thingService) {
        this.thingService = thingService;
    }

    @GetMapping("/random")
    public List<ThingDTO> getRandomThings(@RequestParam Integer limit,
                                          @RequestParam(required = false) Integer taskOrdinalNumber) {
        return thingService.getRandomThings(limit, taskOrdinalNumber);
    }

    @GetMapping("/recently")
    public List<RecentlyAddedThingDTO> getRecentlyAddedThings() {
        return thingService.getRecentlyAddedThings();
    }

    @GetMapping("/{id}")
    public ThingDTO getThingById(@PathVariable Long id) {
        return thingService.getThingById(id);
    }

    @PostMapping
    public ThingDTO createThing(Principal principal,
                                @Validated @RequestBody ThingDTO thingDTO) {
        return thingService.createThing(principal, thingDTO);
    }

    @PutMapping
    public ThingDTO updateThing(Principal principal,
                                @Validated @RequestBody ThingDTO thingDTO) {
        return thingService.updateThing(principal, thingDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteThing(Principal principal, @PathVariable Long id) {
        thingService.deleteThing(principal, id);
    }

    @PutMapping("/{id}")
    public void archiveThing(Principal principal, @PathVariable Long id) {
        thingService.archiveThing(principal, id);
    }
}