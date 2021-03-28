
package mage.cards.b;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.keyword.FlyingAbility;
import mage.abilities.keyword.HasteAbility;
import mage.abilities.mana.AnyColorManaAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.constants.SuperType;

/**
 *
 * @author Anthony
 */
public class BoltTheBird extends CardImpl {

    public BoltTheBird(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{R}{G}");
        this.addSuperType(SuperType.LEGENDARY);
        this.subtype.add(SubType.BIRD);
        this.power = new MageInt(1);
        this.toughness = new MageInt(1);

        //Flying
        this.addAbility(FlyingAbility.getInstance());
        
        //Haste
        this.addAbility(HasteAbility.getInstance());

        //Tap: Add one mana of any color
        this.addAbility(new AnyColorManaAbility());

    }

    private BoltTheBird(final BoltTheBird card) {
        super(card);
    }

    @Override
    public BoltTheBird copy() {
        return new BoltTheBird(this);
    }
}