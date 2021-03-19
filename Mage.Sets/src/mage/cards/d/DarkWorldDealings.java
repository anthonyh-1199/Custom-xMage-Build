
package mage.cards.d;

import java.util.UUID;
import mage.abilities.effects.common.DrawCardAllEffect;
import mage.abilities.effects.common.LoseLifeAllPlayersEffect;
import mage.abilities.effects.common.discard.DiscardEachPlayerEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;

/**
 *
 * @author Anthony
 */
public final class DarkWorldDealings extends CardImpl {

    public DarkWorldDealings(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.SORCERY}, "{B}");

        // Each player discards a card, loses 1 life, then draws a card.
        this.getSpellAbility().addEffect(new DiscardEachPlayerEffect(1, false).setText("each player discards a card"));
        this.getSpellAbility().addEffect(new LoseLifeAllPlayersEffect(1).setText("and loses 1 life"));
        this.getSpellAbility().addEffect(new DrawCardAllEffect(1).setText(", then draws a card"));
    }

    private DarkWorldDealings(final DarkWorldDealings card) {
        super(card);
    }

    @Override
    public DarkWorldDealings copy() {
        return new DarkWorldDealings(this);
    }
}
