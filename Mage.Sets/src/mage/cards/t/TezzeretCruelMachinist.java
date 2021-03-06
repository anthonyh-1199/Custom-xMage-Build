package mage.cards.t;

import mage.abilities.Ability;
import mage.abilities.LoyaltyAbility;
import mage.abilities.common.PlaneswalkerEntersWithLoyaltyCountersAbility;
import mage.abilities.effects.ContinuousEffect;
import mage.abilities.effects.OneShotEffect;
import mage.abilities.effects.common.DrawCardSourceControllerEffect;
import mage.abilities.effects.common.continuous.AddCardTypeTargetEffect;
import mage.abilities.effects.common.continuous.SetPowerToughnessTargetEffect;
import mage.cards.*;
import mage.constants.*;
import mage.filter.StaticFilters;
import mage.game.Game;
import mage.game.permanent.Permanent;
import mage.players.Player;
import mage.target.Target;
import mage.target.TargetPermanent;
import mage.target.common.TargetCardInHand;
import mage.target.targetpointer.FixedTarget;

import java.util.UUID;

/**
 * @author TheElk801
 */
public final class TezzeretCruelMachinist extends CardImpl {

    public TezzeretCruelMachinist(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.PLANESWALKER}, "{4}{U}{U}");

        this.addSuperType(SuperType.LEGENDARY);
        this.subtype.add(SubType.TEZZERET);
        this.addAbility(new PlaneswalkerEntersWithLoyaltyCountersAbility(4));

        // +1: Draw a card.
        this.addAbility(new LoyaltyAbility(new DrawCardSourceControllerEffect(1), 1));

        // 0: Until your next turn, target artifact you control becomes a 5/5 creature in addition to its other types.
        Ability ability = new LoyaltyAbility(new AddCardTypeTargetEffect(
                Duration.UntilYourNextTurn,
                CardType.ARTIFACT,
                CardType.CREATURE
        ).setText("Until your next turn, target artifact you control becomes an artifact creature"), 0);
        ability.addEffect(new SetPowerToughnessTargetEffect(
                5, 5, Duration.UntilYourNextTurn
        ).setText("with base power and toughness 5/5"));
        ability.addTarget(new TargetPermanent(StaticFilters.FILTER_CONTROLLED_PERMANENT_ARTIFACT));
        this.addAbility(ability);

        // ???7: Put any number of cards from your hand onto the battlefield face down. They're 5/5 artifact creatures.
        this.addAbility(new LoyaltyAbility(new TezzeretCruelMachinistEffect(), -7));
    }

    private TezzeretCruelMachinist(final TezzeretCruelMachinist card) {
        super(card);
    }

    @Override
    public TezzeretCruelMachinist copy() {
        return new TezzeretCruelMachinist(this);
    }
}

class TezzeretCruelMachinistEffect extends OneShotEffect {

    public TezzeretCruelMachinistEffect() {
        super(Outcome.Benefit);
        this.staticText = "put any number of cards from your hand onto the battlefield face down. They're 5/5 artifact creatures";
    }

    public TezzeretCruelMachinistEffect(final TezzeretCruelMachinistEffect effect) {
        super(effect);
    }

    @Override
    public TezzeretCruelMachinistEffect copy() {
        return new TezzeretCruelMachinistEffect(this);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        Player player = game.getPlayer(source.getControllerId());
        if (player == null) {
            return false;
        }
        Target target = new TargetCardInHand(0, Integer.MAX_VALUE, StaticFilters.FILTER_CARD);
        if (!player.choose(outcome, target, source.getSourceId(), game)) {
            return false;
        }
        Cards cardsToMove = new CardsImpl();

        for (UUID cardId : target.getTargets()) {
            Card card = game.getCard(cardId);
            if (card == null) {
                continue;
            }
            cardsToMove.add(card);

            ContinuousEffect effectCardType = new TezzeretCruelMachinistCardTypeEffect();
            effectCardType.setTargetPointer(new FixedTarget(
                    card.getId(),
                    card.getZoneChangeCounter(game) + 1
            ));
            game.addEffect(effectCardType, source);

            ContinuousEffect effectPowerToughness = new TezzeretCruelMachinistPowerToughnessEffect();
            effectPowerToughness.setTargetPointer(new FixedTarget(
                    card.getId(),
                    card.getZoneChangeCounter(game) + 1
            ));
            game.addEffect(effectPowerToughness, source);
        }

        return player.moveCards(cardsToMove.getCards(game), Zone.BATTLEFIELD, source, game, false, true, true, null);
    }
}

class TezzeretCruelMachinistCardTypeEffect extends AddCardTypeTargetEffect {

    public TezzeretCruelMachinistCardTypeEffect() {
        super(Duration.WhileOnBattlefield, CardType.ARTIFACT, CardType.CREATURE);
    }

    public TezzeretCruelMachinistCardTypeEffect(final TezzeretCruelMachinistCardTypeEffect effect) {
        super(effect);
    }

    @Override
    public TezzeretCruelMachinistCardTypeEffect copy() {
        return new TezzeretCruelMachinistCardTypeEffect(this);
    }

    @Override
    public boolean apply(Layer layer, SubLayer sublayer, Ability source, Game game) {
        for (UUID targetId : targetPointer.getTargets(game, source)) {
            Permanent target = game.getPermanent(targetId);
            if (target != null
                    && target.isFaceDown(game)) {
                switch (layer) {
                    case TypeChangingEffects_4:
                        target.getSuperType().clear();
                        target.getCardType().clear();
                        target.removeAllSubTypes(game);
                        target.addCardType(CardType.ARTIFACT);
                        target.addCardType(CardType.CREATURE);
                        break;
                }
                return true;
            }
        }
        return false;
    }
}

class TezzeretCruelMachinistPowerToughnessEffect extends SetPowerToughnessTargetEffect {

    public TezzeretCruelMachinistPowerToughnessEffect() {
        super(5, 5, Duration.WhileOnBattlefield);
    }

    public TezzeretCruelMachinistPowerToughnessEffect(final TezzeretCruelMachinistPowerToughnessEffect effect) {
        super(effect);
    }

    @Override
    public TezzeretCruelMachinistPowerToughnessEffect copy() {
        return new TezzeretCruelMachinistPowerToughnessEffect(this);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        for (UUID targetId : this.getTargetPointer().getTargets(game, source)) {
            Permanent target = game.getPermanent(targetId);
            if (target != null
                    && target.isFaceDown(game)) {
                target.getPower().setValue(5);
                target.getToughness().setValue(5);
                return true;
            }
        }
        return false;
    }
}
