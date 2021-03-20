
package mage.cards.m;

import mage.MageInt;
import mage.abilities.keyword.VigilanceAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.*;
import java.util.UUID;
import mage.abilities.keyword.DeathtouchAbility;
import mage.abilities.keyword.FirstStrikeAbility;

/**
 * @author Anthony
 */
public final class MatsuoOfTheSingleCut extends CardImpl {

    public MatsuoOfTheSingleCut(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{R}{W}{B}");

        this.addSuperType(SuperType.LEGENDARY);
        this.subtype.add(SubType.HUMAN);
        this.subtype.add(SubType.SAMURAI);
        this.power = new MageInt(3);
        this.toughness = new MageInt(1);

        // First strike
        this.addAbility(FirstStrikeAbility.getInstance());
        
        // Vigilance
        this.addAbility(VigilanceAbility.getInstance());

        // Deathtouch
        this.addAbility(DeathtouchAbility.getInstance());

    }

    private MatsuoOfTheSingleCut(final MatsuoOfTheSingleCut card) {
        super(card);
    }

    @Override
    public MatsuoOfTheSingleCut copy() {
        return new MatsuoOfTheSingleCut(this);
    }
}