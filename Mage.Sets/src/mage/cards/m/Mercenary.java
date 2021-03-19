package mage.cards.m;

import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.common.AttacksEachCombatStaticAbility;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.costs.mana.GenericManaCost;
import mage.abilities.effects.RestrictionEffect;
import mage.abilities.effects.common.InfoEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.*;
import mage.game.Game;
import mage.game.permanent.Permanent;
import java.util.Objects;
import java.util.UUID;
import mage.abilities.Mode;
import mage.abilities.effects.ContinuousEffect;
import mage.abilities.effects.ContinuousEffectImpl;
import mage.abilities.effects.OneShotEffect;
import mage.players.Player;
import mage.target.Target;
import mage.target.TargetPlayer;
import mage.target.targetpointer.FixedTarget;


/**
 * @author Anthony
 */
public final class Mercenary extends CardImpl {

    public Mercenary(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{2}{B}{B}");

        this.subtype.add(SubType.HUMAN);
        this.subtype.add(SubType.SOLDIER);
        this.power = new MageInt(5);
        this.toughness = new MageInt(5);

        // {3}: Gain control of Mercenary. Any player may activate this ability.
        SimpleActivatedAbility simpleAbility = new SimpleActivatedAbility(
                new MercenaryChangeControlEffect(),
                new GenericManaCost(3)
        );
        simpleAbility.addEffect(new InfoEffect("Any player may activate this ability"));
        simpleAbility.setMayActivate(TargetController.ANY);
        this.addAbility(simpleAbility);
        
        // Mercenary can’t attack its owner.
        Ability ability = new AttacksEachCombatStaticAbility();
        ability.addEffect(new MercenaryAttackRestrictionEffect());
        this.addAbility(ability);
    }

    private Mercenary(final Mercenary card) {
        super(card);
    }

    @Override
    public Mercenary copy() {
        return new Mercenary(this);
    }
}

//Activated ability
class MercenaryChangeControlEffect extends OneShotEffect {

    public MercenaryChangeControlEffect() {
        super(Outcome.Benefit);
        this.staticText = "gain control of {this}";
    }

    public MercenaryChangeControlEffect(final MercenaryChangeControlEffect effect) {
        super(effect);
    }

    @Override
    public MercenaryChangeControlEffect copy() {
        return new MercenaryChangeControlEffect(this);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        Target target = new TargetPlayer();
        target.setNotTarget(true);
        Player controller = game.getPlayer(source.getControllerId());
        if (controller != null) {
            if (controller.chooseTarget(outcome, target, source, game)) {
                ContinuousEffect effect = new MercenaryGainControlEffect(Duration.Custom, target.getFirstTarget());
                effect.setTargetPointer(new FixedTarget(source.getSourceId()));
                game.addEffect(effect, source);
                return true;
            }
        }
        return false;
    }
}

class MercenaryGainControlEffect extends ContinuousEffectImpl {

    UUID controller;

    public MercenaryGainControlEffect(Duration duration, UUID controller) {
        super(duration, Layer.ControlChangingEffects_2, SubLayer.NA, Outcome.GainControl);
        this.controller = controller;
    }

    public MercenaryGainControlEffect(final MercenaryGainControlEffect effect) {
        super(effect);
        this.controller = effect.controller;
    }

    @Override
    public MercenaryGainControlEffect copy() {
        return new MercenaryGainControlEffect(this);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        Permanent permanent = game.getPermanent(source.getFirstTarget());
        if (targetPointer != null) {
            permanent = game.getPermanent(targetPointer.getFirst(game, source));
        }
        if (permanent != null) {
            return permanent.changeControllerId(controller, game, source);
        }
        return false;
    }

    @Override
    public String getText(Mode mode) {
        return "Gain control of {this}";
    }
}

//Can't attack its owner
class MercenaryAttackRestrictionEffect extends RestrictionEffect {

    MercenaryAttackRestrictionEffect() {
        super(Duration.WhileOnBattlefield);
        staticText = "and can't attack its owner.";
    }

    private MercenaryAttackRestrictionEffect(final MercenaryAttackRestrictionEffect effect) {
        super(effect);
    }

    @Override
    public MercenaryAttackRestrictionEffect copy() {
        return new MercenaryAttackRestrictionEffect(this);
    }

    @Override
    public boolean applies(Permanent permanent, Ability source, Game game) {
        return Objects.equals(permanent.getId(), source.getSourceId());
    }

    @Override
    public boolean canAttack(Permanent attacker, UUID defenderId, Ability source, Game game, boolean canUseChooseDialogs) {
        if (defenderId == null) {
            return true;
        }

        boolean allowAttack = true;
        UUID ownerPlayerId = source.getSourcePermanentIfItStillExists(game).getOwnerId();

        if (defenderId.equals(ownerPlayerId)
                && game.getPlayers().size() == 2) { // if only 2 players are left, it can't attack at all.
            allowAttack = false;
        }
        if (defenderId.equals(ownerPlayerId)) { // can't attack owner
            allowAttack = false;
        }

        return allowAttack;
    }
}
