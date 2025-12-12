package com.shiftswap.infrastructure.adapter.inbound.rest;

import com.shiftswap.infrastructure.adapter.inbound.rest.dto.RequestStatusResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/swaps")
public class SwapRequestController {

    @PatchMapping("/{id}/approve")
    public ResponseEntity<RequestStatusResponseDTO> approveRequest(@PathVariable String id) {
        return ResponseEntity.ok(RequestStatusResponseDTO.builder()
                .success(true)
                .status("approved")
                .build());
    }

    @PatchMapping("/{id}/decline")
    public ResponseEntity<RequestStatusResponseDTO> declineRequest(@PathVariable String id) {
        return ResponseEntity.ok(RequestStatusResponseDTO.builder()
                .success(true)
                .status("declined")
                .build());
    }

    @PatchMapping("/{id}/cancel")
    public ResponseEntity<RequestStatusResponseDTO> cancelRequest(@PathVariable String id) {
        return ResponseEntity.ok(RequestStatusResponseDTO.builder()
                .success(true)
                .status("cancelled")
                .build());
    }

    @PatchMapping("/{id}/accept")
    public ResponseEntity<RequestStatusResponseDTO> acceptRequest(@PathVariable String id) {
        return ResponseEntity.ok(RequestStatusResponseDTO.builder()
                .success(true)
                .status("accepted")
                .build());
    }
}
