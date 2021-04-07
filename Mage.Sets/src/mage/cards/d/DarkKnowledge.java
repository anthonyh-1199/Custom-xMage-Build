package mage.cards.d;

import java.util.UUID;
import mage.abilities.Ability;
import mage.abilities.effects.OneShotEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Outcome;
import mage.game.Game;
import mage.players.Player;
import mage.watchers.common.PlayerLostLifeWatcher;

/**
 *
 * @author Anthony
 */
public class DarkKnowledge extends CardImpl {

    public DarkKnowledge(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.SORCERY},"{1}{B}");

        // Scry X, where X is the highest converted mana cost among permanents you control, then draw three cards.
        this.getSpellAbility().addEffect(new DarkKnowledgeEffect());
    }

    private DarkKnowledge(final DarkKnowledge card) {
        super(card);
    }

    @Override
    public DarkKnowledge copy() {
        return new DarkKnowledge(this);
    }
}

class DarkKnowledgeEffect extends OneShotEffect {

    public DarkKnowledgeEffect() {
        super(Outcome.DrawCard);
        this.staticText = "Scry X, where X is the amount of life you've lost this turn, then draw a card";
    }

    public DarkKnowledgeEffect(final DarkKnowledgeEffect effect) {
        super(effect);
    }

    @Override
    public DarkKnowledgeEffect copy() {
        return new DarkKnowledgeEffect(this);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        Player controller = game.getPlayer(source.getControllerId());
        if (controller != null) {
            PlayerLostLifeWatcher watcher = game.getState().getWatcher(PlayerLostLifeWatcher.class);
            if (watcher != null) {
                controller.scry(watcher.getLifeLost(source.getControllerId()), source, game);
            }
            controller.drawCards(1, source, game);
            return true;
        }
        return false;
    }
}
