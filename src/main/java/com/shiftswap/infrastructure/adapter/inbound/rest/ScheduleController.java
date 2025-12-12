package com.shiftswap.infrastructure.adapter.inbound.rest;

import com.shiftswap.infrastructure.adapter.inbound.rest.dto.GenerateScheduleRequestDTO;
import com.shiftswap.infrastructure.adapter.inbound.rest.dto.ShiftDetailDTO;
import com.shiftswap.infrastructure.adapter.inbound.rest.dto.SwapFormDataDTO;
import com.shiftswap.infrastructure.adapter.inbound.rest.dto.SwapRequestDTO;
import com.shiftswap.infrastructure.adapter.inbound.rest.dto.TeamMemberDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    private static final String[] SHIFT_TYPES = {"M", "A", "N", "R", "D"};
    private static final String[] WORKING_SHIFTS = {"M", "A", "N"};
    private static final Map<String, String> SHIFT_TIME_DISPLAY = Map.of(
            "M", "07:00 - 15:00",
            "A", "15:00 - 23:00",
            "N", "23:00 - 07:00",
            "R", "Rest Day",
            "D", "Day Off"
    );
    private static final Random random = new Random();

    @PostMapping("/generate")
    public ResponseEntity<Map<String, List<Map<String, String>>>> generateSchedule(
            @RequestBody GenerateScheduleRequestDTO request) {

        Map<String, List<Map<String, String>>> schedule = new HashMap<>();

        List<TeamMemberDTO> teamMembers = request.teamMembers();
        if (teamMembers == null || teamMembers.isEmpty()) {
            teamMembers = getDefaultTeamMembers();
        }

        LocalDate startDate = LocalDate.parse(request.startDate());
        LocalDate endDate = LocalDate.parse(request.endDate());

        for (TeamMemberDTO member : teamMembers) {
            List<Map<String, String>> shifts = new ArrayList<>();
            LocalDate currentDate = startDate;

            while (!currentDate.isAfter(endDate)) {
                String shiftType = generateRealisticShift(currentDate);
                Map<String, String> shift = new HashMap<>();
                shift.put("date", currentDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
                shift.put("shiftType", shiftType);
                shift.put("timeDisplay", SHIFT_TIME_DISPLAY.get(shiftType));
                shifts.add(shift);
                currentDate = currentDate.plusDays(1);
            }

            schedule.put(member.id(), shifts);
        }

        return ResponseEntity.ok(schedule);
    }

    @PostMapping("/swap-request")
    public ResponseEntity<List<SwapRequestDTO>> submitSwapRequest(@RequestBody SwapFormDataDTO request) {
        List<SwapRequestDTO> swapRequests = new ArrayList<>();
        String requesterId = "current-user-id";
        String requesterName = "John Doe";

        for (ShiftDetailDTO myShift : request.myShifts()) {
            for (ShiftDetailDTO targetShift : request.targetShifts()) {
                SwapRequestDTO swapRequest = SwapRequestDTO.builder()
                        .id(UUID.randomUUID().toString())
                        .requesterId(requesterId)
                        .requesterName(requesterName)
                        .requesterShifts(List.of(myShift))
                        .targetId(request.targetUserId())
                        .targetName("Target User")
                        .targetShifts(List.of(targetShift))
                        .status("pending")
                        .createdAt(LocalDate.now().toString())
                        .message(request.message())
                        .build();
                swapRequests.add(swapRequest);
            }
        }

        return ResponseEntity.ok(swapRequests);
    }

    private String generateRealisticShift(LocalDate date) {
        int dayOfWeek = date.getDayOfWeek().getValue();
        if (dayOfWeek == 6 || dayOfWeek == 7) {
            return random.nextDouble() < 0.3 ? WORKING_SHIFTS[random.nextInt(WORKING_SHIFTS.length)] : "R";
        }
        return random.nextDouble() < 0.8 ? WORKING_SHIFTS[random.nextInt(WORKING_SHIFTS.length)] : "R";
    }

    private List<TeamMemberDTO> getDefaultTeamMembers() {
        return List.of(
                TeamMemberDTO.builder().id("user-1").name("John Doe").role("user").build(),
                TeamMemberDTO.builder().id("user-2").name("Jane Smith").role("teamleader").build(),
                TeamMemberDTO.builder().id("user-3").name("Bob Johnson").role("user").build(),
                TeamMemberDTO.builder().id("user-4").name("Alice Brown").role("user").build(),
                TeamMemberDTO.builder().id("user-5").name("Charlie Wilson").role("user").build()
        );
    }
}
