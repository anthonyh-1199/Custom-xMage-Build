package org.mage.plugins.card.dl.sources;

import com.google.common.collect.ImmutableMap;
import org.tritonus.share.ArraySet;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author JayDi85
 */
public class ScryfallImageSupportCards {

    private static final Map<String, String> xmageSetsToScryfall = ImmutableMap.<String, String>builder()
            .put("8EB", "8ED")
            .put("9EB", "9ED")
            .build();
    static final Pattern REGEXP_DIRECT_KEY_SET_CODE_PATTERN = Pattern.compile("(\\w+)\\/", Pattern.MULTILINE);
    static final Pattern REGEXP_DIRECT_KEY_CARD_NAME_PATTERN = Pattern.compile("\\/(.+?)\\/", Pattern.MULTILINE);

    private static final Set<String> supportedSets = new ArraySet<String>() {
        {
            // Sorted by release date, as listed on Scryfall
            // Commented sets are not available on XMage, most likely because they are non-English sets.

            add("LEA"); // Limited Edition Alpha
            add("LEB"); // Limited Edition Beta
            add("2ED"); // Unlimited Edition
            //add("CEI"); // Intl. Collectorsâ€™ Edition
            //add("CED"); // Collectorsâ€™ Edition
            add("ARN"); // Arabian Nights
            add("ATQ"); // Antiquities
            //add("FBB"); // Foreign Black Border
            add("3ED"); // Revised Edition
            add("LEG"); // Legends
            add("SUM"); // Summer Magic / Edgar
            add("PDRC"); // Dragon Con
            add("DRK"); // The Dark
            add("FEM"); // Fallen Empires
            add("PLGM"); // DCI Legend Membership
            //add("4BB"); // Fourth Edition Foreign Black Border
            add("PHPR"); // HarperPrism Book Promos
            add("4ED"); // Fourth Edition
            add("ICE"); // Ice Age
            add("CHR"); // Chronicles
            //add("RIN"); // Rinascimento
            //add("REN"); // Renaissance
            add("HML"); // Homelands
            add("PTC"); // Pro Tour Collector Set
            add("ALL"); // Alliances
            add("RQS"); // Rivals Quick Start Set
            add("PARL"); // Arena League 1996
            //add("PRED"); // Redemption Program
            add("MIR"); // Mirage
            add("MGB"); // Multiverse Gift Box
            add("ITP"); // Introductory Two-Player Set
            add("VIS"); // Visions
            add("5ED"); // Fifth Edition
            //add("PVAN"); // Vanguard Series
            add("PPOD"); // Portal Demo Game
            add("POR"); // Portal
            add("WTH"); // Weatherlight
            add("WC97"); // World Championship Decks 1997
            add("TMP"); // Tempest
            add("JGP"); // Judge Gift Cards 1998
            add("STH"); // Stronghold
            add("P02"); // Portal Second Age
            add("EXO"); // Exodus
            add("UGL"); // Unglued
            add("WC98"); // World Championship Decks 1998
            add("PALP"); // Asia Pacific Land Program
            add("USG"); // Urza's Saga
            add("ATH"); // Anthologies
            add("PAL99"); // Arena League 1999
            add("G99"); // Judge Gift Cards 1999
            add("ULG"); // Urza's Legacy
            add("6ED"); // Classic Sixth Edition
            add("PTK"); // Portal Three Kingdoms
            add("UDS"); // Urza's Destiny
            add("S99"); // Starter 1999
            add("PGRU"); // Guru
            add("WC99"); // World Championship Decks 1999
            add("PWOS"); // Wizards of the Coast Online Store
            add("MMQ"); // Mercadian Masques
            add("BRB"); // Battle Royale Box Set
            add("PAL00"); // Arena League 2000
            add("G00"); // Judge Gift Cards 2000
            add("FNM"); // Friday Night Magic 2000
            add("PELP"); // European Land Program
            add("NEM"); // Nemesis
            add("S00"); // Starter 2000
            add("PCY"); // Prophecy
            add("WC00"); // World Championship Decks 2000
            add("BTD"); // Beatdown Box Set
            add("INV"); // Invasion
            add("PAL01"); // Arena League 2001
            add("MPR"); // Magic Player Rewards 2001
            add("G01"); // Judge Gift Cards 2001
            add("F01"); // Friday Night Magic 2001
            add("PLS"); // Planeshift
            add("7ED"); // Seventh Edition
            add("APC"); // Apocalypse
            add("WC01"); // World Championship Decks 2001
            add("ODY"); // Odyssey
            add("DKM"); // Deckmasters
            add("PAL02"); // Arena League 2002
            //add("PR2"); // Magic Player Rewards 2002
            add("G02"); // Judge Gift Cards 2002
            add("F02"); // Friday Night Magic 2002
            add("TOR"); // Torment
            add("JUD"); // Judgment
            //add("PHJ"); // Hobby Japan Promos
            add("WC02"); // World Championship Decks 2002
            add("ONS"); // Onslaught
            //add("PMOA"); // Magic Online Avatars
            add("PAL03"); // Arena League 2003
            add("P03"); // Magic Player Rewards 2003
            add("G03"); // Judge Gift Cards 2003
            add("F03"); // Friday Night Magic 2003
            add("LGN"); // Legions
            add("SCG"); // Scourge
            add("8ED"); // Eighth Edition
            add("8EB"); // Eighth Edition Box
            add("WC03"); // World Championship Decks 2003
            add("MRD"); // Mirrodin
            add("PAL04"); // Arena League 2004
            add("P04"); // Magic Player Rewards 2004
            add("G04"); // Judge Gift Cards 2004
            add("F04"); // Friday Night Magic 2004
            add("DST"); // Darksteel
            add("5DN"); // Fifth Dawn
            add("WC04"); // World Championship Decks 2004
            add("CHK"); // Champions of Kamigawa
            add("UNH"); // Unhinged
            //add("PMPS"); // Magic Premiere Shop 2005
            add("PAL05"); // Arena League 2005
            add("P05"); // Magic Player Rewards 2005
            add("G05"); // Judge Gift Cards 2005
            add("F05"); // Friday Night Magic 2005
            add("BOK"); // Betrayers of Kamigawa
            add("SOK"); // Saviors of Kamigawa
            add("9ED"); // Ninth Edition
            add("9EB"); // Ninth Edition Box
            //add("PSAL"); // Salvat 2005
            add("RAV"); // Ravnica: City of Guilds
            add("P2HG"); // Two-Headed Giant Tournament
            add("PAL06"); // Arena League 2006
            //add("PMPS06"); // Magic Premiere Shop 2006
            add("PHUK"); // Hachette UK
            add("PGTW"); // Gateway 2006
            add("P06"); // Magic Player Rewards 2006
            add("G06"); // Judge Gift Cards 2006
            add("F06"); // Friday Night Magic 2006
            add("GPT"); // Guildpact
            add("DIS"); // Dissension
            add("CST"); // Coldsnap Theme Decks
            add("CSP"); // Coldsnap
            add("TSP"); // Time Spiral
            add("TSB"); // Time Spiral Timeshifted
            add("PG07"); // Gateway 2007
            //add("PMPS07"); // Magic Premiere Shop 2007
            add("P07"); // Magic Player Rewards 2007
            add("HHO"); // Happy Holidays
            add("G07"); // Judge Gift Cards 2007
            add("F07"); // Friday Night Magic 2007
            add("PLC"); // Planar Chaos
            add("FUT"); // Future Sight
            add("10E"); // Tenth Edition
            add("P10E"); // Tenth Edition Promos
            add("PSUM"); // Summer of Magic
            add("ME1"); // Masters Edition
            add("PREL"); // Release Events
            add("LRW"); // Lorwyn
            add("DD1"); // Duel Decks: Elves vs. Goblins
            add("PSUS"); // Junior Super Series
            add("PJSE"); // Junior Series Europe
            add("PJAS"); // Junior APAC Series
            //add("PMPS08"); // Magic Premiere Shop 2008
            add("PG08"); // Gateway 2008
            add("P08"); // Magic Player Rewards 2008
            add("G08"); // Judge Gift Cards 2008
            add("F08"); // Friday Night Magic 2008
            add("MOR"); // Morningtide
            add("PCMP"); // Champs and States
            add("P15A"); // 15th Anniversary Cards
            add("SHM"); // Shadowmoor
            //add("PJJT"); // Japan Junior Tournament
            add("EVE"); // Eventide
            add("DRB"); // From the Vault: Dragons
            add("ME2"); // Masters Edition II
            add("PWPN"); // Wizards Play Network 2008
            add("ALA"); // Shards of Alara
            add("DD2"); // Duel Decks: Jace vs. Chandra
            add("PWP09"); // Wizards Play Network 2009
            add("PDTP"); // Duels of the Planeswalkers 2009 Promos
            //add("PMPS09"); // Magic Premiere Shop 2009
            add("P09"); // Magic Player Rewards 2009
            add("G09"); // Judge Gift Cards 2009
            add("F09"); // Friday Night Magic 2009
            add("PBOK"); // Miscellaneous Book Promos
            add("CON"); // Conflux
            add("DDC"); // Duel Decks: Divine vs. Demonic
            add("PPRE"); // Prerelease Events
            add("ARB"); // Alara Reborn
            add("PM10"); // Magic 2010 Promos
            add("M10"); // Magic 2010
            add("V09"); // From the Vault: Exiled
            add("HOP"); // Planechase
            add("ME3"); // Masters Edition III
            add("PZEN"); // Zendikar Promos
            add("ZEN"); // Zendikar
            add("DDD"); // Duel Decks: Garruk vs. Liliana
            add("H09"); // Premium Deck Series: Slivers
            add("PDP10"); // Duels of the Planeswalkers 2010 Promos
            add("PWP10"); // Wizards Play Network 2010
            //add("PMPS10"); // Magic Premiere Shop 2010
            add("P10"); // Magic Player Rewards 2010
            add("G10"); // Judge Gift Cards 2010
            add("F10"); // Friday Night Magic 2010
            add("WWK"); // Worldwake
            add("DDE"); // Duel Decks: Phyrexia vs. the Coalition
            add("ROE"); // Rise of the Eldrazi
            add("DPA"); // Duels of the Planeswalkers
            add("ARC"); // Archenemy
            add("PM11"); // Magic 2011 Promos
            add("M11"); // Magic 2011
            add("PWWK"); // Worldwake Promos
            add("PROE"); // Rise of the Eldrazi Promos
            add("V10"); // From the Vault: Relics
            add("DDF"); // Duel Decks: Elspeth vs. Tezzeret
            add("PSOM"); // Scars of Mirrodin Promos
            add("SOM"); // Scars of Mirrodin
            add("TD0"); // Magic Online Theme Decks
            add("PD2"); // Premium Deck Series: Fire and Lightning
            //add("PMPS11"); // Magic Premiere Shop 2011
            add("PWP11"); // Wizards Play Network 2011
            //add("PS11"); // Salvat 2011
            add("P11"); // Magic Player Rewards 2011
            add("G11"); // Judge Gift Cards 2011
            add("F11"); // Friday Night Magic 2011
            add("ME4"); // Masters Edition IV
            add("PMBS"); // Mirrodin Besieged Promos
            add("MBS"); // Mirrodin Besieged
            add("DDG"); // Duel Decks: Knights vs. Dragons
            add("PNPH"); // New Phyrexia Promos
            add("NPH"); // New Phyrexia
            add("TD2"); // Duel Decks: Mirrodin Pure vs. New Phyrexia
            add("PCMD"); // Commander 2011 Launch Party
            add("CMD"); // Commander 2011
            add("PM12"); // Magic 2012 Promos
            add("M12"); // Magic 2012
            add("V11"); // From the Vault: Legends
            add("DDH"); // Duel Decks: Ajani vs. Nicol Bolas
            add("PISD"); // Innistrad Promos
            add("ISD"); // Innistrad
            add("PD3"); // Premium Deck Series: Graveborn
            add("PIDW"); // IDW Comics 2012
            add("PWP12"); // Wizards Play Network 2012
            add("PDP12"); // Duels of the Planeswalkers 2012 Promos
            add("J12"); // Judge Gift Cards 2012
            add("F12"); // Friday Night Magic 2012
            add("PDKA"); // Dark Ascension Promos
            add("DKA"); // Dark Ascension
            add("DDI"); // Duel Decks: Venser vs. Koth
            add("PHEL"); // Open the Helvault
            add("PAVR"); // Avacyn Restored Promos
            add("AVR"); // Avacyn Restored
            add("PC2"); // Planechase 2012
            add("PM13"); // Magic 2013 Promos
            add("M13"); // Magic 2013
            add("V12"); // From the Vault: Realms
            add("DDJ"); // Duel Decks: Izzet vs. Golgari
            add("RTR"); // Return to Ravnica
            add("PRTR"); // Return to Ravnica Promos
            add("CM1"); // Commander's Arsenal
            add("PDP13"); // Duels of the Planeswalkers 2013 Promos
            add("PI13"); // IDW Comics 2013
            add("J13"); // Judge Gift Cards 2013
            add("F13"); // Friday Night Magic 2013
            add("PGTC"); // Gatecrash Promos
            add("GTC"); // Gatecrash
            add("DDK"); // Duel Decks: Sorin vs. Tibalt
            add("PDGM"); // Dragon's Maze Promos
            add("DGM"); // Dragon's Maze
            add("MMA"); // Modern Masters
            add("PM14"); // Magic 2014 Promos
            add("PSDC"); // San Diego Comic-Con 2013
            add("M14"); // Magic 2014
            add("V13"); // From the Vault: Twenty
            add("DDL"); // Duel Decks: Heroes vs. Monsters
            add("PTHS"); // Theros Promos
            add("THS"); // Theros
            add("C13"); // Commander 2013
            add("PDP14"); // Duels of the Planeswalkers 2014 Promos
            add("PI14"); // IDW Comics 2014
            add("J14"); // Judge Gift Cards 2014
            add("F14"); // Friday Night Magic 2014
            add("PBNG"); // Born of the Gods Promos
            //add("THP2"); // Born of the Gods Hero's Path
            add("BNG"); // Born of the Gods
            add("DDM"); // Duel Decks: Jace vs. Vraska
            add("PJOU"); // Journey into Nyx Promos
            add("JOU"); // Journey into Nyx
            add("MD1"); // Modern Event Deck 2014
            add("PLPA"); // Launch Parties
            add("CNS"); // Conspiracy
            add("VMA"); // Vintage Masters
            add("PS14"); // San Diego Comic-Con 2014
            //add("PPC1"); // M15 Prerelease Challenge
            add("PM15"); // Magic 2015 Promos
            add("M15"); // Magic 2015
            add("CP1"); // Magic 2015 Clash Pack
            add("V14"); // From the Vault: Annihilation
            add("DDN"); // Duel Decks: Speed vs. Cunning
            add("KTK"); // Khans of Tarkir
            add("PKTK"); // Khans of Tarkir Promos
            add("C14"); // Commander 2014
            //add("PCEL"); // Celebration Cards
            add("JVC"); // Duel Decks Anthology: Jace vs. Chandra
            add("GVL"); // Duel Decks Anthology: Garruk vs. Liliana
            add("EVG"); // Duel Decks Anthology: Elves vs. Goblins
            add("DVD"); // Duel Decks Anthology: Divine vs. Demonic
            add("J15"); // Judge Gift Cards 2015
            add("F15"); // Friday Night Magic 2015
            add("UGIN"); // Ugin's Fate
            add("PURL"); // URL/Convention Promos
            add("CP2"); // Fate Reforged Clash Pack
            add("FRF"); // Fate Reforged
            add("PFRF"); // Fate Reforged Promos
            add("DDO"); // Duel Decks: Elspeth vs. Kiora
            add("DTK"); // Dragons of Tarkir
            add("PDTK"); // Dragons of Tarkir Promos
            add("PTKDF"); // Tarkir Dragonfury
            add("TPR"); // Tempest Remastered
            add("MM2"); // Modern Masters 2015
            add("PS15"); // San Diego Comic-Con 2015
            add("CP3"); // Magic Origins Clash Pack
            add("PORI"); // Magic Origins Promos
            add("ORI"); // Magic Origins
            add("V15"); // From the Vault: Angels
            add("DDP"); // Duel Decks: Zendikar vs. Eldrazi
            add("BFZ"); // Battle for Zendikar
            add("PSS1"); // BFZ Standard Series
            add("EXP"); // Zendikar Expeditions
            add("PBFZ"); // Battle for Zendikar Promos
            add("C15"); // Commander 2015
            add("PZ1"); // Legendary Cube Prize Pack
            add("J16"); // Judge Gift Cards 2016
            add("F16"); // Friday Night Magic 2016
            add("OGW"); // Oath of the Gatewatch
            add("POGW"); // Oath of the Gatewatch Promos
            add("DDQ"); // Duel Decks: Blessed vs. Cursed
            add("SOI"); // Shadows over Innistrad
            add("W16"); // Welcome Deck 2016
            add("PSOI"); // Shadows over Innistrad Promos
            add("EMA"); // Eternal Masters
            add("PEMN"); // Eldritch Moon Promos
            add("EMN"); // Eldritch Moon
            add("V16"); // From the Vault: Lore
            add("CN2"); // Conspiracy: Take the Crown
            add("DDR"); // Duel Decks: Nissa vs. Ob Nixilis
            add("PKLD"); // Kaladesh Promos
            add("KLD"); // Kaladesh
            add("MPS"); // Kaladesh Inventions
            add("PS16"); // San Diego Comic-Con 2016
            add("C16"); // Commander 2016
            add("PCA"); // Planechase Anthology
            add("J17"); // Judge Gift Cards 2017
            add("F17"); // Friday Night Magic 2017
            add("AER"); // Aether Revolt
            add("PAER"); // Aether Revolt Promos
            add("MM3"); // Modern Masters 2017
            add("DDS"); // Duel Decks: Mind vs. Might
            add("W17"); // Welcome Deck 2017
            add("PAKH"); // Amonkhet Promos
            add("AKH"); // Amonkhet
            add("MP2"); // Amonkhet Invocations
            add("CMA"); // Commander Anthology
            add("E01"); // Archenemy: Nicol Bolas
            add("PHOU"); // Hour of Devastation Promos
            add("HOU"); // Hour of Devastation
            add("PS17"); // San Diego Comic-Con 2017
            add("C17"); // Commander 2017
            add("PWCQ"); // World Magic Cup Qualifiers
            add("H17"); // HasCon 2017
            add("HTR"); // 2016 Heroes of the Realm
            add("PXLN"); // Ixalan Promos
            add("XLN"); // Ixalan
            add("PSS2"); // XLN Standard Showdown
            add("G17"); // 2017 Gift Pack
            add("DDT"); // Duel Decks: Merfolk vs. Goblins
            add("PUST"); // Unstable Promos
            add("IMA"); // Iconic Masters
            add("V17"); // From the Vault: Transform
            add("PXTC"); // XLN Treasure Chest
            add("E02"); // Explorers of Ixalan
            add("UST"); // Unstable
            add("J18"); // Judge Gift Cards 2018
            add("PRIX"); // Rivals of Ixalan Promos
            add("RIX"); // Rivals of Ixalan
            add("PNAT"); // Nationals Promos
            add("A25"); // Masters 25
            add("DDU"); // Duel Decks: Elves vs. Inventors
            add("PDOM"); // Dominaria Promos
            add("DOM"); // Dominaria
            add("CM2"); // Commander Anthology Volume II
            add("BBD"); // Battlebond
            add("PBBD"); // Battlebond Promos
            add("PGPX"); // Grand Prix Promos
            add("SS1"); // Signature Spellbook: Jace
            add("GS1"); // Global Series Jiang Yanggu & Mu Yanling
            add("PM19"); // Core Set 2019 Promos
            add("PSS3"); // M19 Standard Showdown
            add("M19"); // Core Set 2019
            add("ANA"); // Arena New Player Experience
            add("XANA"); // Arena New Player Experience Extras
            add("PS18"); // San Diego Comic-Con 2018
            //add("HTR17"); // Heroes of the Realm 2017
            add("C18"); // Commander 2018
            add("PGRN"); // Guilds of Ravnica Promos
            add("PRWK"); // GRN Ravnica Weekend
            add("GRN"); // Guilds of Ravnica
            add("GK1"); // GRN Guild Kit
            add("GNT"); // Game Night
            add("G18"); // M19 Gift Pack
            add("PZ2"); // Treasure Chest
            add("PUMA"); // Ultimate Box Topper
            add("UMA"); // Ultimate Masters
            add("PF19"); // MagicFest 2019
            add("PRNA"); // Ravnica Allegiance Promos
            add("RNA"); // Ravnica Allegiance
            add("GK2"); // RNA Guild Kit
            add("PRW2"); // RNA Ravnica Weekend
            add("J19"); // Judge Gift Cards 2019
            add("PRM"); // Magic Online Promos
            add("MED"); // Mythic Edition
            add("WAR"); // War of the Spark
            add("PWAR"); // War of the Spark Promos
            add("PMH1"); // Modern Horizons Promos
            add("MH1"); // Modern Horizons
            add("SS2"); // Signature Spellbook: Gideon
            add("PRES"); // Resale Promos
            add("PPP1"); // M20 Promo Packs
            add("PM20"); // Core Set 2020 Promos
            add("M20"); // Core Set 2020
            add("PS19"); // San Diego Comic-Con 2019
            //add("HTR18"); // Heroes of the Realm 2018
            add("C19"); // Commander 2019
            add("PELD"); // Throne of Eldraine Promos
            add("ELD"); // Throne of Eldraine
            //add("PTG"); // Ponies: The Galloping
            //add("CMB1"); // Mystery Booster Playtest Cards
            add("MB1"); // Mystery Booster
            add("GN2"); // Game Night 2019
            add("HA1"); // Historic Anthology 1
            //add("HHO"); // Happy Holidays
            add("OVNT"); // Vintage Championship
            add("OLGC"); // Legacy Championship
            add("PPRO"); // Pro Tour Promos
            add("PF20"); // MagicFest 2020
            add("J20"); // Judge Gift Cards 2020
            add("PTHB"); // Theros Beyond Death Promos
            add("THB"); // Theros Beyond Death
            add("PWOR"); // World Championship Promos
            add("PANA"); // MTG Arena Promos
            add("UND"); // Unsanctioned
            add("FMB1"); // Mystery Booster Retail Edition Foils
            add("HA2"); // Historic Anthology 2
            add("SLD"); // Secret Lair Drop
            add("PMEI"); // Magazine Inserts
            add("SLU"); // Secret Lair: Ultimate Edition
            add("SS3"); // Signature Spellbook: Chandra
            add("HA3"); // Historic Anthology 3
            // add("TD0"); // Commander Theme Decks
            // add("TD2"); // Duel Decks: Mirrodin Pure vs. New Phyrexia
            // add("MD1"); // Modern Event Deck
            // add("DD3"); // Duel Decks Anthology
            // add("PZ1"); // Legendary Cube
            add("IKO"); // Ikoria: Lair of Behemoths
            add("C20"); // Commander 2020 Edition
            add("M21"); // Core Set 2021
            add("JMP"); // Jumpstart
            add("2XM"); // Double Masters
            add("AKR"); // Amonkhet Remastered
            add("ZNR"); // Zendikar Rising
            add("ZNC"); // Zendikar Rising Commander
            add("ZNE"); // Zendikar Rising Expeditions
            add("CMR"); // Commander Legends
            add("CC1"); // Commander Collection: Green
            add("KHM"); // Kaldheim
            add("KHC"); // Kaldheim Commander
            add("TSR"); // Time Spiral Remastered
            add("STX"); // Strixhaven: School of Mages
        }
    };

    private static final Map<String, String> directDownloadLinks = new HashMap<String, String>() {
        {
            // xmage card -> api link:
            // examples:
            //   api example: https://api.scryfall.com/cards/trix/6/
            // api format is primary
            //
            // code form for one card:
            //   set/card_name
            //
            // code form for same name cards (alternative images):
            //   set/card_name/card_number
            //   set/card_name/card_number

            // Cards with non-ASCII collector numbers must use direct download (cause xmage uses different card number)
            // Verify checks must check and show missing data from that list
            // 10E
            put("10E/Air Elemental/64*", "https://api.scryfall.com/cards/10e/64â?…/");
            put("10E/Anaba Bodyguard/187*", "https://api.scryfall.com/cards/10e/187â?…/");
            put("10E/Ancestor's Chosen/1*", "https://api.scryfall.com/cards/10e/1â?…/");
            put("10E/Angel of Mercy/2*", "https://api.scryfall.com/cards/10e/2â?…/");
            put("10E/Angelic Blessing/3*", "https://api.scryfall.com/cards/10e/3â?…/");
            put("10E/Angelic Wall/5*", "https://api.scryfall.com/cards/10e/5â?…/");
            put("10E/Arcane Teachings/188*", "https://api.scryfall.com/cards/10e/188â?…/");
            put("10E/Ascendant Evincar/127*", "https://api.scryfall.com/cards/10e/127â?…/");
            put("10E/Avatar of Might/251*", "https://api.scryfall.com/cards/10e/251â?…/");
            put("10E/Aven Cloudchaser/7*", "https://api.scryfall.com/cards/10e/7â?…/");
            put("10E/Aven Fisher/68*", "https://api.scryfall.com/cards/10e/68â?…/");
            put("10E/Aven Windreader/69*", "https://api.scryfall.com/cards/10e/69â?…/");
            put("10E/Benalish Knight/11*", "https://api.scryfall.com/cards/10e/11â?…/");
            put("10E/Birds of Paradise/252*", "https://api.scryfall.com/cards/10e/252â?…/");
            put("10E/Blanchwood Armor/253*", "https://api.scryfall.com/cards/10e/253â?…/");
            put("10E/Bog Wraith/130*", "https://api.scryfall.com/cards/10e/130â?…/");
            put("10E/Canopy Spider/254*", "https://api.scryfall.com/cards/10e/254â?…/");
            put("10E/Cloud Elemental/74*", "https://api.scryfall.com/cards/10e/74â?…/");
            put("10E/Cloud Sprite/75*", "https://api.scryfall.com/cards/10e/75â?…/");
            put("10E/Coat of Arms/316*", "https://api.scryfall.com/cards/10e/316â?…/");
            put("10E/Colossus of Sardia/317*", "https://api.scryfall.com/cards/10e/317â?…/");
            put("10E/Contaminated Bond/132*", "https://api.scryfall.com/cards/10e/132â?…/");
            put("10E/Dehydration/78*", "https://api.scryfall.com/cards/10e/78â?…/");
            put("10E/Dragon Roost/197*", "https://api.scryfall.com/cards/10e/197â?…/");
            put("10E/Drudge Skeletons/139*", "https://api.scryfall.com/cards/10e/139â?…/");
            put("10E/Dusk Imp/140*", "https://api.scryfall.com/cards/10e/140â?…/");
            put("10E/Elvish Champion/261*", "https://api.scryfall.com/cards/10e/261â?…/");
            put("10E/Faerie Conclave/351*", "https://api.scryfall.com/cards/10e/351â?…/");
            put("10E/Fear/142*", "https://api.scryfall.com/cards/10e/142â?…/");
            put("10E/Field Marshal/15*", "https://api.scryfall.com/cards/10e/15â?…/");
            put("10E/Firebreathing/200*", "https://api.scryfall.com/cards/10e/200â?…/");
            put("10E/Fog Elemental/85*", "https://api.scryfall.com/cards/10e/85â?…/");
            put("10E/Furnace Whelp/205*", "https://api.scryfall.com/cards/10e/205â?…/");
            put("10E/Ghitu Encampment/353*", "https://api.scryfall.com/cards/10e/353â?…/");
            put("10E/Giant Spider/267*", "https://api.scryfall.com/cards/10e/267â?…/");
            put("10E/Goblin King/207*", "https://api.scryfall.com/cards/10e/207â?…/");
            put("10E/Goblin Sky Raider/210*", "https://api.scryfall.com/cards/10e/210â?…/");
            put("10E/Heart of Light/19*", "https://api.scryfall.com/cards/10e/19â?…/");
            put("10E/Holy Strength/22*", "https://api.scryfall.com/cards/10e/22â?…/");
            put("10E/Hypnotic Specter/151*", "https://api.scryfall.com/cards/10e/151â?…/");
            put("10E/Kamahl, Pit Fighter/214*", "https://api.scryfall.com/cards/10e/214â?…/");
            put("10E/Leonin Scimitar/331*", "https://api.scryfall.com/cards/10e/331â?…/");
            put("10E/Lightning Elemental/217*", "https://api.scryfall.com/cards/10e/217â?…/");
            put("10E/Lord of the Pit/154*", "https://api.scryfall.com/cards/10e/154â?…/");
            put("10E/Loxodon Warhammer/332*", "https://api.scryfall.com/cards/10e/332â?…/");
            put("10E/Lure/276*", "https://api.scryfall.com/cards/10e/276â?…/");
            put("10E/Mahamoti Djinn/90*", "https://api.scryfall.com/cards/10e/90â?…/");
            put("10E/Mantis Engine/333*", "https://api.scryfall.com/cards/10e/333â?…/");
            put("10E/March of the Machines/91*", "https://api.scryfall.com/cards/10e/91â?…/");
            put("10E/Might Weaver/278*", "https://api.scryfall.com/cards/10e/278â?…/");
            //put("10E/Mind Bend/93*", "https://api.scryfall.com/cards/10e/93â?…/"); // not implemented
            put("10E/Mirri, Cat Warrior/279*", "https://api.scryfall.com/cards/10e/279â?…/");
            put("10E/Mobilization/29*", "https://api.scryfall.com/cards/10e/29â?…/");
            put("10E/Molimo, Maro-Sorcerer/280*", "https://api.scryfall.com/cards/10e/280â?…/");
            put("10E/Mortivore/161*", "https://api.scryfall.com/cards/10e/161â?…/");
            put("10E/Nekrataal/163*", "https://api.scryfall.com/cards/10e/163â?…/");
            put("10E/Nightmare/164*", "https://api.scryfall.com/cards/10e/164â?…/");
            put("10E/Nomad Mythmaker/30*", "https://api.scryfall.com/cards/10e/30â?…/");
            put("10E/Ornithopter/336*", "https://api.scryfall.com/cards/10e/336â?…/");
            put("10E/Overgrowth/283*", "https://api.scryfall.com/cards/10e/283â?…/");
            put("10E/Overrun/284*", "https://api.scryfall.com/cards/10e/284â?…/");
            put("10E/Pacifism/31*", "https://api.scryfall.com/cards/10e/31â?…/");
            put("10E/Paladin en-Vec/32*", "https://api.scryfall.com/cards/10e/32â?…/");
            put("10E/Pariah/33*", "https://api.scryfall.com/cards/10e/33â?…/");
            put("10E/Persuasion/95*", "https://api.scryfall.com/cards/10e/95â?…/");
            put("10E/Pincher Beetles/285*", "https://api.scryfall.com/cards/10e/285â?…/");
            put("10E/Plague Beetle/168*", "https://api.scryfall.com/cards/10e/168â?…/");
            put("10E/Platinum Angel/339*", "https://api.scryfall.com/cards/10e/339â?…/");
            put("10E/Primal Rage/286*", "https://api.scryfall.com/cards/10e/286â?…/");
            put("10E/Rage Weaver/223*", "https://api.scryfall.com/cards/10e/223â?…/");
            put("10E/Raging Goblin/224*", "https://api.scryfall.com/cards/10e/224â?…/");
            put("10E/Razormane Masticore/340*", "https://api.scryfall.com/cards/10e/340â?…/");
            put("10E/Regeneration/290*", "https://api.scryfall.com/cards/10e/290â?…/");
            put("10E/Reya Dawnbringer/35*", "https://api.scryfall.com/cards/10e/35â?…/");
            put("10E/Rhox/291*", "https://api.scryfall.com/cards/10e/291â?…/");
            put("10E/Robe of Mirrors/101*", "https://api.scryfall.com/cards/10e/101â?…/");
            put("10E/Rock Badger/226*", "https://api.scryfall.com/cards/10e/226â?…/");
            put("10E/Rootwater Commando/102*", "https://api.scryfall.com/cards/10e/102â?…/");
            put("10E/Rushwood Dryad/294*", "https://api.scryfall.com/cards/10e/294â?…/");
            put("10E/Sage Owl/104*", "https://api.scryfall.com/cards/10e/104â?…/");
            put("10E/Scalpelexis/105*", "https://api.scryfall.com/cards/10e/105â?…/");
            put("10E/Sengir Vampire/176*", "https://api.scryfall.com/cards/10e/176â?…/");
            put("10E/Serra Angel/39*", "https://api.scryfall.com/cards/10e/39â?…/");
            put("10E/Serra's Embrace/40*", "https://api.scryfall.com/cards/10e/40â?…/");
            put("10E/Severed Legion/177*", "https://api.scryfall.com/cards/10e/177â?…/");
            put("10E/Shimmering Wings/107*", "https://api.scryfall.com/cards/10e/107â?…/");
            put("10E/Shivan Dragon/230*", "https://api.scryfall.com/cards/10e/230â?…/");
            put("10E/Shivan Hellkite/231*", "https://api.scryfall.com/cards/10e/231â?…/");
            put("10E/Sky Weaver/109*", "https://api.scryfall.com/cards/10e/109â?…/");
            put("10E/Skyhunter Patrol/41*", "https://api.scryfall.com/cards/10e/41â?…/");
            put("10E/Skyhunter Prowler/42*", "https://api.scryfall.com/cards/10e/42â?…/");
            put("10E/Skyhunter Skirmisher/43*", "https://api.scryfall.com/cards/10e/43â?…/");
            put("10E/Snapping Drake/110*", "https://api.scryfall.com/cards/10e/110â?…/");
            put("10E/Spark Elemental/237*", "https://api.scryfall.com/cards/10e/237â?…/");
            put("10E/Spawning Pool/358*", "https://api.scryfall.com/cards/10e/358â?…/");
            put("10E/Spiketail Hatchling/111*", "https://api.scryfall.com/cards/10e/111â?…/");
            put("10E/Spirit Link/45*", "https://api.scryfall.com/cards/10e/45â?…/");
            put("10E/Stampeding Wildebeests/300*", "https://api.scryfall.com/cards/10e/300â?…/");
            put("10E/Steadfast Guard/48*", "https://api.scryfall.com/cards/10e/48â?…/");
            put("10E/Suntail Hawk/50*", "https://api.scryfall.com/cards/10e/50â?…/");
            put("10E/Tangle Spider/303*", "https://api.scryfall.com/cards/10e/303â?…/");
            put("10E/The Hive/324*", "https://api.scryfall.com/cards/10e/324â?…/");
            put("10E/Thieving Magpie/115*", "https://api.scryfall.com/cards/10e/115â?…/");
            put("10E/Threaten/242*", "https://api.scryfall.com/cards/10e/242â?…/");
            put("10E/Thundering Giant/243*", "https://api.scryfall.com/cards/10e/243â?…/");
            put("10E/Time Stop/117*", "https://api.scryfall.com/cards/10e/117â?…/");
            put("10E/Treetop Bracers/304*", "https://api.scryfall.com/cards/10e/304â?…/");
            put("10E/Treetop Village/361*", "https://api.scryfall.com/cards/10e/361â?…/");
            put("10E/Troll Ascetic/305*", "https://api.scryfall.com/cards/10e/305â?…/");
            put("10E/True Believer/53*", "https://api.scryfall.com/cards/10e/53â?…/");
            put("10E/Tundra Wolves/54*", "https://api.scryfall.com/cards/10e/54â?…/");
            put("10E/Uncontrollable Anger/244*", "https://api.scryfall.com/cards/10e/244â?…/");
            put("10E/Unholy Strength/185*", "https://api.scryfall.com/cards/10e/185â?…/");
            put("10E/Upwelling/306*", "https://api.scryfall.com/cards/10e/306â?…/");
            put("10E/Vampire Bats/186*", "https://api.scryfall.com/cards/10e/186â?…/");
            put("10E/Viashino Sandscout/246*", "https://api.scryfall.com/cards/10e/246â?…/");
            put("10E/Voice of All/56*", "https://api.scryfall.com/cards/10e/56â?…/");
            put("10E/Wall of Air/124*", "https://api.scryfall.com/cards/10e/124â?…/");
            put("10E/Wall of Fire/247*", "https://api.scryfall.com/cards/10e/247â?…/");
            put("10E/Wall of Swords/57*", "https://api.scryfall.com/cards/10e/57â?…/");
            put("10E/Wall of Wood/309*", "https://api.scryfall.com/cards/10e/309â?…/");
            put("10E/Whispersilk Cloak/345*", "https://api.scryfall.com/cards/10e/345â?…/");
            put("10E/Wild Griffin/59*", "https://api.scryfall.com/cards/10e/59â?…/");
            put("10E/Windborn Muse/60*", "https://api.scryfall.com/cards/10e/60â?…/");
            put("10E/Youthful Knight/62*", "https://api.scryfall.com/cards/10e/62â?…/");
            // 4ED
            put("4ED/El-Hajjaj/134+", "https://api.scryfall.com/cards/4ed/134â€ /");
            // 5ED
            put("5ED/Game of Chaos/232+", "https://api.scryfall.com/cards/5ed/232â€ /");
            put("5ED/Inferno/243+", "https://api.scryfall.com/cards/5ed/243â€ /");
            put("5ED/Ironclaw Curse/244+", "https://api.scryfall.com/cards/5ed/244â€ /");
            put("5ED/Manabarbs/250+", "https://api.scryfall.com/cards/5ed/250â€ /");
            put("5ED/Shivan Dragon/267+", "https://api.scryfall.com/cards/5ed/267â€ /");
            // AER
            put("AER/Alley Strangler/52+", "https://api.scryfall.com/cards/aer/52â€ /");
            put("AER/Dawnfeather Eagle/14+", "https://api.scryfall.com/cards/aer/14â€ /");
            put("AER/Wrangle/101+", "https://api.scryfall.com/cards/aer/101â€ /");
            // ARN
            put("ARN/Army of Allah/2+", "https://api.scryfall.com/cards/arn/2â€ /");
            put("ARN/Bird Maiden/37+", "https://api.scryfall.com/cards/arn/37â€ /");
            put("ARN/Erg Raiders/25+", "https://api.scryfall.com/cards/arn/25â€ /");
            put("ARN/Fishliver Oil/13+", "https://api.scryfall.com/cards/arn/13â€ /");
            put("ARN/Giant Tortoise/15+", "https://api.scryfall.com/cards/arn/15â€ /");
            put("ARN/Hasran Ogress/27+", "https://api.scryfall.com/cards/arn/27â€ /");
            put("ARN/Moorish Cavalry/7+", "https://api.scryfall.com/cards/arn/7â€ /");
            put("ARN/Nafs Asp/52+", "https://api.scryfall.com/cards/arn/52â€ /");
            put("ARN/Oubliette/31+", "https://api.scryfall.com/cards/arn/31â€ /");
            put("ARN/Piety/8+", "https://api.scryfall.com/cards/arn/8â€ /");
            put("ARN/Rukh Egg/43+", "https://api.scryfall.com/cards/arn/43â€ /");
            put("ARN/Stone-Throwing Devils/33+", "https://api.scryfall.com/cards/arn/33â€ /");
            put("ARN/War Elephant/11+", "https://api.scryfall.com/cards/arn/11â€ /");
            put("ARN/Wyluli Wolf/55+", "https://api.scryfall.com/cards/arn/55â€ /");
            // ATQ
            put("ATQ/Tawnos's Weaponry/70+", "https://api.scryfall.com/cards/atq/70â€ /");
            // DD2
            put("DD2/Chandra Nalaar/34*", "https://api.scryfall.com/cards/dd2/34â?…/");
            put("DD2/Jace Beleren/1*", "https://api.scryfall.com/cards/dd2/1â?…/");
            // DKM
            put("DKM/Icy Manipulator/36*", "https://api.scryfall.com/cards/dkm/36â?…/");
            put("DKM/Incinerate/14*", "https://api.scryfall.com/cards/dkm/14â?…/");
            put("DKM/Icy Manipulator/36s", "https://api.scryfall.com/cards/dkm/36â?…/");
            put("DKM/Incinerate/14s", "https://api.scryfall.com/cards/dkm/14â?…/");
            // DRK
            put("DRK/Fountain of Youth/103+", "https://api.scryfall.com/cards/drk/103â€ /");
            put("DRK/Gaea's Touch/77+", "https://api.scryfall.com/cards/drk/77â€ /");
            put("DRK/Runesword/107+", "https://api.scryfall.com/cards/drk/107â€ /");
            // J14
            put("J14/Plains/1*", "https://api.scryfall.com/cards/j14/1â?…/");
            put("J14/Island/2*", "https://api.scryfall.com/cards/j14/2â?…/");
            put("J14/Swamp/3*", "https://api.scryfall.com/cards/j14/3â?…/");
            put("J14/Mountain/4*", "https://api.scryfall.com/cards/j14/4â?…/");
            put("J14/Forest/5*", "https://api.scryfall.com/cards/j14/5â?…/");
            // KLD
            put("KLD/Arborback Stomper/142+", "https://api.scryfall.com/cards/kld/142â€ /");
            put("KLD/Brazen Scourge/107+", "https://api.scryfall.com/cards/kld/107â€ /");
            put("KLD/Terrain Elemental/272+", "https://api.scryfall.com/cards/kld/272â€ /");
            put("KLD/Wind Drake/70+", "https://api.scryfall.com/cards/kld/70â€ /");
            // M20
            put("M20/Corpse Knight/206+", "https://api.scryfall.com/cards/m20/206â€ /");
            // MIR
            put("MIR/Reality Ripple/87+", "https://api.scryfall.com/cards/mir/87â€ /");
            // ODY
            put("ODY/Cephalid Looter/72+", "https://api.scryfall.com/cards/ody/72â€ /");
            put("ODY/Seafloor Debris/325+", "https://api.scryfall.com/cards/ody/325â€ /");
            // PAL99
            put("PAL99/Island/3+", "https://api.scryfall.com/cards/pal99/3â€ /");
            // PLS
            put("PLS/Ertai, the Corrupted/107*", "https://api.scryfall.com/cards/pls/107â?…/");
            put("PLS/Skyship Weatherlight/133*", "https://api.scryfall.com/cards/pls/133â?…/");
            put("PLS/Tahngarth, Talruum Hero/74*", "https://api.scryfall.com/cards/pls/74â?…/");
            // POR
            put("POR/Anaconda/158+", "https://api.scryfall.com/cards/por/158â€ /");
            put("POR/Blaze/118+", "https://api.scryfall.com/cards/por/118â€ /");
            put("POR/Elite Cat Warrior/163+", "https://api.scryfall.com/cards/por/163â€ /");
            put("POR/Hand of Death/96+", "https://api.scryfall.com/cards/por/96â€ /");
            put("POR/Monstrous Growth/173+", "https://api.scryfall.com/cards/por/173â€ /");
            put("POR/Raging Goblin/145+", "https://api.scryfall.com/cards/por/145â€ /");
            put("POR/Warrior's Charge/38+", "https://api.scryfall.com/cards/por/38â€ /");
            // PROE
            put("PROE/Emrakul, the Aeons Torn/*4", "https://api.scryfall.com/cards/proe/â?…4/");
            put("PROE/Lord of Shatterskull Pass/*156", "https://api.scryfall.com/cards/proe/â?…156/");
            //
            // PPRE
            put("PPRE/Beast of Burden/5+", "https://api.scryfall.com/cards/ppre/5â€ /");
            // PSOI
            put("PSOI/Tamiyo's Journal/265s+", "https://api.scryfall.com/cards/psoi/265sâ€ /");
            // PWAR
            put("PWAR/Ajani, the Greathearted/184s*", "https://api.scryfall.com/cards/pwar/184sâ?…/");
            put("PWAR/Angrath, Captain of Chaos/227s*", "https://api.scryfall.com/cards/pwar/227sâ?…/");
            put("PWAR/Arlinn, Voice of the Pack/150s*", "https://api.scryfall.com/cards/pwar/150sâ?…/");
            put("PWAR/Ashiok, Dream Render/228s*", "https://api.scryfall.com/cards/pwar/228sâ?…/");
            put("PWAR/Chandra, Fire Artisan/119s*", "https://api.scryfall.com/cards/pwar/119sâ?…/");
            put("PWAR/Davriel, Rogue Shadowmage/83s*", "https://api.scryfall.com/cards/pwar/83sâ?…/");
            put("PWAR/Domri, Anarch of Bolas/191s*", "https://api.scryfall.com/cards/pwar/191sâ?…/");
            put("PWAR/Dovin, Hand of Control/229s*", "https://api.scryfall.com/cards/pwar/229sâ?…/");
            put("PWAR/Gideon Blackblade/13s*", "https://api.scryfall.com/cards/pwar/13sâ?…/");
            put("PWAR/Huatli, the Sun's Heart/230s*", "https://api.scryfall.com/cards/pwar/230sâ?…/");
            put("PWAR/Jace, Wielder of Mysteries/54s*", "https://api.scryfall.com/cards/pwar/54sâ?…/");
            put("PWAR/Jaya, Venerated Firemage/135s*", "https://api.scryfall.com/cards/pwar/135sâ?…/");
            put("PWAR/Jiang Yanggu, Wildcrafter/164s*", "https://api.scryfall.com/cards/pwar/164sâ?…/");
            put("PWAR/Karn, the Great Creator/1s*", "https://api.scryfall.com/cards/pwar/1sâ?…/");
            put("PWAR/Kasmina, Enigmatic Mentor/56s*", "https://api.scryfall.com/cards/pwar/56sâ?…/");
            put("PWAR/Kaya, Bane of the Dead/231s*", "https://api.scryfall.com/cards/pwar/231sâ?…/");
            put("PWAR/Kiora, Behemoth Beckoner/232s*", "https://api.scryfall.com/cards/pwar/232sâ?…/");
            put("PWAR/Liliana, Dreadhorde General/97s*", "https://api.scryfall.com/cards/pwar/97sâ?…/");
            put("PWAR/Nahiri, Storm of Stone/233s*", "https://api.scryfall.com/cards/pwar/233sâ?…/");
            put("PWAR/Narset, Parter of Veils/61s*", "https://api.scryfall.com/cards/pwar/61sâ?…/");
            put("PWAR/Nicol Bolas, Dragon-God/207s*", "https://api.scryfall.com/cards/pwar/207sâ?…/");
            put("PWAR/Nissa, Who Shakes the World/169s*", "https://api.scryfall.com/cards/pwar/169sâ?…/");
            put("PWAR/Ob Nixilis, the Hate-Twisted/100s*", "https://api.scryfall.com/cards/pwar/100sâ?…/");
            put("PWAR/Ral, Storm Conduit/211s*", "https://api.scryfall.com/cards/pwar/211sâ?…/");
            put("PWAR/Saheeli, Sublime Artificer/234s*", "https://api.scryfall.com/cards/pwar/234sâ?…/");
            put("PWAR/Samut, Tyrant Smasher/235s*", "https://api.scryfall.com/cards/pwar/235sâ?…/");
            put("PWAR/Sarkhan the Masterless/143s*", "https://api.scryfall.com/cards/pwar/143sâ?…/");
            put("PWAR/Sorin, Vengeful Bloodlord/217s*", "https://api.scryfall.com/cards/pwar/217sâ?…/");
            put("PWAR/Tamiyo, Collector of Tales/220s*", "https://api.scryfall.com/cards/pwar/220sâ?…/");
            put("PWAR/Teferi, Time Raveler/221s*", "https://api.scryfall.com/cards/pwar/221sâ?…/");
            put("PWAR/Teyo, the Shieldmage/32s*", "https://api.scryfall.com/cards/pwar/32sâ?…/");
            put("PWAR/The Wanderer/37s*", "https://api.scryfall.com/cards/pwar/37sâ?…/");
            put("PWAR/Tibalt, Rakish Instigator/146s*", "https://api.scryfall.com/cards/pwar/146sâ?…/");
            put("PWAR/Ugin, the Ineffable/2s*", "https://api.scryfall.com/cards/pwar/2sâ?…/");
            put("PWAR/Vivien, Champion of the Wilds/180s*", "https://api.scryfall.com/cards/pwar/180sâ?…/");
            put("PWAR/Vraska, Swarm's Eminence/236s*", "https://api.scryfall.com/cards/pwar/236sâ?…/");
            // SHM
            put("SHM/Reflecting Pool/278*", "https://api.scryfall.com/cards/shm/278â?…/");
            // SOI
            put("SOI/Tamiyo's Journal/265+", "https://api.scryfall.com/cards/soi/265â€ /");
            put("SOI/Tamiyo's Journal/265+a", "https://api.scryfall.com/cards/soi/265â€ a/");
            put("SOI/Tamiyo's Journal/265+b", "https://api.scryfall.com/cards/soi/265â€ b/");
            put("SOI/Tamiyo's Journal/265+c", "https://api.scryfall.com/cards/soi/265â€ c/");
            put("SOI/Tamiyo's Journal/265+d", "https://api.scryfall.com/cards/soi/265â€ d/");
            // THB
            put("THB/Temple of Abandon/347*", "https://api.scryfall.com/cards/thb/347â?…/");
            // UNH
            put("UNH/Aesthetic Consultation/48*", "https://api.scryfall.com/cards/unh/48â?…/");
            put("UNH/AWOL/2*", "https://api.scryfall.com/cards/unh/2â?…/");
            put("UNH/Bad Ass/49*", "https://api.scryfall.com/cards/unh/49â?…/");
            put("UNH/Blast from the Past/72*", "https://api.scryfall.com/cards/unh/72â?…/");
            put("UNH/Cardpecker/4*", "https://api.scryfall.com/cards/unh/4â?…/");
            put("UNH/Emcee/9*", "https://api.scryfall.com/cards/unh/9â?…/");
            put("UNH/Farewell to Arms/56*", "https://api.scryfall.com/cards/unh/56â?…/");
            put("UNH/Frazzled Editor/77*", "https://api.scryfall.com/cards/unh/77â?…/");
            put("UNH/Gleemax/121*", "https://api.scryfall.com/cards/unh/121â?…/");
            put("UNH/Goblin Mime/78*", "https://api.scryfall.com/cards/unh/78â?…/");
            put("UNH/Greater Morphling/34*", "https://api.scryfall.com/cards/unh/34â?…/");
            put("UNH/Keeper of the Sacred Word/101*", "https://api.scryfall.com/cards/unh/101â?…/");
            put("UNH/Laughing Hyena/103*", "https://api.scryfall.com/cards/unh/103â?…/");
            put("UNH/Letter Bomb/122*", "https://api.scryfall.com/cards/unh/122â?…/");
            put("UNH/Mana Screw/123*", "https://api.scryfall.com/cards/unh/123â?…/");
            put("UNH/Monkey Monkey Monkey/104*", "https://api.scryfall.com/cards/unh/104â?…/");
            put("UNH/Mons's Goblin Waiters/82*", "https://api.scryfall.com/cards/unh/82â?…/");
            put("UNH/Mox Lotus/124*", "https://api.scryfall.com/cards/unh/124â?…/");
            put("UNH/My First Tome/125*", "https://api.scryfall.com/cards/unh/125â?…/");
            put("UNH/Old Fogey/106*", "https://api.scryfall.com/cards/unh/106â?…/");
            put("UNH/Question Elemental?/43*", "https://api.scryfall.com/cards/unh/43â?…/");
            put("UNH/Richard Garfield, Ph.D./44*", "https://api.scryfall.com/cards/unh/44â?…/");
            put("UNH/Shoe Tree/109*", "https://api.scryfall.com/cards/unh/109â?…/");
            put("UNH/Standing Army/20*", "https://api.scryfall.com/cards/unh/20â?…/");
            put("UNH/Time Machine/128*", "https://api.scryfall.com/cards/unh/128â?…/");
            put("UNH/Touch and Go/90*", "https://api.scryfall.com/cards/unh/90â?…/");
            put("UNH/When Fluffy Bunnies Attack/67*", "https://api.scryfall.com/cards/unh/67â?…/");
            // WAR
            put("WAR/Ajani, the Greathearted/184*", "https://api.scryfall.com/cards/war/184â?…/");
            put("WAR/Angrath, Captain of Chaos/227*", "https://api.scryfall.com/cards/war/227â?…/");
            put("WAR/Arlinn, Voice of the Pack/150*", "https://api.scryfall.com/cards/war/150â?…/");
            put("WAR/Ashiok, Dream Render/228*", "https://api.scryfall.com/cards/war/228â?…/");
            put("WAR/Chandra, Fire Artisan/119*", "https://api.scryfall.com/cards/war/119â?…/");
            put("WAR/Davriel, Rogue Shadowmage/83*", "https://api.scryfall.com/cards/war/83â?…/");
            put("WAR/Domri, Anarch of Bolas/191*", "https://api.scryfall.com/cards/war/191â?…/");
            put("WAR/Dovin, Hand of Control/229*", "https://api.scryfall.com/cards/war/229â?…/");
            put("WAR/Gideon Blackblade/13*", "https://api.scryfall.com/cards/war/13â?…/");
            put("WAR/Huatli, the Sun's Heart/230*", "https://api.scryfall.com/cards/war/230â?…/");
            put("WAR/Jace, Wielder of Mysteries/54*", "https://api.scryfall.com/cards/war/54â?…/");
            put("WAR/Jaya, Venerated Firemage/135*", "https://api.scryfall.com/cards/war/135â?…/");
            put("WAR/Jiang Yanggu, Wildcrafter/164*", "https://api.scryfall.com/cards/war/164â?…/");
            put("WAR/Karn, the Great Creator/1*", "https://api.scryfall.com/cards/war/1â?…/");
            put("WAR/Kasmina, Enigmatic Mentor/56*", "https://api.scryfall.com/cards/war/56â?…/");
            put("WAR/Kaya, Bane of the Dead/231*", "https://api.scryfall.com/cards/war/231â?…/");
            put("WAR/Kiora, Behemoth Beckoner/232*", "https://api.scryfall.com/cards/war/232â?…/");
            put("WAR/Liliana, Dreadhorde General/97*", "https://api.scryfall.com/cards/war/97â?…/");
            put("WAR/Nahiri, Storm of Stone/233*", "https://api.scryfall.com/cards/war/233â?…/");
            put("WAR/Narset, Parter of Veils/61*", "https://api.scryfall.com/cards/war/61â?…/");
            put("WAR/Nicol Bolas, Dragon-God/207*", "https://api.scryfall.com/cards/war/207â?…/");
            put("WAR/Nissa, Who Shakes the World/169*", "https://api.scryfall.com/cards/war/169â?…/");
            put("WAR/Ob Nixilis, the Hate-Twisted/100*", "https://api.scryfall.com/cards/war/100â?…/");
            put("WAR/Ral, Storm Conduit/211*", "https://api.scryfall.com/cards/war/211â?…/");
            put("WAR/Saheeli, Sublime Artificer/234*", "https://api.scryfall.com/cards/war/234â?…/");
            put("WAR/Samut, Tyrant Smasher/235*", "https://api.scryfall.com/cards/war/235â?…/");
            put("WAR/Sarkhan the Masterless/143*", "https://api.scryfall.com/cards/war/143â?…/");
            put("WAR/Sorin, Vengeful Bloodlord/217*", "https://api.scryfall.com/cards/war/217â?…/");
            put("WAR/Tamiyo, Collector of Tales/220*", "https://api.scryfall.com/cards/war/220â?…/");
            put("WAR/Teferi, Time Raveler/221*", "https://api.scryfall.com/cards/war/221â?…/");
            put("WAR/Teyo, the Shieldmage/32*", "https://api.scryfall.com/cards/war/32â?…/");
            put("WAR/The Wanderer/37*", "https://api.scryfall.com/cards/war/37â?…/");
            put("WAR/Tibalt, Rakish Instigator/146*", "https://api.scryfall.com/cards/war/146â?…/");
            put("WAR/Ugin, the Ineffable/2*", "https://api.scryfall.com/cards/war/2â?…/");
            put("WAR/Vivien, Champion of the Wilds/180*", "https://api.scryfall.com/cards/war/180â?…/");
            put("WAR/Vraska, Swarm's Eminence/236*", "https://api.scryfall.com/cards/war/236â?…/");
        }
    };

    public static String findScryfallSetCode(String xmageCode) {
        return xmageSetsToScryfall.getOrDefault(xmageCode, xmageCode).toLowerCase(Locale.ENGLISH);
    }

    public static Set<String> getSupportedSets() {
        return supportedSets;
    }

    public static String findDirectDownloadKey(String setCode, String cardName, String cardNumber) {
        // set/card/number
        String linkCode1 = setCode + "/" + cardName + "/" + cardNumber;
        if (directDownloadLinks.containsKey(linkCode1)) {
            return linkCode1;
        }

        // set/card
        String linkCode2 = setCode + "/" + cardName;
        if (directDownloadLinks.containsKey(linkCode2)) {
            return linkCode2;
        }

        // default
        return null;
    }

    public static String findDirectDownloadLink(String setCode, String cardName, String cardNumber) {
        String key = findDirectDownloadKey(setCode, cardName, cardNumber);
        return directDownloadLinks.get(key);
    }

    public static String extractSetCodeFromDirectKey(String key) {
        // from: 8EB/Giant Octopus
        // to: 8EB
        Matcher matcher = REGEXP_DIRECT_KEY_SET_CODE_PATTERN.matcher(key);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }

    public static String extractCardNameFromDirectKey(String key) {
        // from: 8EB/Giant Octopus/
        // to: Giant Octopus
        Matcher matcher = REGEXP_DIRECT_KEY_CARD_NAME_PATTERN.matcher(key + "/"); // add / for regexp workaround
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }

    public static Map<String, String> getDirectDownloadLinks() {
        return directDownloadLinks;
    }
}
