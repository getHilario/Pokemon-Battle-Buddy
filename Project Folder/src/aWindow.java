/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hilario
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class aWindow extends JFrame {

    public static final int WIDTH = 710;
    public static final int HEIGHT = 560;
    public static final double HIND_CONST = 0.9;
    public static final double NEUTRAL_CONST = 1;
    public static final double BENEF_CONST = 1.1;
    public static final int NUM_OF_POKES = 9; //borrowed constant for array from pokedex

    private String[] PKMNS = new String[NUM_OF_POKES]; //''
    private String[] PSTATS = new String[NUM_OF_POKES * 6]; //''
    private JPanel atkStatPanel;
    private JButton atkStatButton;
    private JButton defStatButton;
    private JComboBox atkPkmnCB = new JComboBox();
    private JComboBox defPkmnCB = new JComboBox();
    private JComboBox srDamageCB = new JComboBox();
    private JComboBox spikesDamageCB = new JComboBox();
    private JLabel hpStatLabel;
    private JLabel atkStatLabel;
    private JLabel defStatLabel;
    private JLabel spAtkStatLabel;
    private JLabel spDefStatLabel;
    private JLabel ivEvLabel;
    private JPanel atkIvEvPanel;
    private JTextField atkIvTextField;
    private JTextField atkEvTextField;
    private JPanel spAtkIvEvPanel;
    private JTextField spAtkIvTextField;
    private JTextField spAtkEvTextField;
    private JPanel hpIvEvPanel;
    private JTextField hpIvTextField;
    private JTextField hpEvTextField;
    private JPanel defIvEvPanel;
    private JTextField defIvTextField;
    private JTextField defEvTextField;
    private JPanel spDefIvEvPanel;
    private JTextField spDefIvTextField;
    private JTextField spDefEvTextField;
    private int hpStat, atkStat, defStat, spAtkStat, spDefStat, speedStat;
    private JPanel natureBtnPanel;
    private int nature = 1;
    private JPanel natureBtnPanel2;
    private int nature2 = 1;
    private final JPanel sRockPanel;
    private final JLabel srLabel;
    private double srDmgPercent = 0;
    private final JPanel spikesPanel;
    private final JLabel spikesLabel;
    private double spikesDmgPercent = 0;
    private final JPanel atkOptionPanel;
    private final JPanel atkMovePanel;
    private final JLabel atkMoveLabel;
    private final JTextField atkPowerTextField;
    private final JPanel atkTypeRBtnPanel;
    private int atkType = 0;
    private final JPanel effectivePanel;
    private final JLabel effectiveLabel;
    private JComboBox effectiveCB = new JComboBox();
    private double effMul = 0;
    private final JPanel modsPanel;
    private JComboBox atkStatModCB = new JComboBox();
    private double atkMod = 1, defMod = 1, stab = 1, refl = 1, lscreen = 1,
            wheth = 1, sanDef = 1, burn = 1, hp = 0, atk = 0, def = 0, spAtk = 0,
            spDef = 0, minDamage, maxDamage;
    private JComboBox defStatModCB = new JComboBox();
    private final JLabel atkModLabel;
    private final JLabel defModLabel;
    private final JLabel atkItemLabel;
    private JComboBox atkItemCB = new JComboBox();
    double itemAtkStat = 1, itemAtkDmg = 1, itemSpAtkStat = 1, itemSpAtkDmg = 1,
            itemDefStat = 1, itemSpDefStat = 1;
    private final JLabel defItemLabel;
    private JComboBox defItemCB = new JComboBox();
    private final JPanel checkBoxPanel;
    private final JCheckBox stabChBox;
    private final JCheckBox reflectChBox;
    private final JCheckBox lightScreenChBox;
    private final JCheckBox rainSunChBox;
    private final JCheckBox sandDefChBox;
    private int stabTrack = 0, reflectTrack = 0, lsTrack = 0, whethTrack = 0,
            sanDefTrack = 0, burnTrack = 0;
    private final JPanel resultsPanel;
    private final JLabel minHpBarLabel;
    private final JLabel maxHpBarLabel;
    private final JCheckBox burnChBox;
    private final JPanel atkTFPanel;
    private final JLabel atkTFLabel;
    private final JTextField atkTF;
    private final JLabel spAtkTFLabel;
    private final JTextField spAtkTF;
    private final JPanel defTFPanel;
    private final JLabel defTFLabel;
    private final JTextField defTF;
    private final JLabel spDefTFLabel;
    private final JTextField spDefTF;
    private final JPanel southTopMidPanel;
    private final JLabel hpTFLabel;
    private final JTextField hpTF;
    private final JPanel minBarPanel;
    private final JPanel maxBarPanel;
    private final JLabel minDamageLabel;
    private final JLabel maxDamageLabel;
    private final JLabel maxHpBar;
    private final JLabel minHpBar;

    
    private Icon icon0 = new ImageIcon("0.jpg");
    private Icon icon1 = new ImageIcon("1.jpg");
    private Icon icon2 = new ImageIcon("2.jpg");
    private Icon icon3 = new ImageIcon("3.jpg");
    private Icon icon4 = new ImageIcon("4.jpg");
    private Icon icon5 = new ImageIcon("5.jpg");
    private Icon icon6 = new ImageIcon("6.jpg");
    private Icon icon7 = new ImageIcon("7.jpg");
    private Icon icon8 = new ImageIcon("8.jpg");
    private Icon icon9 = new ImageIcon("9.jpg");
    private Icon icon10 = new ImageIcon("10.jpg");
    private Icon icon11 = new ImageIcon("11.jpg");
    private Icon icon12 = new ImageIcon("12.jpg");
    private Icon icon13 = new ImageIcon("13.jpg");
    private Icon icon14 = new ImageIcon("14.jpg");
    private Icon icon15 = new ImageIcon("15.jpg");
    private Icon icon16 = new ImageIcon("16.jpg");
    private Icon icon17 = new ImageIcon("17.jpg");
    private Icon icon18 = new ImageIcon("18.jpg");
    private Icon icon19 = new ImageIcon("19.jpg");
    private Icon icon20 = new ImageIcon("20.jpg");
    private Icon icon21 = new ImageIcon("21.jpg");
    private Icon icon22 = new ImageIcon("22.jpg");
    private Icon icon23 = new ImageIcon("23.jpg");
    private Icon icon24 = new ImageIcon("24.jpg");
    private Icon icon25 = new ImageIcon("25.jpg");
    private Icon icon26 = new ImageIcon("26.jpg");
    private Icon icon27 = new ImageIcon("27.jpg");
    private Icon icon28 = new ImageIcon("28.jpg");
    private Icon icon29 = new ImageIcon("29.jpg");
    private Icon icon30 = new ImageIcon("30.jpg");
    private Icon icon31 = new ImageIcon("31.jpg");
    private Icon icon32 = new ImageIcon("32.jpg");
    private Icon icon33 = new ImageIcon("33.jpg");
    private Icon icon34 = new ImageIcon("34.jpg");
    private Icon icon35 = new ImageIcon("35.jpg");
    private Icon icon36 = new ImageIcon("36.jpg");
    private Icon icon37 = new ImageIcon("37.jpg");
    private Icon icon38 = new ImageIcon("38.jpg");
    private Icon icon39 = new ImageIcon("39.jpg");
    private Icon icon40 = new ImageIcon("40.jpg");
    private Icon icon41 = new ImageIcon("41.jpg");
    private Icon icon42 = new ImageIcon("42.jpg");
    private Icon icon43 = new ImageIcon("43.jpg");
    private Icon icon44 = new ImageIcon("44.jpg");
    private Icon icon45 = new ImageIcon("45.jpg");
    private Icon icon46 = new ImageIcon("46.jpg");
    private Icon icon47 = new ImageIcon("47.jpg");
    private Icon icon48 = new ImageIcon("48.jpg");
    private Icon icon49 = new ImageIcon("49.jpg");
    private Icon icon50 = new ImageIcon("50.jpg");
    private Icon icon51 = new ImageIcon("51.jpg");
    private Icon icon52 = new ImageIcon("52.jpg");
    private Icon icon53 = new ImageIcon("53.jpg");
    private Icon icon54 = new ImageIcon("54.jpg");
    private Icon icon55 = new ImageIcon("55.jpg");
    private Icon icon56 = new ImageIcon("56.jpg");
    private Icon icon57 = new ImageIcon("57.jpg");
    private Icon icon58 = new ImageIcon("58.jpg");
    private Icon icon59 = new ImageIcon("59.jpg");
    private Icon icon60 = new ImageIcon("60.jpg");
    private Icon icon61 = new ImageIcon("61.jpg");
    private Icon icon62 = new ImageIcon("62.jpg");
    private Icon icon63 = new ImageIcon("63.jpg");
    private Icon icon64 = new ImageIcon("64.jpg");
    private Icon icon65 = new ImageIcon("65.jpg");
    private Icon icon66 = new ImageIcon("66.jpg");
    private Icon icon67 = new ImageIcon("67.jpg");
    private Icon icon68 = new ImageIcon("68.jpg");
    private Icon icon69 = new ImageIcon("69.jpg");
    private Icon icon70 = new ImageIcon("70.jpg");
    private Icon icon71 = new ImageIcon("71.jpg");
    private Icon icon72 = new ImageIcon("72.jpg");
    private Icon icon73 = new ImageIcon("73.jpg");
    private Icon icon74 = new ImageIcon("74.jpg");
    private Icon icon75 = new ImageIcon("75.jpg");
    private Icon icon76 = new ImageIcon("76.jpg");
    private Icon icon77 = new ImageIcon("77.jpg");
    private Icon icon78 = new ImageIcon("78.jpg");
    private Icon icon79 = new ImageIcon("79.jpg");
    private Icon icon80 = new ImageIcon("80.jpg");
    private Icon icon81 = new ImageIcon("81.jpg");
    private Icon icon82 = new ImageIcon("82.jpg");
    private Icon icon83 = new ImageIcon("83.jpg");
    private Icon icon84 = new ImageIcon("84.jpg");
    private Icon icon85 = new ImageIcon("85.jpg");
    private Icon icon86 = new ImageIcon("86.jpg");
    private Icon icon87 = new ImageIcon("87.jpg");
    private Icon icon88 = new ImageIcon("88.jpg");
    private Icon icon89 = new ImageIcon("89.jpg");
    private Icon icon90 = new ImageIcon("90.jpg");
    private Icon icon91 = new ImageIcon("91.jpg");
    private Icon icon92 = new ImageIcon("92.jpg");
    private Icon icon93 = new ImageIcon("93.jpg");
    private Icon icon94 = new ImageIcon("94.jpg");
    private Icon icon95 = new ImageIcon("95.jpg");
    private Icon icon96 = new ImageIcon("96.jpg");
    private Icon icon97 = new ImageIcon("97.jpg");
    private Icon icon98 = new ImageIcon("98.jpg");
    private Icon icon99 = new ImageIcon("99.jpg");
    private Icon icon100 = new ImageIcon("100.jpg");




    public aWindow() throws FileNotFoundException {

        super("Pkmn Battle Buddy");
        Scanner pkmns = null, pStats = null;
        int hpIvs = 2, hpEvs = 3, atkIvs = 2, atkEvs = 3, defIvs = 2,
                defEvs = 3, spAtkIvs = 2, spAtkEvs = 3, spDefIvs = 2, spDefEvs = 3;



        final NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setGroupingUsed(false);
        nf.setMaximumFractionDigits(0);
        nf.setMinimumFractionDigits(0);

        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JButton northButton = new JButton("North");
        add(northButton, BorderLayout.NORTH);

        JPanel atkPkmnPanel = new JPanel();
        atkPkmnPanel.setLayout(new GridLayout(4, 2));
        Border pkmnBorder = BorderFactory.createLineBorder(Color.black);
        atkPkmnPanel.setBorder(pkmnBorder);

        try {
            pkmns = new Scanner(new FileInputStream("pkmns.txt"));
            pStats = new Scanner(new FileInputStream("pkmnStats.txt"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "File Not Found", 0);
            System.exit(0);
        }



        for (int i = 0; i < NUM_OF_POKES; i++) {
            PKMNS[i] = pkmns.nextLine();
        }
        for (int i = 0; i < NUM_OF_POKES * 6; i++) {
            PSTATS[i] = pStats.nextLine();
        }

//for loop for comboBox inspired by pokedex
        for (int i = 0; i < NUM_OF_POKES; i++) {
            atkPkmnCB.addItem(PKMNS[i]);
        }
        atkPkmnCB.setEditable(false);
        atkPkmnCB.setMaximumRowCount(5);
        atkPkmnPanel.add(atkPkmnCB);
        atkPkmnCB.addActionListener(new ActionListener() {
//this loop goes through pkmnStats.txt file and assigns 6 stats according to pokemon selected
//at this point in the program only atk and spAtk values are used

            public void actionPerformed(ActionEvent e) {
                int pkmnNum = atkPkmnCB.getSelectedIndex();
                String hp = PSTATS[pkmnNum * 6];
                String atk = PSTATS[pkmnNum * 6 + 1];
                String def = PSTATS[pkmnNum * 6 + 2];
                String spAtk = PSTATS[pkmnNum * 6 + 3];
                String spDef = PSTATS[pkmnNum * 6 + 4];
                String speed = PSTATS[pkmnNum * 6 + 5];
                hpStat = Integer.parseInt(hp);
                atkStat = Integer.parseInt(atk);
                defStat = Integer.parseInt(def);
                spAtkStat = Integer.parseInt(spAtk);
                spDefStat = Integer.parseInt(spDef);
                speedStat = Integer.parseInt(speed);

                atkStatLabel.setText("Atk Stat: " + (atkStat * 2 + 5));
                spAtkStatLabel.setText("SP.Atk Stat: " + (spAtkStat * 2 + 5));
            }
        });
//IV's and EV's are values that increase a pokemon's total stat
// for every iv stat increases by 1 for every ev stat increases by 1/4
        ivEvLabel = new JLabel("  IVs/EVs ");
        atkPkmnPanel.add(ivEvLabel);
        atkStatLabel = new JLabel("Atk Stat: ");
        atkPkmnPanel.add(atkStatLabel);

        atkIvEvPanel = new JPanel();
        atkIvEvPanel.setLayout(new GridLayout(1, 2));
        atkIvTextField = new JTextField(atkIvs);
        atkIvEvPanel.add(atkIvTextField);
        atkEvTextField = new JTextField(atkEvs);
        atkIvEvPanel.add(atkEvTextField);

        atkPkmnPanel.add(atkIvEvPanel);

        spAtkStatLabel = new JLabel("Sp.Atk Stat: ");
        atkPkmnPanel.add(spAtkStatLabel);

        spAtkIvEvPanel = new JPanel();
        spAtkIvEvPanel.setLayout(new GridLayout(1, 2));
        spAtkIvTextField = new JTextField(spAtkIvs);
        spAtkIvEvPanel.add(spAtkIvTextField);
        spAtkEvTextField = new JTextField(spAtkEvs);
        spAtkIvEvPanel.add(spAtkEvTextField);

        atkPkmnPanel.add(spAtkIvEvPanel);


        atkStatButton = new JButton("Input Ivs/Evs");
        atkStatButton.addActionListener(new ActionListener() {

            private Component errorFrame;

            public void actionPerformed(ActionEvent e) {
                int atkIvNum = 0, spAtkIvNum = 0, atkEvNum = 0, spAtkEvNum = 0, totalAtk, totalSpAtk;
                try {
                    atkIvNum = Integer.parseInt(atkIvTextField.getText());
                    //if ((atkIvNum < 0 || atkIvNum > 31))
                  //      throw new BadNumberException(atkIvNum);
                }
                 /*catch (BadNumberException ex){
                    JOptionPane.showMessageDialog(null, "Error: Please re-enter"
                            + " an integer value between 0 and 31 fore Atk IVs" , ""+e.getBadNumber(), JOptionPane.ERROR_MESSAGE);
                    return;
                }
                  
                  */

                catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: Please re-enter"
                            + " an integer value for Atk IVs", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    spAtkIvNum = Integer.parseInt(spAtkIvTextField.getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: Please re-enter"
                            + " an integer value for Sp.Atk IVs", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    atkEvNum = Integer.parseInt(atkEvTextField.getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: Please re-enter"
                            + " an integer value for Atk EVs", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    spAtkEvNum = Integer.parseInt(spAtkEvTextField.getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: Please re-enter"
                            + " an integer value for Sp.Atk EVs", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
//calculation once data is set
                totalAtk = (atkEvNum / 4) + (atkStat * 2 + 5) + atkIvNum;
                totalSpAtk = (spAtkEvNum / 4) + (spAtkStat * 2 + 5) + spAtkIvNum;

                switch (nature) {
                    case 0:
                        atkStatLabel.setText("Atk Stat: " + nf.format(totalAtk * HIND_CONST));
                        spAtkStatLabel.setText("SP.Atk Stat: " + nf.format(totalSpAtk * HIND_CONST));
                        atk = totalAtk * HIND_CONST;
                        spAtk = totalSpAtk * HIND_CONST;
                        break;
                    case 1:
                        atkStatLabel.setText("Atk Stat: " + nf.format(totalAtk));
                        spAtkStatLabel.setText("SP.Atk Stat: " + nf.format(totalSpAtk));
                        atk = totalAtk;
                        spAtk = totalSpAtk;
                        break;
                    case 2:
                        atkStatLabel.setText("Atk Stat: " + nf.format(totalAtk * BENEF_CONST));
                        spAtkStatLabel.setText("SP.Atk Stat: " + nf.format(totalSpAtk * BENEF_CONST));
                        atk = totalAtk * BENEF_CONST;
                        spAtk = totalSpAtk * BENEF_CONST;
                        break;
                    default:
                        atkStatLabel.setText("Atk Stat: " + nf.format(totalAtk));
                        spAtkStatLabel.setText("SP.Atk Stat: " + nf.format(totalSpAtk));
                        atk = totalAtk;
                        spAtk = totalSpAtk;
                        break;
                }
            }
        });


        atkPkmnPanel.add(atkStatButton);


//nature radio buttons here to determine total stat multiplier
//hindering(x0.9) neutral(x1) beneficial(x1.1)
        natureBtnPanel = new JPanel(new GridLayout(3, 1));
        ButtonGroup natureGroup = new ButtonGroup();
        JRadioButton hinderBtn;
        hinderBtn = new JRadioButton("Hindering");
        hinderBtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int theNature = 0;
                nature = theNature;
            }
        });
        natureGroup.add(hinderBtn);
        natureBtnPanel.add(hinderBtn);
        JRadioButton neutralBtn;
        neutralBtn = new JRadioButton("Neutral");
        neutralBtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int theNature = 1;
                nature = theNature;
            }
        });
        natureGroup.add(neutralBtn);
        natureBtnPanel.add(neutralBtn);
        JRadioButton beneficialBtn;
        beneficialBtn = new JRadioButton("Beneficial");
        beneficialBtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int theNature = 2;
                nature = theNature;
            }
        });
        natureGroup.add(beneficialBtn);
        natureBtnPanel.add(beneficialBtn);
        neutralBtn.setSelected(true);

        atkPkmnPanel.add(natureBtnPanel);

        add(atkPkmnPanel, BorderLayout.WEST);

//defending pokemon similar to what is in West Panel here, will use def,spDef,hp stats
        JPanel defPkmnPanel = new JPanel();
        defPkmnPanel.setLayout(new GridLayout(6, 2));
        defPkmnPanel.setBorder(pkmnBorder);

        try {
            pkmns = new Scanner(new FileInputStream("pkmns.txt"));
            pStats = new Scanner(new FileInputStream("pkmnStats.txt"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "File Not Found", 0);
            System.exit(0);
        }

//for loop for comboBox inspired by pokedex
        for (int i = 0; i < NUM_OF_POKES; i++) {
            defPkmnCB.addItem(PKMNS[i]);
        }
        defPkmnCB.setEditable(false);
        defPkmnCB.setMaximumRowCount(5);
        defPkmnPanel.add(defPkmnCB);
        defPkmnCB.addActionListener(new ActionListener() {
//same as atkPkmnCB
//at this point the hp, def and Sp def values are now being used

            public void actionPerformed(ActionEvent e) {
                int pkmnNum = defPkmnCB.getSelectedIndex();
                String hp = PSTATS[pkmnNum * 6];
                String atk = PSTATS[pkmnNum * 6 + 1];
                String def = PSTATS[pkmnNum * 6 + 2];
                String spAtk = PSTATS[pkmnNum * 6 + 3];
                String spDef = PSTATS[pkmnNum * 6 + 4];
                String speed = PSTATS[pkmnNum * 6 + 5];
                hpStat = Integer.parseInt(hp);
                atkStat = Integer.parseInt(atk);
                defStat = Integer.parseInt(def);
                spAtkStat = Integer.parseInt(spAtk);
                spDefStat = Integer.parseInt(spDef);
                speedStat = Integer.parseInt(speed);

                hpStatLabel.setText("HP Stat: " + ((((hpStat * 2 + 100) * 100) / 100) + 10));
                defStatLabel.setText("Def Stat: " + (defStat * 2 + 5));
                spDefStatLabel.setText("SP.Def Stat: " + (spDefStat * 2 + 5));
            }
        });
//IV's and EV's are values that increase a pokemon's total stat
// for every iv stat increases by 1 for every ev stat increases by 1/4
        ivEvLabel = new JLabel("  IVs/EVs ");
        defPkmnPanel.add(ivEvLabel);

        hpStatLabel = new JLabel("HP Stat: ");
        defPkmnPanel.add(hpStatLabel);

        hpIvEvPanel = new JPanel();
        hpIvEvPanel.setLayout(new GridLayout(1, 2));
        hpIvTextField = new JTextField(hpIvs);
        hpIvEvPanel.add(hpIvTextField);
        hpEvTextField = new JTextField(hpEvs);
        hpIvEvPanel.add(hpEvTextField);

        defPkmnPanel.add(hpIvEvPanel);

        defStatLabel = new JLabel("Def Stat: ");
        defPkmnPanel.add(defStatLabel);

        defIvEvPanel = new JPanel();
        defIvEvPanel.setLayout(new GridLayout(1, 2));
        defIvTextField = new JTextField(defIvs);
        defIvEvPanel.add(defIvTextField);
        defEvTextField = new JTextField(defEvs);
        defIvEvPanel.add(defEvTextField);

        defPkmnPanel.add(defIvEvPanel);

        spDefStatLabel = new JLabel("Sp.Def Stat: ");
        defPkmnPanel.add(spDefStatLabel);

        spDefIvEvPanel = new JPanel();
        spDefIvEvPanel.setLayout(new GridLayout(1, 2));
        spDefIvTextField = new JTextField(spDefIvs);
        spDefIvEvPanel.add(spDefIvTextField);
        spDefEvTextField = new JTextField(spDefEvs);
        spDefIvEvPanel.add(spDefEvTextField);

        defPkmnPanel.add(spDefIvEvPanel);

//Stealth rock damage panel
        sRockPanel = new JPanel(new GridLayout(2, 1));

        srLabel = new JLabel("Stealth Rock:");
        sRockPanel.add(srLabel);
        srDamageCB.addItem("None");
        srDamageCB.addItem("0.25x (1/32)");
        srDamageCB.addItem("0.5x  (1/16)");
        srDamageCB.addItem("1x    (1/8)");
        srDamageCB.addItem("2x    (1/4)");
        srDamageCB.addItem("4x    (1/2)");
        srDamageCB.setEditable(false);
        srDamageCB.setMaximumRowCount(5);
        sRockPanel.add(srDamageCB);
        srDamageCB.addActionListener(new ActionListener() {

//setting SR damage

            public void actionPerformed(ActionEvent e) {
                int srNum = srDamageCB.getSelectedIndex();
                switch (srNum) {
                    case 0:
                        srDmgPercent = 0;
                        break;
                    case 1:
                        srDmgPercent = 0.03135;
                        break;
                    case 2:
                        srDmgPercent = 0.0625;
                        break;
                    case 3:
                        srDmgPercent = 0.125;
                        break;
                    case 4:
                        srDmgPercent = 0.25;
                        break;
                    case 5:
                        srDmgPercent = 0.50;
                        break;
                    default:
                        System.exit(0);
                        break;
                }

            }
        });

        defPkmnPanel.add(sRockPanel);

//spikes damage panel
        spikesPanel = new JPanel(new GridLayout(2, 1));

        spikesLabel = new JLabel("Spikes:");
        spikesPanel.add(spikesLabel);
        spikesDamageCB.addItem("None");
        spikesDamageCB.addItem("1x (1/8)");
        spikesDamageCB.addItem("2x  (1/5.333)");
        spikesDamageCB.addItem("3x    (1/4)");
        spikesDamageCB.setEditable(false);
        spikesDamageCB.setMaximumRowCount(5);
        spikesPanel.add(spikesDamageCB);
        spikesDamageCB.addActionListener(new ActionListener() {

//setting amount of damage spikes will do

            public void actionPerformed(ActionEvent e) {
                int srNum = spikesDamageCB.getSelectedIndex();
                switch (srNum) {
                    case 0:
                        spikesDmgPercent = 0;
                        break;
                    case 1:
                        spikesDmgPercent = 0.125;
                        break;
                    case 2:
                        spikesDmgPercent = 0.1875;
                        break;
                    case 3:
                        spikesDmgPercent = 0.25;
                        break;
                    default:
                        System.exit(0);
                        break;
                }

            }
        });

        defPkmnPanel.add(spikesPanel);


        defStatButton = new JButton("Input Ivs/Evs");
        defStatButton.addActionListener(new ActionListener() {

            private Component errorFrame;

            public void actionPerformed(ActionEvent e) {
                int hpIvNum = 0, hpEvNum = 0, defIvNum = 0, spDefIvNum = 0,
                        defEvNum = 0, spDefEvNum = 0;
                double totalHp, totalDef, totalSpDef;
                try {
                    hpIvNum = Integer.parseInt(hpIvTextField.getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: Please re-enter"
                            + " an integer value for HP IVs", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    hpEvNum = Integer.parseInt(hpEvTextField.getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: Please re-enter"
                            + " an integer value for HP EVs", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    defIvNum = Integer.parseInt(defIvTextField.getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: Please re-enter"
                            + " an integer value for Def IVs", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    spDefIvNum = Integer.parseInt(spDefIvTextField.getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: Please re-enter"
                            + " an integer value for Sp.Def IVs", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    defEvNum = Integer.parseInt(defEvTextField.getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: Please re-enter"
                            + " an integer value for Def EVs", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    spDefEvNum = Integer.parseInt(spDefEvTextField.getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: Please re-enter"
                            + " an integer value for Sp.Def EVs", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
//calculation once data is set, include hazards damage
                totalHp = (hpEvNum / 4) + ((((hpStat * 2 + 100) * 100) / 100) + 10) + hpIvNum;
                totalDef = ((defEvNum / 4) + (defStat * 2) + defIvNum) + 5;
                totalSpDef = ((spDefEvNum / 4) + (spDefStat * 2) + spDefIvNum) + 5;
                double hazardsTotal = (totalHp * srDmgPercent) + (totalHp * spikesDmgPercent);

                switch (nature2) {
                    case 0:
                        hpStatLabel.setText("HP Stat: " + nf.format(totalHp - hazardsTotal));
                        defStatLabel.setText("Def Stat: " + nf.format(totalDef * HIND_CONST));
                        spDefStatLabel.setText("SP.Def Stat: " + nf.format(totalSpDef * HIND_CONST));
                        hp = totalHp - hazardsTotal;
                        def = totalDef * HIND_CONST;
                        spDef = totalSpDef * HIND_CONST;
                        break;
                    case 1:
                        hpStatLabel.setText("HP Stat: " + nf.format(totalHp - hazardsTotal));
                        defStatLabel.setText("Def Stat: " + nf.format(totalDef));
                        spDefStatLabel.setText("SP.Def Stat: " + nf.format(totalSpDef));
                        hp = totalHp - hazardsTotal;
                        def = totalDef;
                        spDef = totalSpDef;
                        break;
                    case 2:
                        hpStatLabel.setText("HP Stat: " + nf.format(totalHp - hazardsTotal));
                        defStatLabel.setText("Def Stat: " + nf.format(totalDef * BENEF_CONST));
                        spDefStatLabel.setText("SP.Def Stat: " + nf.format(totalSpDef * BENEF_CONST));
                        hp = totalHp - hazardsTotal;
                        def = totalDef * BENEF_CONST;
                        spDef = totalSpDef * BENEF_CONST;
                        break;

                    default:
                        hpStatLabel.setText("HP Stat: " + nf.format(totalHp - hazardsTotal));
                        defStatLabel.setText("Def Stat: " + nf.format(totalDef));
                        spDefStatLabel.setText("SP.Def Stat: " + nf.format(totalSpDef));
                        hp = totalHp - hazardsTotal;
                        def = totalDef;
                        spDef = totalSpDef;
                        break;
                }
            }
        });


        defPkmnPanel.add(defStatButton);


//second sed ot nature radio buttons here to determine total stat multiplier
//hindering(x0.9) neutral(x1) beneficial(x1.1)
        natureBtnPanel2 = new JPanel(new GridLayout(3, 1));
        ButtonGroup natureGroup2 = new ButtonGroup();
        JRadioButton hinderBtn2;
        hinderBtn2 = new JRadioButton("Hindering");
        hinderBtn2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int theNature = 0;
                nature2 = theNature;
            }
        });
        natureGroup2.add(hinderBtn2);
        natureBtnPanel2.add(hinderBtn2);
        JRadioButton neutralBtn2;
        neutralBtn2 = new JRadioButton("Neutral");
        neutralBtn2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int theNature = 1;
                nature2 = theNature;
            }
        });
        natureGroup2.add(neutralBtn2);
        natureBtnPanel2.add(neutralBtn2);
        JRadioButton beneficialBtn2;
        beneficialBtn2 = new JRadioButton("Beneficial");
        beneficialBtn2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int theNature = 2;
                nature2 = theNature;
            }
        });
        natureGroup2.add(beneficialBtn2);
        natureBtnPanel2.add(beneficialBtn2);
        neutralBtn2.setSelected(true);

        defPkmnPanel.add(natureBtnPanel2);

        add(defPkmnPanel, BorderLayout.EAST);

//practice
        //Plans
        //will eventually replace this with attack move chosen and its modifiers to calculate total damage
        atkOptionPanel = new JPanel(new GridLayout(3,1));
        atkMovePanel = new JPanel(new FlowLayout());
        atkOptionPanel.add(atkMovePanel);
        atkMoveLabel = new JLabel("Atk Move Power: ");
        atkMovePanel.add(atkMoveLabel);
        atkPowerTextField = new JTextField(3);
        atkMovePanel.add(atkPowerTextField);

        atkTypeRBtnPanel = new JPanel(new GridLayout(2,1));
        ButtonGroup atkTypeBtnGroup = new ButtonGroup();
        JRadioButton physicalBtn;
        physicalBtn = new JRadioButton("Physical ");
        physicalBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int theAtkType = 0;
                atkType = theAtkType;
            }
        });
        atkTypeBtnGroup.add(physicalBtn);
        atkTypeRBtnPanel.add(physicalBtn);
        JRadioButton specialBtn;
        specialBtn = new JRadioButton("Special ");
        specialBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int theAtkType = 1;
                atkType = theAtkType;
            }
        });
        atkTypeBtnGroup.add(specialBtn);
        atkTypeRBtnPanel.add(specialBtn);
        physicalBtn.setSelected(true);
        atkMovePanel.add(atkTypeRBtnPanel);


        effectivePanel = new JPanel(new GridLayout(2,1));
        effectiveLabel = new JLabel("Effectiveness: ");
        effectivePanel.add(effectiveLabel);
        effectiveCB.addItem("No Effect");
        effectiveCB.addItem("4x Resist");
        effectiveCB.addItem("2x Resist");
        effectiveCB.addItem("Normal");
        effectiveCB.addItem("2x Super Effective");
        effectiveCB.addItem("4x Super Effective");
        effectiveCB.setEditable(false);
        effectiveCB.setMaximumRowCount(5);
        effectivePanel.add(effectiveCB);
        effectiveCB.addActionListener(new ActionListener() {
//same as atkPkmnCB
//at this point the hp, def and Sp def values are now being used

            public void actionPerformed(ActionEvent e) {
                int effectNum = effectiveCB.getSelectedIndex();
                switch(effectNum)
                {
                    case 0: effMul = 0;break;
                    case 1: effMul = 0.25;break;
                    case 2: effMul = 0.5;break;
                    case 3: effMul = 1;break;
                    case 4: effMul = 2;break;
                    case 5: effMul = 4;break;
                }
            }
        });
        atkMovePanel.add(effectivePanel);

        modsPanel = new JPanel(new GridLayout(8,1));
        //input atk mod cb and def mod cb
        atkModLabel = new JLabel("Atk Stat Modifier:");
        modsPanel.add(atkModLabel);
        atkStatModCB.addItem("None");
        atkStatModCB.addItem("stage:  1(1.5x)");
        atkStatModCB.addItem("stage: -1(0.67x)");
        atkStatModCB.addItem("stage:  2(2x)");
        atkStatModCB.addItem("stage: -2(0.5x)");
        atkStatModCB.addItem("stage:  3(2.5x)");
        atkStatModCB.addItem("stage: -3(0.4x)");
        atkStatModCB.addItem("stage:  4(3x)");
        atkStatModCB.addItem("stage: -4(0.33x)");
        atkStatModCB.addItem("stage:  5(3.5x)");
        atkStatModCB.addItem("stage: -5(0.29x)");
        atkStatModCB.addItem("stage:  6(4x)");
        atkStatModCB.addItem("stage: -6(0.25x)");
        atkStatModCB.setEditable(false);
        atkStatModCB.setMaximumRowCount(5);
        modsPanel.add(atkStatModCB);
        atkStatModCB.addActionListener(new ActionListener() {
//another combo box using switch

            public void actionPerformed(ActionEvent e) {
                int atkModNum = atkStatModCB.getSelectedIndex();
                switch(atkModNum)
                {
                    case 0: atkMod = 1;break;
                    case 1: atkMod = 1.5;break;
                    case 2: atkMod = 0.67;break;
                    case 3: atkMod = 2;break;
                    case 4: atkMod = 0.5;break;
                    case 5: atkMod = 2.5;break;
                    case 6: atkMod = 0.4;break;
                    case 7: atkMod = 3;break;
                    case 8: atkMod = 0.333;break;
                    case 9: atkMod = 3.5;break;
                    case 10: atkMod = 0.29;break;
                    case 11: atkMod = 4;break;
                    case 12: atkMod = 0.25;break;
                    default: System.exit(0);break;
                }
            }
        });

        defModLabel = new JLabel("Def Stat Modifier:");
        modsPanel.add(defModLabel);
        defStatModCB.addItem("None");
        defStatModCB.addItem("stage:  1(1.5x)");
        defStatModCB.addItem("stage: -1(0.67x)");
        defStatModCB.addItem("stage:  2(2x)");
        defStatModCB.addItem("stage: -2(0.5x)");
        defStatModCB.addItem("stage:  3(2.5x)");
        defStatModCB.addItem("stage: -3(0.4x)");
        defStatModCB.addItem("stage:  4(3x)");
        defStatModCB.addItem("stage: -4(0.33x)");
        defStatModCB.addItem("stage:  5(3.5x)");
        defStatModCB.addItem("stage: -5(0.29x)");
        defStatModCB.addItem("stage:  6(4x)");
        defStatModCB.addItem("stage: -6(0.25x)");
        defStatModCB.setEditable(false);
        defStatModCB.setMaximumRowCount(5);
        modsPanel.add(defStatModCB);
        defStatModCB.addActionListener(new ActionListener() {
//yet another combo box

            public void actionPerformed(ActionEvent e) {
                int defModNum = defStatModCB.getSelectedIndex();
                switch(defModNum)
                {
                    case 0: defMod = 1;break;
                    case 1: defMod = 1.5;break;
                    case 2: defMod = 0.67;break;
                    case 3: defMod = 2;break;
                    case 4: defMod = 0.5;break;
                    case 5: defMod = 2.5;break;
                    case 6: defMod = 0.4;break;
                    case 7: defMod = 3;break;
                    case 8: defMod = 0.333;break;
                    case 9: defMod = 3.5;break;
                    case 10: defMod = 0.29;break;
                    case 11: defMod = 4;break;
                    case 12: defMod = 0.25;break;
                    default: System.exit(0);break;
                }
            }
        });

//one more combo box this one for items
        atkItemLabel = new JLabel("Attack Item: ");
        modsPanel.add(atkItemLabel);
        atkItemCB.addItem("None");
        atkItemCB.addItem("Choice Specs(Sp.Atk 1.5x)");
        atkItemCB.addItem("Choice Band(Atk 1.5x)");
        atkItemCB.addItem("Life Orb(Dmg 1.3x)");
        atkItemCB.addItem("Expert Belt(Dmg 1.2x)");
        atkItemCB.addItem("Wise Glasses(Special Dmg 1.1x)");
        atkItemCB.addItem("Muscle Band(Physical Dmg 1.1x)");
        atkItemCB.addItem("Deep Sea Tooth(Clampearl SpAtk 2x)");
        atkItemCB.addItem("Light Ball(Pikachu Atk/SpAtk 2x)");
        atkItemCB.addItem("Soul Dew(Lati Twins Sp.Atk 1.5x)");
        atkItemCB.addItem("Thick Club(Cubone/Marrowak Atk 2x)");
        atkItemCB.setEditable(false);
        atkItemCB.setMaximumRowCount(5);
        modsPanel.add(atkItemCB);
        atkItemCB.addActionListener(new ActionListener() {
//same as atkPkmnCB
//at this point the hp, def and Sp def values are now being used

            public void actionPerformed(ActionEvent e) {
                int atkItemNum = atkItemCB.getSelectedIndex();
                switch(atkItemNum)
                {
                    case 0: itemAtkStat = 1; itemSpAtkStat = 1; itemAtkDmg = 1; itemSpAtkDmg = 1;break;
                    case 1: itemSpAtkStat = 1.5;break;
                    case 2: itemAtkStat = 1.5;break;
                    case 3: itemAtkDmg = 1.3; itemSpAtkDmg = 1.3;break;
                    case 4: itemAtkDmg = 1.2; itemSpAtkDmg = 1.2;break;
                    case 5: itemSpAtkDmg = 1.1;break;
                    case 6: itemAtkDmg = 1.1;break;
                    case 7: itemSpAtkStat = 2;break;
                    case 8: itemAtkStat = 2; itemSpAtkStat = 2;break;
                    case 9: itemSpAtkStat = 1.5;break;
                    case 10: itemAtkStat = 2;break;
                    default: System.exit(0);break;
                }
            }
        });

        defItemLabel = new JLabel("Defense Item: ");
        modsPanel.add(defItemLabel);
        defItemCB.addItem("None");
        defItemCB.addItem("Eviolite(PreEvo Def/SpDef 1.5x)");
        defItemCB.addItem("Soul Dew(Lati Twins SpDef 1.5x)");
        defItemCB.addItem("Deep Sea Scale(Clampearl SpDef 2x)");
        defItemCB.addItem("Metal Powder(Ditto Def/SpDef 1.5x");
        defItemCB.setEditable(false);
        defItemCB.setMaximumRowCount(5);
        modsPanel.add(defItemCB);
        defItemCB.addActionListener(new ActionListener() {
//uno mas ComboBox for defense items

            public void actionPerformed(ActionEvent e) {
                int defItemNum = defItemCB.getSelectedIndex();
                switch(defItemNum)
                {
                    case 0: itemDefStat = 1; itemSpDefStat = 1;break;
                    case 1: itemDefStat = 1.5; itemSpDefStat = 1.5;break;
                    case 2: itemSpDefStat = 1.5;break;
                    case 3: itemSpDefStat = 2;break;
                    case 4: itemDefStat = 1.5; itemSpDefStat = 1.5;break;
                    default: System.exit(0);break;
                }
            }
        });
        
        atkOptionPanel.add(modsPanel);
        //then checkboxes


        checkBoxPanel = new JPanel(new FlowLayout());
        stabChBox = new JCheckBox("S.T.A.B.");
        checkBoxPanel.add(stabChBox);
        stabChBox.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int stabNum = stabTrack;
                switch(stabNum)
                {
                    case 0:stabTrack = 1;stab = 1.5;break;
                    case 1:stabTrack = 0;stab = 1;break;
                    default: System.exit(0);break;
                }
            }
        });
        burnChBox = new JCheckBox("Burn ");
        checkBoxPanel.add(burnChBox);
        burnChBox.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int burnNum = burnTrack;
                switch(burnNum)
                {
                    case 0:burnTrack = 1;burn = 0.5;break;
                    case 1:burnTrack = 0;burn = 1;break;
                    default: System.exit(0);break;
                }
            }
        });
        reflectChBox = new JCheckBox("Reflect");
        checkBoxPanel.add(reflectChBox);
        reflectChBox.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int reflectNum = reflectTrack;
                switch(reflectNum)
                {
                    case 0:reflectTrack = 1;refl = 0.5;break;
                    case 1:reflectTrack = 0;refl = 1;break;
                    default: System.exit(0);break;
                }
            }
        });
        lightScreenChBox = new JCheckBox("Light Screen");
        checkBoxPanel.add(lightScreenChBox);
        lightScreenChBox.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int lsNum = lsTrack;
                switch(lsNum)
                {
                    case 0:lsTrack = 1;lscreen = 0.5;break;
                    case 1:lsTrack = 0;lscreen = 1;break;
                    default: System.exit(0);break;
                }
            }
        });
        rainSunChBox = new JCheckBox("Wheather Dmg Bonus");
        checkBoxPanel.add(rainSunChBox);
        rainSunChBox.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int whethNum = whethTrack;
                switch(whethNum)
                {
                    case 0:whethTrack = 1;wheth = 2;break;
                    case 1:whethTrack = 0;wheth = 1;break;
                    default: System.exit(0);break;
                }
            }
        });
        sandDefChBox = new JCheckBox("Sandstorm SpDef Bonus");
        checkBoxPanel.add(sandDefChBox);
        sandDefChBox.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int sanDefNum = sanDefTrack;
                switch(sanDefNum)
                {
                    case 0:sanDefTrack = 1;sanDef = 1.5;break;
                    case 1:sanDefTrack = 0;sanDef = 1;break;
                    default: System.exit(0);break;
                }
            }
        });


                JButton calculateBtn = new JButton("Calculate Stats");
        calculateBtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
                double theAtk, theSpAtk, theDef, theSpDef, theHp;
                theHp = hp;
                theAtk = atk*itemAtkStat*atkMod*burn;
                theSpAtk = spAtk*itemSpAtkStat*atkMod;
                theDef = def*itemDefStat*defMod;
                theSpDef = spDef*itemSpDefStat*defMod;
                hpTF.setText(""+nf.format(theHp));
                atkTF.setText(""+nf.format(theAtk));
                spAtkTF.setText(""+nf.format(theSpAtk));
                defTF.setText(""+nf.format(theDef));
                spDefTF.setText(""+nf.format(theSpDef));
                
            }
        });
        checkBoxPanel.add(calculateBtn);

        atkOptionPanel.add(checkBoxPanel);

        add(atkOptionPanel, BorderLayout.CENTER);



//resulting clash between pokemon. Total damage and percent of total damage
        resultsPanel = new JPanel(new GridLayout(2,3));

        atkTFPanel = new JPanel(new GridLayout(2,2));
        atkTFLabel = new JLabel("Total Atk: ");
        atkTFPanel.add(atkTFLabel);
        atkTF = new JTextField("0",10);
        atkTFLabel.setToolTipText("Enter the Attacking Pokemon's total Attack stat "
                + "here or calculate it through the calculator above");
        atkTFPanel.add(atkTF);
        spAtkTFLabel = new JLabel("Total Sp.Atk: ");
        atkTFPanel.add(spAtkTFLabel);
        spAtkTF = new JTextField("0",10);
        spAtkTFLabel.setToolTipText("Enter the Attacking Pokemon's total Sp.Attack stat"
                + " here or calculate it through the calculator above");
        atkTFPanel.add(spAtkTF);
        resultsPanel.add(atkTFPanel);

        southTopMidPanel = new JPanel(new GridLayout(2,2));
        hpTFLabel = new JLabel("Total HP:");
        southTopMidPanel.add(hpTFLabel);
        hpTF = new JTextField("0", 10);
        southTopMidPanel.add(hpTF);
        minDamageLabel = new JLabel("Min Dmg: -");
        southTopMidPanel.add(minDamageLabel);
        maxDamageLabel = new JLabel("Max Dmg: -");
        southTopMidPanel.add(maxDamageLabel);
        resultsPanel.add(southTopMidPanel);
        

        defTFPanel = new JPanel(new GridLayout(2,2));
        defTFLabel = new JLabel("Total Def: ");
        defTFPanel.add(defTFLabel);
        defTF = new JTextField("0",10);
        defTFLabel.setToolTipText("Enter the Defending Pokemon's total Defense stat "
                + "here or calculate it through the calculator above");
        defTFPanel.add(defTF);
        spDefTFLabel = new JLabel("Total Sp.Def: ");
        defTFPanel.add(spDefTFLabel);
        spDefTF = new JTextField("0",10);
        spDefTFLabel.setToolTipText("Enter the Defending Pokemon's total Sp.Defense stat "
                + "here or calculate it through the calculator above");
        defTFPanel.add(spDefTF);
        resultsPanel.add(defTFPanel);
        
        minBarPanel = new JPanel(new FlowLayout());
        minHpBarLabel = new JLabel("Min: HP: -/-");
        minHpBar = new JLabel(icon100);
        minBarPanel.add(minHpBarLabel);
        minBarPanel.add(minHpBar);
        resultsPanel.add(minBarPanel);
        JButton southButton = new JButton("Let's Do This!");

        southButton.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
                int atkPowerNum = 0, theAtk, theDef, theSpAtk, theSpDef, theHp;
                try {
                    atkPowerNum = Integer.parseInt(atkPowerTextField.getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: Please re-enter"
                            + " an integer value for Atk Move Power", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }try {
                    theAtk = Integer.parseInt(atkTF.getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: Please re-enter"
                            + " an integer value for total Attack", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    theDef = Integer.parseInt(defTF.getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: Please re-enter"
                            + " an integer value for total Defense", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    theSpAtk = Integer.parseInt(spAtkTF.getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: Please re-enter"
                            + " an integer value for total Sp.Attack", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }try {
                    theSpDef = Integer.parseInt(spDefTF.getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: Please re-enter"
                            + " an integer value for total Sp.Defense", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }try {
                    theHp = Integer.parseInt(hpTF.getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: Please re-enter"
                            + " an integer value for total HP", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                switch(atkType)
                {
                    case 0: minDamage = (((((((42) * atkPowerNum * (theAtk/burn)
                            / 50)/ theDef)*burn*refl*wheth) + 2) * 1 * itemAtkDmg * 0.85)*stab*effMul);
                            maxDamage = (((((((42) * atkPowerNum * (theAtk/burn)
                            / 50)/ theDef)*burn*refl*wheth) + 2) * 1 * itemAtkDmg)*stab*effMul);
                            break;
                    case 1: minDamage = (((((((42) * atkPowerNum * (theSpAtk)
                            / 50)/ theDef*sanDef)*lscreen*wheth) + 2)* 1 * itemSpAtkDmg * 0.85)*stab*effMul);
                            maxDamage = (((((((42) * atkPowerNum * (theSpAtk)
                            / 50)/ theDef*sanDef)*lscreen*wheth) + 2)* 1 * itemSpAtkDmg)*stab*effMul);
                            break;
                    default: System.exit(0);break;
                }
                minDamageLabel.setText("Min Dmg: "+nf.format(minDamage));
                maxDamageLabel.setText("Max Dmg: "+nf.format(maxDamage));

                if(minDamage < theHp){
                            minHpBarLabel.setText("Min: HP: "+nf.format(theHp-minDamage)+"/"+theHp);
                            //work in progress
                            int minPercent = (int) Math.floor(((theHp - minDamage)/theHp)*100);
                            switch(minPercent)
                            {
                                case 0: minHpBar.setIcon(icon0);break;
                                case 1: minHpBar.setIcon(icon1);break;
                                case 2: minHpBar.setIcon(icon2);break;
                                case 3: minHpBar.setIcon(icon3);break;
                                case 4: minHpBar.setIcon(icon4);break;
                                case 5: minHpBar.setIcon(icon5);break;
                                case 6: minHpBar.setIcon(icon6);break;
                                case 7: minHpBar.setIcon(icon7);break;
                                case 8: minHpBar.setIcon(icon8);break;
                                case 9: minHpBar.setIcon(icon9);break;
                                case 10: minHpBar.setIcon(icon10);break;
                                case 11: minHpBar.setIcon(icon11);break;
                                case 12: minHpBar.setIcon(icon12);break;
                                case 13: minHpBar.setIcon(icon13);break;
                                case 14: minHpBar.setIcon(icon14);break;
                                case 15: minHpBar.setIcon(icon15);break;
                                case 16: minHpBar.setIcon(icon16);break;
                                case 17: minHpBar.setIcon(icon17);break;
                                case 18: minHpBar.setIcon(icon18);break;
                                case 19: minHpBar.setIcon(icon19);break;
                                case 20: minHpBar.setIcon(icon20);break;
                                case 21: minHpBar.setIcon(icon21);break;
                                case 22: minHpBar.setIcon(icon22);break;
                                case 23: minHpBar.setIcon(icon23);break;
                                case 24: minHpBar.setIcon(icon24);break;
                                case 25: minHpBar.setIcon(icon25);break;
                                case 26: minHpBar.setIcon(icon26);break;
                                case 27: minHpBar.setIcon(icon27);break;
                                case 28: minHpBar.setIcon(icon28);break;
                                case 29: minHpBar.setIcon(icon29);break;
                                case 30: minHpBar.setIcon(icon30);break;
                                case 31: minHpBar.setIcon(icon31);break;
                                case 32: minHpBar.setIcon(icon32);break;
                                case 33: minHpBar.setIcon(icon33);break;
                                case 34: minHpBar.setIcon(icon34);break;
                                case 35: minHpBar.setIcon(icon35);break;
                                case 36: minHpBar.setIcon(icon36);break;
                                case 37: minHpBar.setIcon(icon37);break;
                                case 38: minHpBar.setIcon(icon38);break;
                                case 39: minHpBar.setIcon(icon39);break;
                                case 40: minHpBar.setIcon(icon40);break;
                                case 41: minHpBar.setIcon(icon41);break;
                                case 42: minHpBar.setIcon(icon42);break;
                                case 43: minHpBar.setIcon(icon43);break;
                                case 44: minHpBar.setIcon(icon44);break;
                                case 45: minHpBar.setIcon(icon45);break;
                                case 46: minHpBar.setIcon(icon46);break;
                                case 47: minHpBar.setIcon(icon47);break;
                                case 48: minHpBar.setIcon(icon48);break;
                                case 49: minHpBar.setIcon(icon49);break;
                                case 50: minHpBar.setIcon(icon50);break;
                                case 51: minHpBar.setIcon(icon51);break;
                                case 52: minHpBar.setIcon(icon52);break;
                                case 53: minHpBar.setIcon(icon53);break;
                                case 54: minHpBar.setIcon(icon54);break;
                                case 55: minHpBar.setIcon(icon55);break;
                                case 56: minHpBar.setIcon(icon56);break;
                                case 57: minHpBar.setIcon(icon57);break;
                                case 58: minHpBar.setIcon(icon58);break;
                                case 59: minHpBar.setIcon(icon59);break;
                                case 60: minHpBar.setIcon(icon60);break;
                                case 61: minHpBar.setIcon(icon61);break;
                                case 62: minHpBar.setIcon(icon62);break;
                                case 63: minHpBar.setIcon(icon63);break;
                                case 64: minHpBar.setIcon(icon64);break;
                                case 65: minHpBar.setIcon(icon65);break;
                                case 66: minHpBar.setIcon(icon66);break;
                                case 67: minHpBar.setIcon(icon67);break;
                                case 68: minHpBar.setIcon(icon68);break;
                                case 69: minHpBar.setIcon(icon69);break;
                                case 70: minHpBar.setIcon(icon70);break;
                                case 71: minHpBar.setIcon(icon71);break;
                                case 72: minHpBar.setIcon(icon72);break;
                                case 73: minHpBar.setIcon(icon73);break;
                                case 74: minHpBar.setIcon(icon74);break;
                                case 75: minHpBar.setIcon(icon75);break;
                                case 76: minHpBar.setIcon(icon76);break;
                                case 77: minHpBar.setIcon(icon77);break;
                                case 78: minHpBar.setIcon(icon78);break;
                                case 79: minHpBar.setIcon(icon79);break;
                                case 80: minHpBar.setIcon(icon80);break;
                                case 81: minHpBar.setIcon(icon81);break;
                                case 82: minHpBar.setIcon(icon82);break;
                                case 83: minHpBar.setIcon(icon83);break;
                                case 84: minHpBar.setIcon(icon84);break;
                                case 85: minHpBar.setIcon(icon85);break;
                                case 86: minHpBar.setIcon(icon86);break;
                                case 87: minHpBar.setIcon(icon87);break;
                                case 88: minHpBar.setIcon(icon88);break;
                                case 89: minHpBar.setIcon(icon89);break;
                                case 90: minHpBar.setIcon(icon90);break;
                                case 91: minHpBar.setIcon(icon91);break;
                                case 92: minHpBar.setIcon(icon92);break;
                                case 93: minHpBar.setIcon(icon93);break;
                                case 94: minHpBar.setIcon(icon94);break;
                                case 95: minHpBar.setIcon(icon95);break;
                                case 96: minHpBar.setIcon(icon96);break;
                                case 97: minHpBar.setIcon(icon97);break;
                                case 98: minHpBar.setIcon(icon98);break;
                                case 99: minHpBar.setIcon(icon99);break;
                                case 100: minHpBar.setIcon(icon100);break;
                                default: System.exit(0);
                            }


                        }else if(minDamage >= theHp){
                            minHpBarLabel.setText("Min: HP: 0/"+theHp);
                            minHpBar.setIcon(icon0);
                        }
                            if(maxDamage < theHp){
                                maxHpBarLabel.setText("Max: HP: "+nf.format(theHp-maxDamage)+"/"+theHp);

                                //work in progress
                                int maxPercent = (int) Math.floor((((theHp - maxDamage)/theHp)*100));
                                switch(maxPercent)
                            {
                                case 0: maxHpBar.setIcon(icon0);break;
                                case 1: maxHpBar.setIcon(icon1);break;
                                case 2: maxHpBar.setIcon(icon2);break;
                                case 3: maxHpBar.setIcon(icon3);break;
                                case 4: maxHpBar.setIcon(icon4);break;
                                case 5: maxHpBar.setIcon(icon5);break;
                                case 6: maxHpBar.setIcon(icon6);break;
                                case 7: maxHpBar.setIcon(icon7);break;
                                case 8: maxHpBar.setIcon(icon8);break;
                                case 9: maxHpBar.setIcon(icon9);break;
                                case 10: maxHpBar.setIcon(icon10);break;
                                case 11: maxHpBar.setIcon(icon11);break;
                                case 12: maxHpBar.setIcon(icon12);break;
                                case 13: maxHpBar.setIcon(icon13);break;
                                case 14: maxHpBar.setIcon(icon14);break;
                                case 15: maxHpBar.setIcon(icon15);break;
                                case 16: maxHpBar.setIcon(icon16);break;
                                case 17: maxHpBar.setIcon(icon17);break;
                                case 18: maxHpBar.setIcon(icon18);break;
                                case 19: maxHpBar.setIcon(icon19);break;
                                case 20: maxHpBar.setIcon(icon20);break;
                                case 21: maxHpBar.setIcon(icon21);break;
                                case 22: maxHpBar.setIcon(icon22);break;
                                case 23: maxHpBar.setIcon(icon23);break;
                                case 24: maxHpBar.setIcon(icon24);break;
                                case 25: maxHpBar.setIcon(icon25);break;
                                case 26: maxHpBar.setIcon(icon26);break;
                                case 27: maxHpBar.setIcon(icon27);break;
                                case 28: maxHpBar.setIcon(icon28);break;
                                case 29: maxHpBar.setIcon(icon29);break;
                                case 30: maxHpBar.setIcon(icon30);break;
                                case 31: maxHpBar.setIcon(icon31);break;
                                case 32: maxHpBar.setIcon(icon32);break;
                                case 33: maxHpBar.setIcon(icon33);break;
                                case 34: maxHpBar.setIcon(icon34);break;
                                case 35: maxHpBar.setIcon(icon35);break;
                                case 36: maxHpBar.setIcon(icon36);break;
                                case 37: maxHpBar.setIcon(icon37);break;
                                case 38: maxHpBar.setIcon(icon38);break;
                                case 39: maxHpBar.setIcon(icon39);break;
                                case 40: maxHpBar.setIcon(icon40);break;
                                case 41: maxHpBar.setIcon(icon41);break;
                                case 42: maxHpBar.setIcon(icon42);break;
                                case 43: maxHpBar.setIcon(icon43);break;
                                case 44: maxHpBar.setIcon(icon44);break;
                                case 45: maxHpBar.setIcon(icon45);break;
                                case 46: maxHpBar.setIcon(icon46);break;
                                case 47: maxHpBar.setIcon(icon47);break;
                                case 48: maxHpBar.setIcon(icon48);break;
                                case 49: maxHpBar.setIcon(icon49);break;
                                case 50: maxHpBar.setIcon(icon50);break;
                                case 51: maxHpBar.setIcon(icon51);break;
                                case 52: maxHpBar.setIcon(icon52);break;
                                case 53: maxHpBar.setIcon(icon53);break;
                                case 54: maxHpBar.setIcon(icon54);break;
                                case 55: maxHpBar.setIcon(icon55);break;
                                case 56: maxHpBar.setIcon(icon56);break;
                                case 57: maxHpBar.setIcon(icon57);break;
                                case 58: maxHpBar.setIcon(icon58);break;
                                case 59: maxHpBar.setIcon(icon59);break;
                                case 60: maxHpBar.setIcon(icon60);break;
                                case 61: maxHpBar.setIcon(icon61);break;
                                case 62: maxHpBar.setIcon(icon62);break;
                                case 63: maxHpBar.setIcon(icon63);break;
                                case 64: maxHpBar.setIcon(icon64);break;
                                case 65: maxHpBar.setIcon(icon65);break;
                                case 66: maxHpBar.setIcon(icon66);break;
                                case 67: maxHpBar.setIcon(icon67);break;
                                case 68: maxHpBar.setIcon(icon68);break;
                                case 69: maxHpBar.setIcon(icon69);break;
                                case 70: maxHpBar.setIcon(icon70);break;
                                case 71: maxHpBar.setIcon(icon71);break;
                                case 72: maxHpBar.setIcon(icon72);break;
                                case 73: maxHpBar.setIcon(icon73);break;
                                case 74: maxHpBar.setIcon(icon74);break;
                                case 75: maxHpBar.setIcon(icon75);break;
                                case 76: maxHpBar.setIcon(icon76);break;
                                case 77: maxHpBar.setIcon(icon77);break;
                                case 78: maxHpBar.setIcon(icon78);break;
                                case 79: maxHpBar.setIcon(icon79);break;
                                case 80: maxHpBar.setIcon(icon80);break;
                                case 81: maxHpBar.setIcon(icon81);break;
                                case 82: maxHpBar.setIcon(icon82);break;
                                case 83: maxHpBar.setIcon(icon83);break;
                                case 84: maxHpBar.setIcon(icon84);break;
                                case 85: maxHpBar.setIcon(icon85);break;
                                case 86: maxHpBar.setIcon(icon86);break;
                                case 87: maxHpBar.setIcon(icon87);break;
                                case 88: maxHpBar.setIcon(icon88);break;
                                case 89: maxHpBar.setIcon(icon89);break;
                                case 90: maxHpBar.setIcon(icon90);break;
                                case 91: maxHpBar.setIcon(icon91);break;
                                case 92: maxHpBar.setIcon(icon92);break;
                                case 93: maxHpBar.setIcon(icon93);break;
                                case 94: maxHpBar.setIcon(icon94);break;
                                case 95: maxHpBar.setIcon(icon95);break;
                                case 96: maxHpBar.setIcon(icon96);break;
                                case 97: maxHpBar.setIcon(icon97);break;
                                case 98: maxHpBar.setIcon(icon98);break;
                                case 99: maxHpBar.setIcon(icon99);break;
                                case 100: maxHpBar.setIcon(icon100);break;
                                default: System.exit(0);
                            }


                            }else if(maxDamage >= theHp){
                                maxHpBarLabel.setText("Max: HP: 0/"+theHp);
                                minHpBar.setIcon(icon0);
                            }

            }
        });
        resultsPanel.add(southButton);

        maxBarPanel = new JPanel(new FlowLayout());
        maxHpBarLabel = new JLabel("Max: HP: -/-");
        maxHpBar = new JLabel(icon100);
        maxBarPanel.add(maxHpBarLabel);
        maxBarPanel.add(maxHpBar);
        resultsPanel.add(maxBarPanel);


        add(resultsPanel, BorderLayout.SOUTH);



    }
    /*
    public class BadNumberException extends Exception
    {
        private int badNumber;
        public BadNumberException(int number){
            super("Bad Number Exception");
            badNumber = number;
        }
        public BadNumberException(){
            super("BadNumberException");
        }
        public BadNumberException(String message){
            super(message);
        }
        public int getBadNumber(){
            return badNumber;
        }
    }

     */
}
