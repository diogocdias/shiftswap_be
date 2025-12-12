package com.shiftswap.infrastructure.adapter.inbound.rest;

import com.shiftswap.infrastructure.adapter.inbound.rest.dto.MenuItemDTO;
import com.shiftswap.infrastructure.adapter.inbound.rest.dto.MenuRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cms")
public class MenuController {

    private static final Map<String, List<MenuItemDTO>> MENU_ITEMS_BY_ROLE = Map.of(
            "user", List.of(
                    MenuItemDTO.builder().id("overview").label("Overview").icon("Home").badge(null).order(1).build(),
                    MenuItemDTO.builder().id("my-schedule").label("My Schedule").icon("Calendar").badge(null).order(2).build(),
                    MenuItemDTO.builder().id("requests").label("Requests").icon("ArrowLeftRight").badge(2).order(3).build()
            ),
            "teamleader", List.of(
                    MenuItemDTO.builder().id("overview").label("Overview").icon("Home").badge(null).order(1).build(),
                    MenuItemDTO.builder().id("my-schedule").label("My Schedule").icon("Calendar").badge(null).order(2).build(),
                    MenuItemDTO.builder().id("requests").label("Requests").icon("ArrowLeftRight").badge(2).order(3).build(),
                    MenuItemDTO.builder().id("team").label("Team").icon("Users").badge(null).order(4).build(),
                    MenuItemDTO.builder().id("time-off").label("Time Off").icon("Clock").badge(null).order(5).build(),
                    MenuItemDTO.builder().id("analytics").label("Analytics").icon("BarChart").badge(null).order(6).build()
            ),
            "admin", List.of(
                    MenuItemDTO.builder().id("overview").label("Overview").icon("Home").badge(null).order(1).build(),
                    MenuItemDTO.builder().id("all-schedules").label("All Schedules").icon("CalendarDays").badge(null).order(2).build(),
                    MenuItemDTO.builder().id("requests").label("Requests").icon("ArrowLeftRight").badge(5).order(3).build(),
                    MenuItemDTO.builder().id("all-staff").label("All Staff").icon("Users").badge(null).order(4).build(),
                    MenuItemDTO.builder().id("time-off").label("Time Off").icon("Clock").badge(null).order(5).build(),
                    MenuItemDTO.builder().id("analytics").label("Analytics").icon("BarChart").badge(null).order(6).build(),
                    MenuItemDTO.builder().id("settings").label("Settings").icon("Settings").badge(null).order(7).build()
            )
    );

    @PostMapping("/menu")
    public ResponseEntity<List<MenuItemDTO>> getMenuItems(@RequestBody MenuRequestDTO request) {
        List<MenuItemDTO> menuItems = MENU_ITEMS_BY_ROLE.getOrDefault(request.role(), MENU_ITEMS_BY_ROLE.get("user"));
        return ResponseEntity.ok(menuItems);
    }
}
