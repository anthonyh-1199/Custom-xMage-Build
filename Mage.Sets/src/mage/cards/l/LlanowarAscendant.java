

package mage.cards.l;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.effects.ContinuousEffectImpl;
import mage.abilities.keyword.TrampleAbility;
import mage.abilities.mana.GreenManaAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.constants.Layer;
import mage.constants.Outcome;
import mage.constants.SubLayer;
import mage.constants.SubType;
import mage.constants.Zone;
import mage.filter.StaticFilters;
import mage.game.Game;
import mage.game.permanent.Permanent;
import mage.players.Player;

/**
 *
 * @author Anthony
 */
public final class LlanowarAscendant extends CardImpl {

    public LlanowarAscendant(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.CREATURE},"{G}");
        this.subtype.add(SubType.ELF);
        this.subtype.add(SubType.DRUID);

        this.power = new MageInt(1);
        this.toughness = new MageInt(1);

        // {T}: Add {G}.
        this.addAbility(new GreenManaAbility());
        
        // As long as you control 6 or more lands, Serra Ascendant gets +5/+5 and has trample.
        this.addAbility(new SimpleStaticAbility(Zone.BATTLEFIELD, new LlanowarAscendantEffect()));
    }

    private LlanowarAscendant(final LlanowarAscendant card) {
        super(card);
    }

    @Override
    public LlanowarAscendant copy() {
        return new LlanowarAscendant(this);
    }

}

class LlanowarAscendantEffect extends ContinuousEffectImpl {

    public LlanowarAscendantEffect() {
        super(Duration.WhileOnBattlefield, Outcome.BoostCreature);
        staticText = "As long as you control 6 or more lands, {this} gets +5/+5 and has trample.";
    }

    public LlanowarAscendantEffect(final LlanowarAscendantEffect effect) {
        super(effect);
    }

    @Override
    public LlanowarAscendantEffect copy() {
        return new LlanowarAscendantEffect(this);
    }

    @Override
    public boolean apply(Layer layer, SubLayer sublayer, Ability source, Game game) {
        Permanent creature = game.getPermanent(source.getSourceId());
        Player controller = game.getPlayer(source.getControllerId());
        if (creature != null && controller != null) {
            //Check if controller has 6 or more lands
            if (game.getBattlefield().countAll(StaticFilters.FILTER_LAND, source.getControllerId(), game) >= 6) {
                switch (layer) {
                    case PTChangingEffects_7:
                        if (sublayer == SubLayer.ModifyPT_7c) {
                            creature.addPower(5);
                            creature.addToughness(5);
                        }
                        break;
                    case AbilityAddingRemovingEffects_6:
                        if (sublayer == SubLayer.NA) {
                            creature.addAbility(TrampleAbility.getInstance(), source.getSourceId(), game);
                        }
                        break;
                }

            }
            return true;
        }
        return false;
    }

    @Override
    public boolean apply(Game game, Ability source) {
        return false;
    }

    @Override
    public boolean hasLayer(Layer layer) {
        return Layer.AbilityAddingRemovingEffects_6 == layer || Layer.PTChangingEffects_7 == layer;
    }

}

