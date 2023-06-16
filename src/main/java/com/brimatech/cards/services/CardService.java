package com.brimatech.cards.services;

import com.brimatech.cards.dtos.CreateCardRequest;
import com.brimatech.cards.dtos.UpdateCardRequest;
import com.brimatech.cards.models.Card;
import com.brimatech.cards.models.User;
import com.brimatech.cards.repositories.CardRepository;
import com.brimatech.cards.repositories.UserRepository;
import com.brimatech.cards.security.JwtTokenProviderService;
import com.brimatech.cards.utils.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
public class CardService {

    private final CardRepository cardRepository;

    private final UserRepository userRepository;

    private final JwtTokenProviderService jwtTokenProviderService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CardService.class);

    public CardService(CardRepository cardRepository, UserRepository userRepository, JwtTokenProviderService jwtTokenProviderService) {
        this.cardRepository = cardRepository;
        this.userRepository = userRepository;
        this.jwtTokenProviderService = jwtTokenProviderService;
    }

    private User getUserContext(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(username).orElseThrow();
        return user;
    }

    public ApiResponse<Card> createCard(CreateCardRequest createCardRequest){
        ApiResponse<Card> apiResponse = new ApiResponse<>();
        Card card = new Card();
        card.setName(createCardRequest.getName());
        card.setColor(createCardRequest.getColor());
        card.setDescription(createCardRequest.getDescription());
        card.setCreatedAt(LocalDateTime.now());
        card.setUser(this.getUserContext());
        card.setStatus(Card.Status.TO_DO);

        Card response = cardRepository.save(card);
        apiResponse.setStatus(ApiResponse.Status.SUCCESS);
        apiResponse.setData(response);
        apiResponse.setMessage("Card created successfully");
        LOGGER.info("card request created of user {} ", this.getUserContext().getEmail());
        return apiResponse;
    }

    public ApiResponse<Card> getAllCards(int pageNo, int recordSize){

        Collection<? extends GrantedAuthority> authorities = this.getUserContext().getAuthorities();
        Long userId = this.getUserContext().getId();
        ApiResponse<Card> apiResponse = new ApiResponse<>();
        Pageable pageable = PageRequest.of(pageNo, recordSize);

        if(authorities.toString().equals("Admin")) {

            List<Card> allCards = cardRepository.findAll(pageable).get().toList();
            apiResponse.setStatus(ApiResponse.Status.SUCCESS);
            apiResponse.setDataList(allCards);
            apiResponse.setMessage("All cards retrieved successfully");
            LOGGER.info("All cards retrieved successfully Admin - {} -- {} " ,this.getUserContext().getEmail(), allCards);

        }else {

            List<Card> cardsByUser = cardRepository.cardsByUser(userId, pageable);
            apiResponse.setStatus(ApiResponse.Status.SUCCESS);
            apiResponse.setDataList(cardsByUser);
            apiResponse.setMessage("All cards by user retrieved successfully");
            LOGGER.info("All cards by user - {} - retrieved successfully {} " , this.getUserContext().getEmail(), cardsByUser);
        }
        return apiResponse;
    }

    public ApiResponse<Card> getCardById(Long id) {
        ApiResponse<Card> apiResponse = new ApiResponse<>();
        Card card = cardRepository.findById(id).orElseThrow();

        if (card.getUser().equals(this.getUserContext())) {
            apiResponse.setStatus(ApiResponse.Status.SUCCESS);
            apiResponse.setData(card);
            apiResponse.setMessage("Card retrieved successfully");
            LOGGER.info("Card by user email - {} - retrieved successfully - {} ", this.getUserContext().getEmail(), card);
        } else{
            apiResponse.setStatus(ApiResponse.Status.FAILED);
            apiResponse.setMessage("No card found");
            LOGGER.info("Error occurred! No card found for the user email - {} - ", this.getUserContext().getEmail());
        }
        return apiResponse;
    }

    public ApiResponse<Card> updateCard(Long id, UpdateCardRequest updateCardRequest) {

        ApiResponse<Card> apiResponse = new ApiResponse<>();
        Card card = cardRepository.findById(id).orElseThrow();

        if(card.getUser().equals(this.getUserContext())){
            try {
                card.setName(updateCardRequest.getName());
                card.setColor(updateCardRequest.getColor());
                card.setStatus(updateCardRequest.getStatus());
                card.setDescription(updateCardRequest.getDescription());
                Card updatedCard = cardRepository.save(card);
                apiResponse.setStatus(ApiResponse.Status.SUCCESS);
                apiResponse.setData(updatedCard);
                apiResponse.setMessage("Card updated successfully");
                LOGGER.info("Card by user email - {} - updated successfully {} ", this.getUserContext().getEmail(), updatedCard);
            }catch (Exception e){
                apiResponse.setStatus(ApiResponse.Status.FAILED);
                apiResponse.setMessage(e.getMessage());
                LOGGER.info("Error occurred - {} - " , e.getMessage());
            }
        }else {
            apiResponse.setStatus(ApiResponse.Status.FAILED);
            apiResponse.setMessage("The user is not associated with the card");
            LOGGER.info("user - {} - is not associated with the card name - {} - " , this.getUserContext().getEmail(), card.getName());
        }

        return apiResponse;
    }

    public ApiResponse<Card> deleteCard(Long id) {
        ApiResponse<Card> apiResponse = new ApiResponse<>();
        Card card = cardRepository.findById(id).orElseThrow();
        if (card.getUser().equals(this.getUserContext())){
            try {
                cardRepository.deleteById(id);
                apiResponse.setStatus(ApiResponse.Status.SUCCESS);
                apiResponse.setMessage("Card deleted successfully");
                LOGGER.info("Card by name - {} - deleted successfully by user email - {} " ,card.getName(), this.getUserContext().getEmail());
            }catch (Exception e){
                apiResponse.setStatus(ApiResponse.Status.FAILED);
                apiResponse.setMessage(e.getMessage());
                LOGGER.info("Error occurred - {} - " , e.getMessage());
            }
        }else {
            apiResponse.setStatus(ApiResponse.Status.FAILED);
            apiResponse.setMessage("Error in deletion user not associated with the card");
            LOGGER.info("Error in deletion user email - {} - is not associated with the card name - {} - " , this.getUserContext().getEmail(), card.getName());
        }

        return apiResponse;
    }

    public ApiResponse<Card> searchCard(String name, String color , String status, Date createdAt, int pageNo, int recordSize) {

        ApiResponse<Card> apiResponse = new ApiResponse<>();
        Pageable pageable = PageRequest.of(pageNo, recordSize, Sort.by(String.valueOf(ApiResponse.SortField.name)));
        List<Card> cards ;
        Long userId = this.getUserContext().getId();

        if(createdAt != null){
            cards = this.cardRepository.searchCard(userId, status, name, color, createdAt, pageable);
        } else {
            cards = this.cardRepository.searchCard(userId, status, name, color, pageable);
        }

        apiResponse.setDataList(cards);

        return apiResponse;
    }




}
