package com.easybytes.cards.service.impl;

import com.easybytes.cards.constants.CardsConstants;
import com.easybytes.cards.dto.CardsDto;
import com.easybytes.cards.entity.Cards;
import com.easybytes.cards.exception.CardAlreadyExistsException;
import com.easybytes.cards.exception.ResourceNotFoundException;
import com.easybytes.cards.mapper.CardsMapper;
import com.easybytes.cards.repository.IcardsRepository;
import com.easybytes.cards.service.IcardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class IcardsServiceImpl implements IcardsService {

    @Autowired
    private IcardsRepository cardsRepository;

    @Override
    public void createCards(String mobileNumber) {
        Optional<Cards> optionalCards= cardsRepository.findByMobileNumber(mobileNumber);
        if(optionalCards.isPresent()){
            throw new CardAlreadyExistsException("Card already registered with given mobileNumber "+mobileNumber);
        }
        cardsRepository.save(createNewCard(mobileNumber));

    }

    private Cards createNewCard(String mobileNumber) {
        Cards newCard = new Cards();
        newCard.setMobileNumber(mobileNumber);
        long randomCardNumber = 100000000000L + new Random().nextInt(900000000);
        newCard.setCardNumber(Long.toString(randomCardNumber));
        newCard.setCardType(CardsConstants.CREDIT_CARD);
        newCard.setTotalLimit(CardsConstants.NEW_CARD_LIMIT);
        newCard.setAmountUsed(0);
        newCard.setAvailableAmount(CardsConstants.NEW_CARD_LIMIT);
        return newCard;
    }

    @Override
    public CardsDto fetchCards(String mobileNumber) {
        Cards cards = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Card", "mobileNumber", mobileNumber)
        );
        return CardsMapper.cardsToCardsDto(cards, new CardsDto());    }

    @Override
    public boolean updateCards(CardsDto cardsDto) {
        Cards cards = cardsRepository.findByCardNumber(cardsDto.getCardNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Card", "CardNumber", cardsDto.getCardNumber()));
        CardsMapper.cardsDtoToCards(cardsDto, cards);
        cardsRepository.save(cards);
        return  true;    }

    @Override
    public boolean deleteCards(String mobileNumber) {
        Cards cards = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Card", "mobileNumber", mobileNumber)
        );
        cardsRepository.deleteById(cards.getCardId());
        return true;
    }
}
