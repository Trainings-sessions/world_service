package com.example.worldservice.controller;


import com.example.worldservice.dto.ErrorMessageDTO;
import com.example.worldservice.model.City;
import com.example.worldservice.service.WorldService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Tag(name="World",description = "World Country and City Mgmt API")
@RestController
@RequestMapping(path = "/world")
public class WorldController {

    @Autowired
    WorldService worldService;

    @Operation(
            summary = "Fetch All cities",
            description = "this endpoint will return all cities available in our World database"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = City.class),mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = ErrorMessageDTO.class),mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "500",content = {@Content(schema = @Schema())})
    })
    @GetMapping("/cities")
    public ResponseEntity<List<City>> fetchAllCities()
    {
        return  ResponseEntity.ok(worldService.getAllCities());
    }

    @GetMapping("/cities/{id}")
    public ResponseEntity<City> getCityById(@PathVariable Integer id)
    {
        return ResponseEntity.ok(worldService.getCityById(id));
    }

}
