package com.example.snakesnladders;

import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;
import javafx.util.Duration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;


public class HelloController {

    ScaleTransition scaling;

    public HashMap<Integer, coor> coorList;

    snakegame s;

    Player User;
    Player Comp;

    coor usercoor;
    coor compcoor;

    // int turn = 0; // to keep track of players' turn (0 for blue and 1 for red)

    Image die1;
    Image die2;
    Image die3;
    Image die4;
    Image die5;
    Image die6;

    @FXML
    private Button Dice;

    @FXML
    private Label UserRollLabel;

    @FXML
    private Label CompRollLabel;

    @FXML
    private ImageView board;

    @FXML
    private ImageView dieFace;

    @FXML
    private ImageView dieFace1;

    @FXML
    private Label Label;

    @FXML
    private Button redToken;

    @FXML
    private Button blueToken;

    @FXML
    private Label status;

//    @FXML
//    void showCoordinates(MouseEvent event){
//        coordinates.setText("X: " + event.getSceneX() + "| Y: " + event.getSceneY());
//        System.out.println(coordinates);
//    }

    @FXML
    void rollDice(ActionEvent event) throws IOException {

        s.startGame();
        setDice();
        makeMove();

        if (s.getUserPosition() == 100){
            status.setText("User Won!!");
            scaling = new ScaleTransition(Duration.millis(500), status);
            scaling.setByX(0.5);
            scaling.setByY(0.5);
            scaling.setAutoReverse(true);
            scaling.setCycleCount(2);
            scaling.play();
            Dice.setDisable(true);
        }
        else if (s.getCompPosition() == 100){
            status.setText("Computer Won!!");
            scaling = new ScaleTransition(Duration.millis(500), status);
            scaling.setByX(0.5);
            scaling.setByY(0.5);
            scaling.setAutoReverse(true);
            scaling.setCycleCount(2);
            scaling.play();
            Dice.setDisable(true);
        }


    }

    private int getUserroll() {
        return s.getUserRoll();
    }
    private int getComproll(){
        return s.getCompRoll();
    }

    @FXML
    void showRed(ActionEvent event)
    {
        Label.setText("Computer's token");
    }

    @FXML
    void showBlue(ActionEvent event)
    {
        Label.setText("User's token");
    }

    @FXML
    void start(ActionEvent event) {
        s = new snakegame(1, 1, 0, 1, 1, "y");
        status.setText("Game in progress");
        makeMove();
        Dice.setDisable(false);
    }

    private void makeMove() {
        usercoor = coorList.get(s.getUserPosition());
        User.setDes(usercoor.getX(), usercoor.getY());
        compcoor = coorList.get(s.getCompPosition());
        Comp.setDes(compcoor.getX(), compcoor.getY());
        User.move();
        Comp.move();
    }

    public void initialize() throws FileNotFoundException {
        coorList= new HashMap<>();

        Dice.setDisable(true);
        setALLcoor();
        Comp = new Player(redToken);
        User = new Player(blueToken);
        // InputStream stream = new FileInputStream("C:\\Users\\Aftab Hussain\\IdeaProjects\\SnakesNladders\\src\\main\\java\\com\\example\\snakesnladders\\die1.png");
        InputStream stream1 = getClass().getResourceAsStream("/com/example/snakesnladders/die1.png");
        die1 = new Image(stream1);
        InputStream stream2 = getClass().getResourceAsStream("/com/example/snakesnladders/die2.png");
        die2 = new Image(stream2);
        InputStream stream3 = getClass().getResourceAsStream("/com/example/snakesnladders/die3.png");
        die3 = new Image(stream3);
        InputStream stream4 = getClass().getResourceAsStream("/com/example/snakesnladders/die4.png");
        die4 = new Image(stream4);
        InputStream stream5 = getClass().getResourceAsStream("/com/example/snakesnladders/die5.png");
        die5 = new Image(stream5);
        InputStream stream6 = getClass().getResourceAsStream("/com/example/snakesnladders/die6.png");
        die6 = new Image(stream6);
    }



    void setALLcoor() {
        coor coor1 = new coor(18.4, 459.2); coorList.put(1, coor1);
        coor coor2 = new coor(68.8, 458.4); coorList.put(2, coor2);
        coor coor3 = new coor(119.2, 458.4); coorList.put(3, coor3);
        coor coor4 = new coor(164.0, 460.0); coorList.put(4, coor4);
        coor coor5 = new coor(215.2, 460.0); coorList.put(5, coor5);
        coor coor6 = new coor(262.4, 460.0); coorList.put(6, coor6);
        coor coor7 = new coor(313.6, 460.0); coorList.put(7, coor7);
        coor coor8 = new coor(361.6, 458.4); coorList.put(8, coor8);
        coor coor9 = new coor(413.6, 459.2); coorList.put(9, coor9);
        coor coor10 = new coor(470.4, 457.6); coorList.put(10, coor10);
        coor coor11 = new coor(462.4, 412.8); coorList.put(11, coor11);
        coor coor12 = new coor(412.0, 412.0); coorList.put(12, coor12);
        coor coor13 = new coor(360.8, 412.0); coorList.put(13, coor13);
        coor coor14 = new coor(320.0, 410.4); coorList.put(14, coor14);
        coor coor15 = new coor(267.2, 408.0); coorList.put(15, coor15);
        coor coor16 = new coor(217.6, 408.0); coorList.put(16, coor16);
        coor coor17 = new coor(168.0, 408.0); coorList.put(17, coor17);
        coor coor18 = new coor(112.8, 408.8); coorList.put(18, coor18);
        coor coor19 = new coor(69.6, 411.2); coorList.put(19, coor19);
        coor coor20 = new coor(20.8, 412.0); coorList.put(20, coor20);
        coor coor21 = new coor(15.2, 362.4); coorList.put(21, coor21);
        coor coor22 = new coor(70.4, 360.8); coorList.put(22, coor22);
        coor coor23 = new coor(120.8, 360.0); coorList.put(23, coor23);
        coor coor24 = new coor(171.2, 356.8); coorList.put(24, coor24);
        coor coor25 = new coor(215.2, 359.2); coorList.put(25, coor25);
        coor coor26 = new coor(264.0, 359.2); coorList.put(26, coor26);
        coor coor27 = new coor(316.0, 355.2); coorList.put(27, coor27);
        coor coor28 = new coor(365.6, 355.2); coorList.put(28, coor28);
        coor coor29 = new coor(415.2, 358.4); coorList.put(29, coor29);
        coor coor30 = new coor(462.4, 358.4); coorList.put(30, coor30);
        coor coor31 = new coor(460.0, 312.0); coorList.put(31, coor31);
        coor coor32 = new coor(412.8, 309.6); coorList.put(32, coor32);
        coor coor33 = new coor(363.2, 312.0); coorList.put(33, coor33);
        coor coor34 = new coor(312.8, 312.8); coorList.put(34, coor34);
        coor coor35 = new coor(263.2, 313.6); coorList.put(35, coor35);
        coor coor36 = new coor(217.6, 312.0); coorList.put(36, coor36);
        coor coor37 = new coor(167.2, 310.4); coorList.put(37, coor37);
        coor coor38 = new coor(120.8, 311.2); coorList.put(38, coor38);
        coor coor39 = new coor(69.6, 309.6); coorList.put(39, coor39);
        coor coor40 = new coor(20.0, 314.4); coorList.put(40, coor40);
        coor coor41 = new coor(18.4, 268.8); coorList.put(41, coor41);
        coor coor42 = new coor(64.8, 264.0); coorList.put(42, coor42);
        coor coor43 = new coor(114.4, 256.8); coorList.put(43, coor43);
        coor coor44 = new coor(162.4, 256.8); coorList.put(44, coor44);
        coor coor45 = new coor(213.6, 260.0); coorList.put(45, coor45);
        coor coor46 = new coor(262.4, 259.2); coorList.put(46, coor46);
        coor coor47 = new coor(317.6, 260.8); coorList.put(47, coor47);
        coor coor48 = new coor(361.6, 260.8); coorList.put(48, coor48);
        coor coor49 = new coor(417.6, 261.6); coorList.put(49, coor49);
        coor coor50 = new coor(458.4, 260.8); coorList.put(50, coor50);
        coor coor51 = new coor(458.4, 212.0); coorList.put(51, coor51);
        coor coor52 = new coor(415.2, 210.4); coorList.put(52, coor52);
        coor coor53 = new coor(365.6, 210.4); coorList.put(53, coor53);
        coor coor54 = new coor(308.0, 215.2); coorList.put(54, coor54);
        coor coor55 = new coor(267.2, 216.0); coorList.put(55, coor55);
        coor coor56 = new coor(219.2, 212.8); coorList.put(56, coor56);
        coor coor57 = new coor(168.0, 212.8); coorList.put(57, coor57);
        coor coor58 = new coor(119.2, 215.2); coorList.put(58, coor58);
        coor coor59 = new coor(73.6, 215.2); coorList.put(59, coor59);
        coor coor60 = new coor(24.0, 213.6); coorList.put(60, coor60);
        coor coor61 = new coor(12.8, 162.4); coorList.put(61, coor61);
        coor coor62 = new coor(67.2, 164.0); coorList.put(62, coor62);
        coor coor63 = new coor(111.2, 162.4); coorList.put(63, coor63);
        coor coor64 = new coor(163.2, 157.6); coorList.put(64, coor64);
        coor coor65 = new coor(214.4, 160.0); coorList.put(65, coor65);
        coor coor66 = new coor(269.6, 160.8); coorList.put(66, coor66);
        coor coor67 = new coor(317.6, 160.0); coorList.put(67, coor67);
        coor coor68 = new coor(366.4, 160.0); coorList.put(68, coor68);
        coor coor69 = new coor(408.0, 160.8); coorList.put(69, coor69);
        coor coor70 = new coor(460.0, 161.6); coorList.put(70, coor70);
        coor coor71 = new coor(460.0, 110.4); coorList.put(71, coor71);
        coor coor72 = new coor(412.0, 115.2); coorList.put(72, coor72);
        coor coor73 = new coor(365.6, 114.4); coorList.put(73, coor73);
        coor coor74 = new coor(313.6, 112.8); coorList.put(74, coor74);
        coor coor75 = new coor(271.2, 112.8); coorList.put(75, coor75);
        coor coor76 = new coor(220.8, 115.2); coorList.put(76, coor76);
        coor coor77 = new coor(172.8, 115.2); coorList.put(77, coor77);
        coor coor78 = new coor(116.0, 110.4); coorList.put(78, coor78);
        coor coor79 = new coor(70.4, 115.2); coorList.put(79, coor79);
        coor coor80 = new coor(31.2, 112.8); coorList.put(80, coor80);
        coor coor81 = new coor(28.8, 64.8); coorList.put(81, coor81);
        coor coor82 = new coor(77.6, 64.0); coorList.put(82, coor82);
        coor coor83 = new coor(119.2, 62.4); coorList.put(83, coor83);
        coor coor84 = new coor(171.2, 63.2); coorList.put(84, coor84);
        coor coor85 = new coor(214.4, 64.8); coorList.put(85, coor85);
        coor coor86 = new coor(267.2, 64.0); coorList.put(86, coor86);
        coor coor87 = new coor(315.2, 64.0); coorList.put(87, coor87);
        coor coor88 = new coor(368.0, 65.6); coorList.put(88, coor88);
        coor coor89 = new coor(413.6, 66.4); coorList.put(89, coor89);
        coor coor90 = new coor(473.6, 60.8); coorList.put(90, coor90);
        coor coor91 = new coor(464.0, 14.6); coorList.put(91, coor91);
        coor coor92 = new coor(408.8, 14.8); coorList.put(92, coor92);
        coor coor93 = new coor(408.8, 15.8); coorList.put(93, coor93);
        coor coor94 = new coor(316.0, 14.8); coorList.put(94, coor94);
        coor coor95 = new coor(263.2, 14.6); coorList.put(95, coor95);
        coor coor96 = new coor(213.6, 15.0); coorList.put(96, coor96);
        coor coor97 = new coor(168.8, 13.6); coorList.put(97, coor97);
        coor coor98 = new coor(119.2, 12.8); coorList.put(98, coor98);
        coor coor99 = new coor(72.8, 14.4); coorList.put(99, coor99);
        coor coor100 = new coor(19.2, 14.2); coorList.put(100, coor100);

    }

    void setDice(){
        int userroll;
        userroll = getUserroll();
        UserRollLabel.setText("User Rolled: " + userroll);
        if (userroll == 1)
            dieFace.setImage(die1);
        else if (userroll == 2)
            dieFace.setImage(die2);
        else if (userroll == 3)
            dieFace.setImage(die3);
        else if (userroll == 4)
            dieFace.setImage(die4);
        else if (userroll == 5)
            dieFace.setImage(die5);
        else if (userroll == 6)
            dieFace.setImage(die6);

        int comproll;
        comproll = getComproll();
        CompRollLabel.setText("Comp Rolled: " + comproll);
        if (comproll == 1)
            dieFace1.setImage(die1);
        else if (comproll == 2)
            dieFace1.setImage(die2);
        else if (comproll == 3)
            dieFace1.setImage(die3);
        else if (comproll == 4)
            dieFace1.setImage(die4);
        else if (comproll == 5)
            dieFace1.setImage(die5);
        else if (comproll == 6)
            dieFace1.setImage(die6);
    }
}



class Player{
    double orgX, orgY;
    double currX, currY;
    double desX, desY;
    Button bt;

    Duration duration;
    TranslateTransition transition;

    Player(Button bt){
        duration = Duration.millis(500);
        transition = new TranslateTransition(duration, bt);

        Bounds bis= bt.localToScene(bt.getBoundsInLocal());
        System.out.println(bis);
        this.bt=bt;
        orgX=bis.getMinX();
        orgY=bis.getMinY();
        currX=orgX;
        currY=orgY;
    }


    void move(){
        transition.setByX(desX - currX);
        transition.setByY(desY - currY);
//        transition.setAutoReverse(true);
//        transition.setCycleCount(2);
        transition.play();
        currX=desX;
        currY=desY;
    }

    void setDes(double x, double y) //this func will set (not calculate) the destination of the token
    {
        this.desX = x;
        this.desY = y;
    }

}