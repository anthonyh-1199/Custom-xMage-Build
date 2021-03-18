
package mage.cards.p;

import java.util.Objects;
import java.util.UUID;
import mage.MageInt;
import mage.abilities.TriggeredAbilityImpl;
import mage.abilities.effects.common.PreventCombatDamageBySourceEffect;
import mage.abilities.keyword.TrampleAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.constants.SubType;
import mage.constants.Zone;
import mage.game.Game;
import mage.game.events.GameEvent;
import mage.game.permanent.Permanent;

/**
 *
 * @author Anthony
 */
public final class PlayfulPrimate extends CardImpl {

    public PlayfulPrimate(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{2}{R}{R}");
        this.subtype.add(SubType.APE);

        this.power = new MageInt(3);
        this.toughness = new MageInt(3);
        
        // Trample
        this.addAbility(TrampleAbility.getInstance());

        // Whenever Playful Primate blocks or becomes blocked by a creature with power 1 or less, prevent all combat damage Playful Primate would deal this turn.
        this.addAbility(new PlayfulPrimateTriggeredAbility());

    }

    private PlayfulPrimate(final PlayfulPrimate card) {
        super(card);
    }

    @Override
    public PlayfulPrimate copy() {
        return new PlayfulPrimate(this);
    }
}

class PlayfulPrimateTriggeredAbility extends TriggeredAbilityImpl {

    PlayfulPrimateTriggeredAbility() {
        //Prevent all combat damage it would deal this turn
        super(Zone.BATTLEFIELD, new PreventCombatDamageBySourceEffect(Duration.EndOfTurn)); 
    }

    PlayfulPrimateTriggeredAbility(final PlayfulPrimateTriggeredAbility ability) {
        super(ability);
    }

    @Override
    public PlayfulPrimateTriggeredAbility copy() {
        return new PlayfulPrimateTriggeredAbility(this);
    }

    @Override
    public boolean checkEventType(GameEvent event, Game game) {
        return event.getType() == GameEvent.EventType.BLOCKER_DECLARED;
    }

    @Override
    public boolean checkTrigger(GameEvent event, Game game) {
        Permanent blocker = game.getPermanent(event.getSourceId());
        Permanent blocked = game.getPermanent(event.getTargetId());
        Permanent playfulPrimate = game.getPermanent(sourceId);
        if (blocker != null && !Objects.equals(blocker, playfulPrimate)
                && blocker.getPower().getValue() < 2
                && Objects.equals(blocked, playfulPrimate)) {
            return true;
        }
        return blocker != null && Objects.equals(blocker, playfulPrimate)
                && game.getPermanent(event.getTargetId()).getPower().getValue() < 2;
    }

    @Override
    public String getRule() {
        return "Whenever {this} blocks or becomes blocked by a creature with power 1 or less, prevent all combat damage {this} would deal this turn.";
    }
}