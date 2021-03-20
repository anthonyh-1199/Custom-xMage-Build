
package mage.cards.t;

import java.util.UUID;
import mage.abilities.Ability;
import mage.abilities.condition.common.OpponentControlsMoreCondition;
import mage.abilities.decorator.ConditionalOneShotEffect;
import mage.abilities.effects.OneShotEffect;
import mage.abilities.effects.common.DrawCardSourceControllerEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Outcome;
import mage.filter.StaticFilters;
import mage.filter.common.FilterCreaturePermanent;
import mage.game.Game;
import mage.players.Player;

/**
 *
 * @author Anthony
 */
public class TacticalDisadvantage extends CardImpl {
    
    public TacticalDisadvantage(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.SORCERY},"{2}{W}");


        //Draw a card if an opponent has more life than you
        this.getSpellAbility().addEffect(new TacticalDisadvantageEffect());
        
        //Draw a card if an opponent controls more creatures than you.
        this.getSpellAbility().addEffect(new ConditionalOneShotEffect(
                new DrawCardSourceControllerEffect(1),
                new OpponentControlsMoreCondition(new FilterCreaturePermanent())));
        
        //Draw a card if an opponent controls more lands than you.
        this.getSpellAbility().addEffect(new ConditionalOneShotEffect(
                new DrawCardSourceControllerEffect(1),
                new OpponentControlsMoreCondition(StaticFilters.FILTER_LANDS)));
    }

    private TacticalDisadvantage(final TacticalDisadvantage card) {
        super(card);
    }

    @Override
    public TacticalDisadvantage copy() {
        return new TacticalDisadvantage(this);
    }
}

//If an opponent has more life than you, draw a card.
class TacticalDisadvantageEffect extends OneShotEffect {

    TacticalDisadvantageEffect() {
        super(Outcome.Benefit);
        this.staticText = "If an opponent has more life than you, draw a card";
    }

    TacticalDisadvantageEffect(final TacticalDisadvantageEffect effect) {
        super(effect);
    }

    @Override
    public TacticalDisadvantageEffect copy() {
        return new TacticalDisadvantageEffect(this);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        Player controller = game.getPlayer(source.getControllerId());
        if (controller != null) {
            for (UUID playerId : game.getState().getPlayersInRange(controller.getId(), game)) {
                Player player = game.getPlayer(playerId);
                if (player != null && player.getLife() > controller.getLife()) {
                    controller.drawCards(1, source, game);
                    return true;
                }
            }
        }
        return false;
    }
}
