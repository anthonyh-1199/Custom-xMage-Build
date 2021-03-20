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

        cards.add(new ExpansionSet.SetCardInfo("Dark World Dealings", 12, Rarity.COMMON, mage.cards.d.DarkWorldDealings.class));
        cards.add(new ExpansionSet.SetCardInfo("Dark World Vanguard", 9, Rarity.COMMON, mage.cards.d.DarkWorldVanguard.class));
        cards.add(new ExpansionSet.SetCardInfo("Llanowar Ascendant", 2, Rarity.UNCOMMON, mage.cards.l.LlanowarAscendant.class));
        cards.add(new ExpansionSet.SetCardInfo("Folk Remedies", 4, Rarity.UNCOMMON, mage.cards.f.FolkRemedies.class));
        cards.add(new ExpansionSet.SetCardInfo("Llanowar Priestess", 8, Rarity.RARE, mage.cards.l.LlanowarPriestess.class));
        cards.add(new ExpansionSet.SetCardInfo("Lord of the Dark World", 10, Rarity.RARE, mage.cards.l.LordOfTheDarkWorld.class));
        cards.add(new ExpansionSet.SetCardInfo("Matsuo of the Single Cut", 14, Rarity.RARE, mage.cards.m.MatsuoOfTheSingleCut.class));
        cards.add(new ExpansionSet.SetCardInfo("Mercenary", 11, Rarity.UNCOMMON, mage.cards.m.Mercenary.class));
        cards.add(new ExpansionSet.SetCardInfo("Monkey Kingpin", 7, Rarity.RARE, mage.cards.m.MonkeyKingpin.class));
        cards.add(new ExpansionSet.SetCardInfo("Passing Motivation", 13, Rarity.RARE, mage.cards.p.PassingMotivation.class));
        cards.add(new ExpansionSet.SetCardInfo("Playful Primate", 6, Rarity.UNCOMMON, mage.cards.p.PlayfulPrimate.class));
        cards.add(new ExpansionSet.SetCardInfo("Serra's Shaman", 3, Rarity.UNCOMMON, mage.cards.s.SerrasShaman.class));
        cards.add(new ExpansionSet.SetCardInfo("Serra Super Ascendant", 1, Rarity.RARE, mage.cards.s.SerraSuperAscendant.class));
        cards.add(new ExpansionSet.SetCardInfo("Simian Chieftan", 5, Rarity.RARE, mage.cards.s.SimianChieftan.class));
        cards.add(new ExpansionSet.SetCardInfo("Tactical Disadvantage", 5, Rarity.RARE, mage.cards.t.TacticalDisadvantage.class));

    }

}
