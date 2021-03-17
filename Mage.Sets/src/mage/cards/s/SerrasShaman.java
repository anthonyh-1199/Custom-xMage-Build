package mage.cards.s;

import mage.MageInt;
import mage.abilities.common.GainLifeControllerTriggeredAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;

import java.util.UUID;
import mage.abilities.Ability;
import mage.abilities.condition.Condition;
import mage.abilities.decorator.ConditionalOneShotEffect;
import mage.abilities.effects.OneShotEffect;
import mage.abilities.effects.common.DrawCardSourceControllerEffect;
import mage.game.Game;
import mage.players.Player;

/**
 * @author Anthony
 */
public final class SerrasShaman extends CardImpl {

    public SerrasShaman(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{1}{W}{W}");
        this.subtype.add(SubType.HUMAN);
        this.subtype.add(SubType.SHAMAN);

        this.power = new MageInt(2);
        this.toughness = new MageInt(2);

        //Whenever you gain life, if your life total is greater than your starting life total, draw a card.
        this.addAbility(new GainLifeControllerTriggeredAbility(new ConditionalOneShotEffect(
                new DrawCardSourceControllerEffect(1), 
                SerrasShamanCondition.instance, 
                "if your life total is greater than your starting life total, draw a card."), 
                false
        ));
    }

    private SerrasShaman(final SerrasShaman card) {
        super(card);
    }

    @Override
    public SerrasShaman copy() {
        return new SerrasShaman(this);
    }

}

enum SerrasShamanCondition implements Condition {
    instance;

    @Override
    public boolean apply(Game game, Ability source) {
        Player player = game.getPlayer(source.getControllerId());
        return player != null && player.getLife() >= game.getLife();
    }
}