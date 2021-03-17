package mage.sets;

import mage.cards.ExpansionSet;
import mage.cards.repository.CardCriteria;
import mage.cards.repository.CardInfo;
import mage.cards.repository.CardRepository;
import mage.constants.CardType;
import mage.constants.Rarity;
import mage.constants.SetType;

import java.util.ArrayList;
import java.util.List;
import static mage.cards.ExpansionSet.NON_FULL_USE_VARIOUS;

/**
 * @author Anthony
 */
public final class CustomSet extends ExpansionSet {

    private static final CustomSet instance = new CustomSet();

    public static CustomSet getInstance() {
        return instance;
    }

    private final List<CardInfo> savedSpecialLand = new ArrayList<>();

    private CustomSet() {
        super("Custom Set", "CUS", ExpansionSet.buildDate(2021, 3, 17), SetType.CORE);
        this.hasBoosters = true;
        this.hasBasicLands = true;
        this.numBoosterSpecial = 0;
        this.numBoosterLands = 1;
        this.numBoosterCommon = 10;
        this.numBoosterUncommon = 3;
        this.numBoosterRare = 1;
        this.ratioBoosterMythic = 8;
        this.maxCardNumberInBooster = 280;

        // CustomSet boosters have a 5/12 chance of basic land being replaced
        // with the common taplands, which DO NOT appear in the common slot.
        this.ratioBoosterSpecialLand = 12;
        this.ratioBoosterSpecialLandNumerator = 5;

        cards.add(new ExpansionSet.SetCardInfo("Serra Super Ascendant", 1, Rarity.RARE, mage.cards.s.SerraSuperAscendant.class));

    }

    @Override
    public List<CardInfo> getCardsByRarity(Rarity rarity) {
        // Common cards retrievement of Core Set 2020 boosters - prevent the retrievement of the common lands
        if (rarity == Rarity.COMMON) {
            List<CardInfo> savedCardsInfos = savedCards.get(rarity);
            if (savedCardsInfos == null) {
                CardCriteria criteria = new CardCriteria();
                criteria.rarities(Rarity.COMMON);
                criteria.setCodes(this.code).notTypes(CardType.LAND);
                savedCardsInfos = CardRepository.instance.findCards(criteria);
                if (maxCardNumberInBooster != Integer.MAX_VALUE) {
                    savedCardsInfos.removeIf(next -> next.getCardNumberAsInt() > maxCardNumberInBooster);
                }
                savedCards.put(rarity, savedCardsInfos);
            }
            // Return a copy of the saved cards information, as not to let modify the original.
            return new ArrayList<>(savedCardsInfos);
        } else {
            return super.getCardsByRarity(rarity);
        }
    }

    @Override
    // the common taplands replacing the basic land
    public List<CardInfo> getSpecialLand() {
        if (savedSpecialLand.isEmpty()) {
            CardCriteria criteria = new CardCriteria();
            criteria.setCodes(this.code);
            criteria.rarities(Rarity.COMMON);
            criteria.types(CardType.LAND);
            savedSpecialLand.addAll(CardRepository.instance.findCards(criteria));
        }

        return new ArrayList<>(savedSpecialLand);
    }
}
