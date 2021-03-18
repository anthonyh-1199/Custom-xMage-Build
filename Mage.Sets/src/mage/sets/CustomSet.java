package mage.sets;

import mage.cards.ExpansionSet;
import mage.constants.Rarity;
import mage.constants.SetType;


/**
 * @author Anthony
 */
public final class CustomSet extends ExpansionSet {

    private static final CustomSet instance = new CustomSet();

    public static CustomSet getInstance() {
        return instance;
    }

    private CustomSet() {
        super("Custom Set", "CUS", ExpansionSet.buildDate(2021, 3, 17), SetType.CORE);
        this.hasBoosters = true;
        this.hasBasicLands = false;
        this.numBoosterSpecial = 0;
        this.numBoosterLands = 1;
        this.numBoosterCommon = 10;
        this.numBoosterUncommon = 3;
        this.numBoosterRare = 1;
        this.ratioBoosterMythic = 8;
        this.maxCardNumberInBooster = 280;

        cards.add(new ExpansionSet.SetCardInfo("Llanowar Ascendant", 2, Rarity.UNCOMMON, mage.cards.l.LlanowarAscendant.class));
        cards.add(new ExpansionSet.SetCardInfo("Folk Remedies", 4, Rarity.UNCOMMON, mage.cards.f.FolkRemedies.class));
        cards.add(new ExpansionSet.SetCardInfo("Llanowar Priestess", 8, Rarity.RARE, mage.cards.l.LlanowarPriestess.class));
        cards.add(new ExpansionSet.SetCardInfo("Monkey Kingpin", 7, Rarity.RARE, mage.cards.m.MonkeyKingpin.class));
        cards.add(new ExpansionSet.SetCardInfo("Playful Primate", 6, Rarity.UNCOMMON, mage.cards.p.PlayfulPrimate.class));
        cards.add(new ExpansionSet.SetCardInfo("Serra's Shaman", 3, Rarity.UNCOMMON, mage.cards.s.SerrasShaman.class));
        cards.add(new ExpansionSet.SetCardInfo("Serra Super Ascendant", 1, Rarity.RARE, mage.cards.s.SerraSuperAscendant.class));
        cards.add(new ExpansionSet.SetCardInfo("Simian Chieftan", 5, Rarity.RARE, mage.cards.s.SimianChieftan.class));

    }

}
