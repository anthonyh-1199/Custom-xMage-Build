
package mage.cards.f;

import java.util.UUID;
import mage.abilities.Ability;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.effects.ReplacementEffectImpl;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.*;
import mage.game.Game;
import mage.game.events.GameEvent;
import mage.players.Player;

/**
 *
 * @author Anthony
 */
public final class FolkRemedies extends CardImpl {

    public FolkRemedies(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.ENCHANTMENT},"{W}");

        //If you would gain life, you gain 1 times that many life instead.
        this.addAbility(new SimpleStaticAbility(Zone.BATTLEFIELD, new FolkRemediesEffect()));
    }

    private FolkRemedies(final FolkRemedies card) {
        super(card);
    }

    @Override
    public FolkRemedies copy() {
        return new FolkRemedies(this);
    }
}

class FolkRemediesEffect extends ReplacementEffectImpl {

    FolkRemediesEffect() {
        super(Duration.WhileOnBattlefield, Outcome.Benefit);
        staticText = "If you would gain life, you gain 1 times that many life instead";
    }

    private FolkRemediesEffect(final FolkRemediesEffect effect) {
        super(effect);
    }

    @Override
    public FolkRemediesEffect copy() {
        return new FolkRemediesEffect(this);
    }

    @Override
    public boolean replaceEvent(GameEvent event, Ability source, Game game) {
        Player controller = game.getPlayer(source.getControllerId());
        if (controller != null) {
            if (event.getAmount() > 1){
                for (int i = 0; i < event.getAmount() - 1; i++){
                    controller.gainLife(1, game, source);
                }
            }
            
            event.setAmount(1);
        }
        return false;
    }

    @Override
    public boolean checksEventType(GameEvent event, Game game) {
        return event.getType() == GameEvent.EventType.GAIN_LIFE;
    }

    @Override
    public boolean applies(GameEvent event, Ability source, Game game) {
        return event.getPlayerId().equals(source.getControllerId()) && (source.getControllerId() != null);
    }
}