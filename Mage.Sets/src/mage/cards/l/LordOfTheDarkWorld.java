
package mage.cards.l;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.common.DiscardedTriggeredAbility;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.costs.Cost;
import mage.abilities.costs.Costs;
import mage.abilities.costs.CostsImpl;
import mage.abilities.costs.common.DiscardCardCost;
import mage.abilities.costs.common.PayLifeCost;
import mage.abilities.costs.common.ReturnToHandChosenControlledPermanentCost;
import mage.abilities.costs.mana.ManaCostsImpl;
import mage.abilities.effects.AsThoughEffectImpl;
import mage.abilities.effects.common.DestroyTargetEffect;
import mage.abilities.keyword.FlyingAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.AsThoughEffectType;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.constants.Outcome;
import mage.constants.SubType;
import mage.constants.SuperType;
import mage.constants.Zone;
import mage.filter.common.FilterControlledCreaturePermanent;
import mage.filter.common.FilterCreaturePermanent;
import mage.game.Game;
import mage.players.Player;
import mage.target.common.TargetControlledCreaturePermanent;
import mage.target.common.TargetCreaturePermanent;

/**
 *
 * @author Anthony
 */
public class LordOfTheDarkWorld extends CardImpl {
    
    public LordOfTheDarkWorld(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.CREATURE},"{2}{B}{B}{B}{B}");
        this.subtype.add(SubType.ZOMBIE);
        this.subtype.add(SubType.DRAGON);

        this.addSuperType(SuperType.LEGENDARY);
        this.power = new MageInt(6);
        this.toughness = new MageInt(6);
        
        //Flying
        this.addAbility(FlyingAbility.getInstance());
        
        //You may cast ~ from your graveyard by returning a Zombie creature you control to its owner's hand in addition to paying its other costs.
        this.addAbility(new SimpleStaticAbility(Zone.GRAVEYARD, new LordOfTheDarkWorldPlayEffect()));
        
        //If a spell or ability causes you to discard ~, you may destroy target creature
        DiscardedTriggeredAbility discardAbility = new DiscardedTriggeredAbility(new DestroyTargetEffect(), true);
        discardAbility.addTarget(new TargetCreaturePermanent(new FilterCreaturePermanent("creature")));

        this.addAbility(discardAbility);
    }

    private LordOfTheDarkWorld(final LordOfTheDarkWorld card) {
        super(card);
    }

    @Override
    public LordOfTheDarkWorld copy() {
        return new LordOfTheDarkWorld(this);
    }
}

class LordOfTheDarkWorldPlayEffect extends AsThoughEffectImpl {

    private static final FilterControlledCreaturePermanent filter
            = new FilterControlledCreaturePermanent("Zombie creature you control");

    static {
        filter.add(SubType.ZOMBIE.getPredicate());
    }
    
    public LordOfTheDarkWorldPlayEffect() {
        super(AsThoughEffectType.PLAY_FROM_NOT_OWN_HAND_ZONE, Duration.EndOfGame, Outcome.PutCreatureInPlay);
        staticText = "You may cast {this} from your graveyard by returning a Zombie creature you control to its owner's hand in addition to paying its other costs.";
    }

    public LordOfTheDarkWorldPlayEffect(final LordOfTheDarkWorldPlayEffect effect) {
        super(effect);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        return true;
    }

    @Override
    public LordOfTheDarkWorldPlayEffect copy() {
        return new LordOfTheDarkWorldPlayEffect(this);
    }

    @Override
    public boolean applies(UUID sourceId, Ability source, UUID affectedControllerId, Game game) {
        if (sourceId.equals(source.getSourceId()) && source.isControlledBy(affectedControllerId)) {
            if (game.getState().getZone(source.getSourceId()) == Zone.GRAVEYARD) {
                Player player = game.getPlayer(affectedControllerId);
                if (player != null) {
                    Costs<Cost> costs = new CostsImpl<>();
                    costs.add(new ReturnToHandChosenControlledPermanentCost(new TargetControlledCreaturePermanent(filter)));
                    player.setCastSourceIdWithAlternateMana(sourceId, new ManaCostsImpl<>("{2}{B}{B}{B}{B}"), costs);
                    return true;
                }
            }
        }
        return false;
    }
}