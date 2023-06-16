package com.brimatech.cards.controllers;

import com.brimatech.cards.dtos.CreateCardRequest;
import com.brimatech.cards.dtos.UpdateCardRequest;
import com.brimatech.cards.models.Card;
import com.brimatech.cards.services.CardService;
import com.brimatech.cards.utils.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Tag(
        name = "REST APIs for Cards Resource",
        description = "CRUD REST APIs - Create Cards , Delete Cards ,Update Card and Get All"
)

@RestController
@RequestMapping("/api/v1/card")
public class CardController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CardController.class);

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @Operation(
            summary = "Create Card REST API",
            description = "Create Card REST API is used to save card in a database"
    )
    @PostMapping("/create-card")
    public ResponseEntity<ApiResponse<Card>> createCard(@RequestBody @Valid CreateCardRequest createCardRequest){

        LOGGER.info("New card request with payload {}...", createCardRequest);
        ApiResponse<Card> apiResponse = cardService.createCard(createCardRequest);

        return new ResponseEntity<>(apiResponse, apiResponse.getStatus().equals(ApiResponse.Status.SUCCESS) ? HttpStatus.OK : HttpStatus.BAD_REQUEST );

    }

    @Operation(
            summary = "Get Card REST API",
            description = "Retrieve Card REST API is used to get card by id from the database"
    )
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Card>> getCardById(String bearerToken, @PathVariable Long id){

        ApiResponse<Card> apiResponse = cardService.getCardById(id);

        return new ResponseEntity<>(apiResponse, apiResponse.getStatus().equals(ApiResponse.Status.SUCCESS) ? HttpStatus.OK : HttpStatus.BAD_REQUEST );
    }

    @Operation(
            summary = "Get All Card REST API",
            description = "Retrieve All Cards REST API is used to get card all cards from the database"
    )
    @GetMapping
    public ResponseEntity<ApiResponse<Card>> getAllCards(
            @RequestParam(name="pageNo", defaultValue="0") int pageNo, @RequestParam(name="recordSize", defaultValue="10") int recordSize){
        ApiResponse<Card> apiResponse = cardService.getAllCards(pageNo, recordSize);
        return new ResponseEntity<>(apiResponse, apiResponse.getStatus().equals(ApiResponse.Status.SUCCESS) ? HttpStatus.OK : HttpStatus.BAD_REQUEST );
    }

    @Operation(
            summary = "Search Card REST API",
            description = "Search Cards REST API is used to search cards from the database"
    )
    @GetMapping("/search")
    public ResponseEntity<ApiResponse<Card>> getSearchCardByName(
            @RequestParam(name="pageNo", defaultValue="0", required=true) int pageNo, @RequestParam(name="recordSize", defaultValue="10") int recordSize,
            @RequestParam(name="name", defaultValue="") String name, @RequestParam(name="color", defaultValue="") String color,
            @RequestParam(name="status", defaultValue="") String status, @RequestParam(name="createdAt", required=false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date createdAt ) {
        ApiResponse<Card> apiResponse = cardService.searchCard(name, color , status, createdAt, pageNo, recordSize);
        return new ResponseEntity<>(apiResponse, apiResponse.getStatus().equals(ApiResponse.Status.SUCCESS) ? HttpStatus.OK : HttpStatus.BAD_REQUEST );
    }

    @Operation(
            summary = "Update Card REST API",
            description = "Update Card REST API is used to update a card in the database"
    )
    @PutMapping("/update-card/{id}")
    public ResponseEntity<ApiResponse<Card>> updateCard(@PathVariable Long id, @RequestBody @Valid UpdateCardRequest updateCardRequest){

        ApiResponse<Card> apiResponse = cardService.updateCard(id, updateCardRequest);

        return new ResponseEntity<>(apiResponse, apiResponse.getStatus().equals(ApiResponse.Status.SUCCESS) ? HttpStatus.OK : HttpStatus.BAD_REQUEST );
    }

    @Operation(
            summary = "Delete Card REST API",
            description = "Delete Card REST API is used to delete a card from the database"
    )
    @DeleteMapping("/delete-card/{id}")
    public ResponseEntity<ApiResponse<Card>> deleteCard(@PathVariable Long id){

        ApiResponse<Card> apiResponse = cardService.deleteCard(id);

        return new ResponseEntity<>(apiResponse, apiResponse.getStatus().equals(ApiResponse.Status.SUCCESS) ? HttpStatus.OK : HttpStatus.BAD_REQUEST );
    }
}
