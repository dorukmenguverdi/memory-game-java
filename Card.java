import javax.swing.*;
import java.awt.*;

// Represents a single memory card
public class Card {

    private String name;
    private ImageIcon frontImage;
    private JButton button;
    private boolean isMatched = false;
    private boolean isFlipped = false;

    // Initializes the card with a name and front image
    public Card(String name, ImageIcon frontImage) {
        this.name = name;

        this.button = new JButton();
        this.button.setPreferredSize(new Dimension(100, 100));

        ImageIcon backIcon = new ImageIcon("src/images/back.png");
        Image scaledBack = backIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        this.button.setIcon(new ImageIcon(scaledBack));

        Image scaledFront = frontImage.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        this.frontImage = new ImageIcon(scaledFront);
    }

    public JButton getButton() {
        return button;
    }

    // Flips the card to show front or back image
    public void flip() {
        if (isFlipped) {
            ImageIcon backIcon = new ImageIcon("src/images/back.png");
            Image scaledBack = backIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            button.setIcon(new ImageIcon(scaledBack));
            isFlipped = false;
        }
        else {
            button.setIcon(frontImage);
            isFlipped = true;
        }
    }

    public String getName() {
        return name;
    }

    public boolean isMatched() {
        return isMatched;
    }

    public void setMatched(boolean matched) {
        isMatched = matched;
    }

    public boolean isFlipped() {
        return isFlipped;
    }


}
