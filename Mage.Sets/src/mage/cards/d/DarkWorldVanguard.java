
package mage.cards.d;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.effects.ReplacementEffectImpl;
import mage.cards.Card;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.constants.Outcome;
import mage.constants.SubType;
import mage.constants.Zone;
import mage.game.Game;
import mage.game.events.GameEvent;
import mage.game.events.ZoneChangeEvent;
import mage.game.stack.StackObject;
import mage.players.Player;

/**
 *
 * @author Anthony
 */
public class DarkWorldVanguard extends CardImpl {

    public DarkWorldVanguard(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.CREATURE},"{1}{B}");
        this.subtype.add(SubType.ZOMBIE);
        this.subtype.add(SubType.WARRIOR);

        this.power = new MageInt(2);
        this.toughness = new MageInt(2);
        
        //If a spell or ability causes you to discard {this}, put it onto the battlefield instead of putting it into your graveyard
        this.addAbility(new SimpleStaticAbility(Zone.HAND, new DarkWorldVanguardEffect()));
    }

    private DarkWorldVanguard(final DarkWorldVanguard card) {
        super(card);
    }

    @Override
    public DarkWorldVanguard copy() {
        return new DarkWorldVanguard(this);
    }
}

class DarkWorldVanguardEffect extends ReplacementEffectImpl {

    public DarkWorldVanguardEffect() {
        super(Duration.EndOfGame, Outcome.PutCardInPlay);
        staticText = "If a spell or ability causes you to discard {this}, you may put it onto the battlefield instead of putting it into your graveyard";
    }

    public DarkWorldVanguardEffect(final DarkWorldVanguardEffect effect) {
        super(effect);
    }

    @Override
    public DarkWorldVanguardEffect copy() {
        return new DarkWorldVanguardEffect(this);
    }

    @Override
    public boolean checksEventType(GameEvent event, Game game) {
        return event.getType() == GameEvent.EventType.ZONE_CHANGE;
    }

    @Override
    public boolean applies(GameEvent event, Ability source, Game game) {
        if (event.getTargetId().equals(source.getSourceId())) {
            ZoneChangeEvent zcEvent = (ZoneChangeEvent) event;
            if (zcEvent.getFromZone() == Zone.HAND && zcEvent.getToZone() == Zone.GRAVEYARD) { //Checks if the card is being moved from your hand to the graveyard
                StackObject spell = game.getStack().getStackObject(event.getSourceId());
                if (spell != null) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean replaceEvent(GameEvent event, Ability source, Game game) {
        Card card = game.getCard(source.getSourceId());
        if (card != null) {
            Player owner = game.getPlayer(card.getOwnerId());
            if (owner != null) {
                if (owner.chooseUse(outcome, "Put " + card.getIdName() + " onto the battlefield?", source, game)) { //May ability
                    if (owner.moveCards(card, Zone.BATTLEFIELD, source, game)) { //Put the card onto the battlefield instead
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
