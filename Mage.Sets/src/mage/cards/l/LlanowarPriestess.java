
package mage.cards.l;

import java.util.UUID;

import mage.MageInt;
import mage.Mana;
import mage.abilities.dynamicvalue.DynamicValue;
import mage.abilities.dynamicvalue.common.PermanentsOnBattlefieldCount;
import mage.abilities.mana.DynamicManaAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.filter.common.FilterControlledCreaturePermanent;
import mage.filter.predicate.mageobject.AnotherPredicate;

/**
 * @author Anthony
 */
public final class LlanowarPriestess extends CardImpl {

    private static final FilterControlledCreaturePermanent filter = new FilterControlledCreaturePermanent(SubType.ELF, "other Elf creature you control");
    static{
        filter.add(AnotherPredicate.instance); //Other elves
    }
    private static final DynamicValue xValue = new PermanentsOnBattlefieldCount(filter);

    public LlanowarPriestess(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{1}{G}");
        this.subtype.add(SubType.ELF);
        this.subtype.add(SubType.DRUID);

        this.power = new MageInt(1);
        this.toughness = new MageInt(1);

        // {T}: Add {G} for each other Elf creature you control.
        this.addAbility(new DynamicManaAbility(Mana.GreenMana(1), xValue));
    }

    private LlanowarPriestess(final LlanowarPriestess card) {
        super(card);
    }

    @Override
    public LlanowarPriestess copy() {
        return new LlanowarPriestess(this);
    }
}
