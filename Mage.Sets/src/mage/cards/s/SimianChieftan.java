package mage.cards.s;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import mage.MageInt;
import mage.Mana;
import mage.abilities.Ability;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.costs.common.ExileFromHandCost;
import mage.abilities.dynamicvalue.DynamicValue;
import mage.abilities.effects.Effect;
import mage.abilities.effects.common.continuous.BoostSourceEffect;
import mage.abilities.effects.mana.BasicManaEffect;
import mage.abilities.mana.SimpleManaAbility;
import mage.cards.Card;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.cards.Cards;
import mage.cards.CardsImpl;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.constants.SubType;
import mage.constants.Zone;
import mage.filter.FilterCard;
import mage.filter.common.FilterOwnedCard;
import mage.filter.predicate.card.OwnerIdPredicate;
import mage.game.ExileZone;
import mage.game.Game;
import mage.players.Player;
import mage.target.common.TargetCardInHand;

/**
 * @author Anthony
 */
public final class SimianChieftan extends CardImpl {

    public SimianChieftan (UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.CREATURE},"{1}{R}{R}");
        this.subtype.add(SubType.APE);
        this.subtype.add(SubType.WARRIOR);
        this.power = new MageInt(2);
        this.toughness = new MageInt(2);
        
        // Exile an Ape card from your hand: Add {R}.
        FilterOwnedCard filter = new FilterOwnedCard("an Ape card from your hand");
        filter.add(SubType.APE.getPredicate());
        
        this.addAbility(new SimpleManaAbility(Zone.BATTLEFIELD, 
                new SimianChieftanManaEffect(Mana.RedMana(1)), 
                new ExileFromHandCost(new TargetCardInHand(filter))));
        
        //Simian Chieftan gets +1/+1 for each Ape card you own in exile
        Effect effect = new BoostSourceEffect(SimianChieftanValue.instance, SimianChieftanValue.instance, Duration.EndOfGame);
        effect.setText("Simian Chieftan gets +1/+1 for each Ape card you own in exile.");
        Ability ability = new SimpleStaticAbility(effect);
        this.addAbility(ability);
    }

    public SimianChieftan (final SimianChieftan card) {
        super(card);
    }

    @Override
    public SimianChieftan copy() {
        return new SimianChieftan(this);
    }

}

enum SimianChieftanValue implements DynamicValue {
    instance;

    @Override
    public int calculate(Game game, Ability sourceAbility, Effect effect) {
        Player controller = game.getPlayer(sourceAbility.getControllerId());
        if (controller != null) {
            Collection<ExileZone> exileZones = game.getState().getExile().getExileZones();
            Cards apeCardsInExileZones = new CardsImpl();
            FilterCard filter = new FilterCard();
            filter.add(new OwnerIdPredicate(controller.getId()));
            filter.add(SubType.APE.getPredicate());
            for (ExileZone exile : exileZones) {
                for (Card card : exile.getCards(filter, game)) {
                    apeCardsInExileZones.add(card);
                }
            }
            return apeCardsInExileZones.size();
        }
        return 0;
    }

    @Override
    public DynamicValue copy() {
        return instance;
    }

    @Override
    public String getMessage() {
        return "";
    }
}

class SimianChieftanManaEffect extends BasicManaEffect {

    public SimianChieftanManaEffect(Mana mana) {
        super(mana);
    }

    public SimianChieftanManaEffect(final SimianChieftanManaEffect effect) {
        super(effect);
    }

    @Override
    public SimianChieftanManaEffect copy() {
        return new SimianChieftanManaEffect(this);
    }

    @Override
    public List<Mana> getNetMana(Game game, Ability source) {
        if (game != null && game.inCheckPlayableState()) {
            List<Mana> netMana = new ArrayList<>();
            Player player = game.getPlayer(source.getControllerId());
            if (player != null) {
                int count = player.getHand().size();          
                if (count > 0) {
                    Mana mana = new Mana(
                            getManaTemplate().getWhite() * count, getManaTemplate().getBlue() * count, getManaTemplate().getBlack() * count, getManaTemplate().getRed() * count,
                            getManaTemplate().getGreen() * count,
                            getManaTemplate().getGeneric() * count,
                            getManaTemplate().getAny() * count,
                            getManaTemplate().getColorless() * count
                    );
                        
                    netMana.add(mana);
                }
            }
            return netMana;
        }
        return super.getNetMana(game, source);
    }
}