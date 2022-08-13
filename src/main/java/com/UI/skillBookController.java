package com.UI;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import com.abyss.Config;
import com.abyss.changeBackground;
import com.abyss.dataBase;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import static com.abyss.dataBase.getSkillsChoosing;
import static com.abyss.dataBase.initSkillsChoosing;

public class skillBookController extends changeBackground {
    private final Region[] button = new Region[11];
    private final Label[] label = new Label[5];
    private final List<Region> selectedSkill = new LinkedList<Region>();
    private String path;
    @FXML
    private AnchorPane onShow;
    @FXML
    private Text numb;
    @FXML
    private Region btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10;
    @FXML
    private Label lab6,lab7,lab8,lab9,lab10;

    @FXML
    void select(MouseEvent event) {
        for(int i = 1; i <= 10; i++)
            if(event.getSource().equals(button[i])){
                if(!dataBase.isGet(i))
                    return;

                path = Config.skillOnShowPath + i + ".png";
                changebg(onShow,path);

                if(selectedSkill.contains(button[i])) {
                    selectedSkill.remove(button[i]);
                    path = Config.tanSkillPath + i + "_0.png";
                    changebg(button[i],path);
                }
                else {
                    if(selectedSkill.size() >= 4)
                        return;
                    selectedSkill.add(button[i]);
                    path = Config.tanSkillPath + i + "_1.png";
                    changebg(button[i],path);
                }

                int text = selectedSkill.size();
                numb.setText(String.valueOf(text));
            }
    }

    @FXML
    void returnSection(MouseEvent event) throws IOException {
        goToPage(onShow,Config.pageSection);
    }

    @FXML
    void processAtk(MouseEvent event) throws IOException {
        initSkillsChoosing();
        int len = selectedSkill.size();
        if(len == 0)
            return;
        for(int i = 0; i < len; i++) {
            Region re = selectedSkill.get(i);
            for(int index = 1; index <= 10; index++)
                if(re.equals(button[index])) {
                    getSkillsChoosing(index);
                    break;
                }
        }
        goToPage(onShow,Config.pageLoading);
    }

    @FXML
    void initialize() {
        button[1] = btn1;   button[2] = btn2;   button[3] = btn3;   button[4] = btn4;   button[5] = btn5;
        button[6] = btn6;   button[7] = btn7;   button[8] = btn8;   button[9] = btn9;   button[10] = btn10;
        label[0] = lab6;   label[1] = lab7;   label[2] = lab8;   label[3] = lab9;   label[4] = lab10;

        for(int i = 6; i <= 10; i++) {
            if(dataBase.isGet(i)) {
                path = Config.tanSkillPath + i + "_0.png";
                changebg(button[i], path);
            }
            else {
                path = Config.skillLockedPath + i + ".png";
                changebg(button[i], path);
                label[i-6].setVisible(false);
            }
        }

    }
}
