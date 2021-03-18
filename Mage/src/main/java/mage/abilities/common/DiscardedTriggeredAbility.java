
package mage.abilities.common;

import mage.abilities.TriggeredAbilityImpl;
import mage.abilities.effects.Effect;
import mage.constants.Zone;
import mage.game.Game;
import mage.game.events.GameEvent;
import mage.game.events.GameEvent.EventType;
import mage.game.stack.StackObject;

/**
 *
 * @author Anthony
 */
public class DiscardedTriggeredAbility extends TriggeredAbilityImpl {

    public DiscardedTriggeredAbility(Effect effect) {
        this(effect, false);
    }

    public DiscardedTriggeredAbility(Effect effect, boolean optional) {
        super(Zone.GRAVEYARD, effect, optional);
    }

    public DiscardedTriggeredAbility(final DiscardedTriggeredAbility ability) {
        super(ability);
    }

    @Override
    public DiscardedTriggeredAbility copy() {
        return new DiscardedTriggeredAbility(this);
    }
    
    //Activates whenever a DISCARDED_CARD event occurs
    @Override
    public boolean checkEventType(GameEvent event, Game game) {
        return event.getType() == GameEvent.EventType.DISCARDED_CARD;
    }
    
    //Removed check to see if spell or ability was controlled by an opponent (DiscardedByOpponentTriggeredAbility)
    @Override
    public boolean checkTrigger(GameEvent event, Game game) {
        if (getSourceId().equals(event.getTargetId())) {
            StackObject stackObject = game.getStack().getStackObject(event.getSourceId());
            if (stackObject != null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getRule() {
        return "When a spell or ability causes you to discard this card, " + super.getRule();
    }
}
