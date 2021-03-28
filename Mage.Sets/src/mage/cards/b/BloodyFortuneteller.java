package mage.cards.b;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.TriggeredAbilityImpl;
import mage.abilities.effects.keyword.ScryEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.constants.Zone;
import mage.game.Game;
import mage.game.events.GameEvent;

/**
 *
 * @author Anthony
 */
public class BloodyFortuneteller extends CardImpl {

    public BloodyFortuneteller(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{1}{B}");
        this.subtype.add(SubType.VAMPIRE);
        this.subtype.add(SubType.SHAMAN);
        this.power = new MageInt(2);
        this.toughness = new MageInt(2);

        // Whenever you pay life, scry 1.
        this.addAbility(new BlododyFortunetellerTriggeredAbility());
    }

    private BloodyFortuneteller(final BloodyFortuneteller card) {
        super(card);
    }

    @Override
    public BloodyFortuneteller copy() {
        return new BloodyFortuneteller(this);
    }
}

class BlododyFortunetellerTriggeredAbility extends TriggeredAbilityImpl {

    BlododyFortunetellerTriggeredAbility() {
        super(Zone.BATTLEFIELD, new ScryEffect(1), false);
    }

    private BlododyFortunetellerTriggeredAbility(final BlododyFortunetellerTriggeredAbility ability) {
        super(ability);
    }

    @Override
    public BlododyFortunetellerTriggeredAbility copy() {
        return new BlododyFortunetellerTriggeredAbility(this);
    }

    @Override
    public boolean checkEventType(GameEvent event, Game game) {
        return event.getType().equals(GameEvent.EventType.LIFE_PAID);
    }

    @Override
    public boolean checkTrigger(GameEvent event, Game game) {
        if (event.getPlayerId().equals(controllerId) && event.getAmount() > 0) {
            this.getEffects().clear();
            if (event.getAmount() > 0) {
                this.addEffect(new ScryEffect(1));
            }
            return true;
        }
        return false;
    }

    @Override
    public String getRule() {
        return "Whenever you pay life, scry 1.";
    }
}