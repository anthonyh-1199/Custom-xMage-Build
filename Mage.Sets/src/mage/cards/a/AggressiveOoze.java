
package mage.cards.a;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.common.BlocksOrBecomesBlockedByOneOrMoreTriggeredAbility;
import mage.abilities.effects.CreateTokenCopySourceEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;

/**
 *
 * @author Anthony
 */
public class AggressiveOoze extends CardImpl {

    public AggressiveOoze(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{2}{G}");
        this.subtype.add(SubType.OOZE);
        this.power = new MageInt(1);
        this.toughness = new MageInt(1);

        // Whenever Aggressive Ooze blocks or becomes blocked by one or more  creatures, create a token that's a copy of Aggressive Ooze.
        this.addAbility(new BlocksOrBecomesBlockedByOneOrMoreTriggeredAbility(new CreateTokenCopySourceEffect(), false));
    }

    private AggressiveOoze(final AggressiveOoze card) {
        super(card);
    }

    @Override
    public AggressiveOoze copy() {
        return new AggressiveOoze(this);
    }
}
