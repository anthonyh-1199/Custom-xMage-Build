
package mage.cards.m;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.dynamicvalue.common.StaticValue;
import mage.abilities.effects.common.continuous.BoostControlledEffect;
import mage.abilities.effects.common.continuous.GainAbilityControlledEffect;
import mage.abilities.keyword.TrampleAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.*;
import mage.filter.common.FilterCreaturePermanent;

/**
 *
 * @author Anthony
 */
public final class MonkeyKingpin extends CardImpl {

    private static final FilterCreaturePermanent filter = new FilterCreaturePermanent(SubType.APE, "Ape creatures");
    static {
        filter.add(TargetController.YOU.getControllerPredicate());
    }
    
    public MonkeyKingpin(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.CREATURE},"{1}{R}{R}");
        this.subtype.add(SubType.APE);
        this.subtype.add(SubType.ROGUE);

        this.power = new MageInt(2);
        this.toughness = new MageInt(2);

        // Trample
        this.addAbility(TrampleAbility.getInstance());
        
        // Other Ape creatures you control get +1/+1 and have trample.
        this.addAbility(new SimpleStaticAbility(Zone.BATTLEFIELD, new BoostControlledEffect(StaticValue.get(1), StaticValue.get(1), Duration.WhileOnBattlefield, filter, true)));
        this.addAbility(new SimpleStaticAbility(Zone.BATTLEFIELD, new GainAbilityControlledEffect(TrampleAbility.getInstance(), Duration.WhileOnBattlefield, filter, true)));
    }

    private MonkeyKingpin(final MonkeyKingpin card) {
        super(card);
    }

    @Override
    public MonkeyKingpin copy() {
        return new MonkeyKingpin(this);
    }
}
